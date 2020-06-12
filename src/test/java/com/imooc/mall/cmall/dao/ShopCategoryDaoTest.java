package com.imooc.mall.cmall.dao;


import com.imooc.mall.BaseTest;
import com.imooc.mall.dao.ShopCategoryDao;
import com.imooc.mall.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

public class ShopCategoryDaoTest extends BaseTest {

    @Autowired
    private ShopCategoryDao shopCategoryDao;

    @Test
    public void testQueryShopCategory(){
        List<ShopCategory> shopCategoryList=shopCategoryDao.queryShopCategory(new ShopCategory());
        assertEquals(1,shopCategoryList.size());
        ShopCategory shopCategory=new ShopCategory();
        ShopCategory parentS=new ShopCategory();
        parentS.setShopCategoryId(1L);
        shopCategory.setParent(parentS);
        shopCategoryList=shopCategoryDao.queryShopCategory(shopCategory);
        assertEquals(1,shopCategoryList.size());
        System.out.println(shopCategoryList.get(0).getShopCategoryName());
    }
}
