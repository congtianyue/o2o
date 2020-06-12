package com.imooc.mall.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ShopCategory {
    private Long shopCategoryId;
    private String shopCategoryName;
    private String shopCategoryDesc;
    private Integer priority;
    private Date createTime;
    private Date lastEditTime;
    private ShopCategory parent;//上级类别id
}
