package com.example.car.util;

import com.example.car.model.Account;
import com.example.car.model.Car;
import com.example.car.model.Modification;

public record CarModfctn(Car car, Modification modification, Account account) {
}
