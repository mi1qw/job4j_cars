package com.example.car.web;

public record Pagination(int page, int size) {
    public Pagination(final int page, final int size) {
        if (page < 0) {
            throw new IllegalArgumentException("Page index must not be less than zero!");
        } else if (size < 1) {
            throw new IllegalArgumentException("Page size must not be less than one!");
        } else {
            this.page = page;
            this.size = size;
        }
    }

    public static Pagination of(final int page, final int size) {
        return new Pagination(page, size);
    }

    public int getOffset() {
        return page * size;
    }

    public int getTotalPages(final int rows) {
        double pages = Math.ceil(rows / (double) size);
        return (int) pages;
    }

    public boolean hasPrevious() {
        return page > 0;
    }
}
