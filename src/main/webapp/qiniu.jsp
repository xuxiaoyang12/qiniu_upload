<%--
  Created by IntelliJ IDEA.
  User: Mxia
  Date: 2016/12/13
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="http://up-z1.qiniu.com" method="post" enctype="multipart/form-data">

    <input type="hidden" name="token" value="${token}">
    <input type="file" name="file">
    <button>上传</button>
</form>
<c:if test="${not empty fileName}">
    <img src="http://oi2ngv1it.bkt.clouddn.com/${fileName}" alt="">
</c:if>

</body>
</html>
