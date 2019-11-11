package com.demo.carsys.entity;

import lombok.Data;


@Data
public class City {
    private Integer id;
    private String name;
    private Integer pid;

    // 城市 Pid
    private Integer cityPid;

    // 地区 Pid
    private Integer regionPid;
}
