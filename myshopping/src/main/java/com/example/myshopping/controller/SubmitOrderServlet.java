package com.example.myshopping.controller;

import com.example.myshopping.domain.Users;
import com.example.myshopping.mail.Mail;
import com.example.myshopping.service.MyCart;
import com.example.myshopping.service.OrderService;
import com.sun.org.apache.xpath.internal.operations.Or;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
// 处理下订单的请求
public class SubmitOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try{
            OrderService os = new OrderService();
            MyCart myCart = (MyCart) req.getSession().getAttribute("mycart");
            Users user = (Users) req.getSession().getAttribute("user");
            os.submitOrder(myCart,user);

        }catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            req.getRequestDispatcher("/WEB-INF/errInfo.jsp").forward(req,resp);
        }

        req.getRequestDispatcher("/WEB-INF/orderOk.jsp").forward(req,resp);

        //如果订单写入数据库成功，把邮件发送给客户
        //创建一个Mail对象实例
//        Mail mail = new Mail();
//        Users user = (Users)req.getSession().getAttribute("user");
//        String To=user.getEmail();
//        String Subject="订单完成通知";
//        String Content="你在XX网上订购了图书，请注意查收，谢谢！";
//        String Username=user.getName();
//        String Filename = "";
//        try {
//            mail.SendMail(To,Subject,Content,Username,Filename);
//        } catch (MessagingException e) {
//            // TODO Auto-generated catch block
//            System.out.println("购物车---SubmitOrderServlet--邮件发送失败");
//            e.printStackTrace();
//        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
