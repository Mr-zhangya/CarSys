package com.demo.carsys.mapper;

import com.demo.carsys.entity.Car;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarMapper {
    List<Car> priceSort(Integer getid);

    List<Car> numberSort(Integer getid);

    Car findCar(Integer cid);
}
