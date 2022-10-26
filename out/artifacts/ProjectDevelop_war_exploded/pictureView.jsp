<%@ page import="cn.wolfcode.entity.PicView" %><%--
  Created by IntelliJ IDEA.
  User: 瑶
  Date: 2022/8/17
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
  PicView picView = (PicView)session.getAttribute("picView");

%>

<!DOCTYPE html>
<html>
<head lang="en">
  <meta charset="UTF-8">
  <title> 静态资源后台管理系统</title>
  <link rel="stylesheet" href="css/public.css"/>
  <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<!--头部-->
<header class="publicHeader">
  <h1> 静态资源后台管理系统</h1>
  <div class="publicHeaderR">
    <div style="width: 46px;height: 46px;border-radius: 50%;overflow: hidden;margin-left: -100px;float: left">
      <img style="width: 100%" src="img/head_img.jpeg" alt="头像">
    </div>
    <span style="float: left" ><a href="login.html">退出</a></span>
  </div>
</header>
<!--时间-->
<section class="publicTime">
  <span id="time">2019年1月1日 11:11  星期一</span>
  <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian ">
  <div class="left"></div>
  <div class="right">
    <div class="location">
      <strong>你现在所在的位置是:</strong>
      <span>图片管理页面 >> 图片详情</span>
    </div>
    <div class="providerView">
      <div class="providerViewLeftbox">
        <p><strong>图片编号：</strong><span>${picView.picId}</span></p>
        <p><strong>文件名称：</strong><span>${picView.picName}</span></p>
        <p><strong>文件大小：</strong><span>${picView.picSize}</span></p>
        <p><strong>文件类型：</strong><span>${picView.picType}</span></p>
        <p><strong>图片分类：</strong><span>${picView.picDes}</span></p>
        <p><strong>审核状态：</strong><span>${picView.status}</span></p>
        <p><strong>上传时间：</strong><span>${picView.picUpTime}</span></p>
        <p><strong>浏览数量：</strong><span>${picView.num}</span></p>
      </div>
      <div class="providerViewRightbox">
        <a href="./uppicsta?picId=${picView.picId}&picSta=1">审核通过</a>
        <a href="./uppicsta?picId=${picView.picId}&picSta=2">审核未通过</a>
        <a href="picture.jsp">返回</a>
        <div style="border: #bd644e solid ;width: 300px;height: 300px;margin-top: 20px;">
            <img src="img/${picView.picUrl}" width=300 height=300>
        </div>
      </div>

    </div>
  </div>
</section>
<footer class="footer">
</footer>
<script src="js/time.js"></script>
<script src="js/jquery.js"></script>
<script>
  $(function () {
    $(".left").load("common_pri.jsp");
  }) ;
</script>
</body>
</html>