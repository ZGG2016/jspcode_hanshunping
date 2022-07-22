<%--
  Created by IntelliJ IDEA.
  User: cdtdri
  Date: 2021/9/28
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> 输入页面 </title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/checknum.js"></script>
</head>
<body>

    <form action="result.jsp" method="post">
        第一个数字: <input type="text" id="num1" name="num1"/><br>
        第二个数字: <input type="text" id="num2" name="num2"/><br>
        选择运算符号: <select name="operator">
                        <option value="+">+</option>
                        <option value="-">-</option>
                        <option value="*">*</option>
                        <option value="/">/</option>
                    </select><br>
        <input type="submit" onclick="return checkNum()" value="开始计算"/>
    </form>

</body>
</html>
