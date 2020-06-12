package com.imooc.mall.service.impl;

import com.imooc.mall.dao.ShopDao;
import com.imooc.mall.dto.ShopExecution;
import com.imooc.mall.entity.Shop;
import com.imooc.mall.enums.ShopStateEnum;
import com.imooc.mall.interceptor.ShopOperatationException;
import com.imooc.mall.service.ShopService;
import com.imooc.mall.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.imooc.mall.util.ImageUtil;
import java.io.InputStream;
import java.util.Date;

@Service
public class  ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;

    @Override
    @Transactional
    public ShopExecution addShop(Shop shop, InputStream shopImgInputStream,String fileName) {
        //判断控制
        if (shop==null){
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }
        try {
            //给店铺信息附初始值,该值不允许改变
            shop.setEnableStatus(0);
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());
            //添加店铺信息
            int effectedNum=shopDao.insertShop(shop);
            if (effectedNum<=0){
                throw new ShopOperatationException("店铺创建失败");
            }else {
                if (shopImgInputStream!=null){
                    //存储图片
                    try {
                        addShopImg(shop, shopImgInputStream,fileName);
                    }catch (Exception e){
                        throw new ShopOperatationException("addShopIMg error:"+e.getMessage());
                    }
                    //更新店铺的图片地址
                    effectedNum=shopDao.updateShop(shop);
                    if (effectedNum<=0){
                        throw  new ShopOperatationException("更新图片地址失败");
                    }
                }
            }

        } catch (Exception e) {
           throw new ShopOperatationException("addShop error:"+e.getMessage());
        }
        return new ShopExecution(ShopStateEnum.CHECK,shop);
    }

    private void addShopImg(Shop shop, InputStream shopImgInputStream,String fileName) {
        //获取shop图片目录的相对值路径
        String dest= PathUtil.getShopImagePath(shop.getShopId());
        String shopImgAddr= ImageUtil.generateThumbnail(shopImgInputStream,fileName,dest);
        shop.setShopImg(shopImgAddr);
    }
}
