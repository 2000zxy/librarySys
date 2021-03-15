<%--
  Created by IntelliJ IDEA.
  User: 就这样乖乖哒等着
  Date: 2021/3/8
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        #body{
            width: 30%;
            margin: 150px auto;
            font-size: 17px;
        }
        input {
            margin-top: 30px;
            width: 200px;
            height: 30px;
        }
        button{
            width: 60px;
            height: 30px;
            margin: 30px 80px 30px 25px;
        }
        span{
            color: red;
        }
    </style>
    <script src="js/jquery-3.5.1.js"></script>
    <script type="text/javascript">
        function check_user_code() {
            var user_code = $("#user_code").val();
            if($("#user_code_erro").length>0){
                $("#user_code_erro").remove();
            }
            if(user_code==""){
                    var str=$("<span id='user_code_erro'>账号不能为空</span>");
                    $("#user_code1").append(str);
                    return false;
            }else {
                $.getJSON("users?action=checkUser_code",{user_code:user_code},function (data) {
                    if(data==true){
                        var str=$("<span id='user_code_erro'>账号已存在</span>");
                        $("#user_code1").append(str);
                        return false;
                    }else {
                        return true;
                    }
                })
            }
        }
        function check_user_pass() {
            if($("#user_pass_erro").length>0){
                $("#user_pass_erro").remove();
            }
            var pass=$("#pass").val();
            var tset = /^[0-9,A-Z,a-z]{6}$/;
            if(pass==""){
                var str=$("<span id='user_pass_erro'>密码不能为空</span>");
                $("#user_pass").append(str);
                return false;
            }else {
                if(!tset.test(pass)){
                    var str=$("<span id='user_pass_erro'>密码为6位字符</span>");
                    $("#user_pass").append(str);
                    return false;
                }else {
                    return true;
                }

            }
        }
        function check_user_pass2() {
            if($("#user_pass2_erro").length>0){
                $("#user_pass2_erro").remove();
            }
            var pass=$("#pass").val();
            var pass2=$("#password2").val();
            if(pass!=pass2||pass2==""){
                var str=$("<span id='user_pass2_erro'>两次密码不一致</span>");
                $("#user_pass2").append(str);
                return false;
            }else {
                return  true;
            }
        }
        function check_user_email() {
            if($("#user_email_erro").length>0){
                $("#user_email_erro").remove();
            }
            var email = $("#email").val();
            var tset = /^[0-9,A-Z,a-z,@,.]{7,50}$/;
            if(!tset.test(email)){
                var str=$("<span id='user_email_erro'>邮箱格式错误</span>");
                $("#user_email").append(str);
                return false;
            }else {
                return true;
            }
        }
        $(document).ready(function () {
            $("form").submit(function () {
                check_user_code();
                check_user_pass();
                check_user_pass2();
                check_user_email();
                var gender = document.getElementsByName("gender");
                var sex;
                for (var i = 0; i < gender.length; i++) {
                    if(gender[i].checked==true){
                        sex = gender[i].value;
                    }
                }
                if(check_user_code()&&check_user_pass()&&check_user_pass2()&&check_user_email()){
                    if(sex==null||sex==""){
                        alert("请选择性别");
                        return false;
                    }else {
                       return true;
                    }
                }else {
                    alert("请填写正确信息");
                    return false;
                }



                return true;

            })

        })
    </script>

</head>
<body>
<div id="body">
<form action="users?action=register" method="post">
    <div id="user_code1">账　　号&nbsp<input name="user_code" id="user_code" maxlength="25" onblur="check_user_code()"></div>
    <div id="user_email">邮　　箱&nbsp<input name="email" id="email" onblur="check_user_email()"></div>
    <div id="user_gender">性　　别&nbsp<input name="gender" type="radio" value="男" style="width: 50px;height: 15px">男<input name="gender" type="radio" value="女" style="width: 50px;height: 15px">女</div>
    <div id="user_pass">密　　码&nbsp<input name="pass" type="password" id="pass" onblur="check_user_pass()"></div>
    <div id="user_pass2">确认密码&nbsp<input name="pass2" type="password" id="password2" onblur="check_user_pass2()"></div>
    <div>
        <button id="btn" type="submit">提交</button>
        <button id="re" type="reset">重置</button>
    </div>
</form>
</div>
</body>
</html>
