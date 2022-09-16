package com.example.car.util;

import static org.junit.jupiter.api.Assertions.*;

import com.example.car.model.Mark;
import com.example.car.model.Model;
import com.example.car.service.MarkService;
import com.example.car.service.ModelService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Slf4j
class JsonUtilTest {
    @Autowired
    private JsonUtil jsonUtil;
    @Autowired
    private ModelService modelService;
    @Autowired
    private MarkService markService;

    @Test
    void mapToJson() {
        Map<Integer, String> map = new HashMap<>(Map.of(
                1, "str1",
                2, "str2",
                3, "str3"
        ));
        String s = jsonUtil.mapToJson(map);
        log.info("{}", s);

        Mark mark = markService.findById(2L);
        Map<Long, Model> models = modelService.getModelsByMark(mark);
        Map<Long, String> longStringMap = models.values().stream()
                .collect(Collectors.toMap(
                        Model::getId,
                        (n)->n.getName())
                );
        log.info("{}", jsonUtil.mapToJson(longStringMap));
    }
}
