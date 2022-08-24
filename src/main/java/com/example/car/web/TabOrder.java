package com.example.car.web;

import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@ToString
public class TabOrder {
    private final AtomicInteger total = new AtomicInteger();
    private int start = 0;

    // TODO добавить кол-во уже имеющихся картинок в базе
    @Setter
    private int prevTotal = 0;

    public TabOrder() {
    }

    public int getOrder(final int order, final int totalFiles) {
        synchronized (this) {
            if (total.get() == 0) {
                total.set(totalFiles);
                start = prevTotal;
                prevTotal = prevTotal + totalFiles;
            }
        }
        total.decrementAndGet();
        return start + order;
    }

    public int getOrderWihtStart(final int order, final int totalFiles, final int start) {
        synchronized (this) {
            if (total.get() == 0) {
                total.set(totalFiles);
                this.start = start;
            }
            total.decrementAndGet();
            log.warn("this.Start={}   Start={}   total={}", this.start, start, total.get());
            return start + order;
        }
    }
}
