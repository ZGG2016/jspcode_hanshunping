<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.myshopping.domain.Books" %><%--
  Created by IntelliJ IDEA.
  User: cdtdri
  Date: 2021/9/29
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>购物大厅</title>
</head>
<body>
    <h1>欢迎访问购物大厅</h1>

    <table border="1">
        <tr>
            <td>书名</td> <td>价格</td> <td>出版社</td> <td>点击购买</td>
        </tr>

        <%

            ArrayList<Books> books = (ArrayList<Books>) request.getAttribute("books");
            for(Books book:books){
        %>
        <tr>
            <td><%=book.getName() %></td>
            <td><%=book.getPrice() %></td>
            <td><%=book.getPublishhouse() %></td>
            <td><a href="<%=basePath%>shoppingclservlet?type=add&id=<%=book.getId()%>">购买</a></td>
        </tr>
        <%
            }
        %>

        <tr>
            <td colspan="4"><input type="button" value="查看购物车"></td>
        </tr>
    </table>

    <a href="/myshopping_war_exploded">返回重新登录</a>

</body>
</html>
