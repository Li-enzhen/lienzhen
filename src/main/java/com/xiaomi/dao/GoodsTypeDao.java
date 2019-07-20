package com.xiaomi.dao;

import com.xiaomi.domain.GoodsType;

import java.util.List;

/**
 * Created by Li Enzhen
 * 2019/7/1 0001 下午 5:51
 */
public interface GoodsTypeDao {
    List<GoodsType> findById(int level);
}
