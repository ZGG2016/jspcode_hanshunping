package com.example.myshopping.controller;

import com.example.myshopping.service.MyCart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoShowMyCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //得到购物车
        MyCart myCart = (MyCart)req.getSession().getAttribute("mycart");
        //把要显示的数据放入request，准备显示
        req.setAttribute("bookList",myCart.showMyCart());
        req.setAttribute("totalPrice",myCart.getTotalPrice());
        //跳转到显示我的购物车中去
        req.getRequestDispatcher("/WEB-INF/showMyCart.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
