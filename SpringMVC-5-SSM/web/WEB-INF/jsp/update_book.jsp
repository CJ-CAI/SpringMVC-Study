<%--
  Created by IntelliJ IDEA.
  User: CJ_CA
  Date: 2022/9/30 0030
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h1 style="margin-left: 200px">修改书籍</h1>
<form class="form-horizontal" action="/books/Update" method="get" style="align-content: center;margin-top: 20px">
    <input type="hidden" name="bookID" value="${bookID}"/>
    <div class="form-group">
        <label for="输入书籍名称" class="col-sm-2 control-label">书籍名称</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="bookName" value="${bookName}" style="width: 300px">
        </div>
    </div>
    <div class="form-group">
        <label  class="col-sm-2 control-label">书籍数量</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="bookCounts" value="${bookCounts}" style="width: 300px">
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">书籍简介</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="detail" value="${detail}" style="width: 300px">
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">更改</button>
        </div>
    </div>
</form>
</body>
</html>
