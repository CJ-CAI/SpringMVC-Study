<%--
  Created by IntelliJ IDEA.
  User: CJ_CA
  Date: 2022/9/30 0030
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="jumbotron" style="margin-top: 100px;background: white">
    <div class="container">
    <h1>library</h1>
    <p>this is a small web library system</p>
    <p>
        <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/books" role="button">Query books</a></p>
    </div>
</div>
</body>
</html>
