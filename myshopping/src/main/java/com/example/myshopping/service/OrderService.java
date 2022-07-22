package com.example.myshopping.service;

import com.example.myshopping.domain.Books;
import com.example.myshopping.domain.Users;
import com.example.myshopping.util.DBUtil;

import java.awt.print.Book;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;

// 处理与订单相关的业务逻辑
public class OrderService {

    private static Connection ct=null;
    private static ResultSet rs=null;
    private static PreparedStatement ps=null;
    Serializable serialnumber = null;

    //下订单涉及到两张表，而两张表有关系
    public void submitOrder(MyCart mycart, Users user) {

        try {
            String sql1 = "insert into orders (userid,totalPrice) values (?,?)";
            //因为添加订单复杂！所以这种操作很特别，
            // 于是我们不使用SqlHelper,而是专门针对下订单写对数据库的操作
            ct = DBUtil.getConnection();
            //为了保证我们的订单号，是稳定的，所以将其事务隔离级别升级（可串行）
            ct.setAutoCommit(false);
            ct.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

            ps = ct.prepareStatement(sql1,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,user.getId());
            ps.setFloat(2,mycart.getTotalPrice());
            ps.executeUpdate();

            //如何得到刚刚插入的订单记录的订单号呢？
            rs = ps.getGeneratedKeys();
            if(rs.next()){
                serialnumber = (Serializable) rs.getObject(1);
            }
            //把订单细节表也生成【批量提交！！！】
            ArrayList<Books> al = mycart.showMyCart();
            for (Books book : al) {
                String sql2 = "insert into orderitem (ordid,bookid,booknum) values (?,?,?)";
                ps = ct.prepareStatement(sql2);
                ps.setInt(1, Integer.parseInt(String.valueOf(serialnumber)));
                ps.setInt(2, book.getId());
                ps.setInt(3, book.getShoppingNum());
                ps.executeUpdate();

            }
            //整体提交
            ct.commit();

        }catch (Exception e) {
            try {
                ct.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                System.out.println("插入数据失败");
                e1.printStackTrace();
            }
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }finally {
            DBUtil.close(rs,ps,ct);
        }
    }
}
