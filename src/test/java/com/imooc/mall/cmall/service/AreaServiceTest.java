package com.imooc.mall.cmall.service;

import com.imooc.mall.BaseTest;
import com.imooc.mall.entity.Area;
import com.imooc.mall.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AreaServiceTest extends BaseTest {

    @Autowired
    private AreaService areaService;

    @Test
    public void getAreaList(){
        List<Area> areaList =areaService.getAreaList();
        assertEquals("zhanglei",areaList.get(0).getAreaName());
    }
}
