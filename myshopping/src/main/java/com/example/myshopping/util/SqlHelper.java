package com.example.myshopping.util;

import java.sql.*;
import java.util.ArrayList;
// 工具类，完成对数据库的curd操作
// 也要支持分页和多表查询
public class SqlHelper {

    private static Connection ct=null;
    private static ResultSet rs=null;
    private static PreparedStatement ps=null;

    // 把查询封装成一个函数
    // select ?,?,? from student where name=?...
    public ArrayList executeQuery(String sql, String[] params) {
        ArrayList al=new ArrayList();
        try {
            ct=DBUtil.getConnection();
            ps=ct.prepareStatement(sql);
            //给sql问号赋值
            for (int i = 0; i < params.length; i++) {
                ps.setString(i+1, params[i]);
            }
            rs=ps.executeQuery();
            //非常有用
            ResultSetMetaData rsmd=rs.getMetaData();
            //用法rs可以得到结果集有多少列
            int columnNum=rsmd.getColumnCount();
            //循环从a1中取出数据封装到ArrayList
            while(rs.next()) {
                Object[] objects=new Object[columnNum];
                for(int i=0;i<objects.length;i++) {
                    objects[i]=rs.getObject(i+1); //返回对象数组
                }
                al.add(objects);
            }
            return al;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }finally {
            DBUtil.close(rs,ps,ct);
        }

    }
    public ResultSet executeQuery(String sqlstr)
    {
        Statement stmt = null;
        try
        {
            //得到连接
            ct=DBUtil.getConnection();
            //ps=ct.prepareStatement(sqlstr);
            stmt = ct.createStatement();
            //创建结果集
            rs = stmt.executeQuery(sqlstr);
            //将结果集返回
            return rs;
        }
        catch(SQLException e)
        {
            System.out.print("错误");
        }
        return null;
    }
}
