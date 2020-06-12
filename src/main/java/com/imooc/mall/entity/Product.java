package com.imooc.mall.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Product {

    private Long productId;
    private String productName;
    private String productDesc;
    private String imgAddr;//缩略图
    private String normalPrice;
    private String promotionPrice;
    private Integer priority;
    private Date createTime;
    private Date lastEditTime;
    private Integer enableStatus;//0、下架；1、在前端展示系统展示
    private List<ProductImg> productImgList;
    private ProductCategory productCategory;
    private Shop shop;
}
