<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.myshopping.domain.Books" %>
<%@ page import="com.example.myshopping.service.MyCart" %>
<%@ page import="com.example.myshopping.domain.Users" %>
<%--
  Created by IntelliJ IDEA.
  User: cdtdri
  Date: 2021/9/29
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title> 我的购物车清单 </title>
</head>
<body>
    <h1>我的购物车</h1>
    <a href="<%=basePath%>gohallui">返回购物大厅</a>
    <form action="<%=basePath%>shoppingclservlet?type=update" method="post">
        <table border="1" style="border-collapse: collapse; width: 600px">
            <tr><td>编号</td><td>书名</td><td>价格</td><td>出版社</td><td>数量</td><td>删除</td></tr>

            <%
                //从request取出要显示的商品的信息
                ArrayList<Books> al = (ArrayList<Books>) request.getAttribute("bookList");

                for(Books book:al){
            %>

                <tr>
                    <td><%=book.getId()%><input type='hidden' name='id' value="<%=book.getId()%>"/></td>
                    <td><%=book.getName()%></td>
                    <td><%=book.getPrice()%></td>
                    <td><%=book.getPublishhouse()%></td>
                    <td><input type="text" name="booknum" value="<%=book.getShoppingNum()%>"/>本</td>
                    <td><a href="<%=basePath%>/shoppingclservlet?type=del&id=<%=book.getId()%>">删除</a></td>
                </tr>

            <%
                }
            %>

            <tr><td colspan="6"><input type="submit" value="update"></td></tr>
            <tr><td colspan="6">购物车总价格：${totalPrice} 元</td></tr>
    </form>
    <a href="<%=basePath%>/gomyorderservlet">提交订单</a>

</body>
</html>
