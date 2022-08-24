package com.example.car.util;

import com.example.car.model.Car;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class ImageUtil {

    private static final Pattern PATTERN = Pattern
            .compile("[^\\s]+(\\.(?i)(jpe?g|png|gif|bmp))$");
    private static final Pattern ID = Pattern
            .compile("^\\d+-(\\d+)-.*");

    public static String rename(final String img, final int order, final Car car) {
        return car.getId() + "-" + order + "-" + img;
    }

    public static boolean isValid(final String img) {
        return PATTERN.matcher(img).matches();
    }

    public static int findMaxID(final Car car) {
        List<String> images = car.getImages();
        Optional<Integer> max =
                images.stream()
                        .map(name -> {
                            Matcher matcher = ID.matcher(name);
                            matcher.find();
                            return Integer.parseInt(matcher.group(1));
                        })
                        .max(Integer::compareTo);
        return max.orElse(-1);
    }
}
