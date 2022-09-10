package com.example.car.store;

import com.example.car.dto.FileImageDto;
import com.example.car.model.Car;
import jakarta.persistence.PersistenceException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarStore extends CrudPersist<Car> {

    public CarStore() {
        super(Car.class);
    }

    public Car merge(final Car car) {
        return tx(session -> {
            Car merge = session.merge(car);
            return merge;
        });


//        List<String> carImages = car.getImages();
//        Car tx = tx(session -> {
//            Car car2 = session.get(Car.class, car.getId());
//            List<String> images = car2.getImages();
//            images.addAll(carImages);
////            images.add("aaaaaaaaaaaaaa");
//            return car2;
//        });
//        return tx;
    }

    // TODO порядок может не совпадать, достаточно переместить картинку на фронте
    public Car deleteImage(final Car car, final FileImageDto imageDto) {
        car.getImages().remove(imageDto.getOrder());
        return tx(session -> session.merge(car));
    }

    public Car deleteImageByOrder(final Car car, final int order) {
        car.getImages().remove(order);
        return tx(session -> session.merge(car));
    }

    public Car deleteImageByName(final Car car, final String name) {
        return tx(session -> {
            Car car1 = session.find(Car.class, car.getId());
            car1.getImages().remove(name);
//            Car merge = session.merge(car1);
            return car1;
        });
    }

    public Car getCar(final Long id) {
        return tx(session -> {
            Car car = session.find(Car.class, id);
//            List<String> images = car.getImages();
//            System.out.println(images + "  System.out.println(images");
            return car;
        });
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

//    public Car findByIdWithImages(final Long id) {
//        return tx(session -> {
//            session.find(Car.class, id)
//        });
//    }

//    public void addim(final String im){
//        txv(session -> {
//           session.createQuery(ins)
//        })
//    }

//    public boolean addImagesSQL(final Car car, final List<String> images) {
//        try {
//            txv(session -> {
//                List<String> listImg = car.getImages();
//                int[] size = {listImg.size()};
//                int[] res = {0};
//                images.forEach(n -> {
//                    int i = session.createNativeQuery(
//                                    "insert into image values (:carId,:filename,:order)")
//                            .setParameter("carId", car.getId())
//                            .setParameter("filename", n)
//                            .setParameter("order", size[0]++)
//                            .executeUpdate();
//
//                    if (i == 0) {
////                        ++res[0];
//                        return false;
//                    }
//                    listImg.add(n);
//                });
//            });
//        } catch (Throwable e) {
//            throw new PersistenceException();
//        }
//    }


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

    // TODO фильтр добавить
    public List<Car> finCarsWithEngineGearFILTR() {
        return tx(session ->
                session.createQuery("from Car c join fetch c.gearbox "
                                    + "join fetch c.transmission",
                                Car.class)
                        .list());
    }
}

//jakarta.persistence.PersistenceException:
//Converting `org.hibernate.exception.ConstraintViolationException` to JPA `PersistenceException`
// : JDBC exception executing
