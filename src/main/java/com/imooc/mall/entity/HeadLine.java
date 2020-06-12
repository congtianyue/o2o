package com.imooc.mall.entity;

import lombok.Data;

import java.util.Date;

@Data
public class HeadLine {
    private Long lineId;
    private String lineName;
    private String lineLink;
    private String lineImg;
    private Integer priority;
    private Integer enableStatus;//0:不可用；1：可用
    private Date createTime;
    private Date lastEditTime;
}
