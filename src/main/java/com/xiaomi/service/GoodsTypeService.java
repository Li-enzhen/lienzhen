package com.xiaomi.service;

import com.xiaomi.domain.GoodsType;

import java.util.List;

/**
 * Created by Li Enzhen
 * 2019/7/1 0001 下午 5:44
 */
public interface GoodsTypeService {
    List<GoodsType> findByLevel(int level);
}
