<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <form method="GET" action="/user/login">
        username:<input type = "text" name = "username"/>
        password:<input type = "password" name = "password"/>
        <input type="submit" value = "submit">
    </form>
    <hr/>
    <%
        String msg = (String) request.getAttribute("msg");
        if(msg==null){
            msg = "";
        }
    %>
    ${msg}
</body>
</html>
