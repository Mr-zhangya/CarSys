package com.demo.carsys.service.impl;

import com.demo.carsys.entity.Car;
import com.demo.carsys.mapper.CarMapper;
import com.demo.carsys.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarMapper carMapper;
    @Transactional
    public List<Car> priceSort(Integer getid) {
        return carMapper.priceSort(getid);
    }

    @Transactional
    public List<Car> numberSort(Integer getid) {
        return carMapper.numberSort(getid);
    }

    @Transactional
    public Car findCar(Integer cid) {
        return carMapper.findCar(cid);
    }
}
