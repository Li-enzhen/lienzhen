package com.xiaomi.web.filter;

import com.xiaomi.domain.User;
import com.xiaomi.service.UserService;
import com.xiaomi.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

/**
 * Created by Li Enzhen
 * 2019/7/1 0001 上午 11:31
 */
@WebFilter(filterName = "AutoLoginFilter", value = "/index.jsp")
public class AutoLoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //1.先转换
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        //2.获取session
        Object user = request.getSession().getAttribute("user");
        if (user != null) {

            chain.doFilter(request, response);
            return;
        }
        //3.获取cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if (name.equals("userinfo")) {
                    String value = cookie.getValue();
                    value = URLDecoder.decode(value, "utf-8");
                    String[] userinfos = value.split("#");
                    //判断用户名密码
                    UserService userService = new UserServiceImpl();
                    User user2 = userService.login(userinfos[0], userinfos[1]);
                    if (user2 != null && user2.getFlag() == 1 && user2.getRole() == 1) {
                        //合法用户
                        request.getSession().setAttribute("user", user2);
                    } else {
                        //用户名不正确 销毁
                        Cookie cookie1 = new Cookie("userinfo", "");
                        cookie1.setMaxAge(0);//删除
                        cookie1.setPath("/");
                        cookie1.setHttpOnly(true);
                        response.addCookie(cookie1);
                    }

                }
            }
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
