package com.imooc.mall.dao;

import com.imooc.mall.entity.Shop;

public interface ShopDao {
    /**
     * 新增店铺
     * @param shop
     * @return 1：新增店铺成功；-1：新增店铺失败
     */
    int insertShop(Shop shop);

    /**
     * 更新店铺
     * @param shop
     * @return
     */
    int updateShop(Shop shop);

}
