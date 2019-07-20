package com.xiaomi.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created by Li Enzhen
 * 2019/6/27 0027 下午 10:41
 */
public class BaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String methodName = request.getParameter("method");
        //利用反射
        try {
            Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);

            if (method != null) {
                String url = (String) method.invoke(this, request, response);
                if (url != null && url.trim().length() != 0) {
                    String[] urls = url.split(":");
                    if (urls[0].equals("redirect")) {
                        //重定向
                        response.sendRedirect(urls[1]);
                    } else {    //转发
                        request.getRequestDispatcher(url).forward(request, response);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("方法不存在");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
