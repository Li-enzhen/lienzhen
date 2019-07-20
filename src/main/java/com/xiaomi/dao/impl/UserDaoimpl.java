package com.xiaomi.dao.impl;

import com.xiaomi.dao.UserDao;
import com.xiaomi.domain.User;
import com.xiaomi.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Li Enzhen
 * 2019/6/27 0027 下午 4:36
 */
public class UserDaoimpl implements UserDao {

    @Override
    public List<User> findAll() {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        try {
            return qr.query("select * from tb_user", new BeanListHandler<User>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查询所有用户失败", e);
        }

    }

    @Override
    public User findByUserId(Integer uid) {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        try {
            return qr.query("select * from tb_user where id=?", new BeanHandler<User>(User.class), uid);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查询用户失败", e);
        }
    }

    @Override
    public User findByUserNameAndPwd(String username, String pwd) {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        try {
            return qr.query("select * from tb_user where username=? and password=?", new BeanHandler<User>(User.class), username, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查询所有用户失败", e);
        }
    }

    @Override
    public void add(User user) {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        Object[] params = {user.getUsername(), user.getPassword(), user.getEmail(), user.getGender(), user.getFlag(), user.getRole(), user.getCode()};
        try {
            qr.update("insert into tb_user(username,password,email,gender,flag,role,code)value(?,?,?,?,?,?,?)", params);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("添加用户失败", e);
        }
    }

    @Override
    public void update(User user) {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        Object[] params = {user.getUsername(), user.getPassword(), user.getEmail(), user.getGender(), user.getFlag(), user.getRole(), user.getCode(), user.getId()};

        try {
            qr.update("update into tb_user set username=?,password=?,email=?,gender=?,flag=?,role=?,code=? where id=?", params);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("更新用户失败", e);
        }

    }

    @Override
    public void delete(Integer uid) {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        try {
            qr.update("update  tb_user  set flag=2 where id=?", uid);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("删除用户失败", e);
        }

    }

    @Override
    public User findByName(String username) {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        try {
            return qr.query("select * from tb_user where username=?", new BeanHandler<User>(User.class), username);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("根据用户名查询失败", e);
        }

    }

}
