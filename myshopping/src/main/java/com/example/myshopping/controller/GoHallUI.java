package com.example.myshopping.controller;

import com.example.myshopping.domain.Books;
import com.example.myshopping.domain.Users;
import com.example.myshopping.service.BookService;
import com.example.myshopping.service.MyCart;
import com.example.myshopping.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class GoHallUI extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //先判断该用户是否已经登录，如果登录了的话，则直接跳转到购物大厅。可读性差一些
        if(req.getSession().getAttribute("user")!=null){
            BookService bs = new BookService();
            ArrayList<Books> al = bs.getAllBook();
            //把显示的数据放入到request原因第因为request对象的生命最短
            req.setAttribute("books", al);

            req.getRequestDispatcher("/WEB-INF/hall.jsp").forward(req,resp);
        }

        String id = req.getParameter("id");
        String passwd = req.getParameter("password");

        Users user = new Users(Integer.parseInt(id),passwd);

        UserService us = new UserService();

        if(us.checkUser(user)){

            // 其他页面可能要用到用户信息，所以将其放到session
            req.getSession().setAttribute("user",user);

            //创建购物车对象（当用户登录成功后，为其创建购物车）
            MyCart myCart = new MyCart();
            req.getSession().setAttribute("mycart",myCart);

            //也是给下一个页面hall.jsp准备要显示的数据
            BookService bs = new BookService();
            ArrayList<Books> al = bs.getAllBook();
            //把显示的数据放入到request原因第因为request对象的生命最短
            req.setAttribute("books", al);

            req.getRequestDispatcher("/WEB-INF/hall.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req,resp);

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
