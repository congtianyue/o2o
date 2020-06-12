package com.imooc.mall.cmall.service;

import com.imooc.mall.BaseTest;
import com.imooc.mall.dto.ShopExecution;
import com.imooc.mall.entity.Area;
import com.imooc.mall.entity.PersonInfo;
import com.imooc.mall.entity.Shop;
import com.imooc.mall.entity.ShopCategory;
import com.imooc.mall.enums.ShopStateEnum;
import com.imooc.mall.interceptor.ShopOperatationException;
import com.imooc.mall.service.ShopService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShopServiceTest extends BaseTest {
    @Autowired
    private ShopService shopService;

    @Test
    public void teatAddShop(){
        Shop shop=new Shop();
        PersonInfo owner=new PersonInfo();
        Area area=new Area();
        ShopCategory shopCategory=new ShopCategory();
        owner.setUserId(1L);
        area.setAreaId(2);
        shopCategory.setShopCategoryId(1L);
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试的店铺3");
        shop.setShopDesc("desc3");
        shop.setShopAddr("test3");
        shop.setPhone("test1");
        shop.setShopImg("test1");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        shop.setAdvice("审核中");
        File shopImg=new File("/Users/tianyuecong/Pictures/image/timg01.jpg");
        try {
            FileInputStream is=new FileInputStream(shopImg);
            ShopExecution se=shopService.addShop(shop, is, shopImg.getName());
            assertEquals(ShopStateEnum.CHECK.getState(),se.getState());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
