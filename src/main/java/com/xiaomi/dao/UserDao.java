package com.xiaomi.dao;

import com.xiaomi.domain.User;

import java.util.List;

/**
 * Created by Li Enzhen
 * 2019/6/27 0027 下午 4:34
 */
public interface UserDao {
    //查询所有的用户
    List<User> findAll();

    //根据查询单个用户
    User findByUserId(Integer uid);

    //根据用户名和密码查询
    User findByUserNameAndPwd(String username, String pwd);

    //添加
    void add(User user);

    //更新
    void update(User user);

    //删除
    void delete(Integer uid);

    //根据用户名查询
    User findByName(String username);


}
