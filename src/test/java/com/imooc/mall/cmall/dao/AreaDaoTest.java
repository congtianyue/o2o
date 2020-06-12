package com.imooc.mall.cmall.dao;

import com.imooc.mall.BaseTest;
import com.imooc.mall.dao.AreaDao;
import com.imooc.mall.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AreaDaoTest extends BaseTest {

    @Autowired
    private AreaDao areaDao;

    @Test
    public void testQueryArea(){
        List<Area> list=areaDao.queryArea();
        assertEquals(3,list.size());
    }
}
