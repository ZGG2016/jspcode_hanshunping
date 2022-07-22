<%@ page import="com.example.myshopping.domain.Users" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.myshopping.domain.Books" %><%--
  Created by IntelliJ IDEA.
  User: cdtdri
  Date: 2021/9/30
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>我的订单</title>
    <script type="text/javascript">

        window.location.href = "<%=basePath%>submitorderservlet";

    </script>
</head>
<body>
    <h1>我的订单</h1>
    <h2>我的个人信息</h2>
    <table border="1" style="border-collapse:collapse">
        <tr><td colspan="2">用户个人信息</td></tr>
        <tr><td>用户名</td><td><%=((Users)session.getAttribute("user")).getName() %></td></tr>
        <tr><td>电子邮箱</td><td><%=((Users)session.getAttribute("user")).getEmail() %></td></tr>
        <tr><td>用户级别</td><td><%=((Users)session.getAttribute("user")).getGrade() %></td></tr>
    </table></br>

    <table border=1 style="border-collapse:collapse">
        <tr><td>编号<td>书名</td><td>价格</td><td>出版社</td><td>数量</td></tr>
        <%
            //循环的显示购物车中的商品信息
            ArrayList<Books> al = (ArrayList)request.getAttribute("bookList");
    //     		System.out.println("al.size:"+al.size());
            for(Books book:al){
        %>
            <tr>
                <td><%=book.getId()%></td>
                <td><%=book.getName()%></td>
                <td><%=book.getPrice()%></td>
                <td><%=book.getPublishhouse()%></td>
                <td><%=book.getShoppingNum()%>本</td>
            </tr>
        <%
            }
        %>
        <tr><td colspan="5">订单总价格：${totalPrice}元</td></tr>
    </table>

    <input type="button" onclick="goSubmitOrder()" value="确认订单"/>
</body>
</html>
