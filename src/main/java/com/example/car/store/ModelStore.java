package com.example.car.store;

import com.example.car.model.Mark;
import com.example.car.model.Model;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ModelStore extends CrudPersist<Model> {

    public ModelStore() {
        super(Model.class);
    }

    public Map<Long, Model> getModelsByMark(final Mark mark) {
        HashMap<Long, Model> map = new HashMap<>();

        List<Model> mark1 = tx(session -> session.createQuery("from Model m where m.mark=:mark")
                .setParameter("mark", mark)
                .list());
        mark1.forEach(n -> map.put(n.getId(), n));
        return map;
    }
}
