<%--
  Created by IntelliJ IDEA.
  User: cdtdri
  Date: 2021/9/28
  Time: 15:03
  To change this template use File | Settings | File Templates.
  两个 JSP 合并成一个 JSP 文件
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> 计算器 </title>
    <script type="text/javascript" src="../js/checknum.js"></script>
</head>
<body>

    <%
        String num1 = request.getParameter("num1");
        String num2 = request.getParameter("num2");
        String operator = request.getParameter("operator");
        double d_num1 = 0;
        double d_num2 = 0;
        double res = 0;

        if(num1!=null && num2!=null & operator!=null){
            d_num1 = Double.parseDouble(num1);
            d_num2 = Double.parseDouble(num2);

            switch (operator) {
                case "+":
                    res = d_num1 + d_num2;
                    break;
                case "-":
                    res = d_num1 - d_num2;
                    break;
                case "*":
                    res = d_num1 * d_num2;
                    break;
                case "/":
                    res = d_num1 / d_num2;
                    break;
            }
        }

    %>

    <form method="post">
        第一个数字: <input type="text" id="num1" value="<%=d_num1 %>" name="num1"/><br>
        第二个数字: <input type="text" id="num2" value="<%=d_num2 %>" name="num2"/><br>
        选择运算符号: <select name="operator">
        <option value="+">+</option>
        <option value="-">-</option>
        <option value="*">*</option>
        <option value="/">/</option>
    </select><br>
        <input type="submit" onclick="return checkNum()" value="开始计算"/>
    </form>
    <hr/>
    运算结果是: <%=res %>

</body>
</html>
