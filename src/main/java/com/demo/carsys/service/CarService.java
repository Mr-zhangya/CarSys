package com.demo.carsys.service;

import com.demo.carsys.entity.Car;

import java.util.List;

public interface CarService {
    List<Car> priceSort(Integer getid);

    List<Car> numberSort(Integer getid);

    Car findCar(Integer cid);
}
