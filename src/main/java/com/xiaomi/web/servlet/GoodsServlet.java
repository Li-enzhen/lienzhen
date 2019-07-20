package com.xiaomi.web.servlet;

import com.xiaomi.domain.Goods;
import com.xiaomi.domain.PageBean;
import com.xiaomi.service.GoodsService;
import com.xiaomi.service.impl.GoodsServiceImpl;
import com.xiaomi.utils.StringUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Li Enzhen
 * 2019/7/1 0001 下午 9:28
 */
@WebServlet(name = "GoodsServlet",value = "/goodsservlet")
public class GoodsServlet extends BaseServlet{
    public  String getGoodsListByTypeId(HttpServletRequest request, HttpServletResponse response){
        //1.获取商品类别
        String _typeId = request.getParameter("typeId");
        String _pageNum = request.getParameter("pageNum");
        String _pageSize = request.getParameter("pageSize");
        int pageNum = 1;
        int pageSize = 8;
        if(!StringUtils.isEmpty(_pageNum)){
            pageNum = Integer.parseInt(_pageNum);
            if(pageNum<=0){
                pageNum = 1;
            }
        }
        if(!StringUtils.isEmpty(_pageSize)){
            pageSize = Integer.parseInt(_pageSize);
            if(pageSize<=0){
                pageSize= 8;

            }

        }
        int typeId = 0;
        if(!StringUtils.isEmpty(_typeId)){
            typeId = Integer.parseInt(_typeId);

        }

        //2.创建业务对象
        GoodsService goodsService =  new GoodsServiceImpl();
       //3.调用方法
       PageBean<Goods> pageBean =  goodsService.findByPage(typeId,pageNum,pageSize);
    //4.放入request
        request.setAttribute("pageBean", pageBean);
        request.setAttribute("typeId", typeId);
        System.out.println(pageBean.getData().toString());
        return "goodsList.jsp";
    }

}
