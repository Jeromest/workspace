<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    	<title>注册界面</title>
    	<link href="css/style.css" type="text/css" rel="stylesheet" />
    </head>
    <body>
    	<div class="global">
            <div class="header">
                <h2>后台管理系统</h2>
            </div>
            <div class="content register">
                <h3>管理员账号注册</h3>
                <form action="admin?msg=register" method="post">
                    <input type="text" name="username" placeholder="用户名" />
                    <input type="password" name="password"  placeholder="密码" />
                    <input type="password" name="repassword"  placeholder="重复密码" />
					<input type="text" name="email"  placeholder="电子邮箱" />
                    <input type="text" name="tel" class="tel" placeholder="电话" />
                    <input type="submit" value="注册" />
                </form>
                <div style="padding:10px 0px;text-align:center">
                    <font color="red">${error}</font>
                </div>
            </div>
            <div class="footer">
           粤嵌科技 &nbsp;©&nbsp;版权所有&nbsp;&nbsp;2021
            </div>
        </div>
    </body>
</html>