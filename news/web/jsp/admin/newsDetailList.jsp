
<%@page import="com.news.entity.News"%>
<%@page import="java.util.List"%>
<%@ page import="java.util.ArrayList" %>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>无标题文档</title>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/css/common.css"/>
<style type="text/css">

</style>
<script>
	function addNews(){
		window.location="newsDetailCreateSimple.jsp";
	}
</script>
</head>

<body>
<!--主体-->


    <div class="main-content-right">
        <!--即时新闻-->
        <div class="main-text-box">
            <div class="main-text-box-tbg">
                <div class="main-text-box-bbg">
                    <form name ="searchForm" id="searchForm" action="/news/jsp/admin/newsDetailList.jsp" method="post">
		 	          <div>
		 				新闻分类：
		 					<select name="tid">
	        				<option value="t1001">企业新闻</option>
	        				<option value="t2002">企业文化</option>
	        				<option value="t3003">规章制度</option>
	        				<option value="t4004">市场简讯</option>
	        				<option value="t5005">最新产品</option>
	        				<option value="t6006">人事招聘</option>	        				        			
	        				</select>
		 				新闻标题<input type="text" name="title" id="title" value=''/>
		 					<button type="submit" class="page-btn">GO</button>
		 					<button type="button" onclick="addNews();" class="page-btn">增加</button>
		 					<input type="hidden" name="currentPageNo" value="1"/>
		 					<input type="hidden" name="pageSize" value="10"/>
		 					<input type="hidden" name="totalPageCount" value="2"/>
		 	</div>
		 	</form>
			<table cellpadding="1" cellspacing="1" class="admin-list">
				<thead >
					<tr class="admin-list-head">
						<th>新闻标题</th>
                        <th>作者</th>
                        <th>时间</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                <jsp:useBean id="newsDao" class="com.news.dao.Impl.NewsDaoImpl"></jsp:useBean>
                <%
//                	NewsService newsService=new NewsServiceImpl();
                	List<News> list= newsDao.getNewsList();
                	for(News news:list){
                %>
                	<tr >
                		<td><a href='adminNewsView.jsp?id=2'><%=news.getTitle() %></a></td>
                		<td><%=news.getInputer() %></td>
                		<td><%=news.getTime() %></td>
                		<td><a href='adminNewsCreate.jsp?id=<%=news.getNid() %>'>修改</a>
                			<a href="javascript:if(confirm('确认是否删除此新闻？')) location='adminNewsDel.jsp?id=<%=news.getNid() %>'">删除</a>
                		</td>
                	</tr> 
                <%} %>
            
                </tbody>
            </table>
           <div class="page-bar">
			<ul class="page-num-ul clearfix">
				<li>共7条记录&nbsp;&nbsp; 1/2页</li>
				<a href="javascript:page_nav(document.forms[0],2);">下一页</a>
				<a href="javascript:page_nav(document.forms[0],2);">最后一页</a>&nbsp;&nbsp;
			</ul>
		 <span class="page-go-form"><label>跳转至</label>
	     <input type="text" name="inputPage" id="inputPage" class="page-key" />页
	     <button type="button" class="page-btn" onClick='jump_to(document.forms[0],document.getElementById("inputPage").value)'>GO</button>
		</span>
		</div> 
        </div>
       </div>
   </div>
   </div>



</body></html>