package com.demo.carsys.entity;

import lombok.Data;

import java.util.List;

@Data
public class Page {

    // 数据存放在 result 中
    private List<UserOrder> result;

    // 页数
    private Integer pageNum;

    // 总数据数量
    private Integer total;

    // 每页多少数据  设置初始值为 5
    private Integer pageSize = 5;

    // 从那条数据开始查
    private Integer startIndex;

    public Page(Integer pageNum, Integer pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;

        /*通过计算获取 startIndex */
        this.startIndex = (this.pageNum - 1) * this.pageSize;
    }

}
