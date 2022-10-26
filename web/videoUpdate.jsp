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
        <span style="float: left" ><a href="login.jsp">退出</a></span>
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
            <span>视频管理页面 >> 视频编辑页</span>
        </div>
        <div class="providerAdd">
            <form method="post" action="videoUpdateInput">
                <div class="">
                    <label for="videoId">视频编号：</label>
                    <input type="text" name="vid" value="${video.vid}" readonly="readonly" id="videoId" placeholder="${video.vid}" />
                    <span>*</span>
                </div>
                <div>
                    <label for="fileId">文件名称：</label>
                    <input type="text" name="vname" value="${video.vname}" id="fileId" placeholder="${video.vname}"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="people">文件大小：</label>
                    <input type="text" name="vsize" value="${video.vsize}" readonly="readonly" id="people" placeholder="${video.vsize}"/>
                    <span>*</span>

                </div>
                <div>
                    <label for="fileType">视频分类：</label>
                    <input type="text" name="vclassify" value="${video.vclassify}" id="fileType" placeholder="${video.vclassify}"/>
                    <span>*</span>
                </div>
                <div>
                    <label >审核状态：</label>
                    审核通过: <input value="2" type="radio" name="vstatues"  placeholder="审核通过" checked/>
                    审核未通过: <input value="1" type="radio" name="vstatues"  placeholder="审核未通过"/>
                    <span>*</span>
                </div>
                <div>
                    <label for="uploadTime">上传时间：</label>
                    <input type="text" name="vtime" id="uploadTime" value="${video.vtime}" placeholder="${video.vtime}"/>
                    <span>*</span>
                </div>
                <div>
                    <label for="countId" >浏览数量：</label>
                    <input type="text" name="vnumber" value="${video.vnumber}" readonly="readonly" id="countId" placeholder="${video.vnumber}"/>
                </div>
                <div class="providerAddBtn">
                    <input type="submit" value="保存" onclick="history.back(-1)"/>
                    <input type="button" value="返回" onclick="history.back(-1)"/>
                </div>
            </form>
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