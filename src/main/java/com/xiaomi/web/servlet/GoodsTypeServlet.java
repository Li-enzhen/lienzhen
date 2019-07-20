package com.xiaomi.web.servlet;

import com.alibaba.fastjson.JSON;
import com.xiaomi.domain.GoodsType;
import com.xiaomi.service.GoodsTypeService;
import com.xiaomi.service.impl.GoodsTypeServiceimpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Li Enzhen
 * 2019/7/1 0001 下午 5:36
 */
@WebServlet(name = "GoodsTypeServlet", value = "/goodstypeservlet")
public class GoodsTypeServlet extends BaseServlet {
    public String goodstypelist(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("application/json;charset=Utf-8");
        GoodsTypeService goodsTypeService = new GoodsTypeServiceimpl();
        List<GoodsType> goodsTypeList = goodsTypeService.findByLevel(1);
        //把集合转成JSON
        String json = JSON.toJSONString(goodsTypeList);
        response.getWriter().println(json);
        return null;
    }
}
