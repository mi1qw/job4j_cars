package com.example.car.util;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class JsonUtilTest {
    @Test
    void mapToJson() {
        Map<Integer, String> map = new HashMap<>(Map.of(
                1, "str1",
                2, "str2",
                3, "str3"
        ));
        assertThat(new JsonUtil().mapToJson(map))
                .isEqualTo("{\"1\":\"str1\",\"2\":\"str2\",\"3\":\"str3\"}");
    }
}
