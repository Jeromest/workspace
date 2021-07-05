<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    	<title>管理员信息界面</title>
    	<link href="css/style.css" type="text/css" rel="stylesheet" />
    </head>

    <body>
    	<div class="global">
            <div class="header">
                <h2>后台管理系统</h2>
            </div>
            <div class="content">
                <div class="float-lt ctleft">
                    <div style="padding:0px;text-align:center">
                        <font color="red">欢迎你，${admin.username}！</font>
                    </div>
                	<h3>管理员信息</h3>
                    <table>
                    <tr>
                        <th>账号名称:</th><td>${admin.username}</td>
                    </tr>
                    <tr>
                        <th>密码:</th><td>${admin.password}</td>
                    </tr>
                    <tr>
                        <th>电子邮箱:</th><td>${admin.email}</td>
                    </tr>
                    <tr>
                        <th>电话:</th><td>${admin.tel}</td>
                    </tr>
                    </table>
                    <div class="btninfo">
                        <a class="exitbtn" href="admin?msg=exit">退出账号</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a class="changepsbtn" href="changepassword.jsp">修改密码</a>
                    </div>
                </div>
                <div class="float-rt ctright">
                 	<h3>JSP连接数据库</h3>
                    <p>
                    1、注册JDBC驱动(加载驱动程序)<br/>
                    2、连接数据库<br/>
                    3、执行数据操作(执行SQL语句)<br/>
                    &nbsp;&nbsp;(1)、增加数据操作&nbsp;&nbsp;&nbsp;&nbsp;(2)、删除数据操作<br/>
                    &nbsp;&nbsp;(3)、修改数据操作&nbsp;&nbsp;&nbsp;&nbsp;(4)、查询数据操作<br/>
                    4、操作完成后关闭<br/>
                    </p>
                    <a class="registerbtn" href="admin?action=logout&adminid=${admin.id}">注销账号</a>
                </div>
                <div class="clear"></div>
            </div>
            <div class="footer">
            粤嵌科技 &nbsp;©&nbsp;版权所有&nbsp;&nbsp;2021
            </div>
        </div>
    </body>
</html>