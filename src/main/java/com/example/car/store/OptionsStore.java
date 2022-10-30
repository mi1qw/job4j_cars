package com.example.car.store;

import com.example.car.model.Options;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OptionsStore extends CrudPersist<Options> {

    public OptionsStore() {
        super(Options.class);
    }

    public List<Long> findGenerationOptionsById(final Long id) {
        return tx(session ->
                session.createNativeQuery("""
                                select go.options_id from generations_options go
                                where go.generations_id=:id
                                 """, Long.class)
                        .setParameter("id", id)
                        .list());
    }
}
