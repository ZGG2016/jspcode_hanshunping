<%--
  Created by IntelliJ IDEA.
  User: cdtdri
  Date: 2021/9/29
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>登录页面</title>
    <style>
        table{
            border-collapse: collapse;
        }
    </style>
</head>
<body>

    <h1> 登录页面 </h1>
    <form action="<%=basePath%>gohallui" method="post">
        <table>
            <tr>
                <td>请输入用户号: </td>
                <td><input type="text" name="id"></td>
            </tr>
            <tr>
                <td>请输入密码: </td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td><input type="submit" value="登录"></td>
                <td><input type="reset" value="重输"></td>
            </tr>
        </table>

    </form>

</body>
</html>
