
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
	//中文显示问题
	request.setCharacterEncoding("utf-8");
	News news=new News();
	//从session中获取id的值 
	int nid=(int) session.getAttribute("id");
	//从表单中获取提交的数据	
	String title=request.getParameter("title");
	String content=request.getParameter("newscontent");
	//将数据封装到news对象中来
	news.setNid(nid);
	news.setTitle(title);
	news.setContent(content);
	//修改日期为当前日期 
	news.setTime(new Date());
	//调用updateNews方法
	NewsDao newsDao=new NewsDaoImpl();
	boolean flag=newsDao.updateNews(news);
	if(flag){
%>	
	<jsp:forward page="newsDetailList.jsp"></jsp:forward>	
	<% } else{%>
	<jsp:forward page="adminNewsCreate.jsp"></jsp:forward>
	<%} %>


</body>
</html>