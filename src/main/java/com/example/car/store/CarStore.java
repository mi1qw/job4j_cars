package com.example.car.store;

import com.example.car.dto.FileImageDto;
import com.example.car.dto.FilterDto;
import com.example.car.model.Account;
import com.example.car.model.Car;
import com.example.car.model.Modification;
import com.example.car.model.Status;
import com.example.car.service.FileService;
import com.example.car.service.dto.PaginationDto;
import com.example.car.util.CarModfctn;
import com.example.car.util.FilterForm;
import com.example.car.web.Pagination;
import com.example.car.web.UserSession;
import jakarta.persistence.PersistenceException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.query.Query;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

@Repository
@Slf4j
public class CarStore extends CrudPersist<Car> {
    private final UserSession userSession;
    private final FileService fileService;

    public CarStore(final UserSession userSession, @Lazy final FileService fileService) {
        super(Car.class);
        this.userSession = userSession;
        this.fileService = fileService;
    }

    public Car merge(final Car car) {
        return tx(session -> session.merge(car));
    }

    public Car deleteImageByName(final Car car, final String name) {
        Account account = userSession.getAccount();
        return tx(session -> {
            Car car1 = session.find(Car.class, car.getId());
            if (!car1.getAccount().getId().equals(account.getId())) {
                return null;
            }
            car1.getImages().remove(name);
            return car1;
        });
    }

    public Car getCar(final Long id) {
        return tx(session ->
                session.createQuery("""
                                from Car c left join fetch c.options where c.id=:id
                                """, Car.class)
                        .setParameter("id", id)
                        .uniqueResult());
    }

    public Car reorderImg(final Long id, final String[] names) {
        return tx(session -> {
            Car car = session.find(Car.class, id);
            List<String> images = car.getImages();
            images.clear();
            for (int i = 0; i < names.length; i++) {
                images.add(names[i]);
            }
            return car;
        });

    }

    public boolean addImage(final Car car, final FileImageDto imageDto) {
        try {
            List<String> images = car.getImages();
            Integer res = tx(session ->
                    session.createNativeQuery(
                                    "insert into image values (:carId,:filename,:order)")
                            .setParameter("carId", car.getId())
                            .setParameter("filename", imageDto.getName())
                            .setParameter("order", imageDto.getOrder())
                            .executeUpdate()
            );
            if (res == 0) {
                return false;
            }
            images.add(imageDto.getName());
        } catch (Throwable e) {
            e.printStackTrace();
            throw new PersistenceException();
        }
        return true;
    }

    public PaginationDto findByFilter(final FilterDto filterDto, final Pagination pagination) {
        FilterForm filterForm = userSession.getFilterForm();
        filterForm.update(filterDto);
        int[] rowNumber = {0};
        List<Car> carFiltered = tx(session -> {
            Query<Car> query = session.createQuery(
                    filterForm.makeQuery(),
                    Car.class);
            query = filterForm.setParameters(query);
            ScrollableResults<Car> scroll = query.scroll(ScrollMode.SCROLL_INSENSITIVE);
            scroll.last();
            rowNumber[0] = scroll.getRowNumber() + 1;
            scroll.close();
            return query
                    .setFirstResult(pagination.getOffset())
                    .setMaxResults(pagination.getSize())
                    .list();
        });
        return new PaginationDto(carFiltered, pagination.getTotalPages(rowNumber[0]));
    }

    public List<Car> findMyCars(final Account account) {
        return tx(session ->
                session.createQuery("from Car c where c.account=:account", Car.class)
                        .setParameter("account", account)
                        .list()
        );
    }

    public Car createAccountCar(final Account account) {
        return tx(session -> {
                    List<Car> cars = session.createQuery(
                                    "from Car c where c.account=:account and c.status=:status",
                                    Car.class)
                            .setParameter("account", account)
                            .setParameter("status", Status.newItem)
                            .list();
                    if (!cars.isEmpty()) {
                        while (cars.size() > 1) {
                            session.remove(cars.get(1));
                        }
                        return cars.get(0);
                    }
                    Car car = new Car();
                    car.setAccount(account);
                    session.persist(car);
                    return car;
                }
        );
    }

    public boolean changeStatus(final Long id, final Status status) {
        Account account = userSession.getAccount();
        Integer res = tx(session ->
                session.createQuery("""
                                update Car c set c.status=:status where c.id=:id
                                and c.status!=:newItem
                                and c.account=:account""")
                        .setParameter("id", id)
                        .setParameter("newItem", Status.newItem)
                        .setParameter("status", status)
                        .setParameter("account", account)
                        .executeUpdate());
        return res != 0;
    }

    public boolean deleteCar(final Long id) {
        List<String> images = new ArrayList<>();
        Account account = userSession.getAccount();
        Boolean resBoolean = false;
        try {
            resBoolean = tx(session -> {
                Car car = session.find(Car.class, id);
                if (car.getAccount().getId().equals(account.getId())) {
                    images.addAll(car.getImages());
                    session.remove(car);
                    return true;
                }
                return false;
            });

            if (resBoolean) {
                ForkJoinPool.commonPool().execute(() ->
                        images.forEach(fileService::deleteByName));
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return resBoolean;
    }

    public CarModfctn findCarPost(final Long id) {
        return tx(session -> {
                    CarModfctn modfctn = session.createQuery("""
                                    select c, m, a from Car c, Account a,
                                    Modification m where c.account= a and c.id=:id and
                                    c.modification=m.id.nameId and c.year=m.id.yearId
                                    and c.mark=m.id.markId""", Object[].class)
                            .setParameter("id", id)
                            .setTupleTransformer((tuple, aliases) ->
                                    new CarModfctn(
                                            (Car) tuple[0],
                                            (Modification) tuple[1],
                                            ((Account) tuple[2])))
                            .getSingleResult();
                    modfctn.car().getOptions().size();
                    return modfctn;
                }
        );
    }
}
