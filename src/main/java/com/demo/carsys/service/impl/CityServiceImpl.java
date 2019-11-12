package com.demo.carsys.service.impl;

import com.demo.carsys.entity.City;
import com.demo.carsys.mapper.CityMapper;
import com.demo.carsys.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityMapper cityMapper;

    @Transactional
    public String selectGetCarCityByPid(Integer getid) {
        return cityMapper.selectGetCarCityByPid(getid);
    }

    @Transactional
    public String selectRepayCarCityByPid(Integer backid) {
        return cityMapper.selectRepayCarCityByPid(backid);
    }

    @Transactional
    public List<City> selectCitys() {
        return cityMapper.selectCitys();
    }
}
