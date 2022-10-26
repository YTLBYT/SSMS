<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
    <nav>
        <ul class="list">

            <c:forEach items="${userInfo.t_priviageList}" var="pri">
                <li ><a href="${pri.purl}">${pri.pname}</a></li>
            </c:forEach>
        </ul>
        <script >

        </script>
    </nav>

