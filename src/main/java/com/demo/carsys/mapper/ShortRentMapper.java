package com.demo.carsys.mapper;

import com.demo.carsys.entity.City;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShortRentMapper {

    List<City> selectCity(Integer pid);
}
