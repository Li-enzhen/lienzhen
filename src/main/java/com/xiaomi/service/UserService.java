package com.xiaomi.service;

import com.xiaomi.domain.User;

/**
 * Created by Li Enzhen
 * 2019/6/28 0028 下午 7:59
 */
public interface UserService {
    //注册
    void  register(User user);
    //登录
    User  login(String username,String pwd);

    boolean checkExists(String username);
}
