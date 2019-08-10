<%--
  Created by IntelliJ IDEA.
  User: TsuaNm
  Date: 2019/7/30
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:choose>
        <c:when test="${requestScope.security!=null}">
                防伪码:${requestScope.security.securityid}<br>
                验证次数:${requestScope.security.checkcount}<br>
                首次验证时间:${requestScope.security.day}<br>
                产品名称:${requestScope.security.product.productname}<br>
                产品描述:${requestScope.security.product.description}<br>

        </c:when>
        <c:otherwise>
                ${requestScope.msg1}<br>
                ${requestScope.msg2}
        </c:otherwise>
</c:choose>



</body>
</html>
