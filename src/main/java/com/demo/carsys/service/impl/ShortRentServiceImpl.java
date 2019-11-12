package com.demo.carsys.service.impl;

import com.demo.carsys.entity.City;
import com.demo.carsys.mapper.ShortRentMapper;
import com.demo.carsys.service.ShortRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShortRentServiceImpl implements ShortRentService {

    @Autowired
    ShortRentMapper shortRentMapper;

    @Transactional
    public List<City> selectCity(Integer pid) {
        return shortRentMapper.selectCity(pid);
    }
}
