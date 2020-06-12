package com.imooc.mall.dto;

import com.imooc.mall.entity.Shop;
import com.imooc.mall.enums.ShopStateEnum;
import lombok.Data;

import java.util.List;
@Data
public class ShopExecution {
    //结果状态
    private int state;

    //状态标示
    private String stateInfo;

    //店铺的数量
    private int count;

    //操作的shop(增删改店铺的时候用到)
    private Shop shop;

    //shop列表（查询店铺列表的时候使用）
    private List<Shop> shopList;

    public ShopExecution(){}

    //店铺操作失败时候的构造函数
    public ShopExecution(ShopStateEnum stateEnum){
        this.state=stateEnum.getState();
        this.stateInfo=stateEnum.getStateInfo();
    }
    //店铺操作成功时候的构造函数（返回shop）
    public ShopExecution(ShopStateEnum stateEnum,Shop shop){
        this.state=stateEnum.getState();
        this.stateInfo=stateEnum.getStateInfo();
        this.shop=shop;
    }
    //店铺列表操作成功时候的构造函数(返回列表)
    public ShopExecution(ShopStateEnum stateEnum,List<Shop> shopList){
        this.state=stateEnum.getState();
        this.stateInfo=stateEnum.getStateInfo();
        this.shopList=shopList;
    }
}
