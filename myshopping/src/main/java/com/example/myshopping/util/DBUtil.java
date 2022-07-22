package com.example.myshopping.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtil {

    private static Connection conn = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;
    private static PreparedStatement ps=null;
    private static Properties prop = new Properties(); // 创建并实例化Properties对象的实例
    private static String propFileName = "db.properties"; // 指定资源文件保存的位置
    private static String dbClassName = ""; //定义保存数据库驱动的变量
    private static String dbUrl = "";
    private static String dbUser = "";
    private static String dbPwd = "";
    static{	//定义构造方法
        try {
            //将Properties文件读取到InputStream对象中
            InputStream in = DBUtil.class.getClassLoader().getResourceAsStream(propFileName);
            prop.load(in); // 通过输入流对象加载Properties文件
            dbClassName = prop.getProperty("DB_CLASS_NAME");
            dbUrl = prop.getProperty("DB_URL", dbUrl);
            dbUser = prop.getProperty("DB_USER", dbUser);
            dbPwd = prop.getProperty("DB_PWD", dbPwd);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //得到连接
    public static Connection getConnection() {

//		System.out.println("dbClassName:"+dbClassName);
//		System.out.println("dbUrl:"+dbUrl);
//		System.out.println("dbUser:"+dbUser);
//		System.out.println("dbPwd:"+dbPwd);

        try {
            Class.forName(dbClassName) ;
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
        } catch (Exception ee) {
            ee.printStackTrace();
        }
        if (conn == null) {
            System.err
                    .println("警告: DbConnectionManager.getConnection() 获得数据库链接失败.\r\n\r\n链接类型:"
                            + dbClassName
                            + "\r\n链接位置:"
                            + dbUrl
                            + "\r\n用户/密码"
                            + dbUser + "/" + dbPwd);
        }
        return conn;
    }

    /*
     * 功能：执行查询语句
     */
    public static ResultSet executeQuery(String sql) {
        try {
            conn = getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return rs; // 返回结果集对象
    }

    /*
     * 功能:执行更新操作
     */
    public int executeUpdate(String sql) {
        int result = 0; // 定义保存返回值的变量
        try { // 捕捉异常
            conn = getConnection(); // 调用getConnection()方法构造Connection对象的一个实例conn
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            result = stmt.executeUpdate(sql); // 执行更新操作
        } catch (SQLException ex) {
            result = 0; // 将保存返回值的变量赋值为0
        }
        return result; // 返回保存返回值的变量
    }

    /*
     * 功能:关闭数据库的连接
     */
    public static void close(ResultSet rs,Statement stmt,Connection conn) {
        try { // 捕捉异常
            if (rs != null) { // 当ResultSet对象的实例rs不为空时
                rs.close(); // 关闭ResultSet对象
            }
            if (stmt != null) { // 当Statement对象的实例stmt不为空时
                stmt.close(); // 关闭Statement对象
            }
            if (conn != null) { // 当Connection对象的实例conn不为空时
                conn.close(); // 关闭Connection对象
            }
        } catch (Exception e) {
            e.printStackTrace(System.err); // 输出异常信息
        }
    }

//    public static void main(String args [])
//    {
//        System.out.println("dbClassName:"+dbClassName);
//        System.out.println("dbUrl:"+dbUrl);
//        System.out.println("dbUser:"+dbUser);
//        System.out.println("dbPwd:"+dbPwd);
//        System.out.println("--------------------------");
//    }
}
