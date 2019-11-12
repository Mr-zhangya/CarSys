package com.demo.carsys.entity;

import lombok.Data;

@Data
public class Order {
    private Integer id;

    private Integer cid;

    private Integer uid;

    private Integer getid;
    private String getCarCityName;

    private Integer backid;
    private String backCarCityName;

    private Double oprice;

    private String status = "已预定";
}
