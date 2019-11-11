package com.demo.carsys.entity;

import lombok.Data;

import java.util.List;

@Data
public class City {
    private Integer id;
    private String name;
    private Integer pId;

    private List<City> shortList;

    private List<City> cityList;
}
