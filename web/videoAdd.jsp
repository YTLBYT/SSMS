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
    <div class="left">

    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>视频管理页面 >> 视频添加页面</span>
        </div>
        <div class="providerAdd">
            <form method="post" action="videoAdd" enctype="multipart/form-data">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label for="billId">视频编码：</label>
                    <input type="text" name="vid" id="billId" required/>
                    <span>*请输入视频编码</span>
                </div>
                <div>
                    <label for="billName">商品名称：</label>
                    <input type="text" name="vname" id="billName" required/>
                    <span >*请输入商品名称</span>
                </div>
                <div>
                    <label for="billCom">商品单位：</label>
                    <input type="text" name="vunit" id="billCom" required/>
                    <span>*请输入商品单位</span>

                </div>
                <div>
                    <label for="billNum">商品数量：</label>
                    <input type="text" name="vnum" id="billNum" required/>
                    <span>*请输入大于0的正自然数，小数点后保留2位</span>
                </div>
                <div>
                    <label for="money">总金额：</label>
                    <input type="text" name="vmoney" id="money" required/>
                    <span>*请输入大于0的正自然数，小数点后保留2位</span>
                </div>
                <div>
                    <label >视频：</label>
                    <input type="file" name="myfile" value="选择文件" style="border:0; box-shadow:0px 0px 0px #fff;"/>
                    <span>*请选择视频</span>
                </div>
                <div>
                    <label >是否付款：</label>
                    <input value="0" type="radio" name="zhifu"checked />未付款
                    <input value="1" type="radio" name="zhifu"/>已付款
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