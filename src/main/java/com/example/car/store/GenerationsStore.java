package com.example.car.store;

import com.example.car.model.Generations;
import com.example.car.model.Model;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenerationsStore extends CrudPersist<Generations> {

    public GenerationsStore() {
        super(Generations.class);
    }

    public List<Short> getYearsByModel(final Model model) {
        return tx(session -> session
                .createQuery("select distinct g.year from Generations g where g.model=:model",
                        Short.class)
                .setParameter("model", model)
                .list());
    }

    public List<Generations> getGenerationsByYearByModel(final Short year, final Model model) {
        return tx(session ->
                session.createQuery(""" 
                                        from Generations g join fetch g.body
                                        join fetch g.engine 
                                        join fetch g.gearbox 
                                        join fetch g.transmission where
                                         g.model=:model and g.year=:year""",
                                Generations.class)
                        .setParameter("model", model)
                        .setParameter("year", year)
                        .list()
        );
    }
}
