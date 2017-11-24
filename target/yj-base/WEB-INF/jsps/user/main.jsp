<%@ page import="com.project.po.UserData" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>main</title>
    <script src="/js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript">
        function check2(){
            var name = document.getElementById("username");
            $.ajax({
                type:"post",
                async:false,
                url:"/user/check",
                dataType:"text",
                data:"username="+name,
                success:function (data) {
                    var jsonObj = JSON.parse(data)

                    if (jsonObj.result=="true"){
                        alert("此账号可以注册")
                    }
                    else{
                        alert("此账号不可注册")
                    }
                }

            })
        }



        function check(){
            var name = document.getElementById("username");
            $.get("/user/check?username="+name,name,function(data){
                var jsonObj = JSON.parse(data)
                alert (jsonObj.res)
            })
        }
    </script>
</head>
<body>

    welcome ${requestScope.username} !
    <hr/>
    ${requestScope.userdata}
    <hr/>
    <form action = "/user/upload" method="post" enctype="multipart/form-data">
        <input type="file" name = "file" /><br/>
        <input type = submit value="文件上传">
    </form>
    <input id = "username">
    <button name = "check" onclick = "check()">check</button>
</body>
</html>
