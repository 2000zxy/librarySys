<%--
  Created by IntelliJ IDEA.
  User: 就这样乖乖哒等着
  Date: 2021/3/8
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        body{
            font-size: 17px;
        }
        #index{
            width: 30%;
            margin: 150px auto;
        }
        input {
            margin-top: 30px;
            width: 250px;
            height: 30px;
        }

        button{
            width: 60px;
            height: 30px;
            margin: 30px 80px 30px 40px;
        }
        img{
            width: 100px;
            height: 35px;
            margin-bottom: -10px;
        }
        span{
            color: red;
        }
    </style>
    <script src="js/jquery-3.5.1.js"></script>
    <script type="text/javascript">
        // alert(11);
        function check_user_code() {
            var user_id=$("#uesr_id").val();
            var tset = /^[0-9,A-Z,a-z]{1,25}$/;
            if($("#uesr_id_erro").length>0){
                $("#uesr_id_erro").remove();
            }

            if(!tset.test(user_id)){
                var str=$("<span id='uesr_id_erro'></span>");
                str.text("账号最大长度25位");
                $("#uesr").append(str);
                return false;
                // $("<span id='uesr_id_erro'>账号最大长度25位</span>").appendTo("input");
            }else {
                return true;
            }
        }
        function check_user_pass() {
            if($("#uesr_pass_erro").length>0){
                $("#uesr_pass_erro").remove();
            }
            var pass=$("#pass").val();
            var tset = /^[0-9,A-Z,a-z]{6}$/;
            if(!tset.test(pass)){
                var str=$("<span id='uesr_pass_erro'>密码为6位</span>");
                $("#pas").append(str);
            }
        }
        $(document).ready(function () {
            $("#reg").click(function () {
                location.href="register.jsp";
            })

            $("form").submit(function () {
                if($("#uesr_id").val()==""||$("#pass").val()==""){
                    alert("请输入账号和密码");
                    return false;
                }
                if($("#uesr_id_erro").length>0||$("#uesr_pass_erro").length>0){
                    alert("请填写正确的账号密码");
                    return false;
                }
                return true;
            })

        })
        function ff(){
            pic.src="pic?m="+Math.random();//产生0-1之间的一个值
            return false;//取消了链接的原始事件
        }

    </script>
</head>
<body>
<div id="index">
<form action="users?action=login" method="post">
    <div  id="uesr">账&nbsp&nbsp&nbsp号：<input name="user_code" type="text" id="uesr_id" onblur="check_user_code()"/></div>
    <div  id="pas">密&nbsp&nbsp&nbsp码：<input name="password" type="password" id="pass" onblur="check_user_pass()"/></div>
    <div>验证码：<input type="text" name="usrcode" style="width: 145px;height: 25px"/>
        <a href="" onclick="return ff()"><img src="pic" id="pic" /></a><span class=""></span><br>
        </div>
    <div>
        <button type="submit" id="log">登录</button>
        <button type="button" id="reg">注册</button>
    </div>
</form>
</div>
</body>
</html>
