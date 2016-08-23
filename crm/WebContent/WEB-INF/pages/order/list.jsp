<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="atguigu" tagdir="/WEB-INF/tags"%>
<%@ include file="/commons/common.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="true">
  <head>
    <title>查看历史订单</title>
  </head>  
  <body>
  	
  
  	<div class="page_title">查看历史订单</div>
  	<div class="button_bar">
		<button class="common_button" onclick="javascript:history.go(-1);">返回</button>  
	</div>
		
	<br />
	<c:if test="${empty page.pageList }">
			暂时没有数据
		</c:if>
		<c:if test="${!empty page.pageList }">
		<table class="data_list_table" border="0" cellPadding="3" cellSpacing="0">
		<tr>
			<th>订单编号</th>
			<th>日期</th>
			<th>送货地址</th>
			<th>状态</th>
			<th>操作</th>
		</tr>
			<c:forEach items="${page.pageList }" var="item">
				<tr>
					<td class="list_data_number">${item.no }</td>
					<td class="list_data_text">
						<fmt:formatDate value="${item.date }" pattern="yyyy-MM-dd"/>
					</td>
					<td class="list_data_ltext">${item.address }</td>
					<td class="list_data_text">${item.status }</td>
					<td class="list_data_op">
						<img onclick="window.location.href='${ctp}/order/${item.id }'"
						title="查看明细" src="${ctp}/static/images/bt_detail.gif" class="op_button" />
					</td>
				</tr>			
		</c:forEach>
		</table>
		<atguigu:page page="${page}"></atguigu:page>	
	</c:if>
  </body>
</html>

