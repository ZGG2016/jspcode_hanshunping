package com.example.myshopping.controller;

import com.example.myshopping.service.MyCart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 响应用户购买商品的请求
public class ShoppingClServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 接收用户想要购买的商品id
        String id = req.getParameter("id");
//        System.out.println("购买的书号："+id);

        // 什么时候创建购物车： 用户登录成功后，为其创建一个购物车对象
        MyCart myCart = (MyCart) req.getSession().getAttribute("mycart");

        // 接收type值，区分用户希望做什么 del add update
        String type = req.getParameter("type");
        if(type.equals("del")){
            myCart.delBook(id);

        }else if(type.equals("add")){
            //把商品添加到购物车中
            myCart.addBook2(id);

        }else if(type.equals("update")){
            String[] ids = req.getParameterValues("id");
            String[] booknums = req.getParameterValues("booknum");

            for(int i=0;i<ids.length;i++){
                myCart.updateBook(ids[i],Integer.parseInt(booknums[i]));
            }

        }

//        req.setAttribute("bookList",myCart.showMyCart());
//        req.setAttribute("totalPrice",myCart.getTotalPrice()+"");
//
//        req.getRequestDispatcher("/WEB-INF/showMyCart.jsp").forward(req,resp);

        //为了防止某个页面刷新，我们可以sendRedirect
        resp.sendRedirect("goshowmycart");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
