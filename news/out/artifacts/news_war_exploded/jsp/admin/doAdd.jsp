
<%@page import="com.news.dao.Impl.NewsDaoImpl"%>
<%@page import="com.news.dao.NewsDao"%>
<%@page import="java.util.Date"%>
<%@page import="com.news.entity.News"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//点击保存按钮后，跳转到的页面，在该页面需要调用后台新闻增加功能
//增加成功后，跳转回新闻列表页面，失败了，则返回新闻增加页面
	//中文显示问题
	request.setCharacterEncoding("utf-8");
	News news=new News();
	//从表单中获取提交的数据
	String tid=request.getParameter("tid");
	String title=request.getParameter("title");
	String inputer=request.getParameter("inputer");
	String content=request.getParameter("newscontent");
	String chkuser="u1001";
	//将数据封装到news对象中来
	news.setTid(tid);
	news.setTitle(title);
	news.setInputer(inputer);
	news.setChkuser(chkuser);
	news.setContent(content);
	//日期为当前日期
	news.setTime(new Date());
	//调用addNews方法
	NewsDao newsDao=new NewsDaoImpl();
	boolean flag=newsDao.addNews(news);
	if(flag){
%>	
	<jsp:forward page="newsDetailList.jsp"></jsp:forward>	
	<% } else{%>
	<jsp:forward page="newsDetailCreateSimple.jsp"></jsp:forward>
	<%} %>


</body>
</html>