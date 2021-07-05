<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="com.news.dao.Impl.NewsDaoImpl"%>
<%@page import="com.news.dao.NewsDao"%>
<%@page import="com.news.entity.News"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
	<head>
		<link href="<%=request.getContextPath() %>/css/common.css" rel="stylesheet" type="text/css" />
	</head>
<body>
<form name ="dataFrm" id="dataFrm" action="doUpdate.jsp" method="post">
	<table  width="100%" border="0" cellspacing="5" cellpadding="0">
		<thead>
			<tr><td align="center" colspan="2" class="text_tabledetail2">修改新闻</td></tr>
		</thead>
		<tbody>
		<%
			//中文显示问题
			request.setCharacterEncoding("utf-8");
			News news=new News();
			NewsDao newsDao=new NewsDaoImpl();
		
			int nid=Integer.parseInt(request.getParameter("id"));
			news.setNid(nid);
			news=newsDao.getNewsById(news);
			session.setAttribute("id", news.getNid());
		%>
			
			<tr>
				<td style="text-align:right;" class="text_tabledetail2">标题</td>
				<td style="text-align:left;"><input type="text" name="title" value=<%=news.getTitle() %>></td>
			</tr>
						
			
			<tr>
				<td style="text-align:right;" class="text_tabledetail2">内容</td>
				<td style="text-align:left;">
				<div id="xToolbar"></div>
				<textarea id="newscontent" name="newscontent" rows="8" cols="50"><%=news.getContent() %></textarea></td>
			</tr>
			
			<tr>
				<td style="text-align:center;" colspan="2">
					<button type="submit" class="page-btn" name="save">保存</button>
					<button type="button" class="page-btn" name="return" onclick="javascript:location.href='newsDetailList.jsp'">返回</button>
				</td>
			</tr>
		</tbody>
	</table>
</form>
</body>
</html>