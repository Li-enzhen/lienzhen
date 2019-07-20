package com.xiaomi.service.impl;

import com.xiaomi.dao.GoodsTypeDao;
import com.xiaomi.dao.impl.GoodsTypeDaoImpl;
import com.xiaomi.domain.GoodsType;
import com.xiaomi.service.GoodsTypeService;

import java.util.List;


/**
 * Created by Li Enzhen
 * 2019/7/1 0001 下午 5:45
 */
public class GoodsTypeServiceimpl implements GoodsTypeService {
    private GoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();



    @Override
    public List<GoodsType> findByLevel(int level) {

        return goodsTypeDao.findById(level);
    }
}
