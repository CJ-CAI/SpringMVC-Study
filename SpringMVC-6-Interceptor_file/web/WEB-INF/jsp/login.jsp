<%--
  Created by IntelliJ IDEA.
  User: CJ_CA
  Date: 2022/10/3 0003
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
<%--    <script src="${pageContext.request.contextPath}/WEB-INF/statics/jquery-3.6.1.min.js"></script>--%>
    <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
    <script>
        function login(){
            let name=document.getElementById("name").value;
            console.log(name+pwd);
            $.get({
                url:"/doLogin/"+name+"/"+pwd,
                data:{'flag':$("#flag").val()},
                success:function (data) {
                alert(data);
                }
            });
        }
    </script>
</head>
<body>
<form name="myForm">
    <input type="text" id="name" name="name">
    <input type="text" id="pwd" name="pwd" onblur="login()">
</form>

</body>
</html>
