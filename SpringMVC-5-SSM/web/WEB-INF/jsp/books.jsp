<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: CJ_CA
  Date: 2022/9/30 0030
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>books</title>
</head>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<body style="align-content: center;text-align: center">
<form class="form-inline" style="margin-top: 30px;" action="/books/search/" method="get">
    <div class="form-group" style="margin-left:900px">
        <label >书籍名称</label>
        <input type="text" class="form-control" id="name" placeholder="查询书籍" name="name">
    </div>
    <button type="submit" class="btn btn-default" >Search</button>
    <a href="${pageContext.request.contextPath}/books/toAdd" style="margin-left: 10px">添加书籍</a>
</form>
<div class="table-responsive"style="margin-text-outline: 30px;">
    <table class="table">
        <caption>全部图书</caption>
        <thead>
        <tr>
            <th>书籍编号</th>
            <th>书籍名称</th>
            <th>书记数量</th>
            <th>书籍简介</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="book" items="${requestScope.get('bookList')}">
            <tr>
                <td>${book.getBookID()}</td>
                <td>${book.getBookName()}</td>
                <td>${book.getBookCounts()}</td>
                <td>${book.getDetail()}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/books/toUpdate/${book.getBookID()}/${book.getBookName()}/${book.getBookCounts()}/${book.getDetail()}">更改</a> |
                    <a href="${pageContext.request.contextPath}/books/delete/${book.getBookID()}">删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</table>
</body>
</html>
