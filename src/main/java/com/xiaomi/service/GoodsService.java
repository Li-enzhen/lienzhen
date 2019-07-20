package com.xiaomi.service;

import com.xiaomi.domain.Goods;
import com.xiaomi.domain.PageBean;

/**
 * Created by Li Enzhen
 * 2019/7/1 0001 下午 10:08
 */
public interface GoodsService {
    PageBean<Goods> findByPage(int typeid,int pageNum,int pageSize);
}
