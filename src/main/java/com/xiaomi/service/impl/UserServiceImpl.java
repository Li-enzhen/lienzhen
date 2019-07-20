package com.xiaomi.service.impl;

import com.xiaomi.dao.UserDao;
import com.xiaomi.dao.impl.UserDaoimpl;
import com.xiaomi.domain.User;
import com.xiaomi.service.UserService;
import com.xiaomi.utils.EmailUtils;
import com.xiaomi.utils.MD5Utils;

/**
 * Created by Li Enzhen
 * 2019/6/28 0028 下午 8:36
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoimpl();

    @Override
    public void register(User user) {
        //业务处理
        //1.密码加密
        //String s = MD5Utils.md5(user.getPassword());
        user.setPassword(MD5Utils.md5(user.getPassword()));
        userDao.add(user);
        //2.发送邮件  javaee发邮件技术
        EmailUtils.sendEmail(user);


    }

    @Override
    public User login(String username, String pwd) {
        //业务处理
        return userDao.findByUserNameAndPwd(username, pwd);
    }

    @Override
    public boolean checkExists(String username) {
        User user = userDao.findByName(username);
        if (user!=null){
            return true;
        }
        return false;
    }
}
