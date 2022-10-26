<%--
  Created by IntelliJ IDEA.
  User: 杨涛
  Date: 2022/8/16
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<%
        String uid = request.getParameter("uid");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeUse">
    <div class="removerChid">
        <h2>提示</h2>
        <form action="userDelete" method="post">
            <span style="color: #c63317">确定删除该用户</span>
            <input type="hidden" name="account" value=<%=uid%>>
            <input type="submit" value="确定"/>
            <input type="button" value="返回" onclick="history.back(-1)"/>
        </form>
    </div>
</div>
</body>
</html>

