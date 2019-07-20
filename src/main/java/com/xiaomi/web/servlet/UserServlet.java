package com.xiaomi.web.servlet;


import cn.dsna.util.images.ValidateCode;
import com.xiaomi.domain.User;
import com.xiaomi.service.UserService;
import com.xiaomi.service.impl.UserServiceImpl;
import com.xiaomi.utils.MD5Utils;
import com.xiaomi.utils.RandomUtils;
import com.xiaomi.utils.StringUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;

/**
 * Created by Li Enzhen
 * 2019/6/27 0027 下午 9:29
 */
@WebServlet(name = "UserServlet", value = "/userservlet")
public class UserServlet extends BaseServlet {

    public String login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取用户名和密码
        System.out.println("登录!");
        //
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String auto = request.getParameter("auto");
        if (StringUtils.isEmpty(username)) {
            request.setAttribute("msg", "用户名不能为空");
            return "login.jsp";
        }
        if (StringUtils.isEmpty(password)) {
            request.setAttribute("msg", "密码不能为空");
            return "login.jsp";
        }
        //1创建业务对象
        UserService userService = new UserServiceImpl();
        User user = userService.login(username, MD5Utils.md5(password));
        if (user == null) {
            request.setAttribute("msg", "用户名和密码错误");
            return "login.jsp";
        }
        //判断账号
        if (user.getFlag() != 1) {
            request.setAttribute("msg", "账号未激活");
            return "login.jsp";

        }
        //判断角色  0   1
        if (user.getRole() != 1) {
            request.setAttribute("msg", "账号没有权限");
            return "login.jsp";
        }

        //登录成功
        request.getSession().setAttribute("user", user);
        if (auto != null) {
            //选择自动登录
            //cookie
            String userinfo = user.getUsername() + "#" + user.getPassword();
            Cookie cookie = new Cookie("userinfo", URLEncoder.encode(userinfo, "utf-8"));
            cookie.setMaxAge(60 * 60 * 24 * 14);
            cookie.setPath("/");
            cookie.setHttpOnly(true);
            response.addCookie(cookie);


        }
        //重定向
        //return  "index.jsp";//转发  地址不会变化
        return "redirect:index.jsp";//重定向  页面的地址会变化
    }

    public String checkUserName(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = request.getParameter("username");
        //创建业务对象
        UserService userService = new UserServiceImpl();
        //调用业务方法
        boolean b = userService.checkExists(username);
//判断
        if (b) {
            response.getWriter().write("1");

        } else {
            response.getWriter().write("2");
        }
        return null;
    }

    public String register(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("注册!");
        //接受数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        //验证
        if (StringUtils.isEmpty(username)) {
            //kong
            request.setAttribute("registerMsg", "用户名不能为空");
            return "register.jsp";
        }
        if (StringUtils.isEmpty(password)) {
            //kong
            request.setAttribute("registerMsg", "密码不能为空");
            return "register.jsp";
        }
        if (StringUtils.isEmpty(repassword)) {
            //kong
            request.setAttribute("registerMsg", "确认密码不能为空");
            return "register.jsp";
        }
        if (!password.equals(repassword)) {
            //kong
            request.setAttribute("registerMsg", "两次密码不一致");
            return "register.jsp";
        }
        if (StringUtils.isEmpty(email)) {
            //kong
            request.setAttribute("registerMsg", "邮箱不能为空不能为空");
            return "register.jsp";
        }
        //创建业务对象

        UserService userService = new UserServiceImpl();
        try {
            User user = new User(0, username, password, email, gender, 0, 1, RandomUtils.createActiveCode());

            userService.register(user);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("registerMsg", "注册失败");
            return "register.jsp";
        }
        //重定向到
        return "redirect:registerSuccess.jsp";
    }

    public String code(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //创建对象

        ValidateCode validateCode = new ValidateCode(100, 30, 4, 20);
        String code = validateCode.getCode();
        //  放入session
        request.getSession().setAttribute("servletcode", code);
        //返回
        validateCode.write(response.getOutputStream());
        return null;
    }

    public String checkCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String clientcode = request.getParameter("code");
        Object servletcode = request.getSession().getAttribute("servletcode");
        if (clientcode.equals(servletcode)) {
            response.getWriter().write("0");

        } else {
            response.getWriter().write("1");

        }
        return null;


    }

    public String logOut(HttpServletRequest request,HttpServletResponse response) {
        //1.把用户信息从session中移除
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        //2.把session失效
        session.invalidate();
        //3.把cookie删除
        Cookie cookie = new Cookie("userinfo", "");
        cookie.setMaxAge(0);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        System.out.println("注销!!!!!!!!!!!!!!!");

        return "redirect:index.jsp";


    }

}

