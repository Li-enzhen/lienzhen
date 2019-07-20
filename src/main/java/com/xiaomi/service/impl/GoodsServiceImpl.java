package com.xiaomi.service.impl;

import com.xiaomi.dao.GoodsDao;
import com.xiaomi.dao.impl.GoodsDaoImpl;
import com.xiaomi.domain.Goods;
import com.xiaomi.domain.PageBean;
import com.xiaomi.service.GoodsService;

import java.util.List;

/**
 * Created by Li Enzhen
 * 2019/7/1 0001 下午 10:08
 */
public class GoodsServiceImpl implements GoodsService {
    private GoodsDao goodsDao =  new GoodsDaoImpl();
    @Override
    public PageBean<Goods> findByPage(int typeid,int pageNum,int pageSize) {
        List<Goods> data = goodsDao.findByPage(typeid,pageNum,pageSize);
        long totalSize = goodsDao.getCount(typeid);
        PageBean<Goods> pageBean = new PageBean<>(pageNum, pageSize, totalSize, data);


        return pageBean ;
    }
}
