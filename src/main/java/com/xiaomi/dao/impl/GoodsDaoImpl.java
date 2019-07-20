package com.xiaomi.dao.impl;

import com.xiaomi.dao.GoodsDao;
import com.xiaomi.domain.Goods;
import com.xiaomi.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Li Enzhen
 * 2019/7/1 0001 下午 10:33
 */
public class GoodsDaoImpl implements GoodsDao {
    @Override
    public List<Goods> findByPage(int typeid, int pageNum, int pageSize) {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        try {
            if (typeid > 0) {
                return qr.query("select * from tb_goods where typeid=?  order by id  limit ?,?", new BeanListHandler<>(Goods.class), typeid, (pageNum - 1) * pageSize, pageSize);

            } else {
                return qr.query("select * from tb_goods order by id  limit ?,?", new BeanListHandler<>(Goods.class), (pageNum - 1) * pageSize, pageSize);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("分页查询失败", e);
        }

    }

    @Override
    public long getCount(int typeid) {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        try {
            if (typeid > 0) {
                Long count = (Long) qr.query("select count(*) from tb_goods where typeid=?", new ScalarHandler(), typeid);
                return count;
            } else {
                Long count = (Long) qr.query("select count(*) from tb_goods ", new ScalarHandler());
                return count;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查询商品的个数失败", e);
        }
    }
}
