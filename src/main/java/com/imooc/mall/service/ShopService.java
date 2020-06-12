package com.imooc.mall.service;

import com.imooc.mall.dto.ShopExecution;
import com.imooc.mall.entity.Shop;


import java.io.InputStream;

public interface ShopService {
    ShopExecution addShop(Shop shop, InputStream shopImgInputStream,String fileName);
}
