<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
	<head>
		<link href="<%=request.getContextPath() %>/css/common.css" rel="stylesheet" type="text/css" />
	</head>
<body>
<form name ="dataFrm" id="dataFrm" action="doAdd.jsp" method="post">
	<table  width="100%" border="0" cellspacing="5" cellpadding="0">
		<thead>
			<tr><td align="center" colspan="2" class="text_tabledetail2">增加新闻</td></tr>
		</thead>
		<tbody>
			<tr>
				<td style="text-align:right;" class="text_tabledetail2">分类</td>
				<td style="text-align:left;">
				<!-- 列出所有的新闻分类 -->
					<select name="tid">
	        			<option value="t1001">企业新闻</option>
	        			<option value="t2002">企业文化</option>
	        			<option value="t3003">规章制度</option>
	        			<option value="t4004">市场简讯</option>
	        			<option value="t5005">最新产品</option>
	        			<option value="t6006">人事招聘</option>	        				        			
	        		</select>
				</td>
			</tr>
			<tr>
				<td style="text-align:right;" class="text_tabledetail2">标题</td>
				<td style="text-align:left;"><input type="text" name="title" value=""/></td>
			</tr>
			<tr>
				<td style="text-align:right;" class="text_tabledetail2">作者</td>
				<td style="text-align:left;"><input type="text" name="inputer" value=""/></td>
			</tr>
						
			<tr>
				<td style="text-align:right;" class="text_tabledetail2">内容</td>
				<td style="text-align:left;">
				<div id="xToolbar"></div>
				<textarea id="newscontent" name="newscontent" rows="8" cols="50"></textarea></td>
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