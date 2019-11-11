package com.demo.carsys.mapper;

import com.demo.carsys.entity.City;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityMapper {
    String selectGetCarCityByPid(Integer getid);

    String selectRepayCarCityByPid(Integer repayPid);

    List<City> selectCitys();

}
