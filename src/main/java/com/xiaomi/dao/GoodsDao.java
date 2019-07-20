package com.xiaomi.dao;

import com.xiaomi.domain.Goods;

import java.util.List;

/**
 * Created by Li Enzhen
 * 2019/7/1 0001 下午 10:33
 */
public interface GoodsDao {
    List<Goods> findByPage(int typeid,int pageNum,int pageSize);

    long getCount(int typeid);
}
