package com.example.car.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/*@Slf4j
public enum Sort {
    timeNewToOld,
    priceExpensiveToCheap,
    priceCheapToExpensive
}*/
@ToString
@RequiredArgsConstructor(staticName = "of")
@Data
public class Sort {
    private final Long id;
    private final String name;
    private final String query;
}