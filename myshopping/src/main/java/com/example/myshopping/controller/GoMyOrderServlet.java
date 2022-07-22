package com.example.myshopping.controller;

import com.example.myshopping.domain.Books;
import com.example.myshopping.service.MyCart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
// 处理用户查看订单的请求
public class GoMyOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        MyCart myCart = (MyCart) req.getSession().getAttribute("mycart");

        ArrayList<Books> al = myCart.showMyCart();
        float totalPrice = myCart.getTotalPrice();

        req.setAttribute("bookList",al);
        req.setAttribute("totalPrice",totalPrice);

        req.getRequestDispatcher("/WEB-INF/goMyOrder.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
