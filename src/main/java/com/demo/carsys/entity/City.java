package com.demo.carsys.entity;

import lombok.Data;


@Data
public class City {
    private Integer id;
    private String name;
    private Integer pid;


    // 取车 地区 Pid
    private Integer getPid;
    // 取车 地区
    private String getCarCity;

    // 还车 地区 Pid
    private Integer repayPid;
    // 还车 地区
    private String repayCarCity;

}
