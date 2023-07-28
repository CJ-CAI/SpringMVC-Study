<%--
  Created by IntelliJ IDEA.
  User: CJ_CA
  Date: 2022/9/30 0030
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
  if (${flag})
    window.alert("用户名或密码错误");
</script>
<html>
<head>
  <title>Title</title>
  <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h1 style="margin-left: 200px;margin-top: 20px">login</h1>
<form action="/books/doLogin" class="form-horizontal" style="margin-top: 20px">
  <div class="form-group">
    <label  class="col-sm-2 control-label">账号名称</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="name" style="width: 300px">
    </div>
  </div>
  <div class="form-group">
    <label class="col-sm-2 control-label">密码</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="pwd" style="width: 300px">
    </div>
  </div>

  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">登录</button>
    </div>
  </div>
</form>
</body>
</html>
