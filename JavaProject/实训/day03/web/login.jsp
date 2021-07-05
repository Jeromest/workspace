<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    	<title>登录界面</title>
    	<link href="css/style.css" type="text/css" rel="stylesheet" />
    </head>
    
    <body>
    	<div class="global">
            <div class="header">
                <h2>后台管理系统</h2>
            </div>
            <div class="content">
                <div class="float-lt ctleft">
                	<h3>管理员登录</h3>
                    <form action="admin?msg=login" method="post">
                        <input type="text" name="username" class="name" placeholder="用户名" required="" />
                        <input type="password" name="password" class="password" placeholder="密码" required="" />
                        <ul>
                            <li>
                            <input type="checkbox" id="brand" value="" />
                            <label for="brand"><span></span>记住密码</label>
                            </li>
                        </ul>
                        <a href="#">忘记密码?</a><br/>
                        <input type="submit" value="登录" />
                    </form>
                    <div style="padding:10px 0px;text-align:center">
                    	<font color="red">${error}</font>
                    </div>
                </div>
                <div class="float-rt ctright">
                 	<h3>JSP简介</h3>
			<p>&nbsp;&nbsp;&nbsp;&nbsp;JSP 与 PHP、ASP、ASP.NET 等语言类似，运行在服务端的语言。<br/> &nbsp;&nbsp;&nbsp;&nbsp;JSP全称Java Server Pages，是一种动态网页开发技术。它使用JSP标签在HTML网页中插入Java代码。<br/> &nbsp;&nbsp;&nbsp;&nbsp;JSP是一种Java servlet，主要用于实现Java web应用程序的用户界面部分。网页开发者们通过结合HTML代码、XHTML代码、XML元素以及嵌入JSP操作和命令来编写JSP。</p>
            <a class="registerbtn" href="register.jsp">点击注册</a>
                </div>
                <div class="clear"></div>
            </div>
            <div class="footer">
            粤嵌科技 &nbsp;©&nbsp;版权所有&nbsp;&nbsp;2021
            </div>
        </div>
    </body>
</html>