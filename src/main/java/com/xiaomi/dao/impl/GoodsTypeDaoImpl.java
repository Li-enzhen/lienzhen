package com.xiaomi.dao.impl;

import com.xiaomi.dao.GoodsTypeDao;
import com.xiaomi.domain.GoodsType;
import com.xiaomi.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Li Enzhen
 * 2019/7/1 0001 下午 5:51
 */
public class GoodsTypeDaoImpl implements GoodsTypeDao {
    @Override
    public List<GoodsType> findById(int level) {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        try {
            return  qr.query("select * from tb_goods_type where level=?",new BeanListHandler<GoodsType>(GoodsType.class),level);
        } catch (SQLException e) {
            e.printStackTrace();
            throw  new RuntimeException("查询商品类别失败", e);



        }



    }
}
