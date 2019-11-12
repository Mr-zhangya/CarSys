package com.demo.carsys.entity;

import lombok.Data;

@Data
public class UserOrder {
    private Integer id;
    private Double oprice;
    private String ostatus;
    private String cname;
    private String gname;
    private String bname;
}
