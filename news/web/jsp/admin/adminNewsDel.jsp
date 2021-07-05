
<%@page import="com.news.dao.Impl.NewsDaoImpl"%>
<%@page import="com.news.dao.NewsDao"%>
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
	//获取提交的数据	
	int nid=Integer.parseInt(request.getParameter("id")) ;
	//将数据封装到news对象中来
	News news=new News();
	news.setNid(nid);
	//调用deleteNews方法
	
	NewsDao newsDao=new NewsDaoImpl();
	boolean flag=newsDao.deleteNews(news);
	if(flag){
%>	
	<jsp:forward page="newsDetailList.jsp"></jsp:forward>	
	<% } else{%>
		<script >
			alert("没有删除成功");
			window.document.location.href="newsDetailList.jsp";
		</script> 
	<%} %>
</body>
</html>