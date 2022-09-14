package com.example.car.model;

import lombok.RequiredArgsConstructor;

/*@Slf4j
public enum Sort {
    timeNewToOld,
    priceExpensiveToCheap,
    priceCheapToExpensive
}*/

@RequiredArgsConstructor(staticName = "of")
public class Sort {
    private final Long id;
    private final String name;
    private final String query;
}