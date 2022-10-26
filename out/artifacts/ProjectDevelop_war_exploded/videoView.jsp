<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <span style="float: left"><a href="login.jsp">退出</a></span>
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
            <span>视频管理页面 >> 查看详情</span>
        </div>
        <div class="providerView">
            <div class="providerViewLeftbox">
                <p><strong>视频编号：</strong><span>${video.vid}</span></p>
                <p><strong>文件名称：</strong><span>${video.vname}</span></p>
                <p><strong>文件大小：</strong><span>${video.vsize}</span></p>
                <p><strong>文件类型：</strong><span>${video.vtype}</span></p>
                <p><strong>视频分类：</strong><span>${video.vclassify}</span></p>
                <p><strong>审核状态：</strong><c:if test="${video.vstatues==0}">
                                                <span>未审核</span>
                                            </c:if>

                                             <c:if test="${video.vstatues==1}">
                                                <span>审核未通过</span>
                                             </c:if>
                                            <c:if test="${video.vstatues==2}">
                                                <span>审核通过</span>
                                            </c:if></p>
                <p><strong>上传时间：</strong><span>${video.vtime}</span></p>
                <p><strong>浏览数量：</strong><span>${video.vnumber}</span></p>
            </div>
            <div class="providerViewRightbox">
                <a href="pro">审核通过</a>
                <a href="pro">审核未通过</a>
                <a href="videoList">返回</a>
                <div style="border: #bd644e solid ;width: 300px;height: 300px;margin-top: 20px;">
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
    });
</script>
</body>
</html>