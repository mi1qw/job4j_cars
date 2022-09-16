package com.example.car.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
public class JsonUtil {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public String mapToJson(final Map map) {
        String json = null;
        try {
            json = objectMapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
        }
        return json;
    }
}
