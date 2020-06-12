package com.imooc.mall.service.impl;

import com.imooc.mall.dao.AreaDao;
import com.imooc.mall.entity.Area;
import com.imooc.mall.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }
}
