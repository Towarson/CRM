<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="atguigu" tagdir="/WEB-INF/tags"%>
<%@ include file="/commons/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>客户构成分析</title>
</head>
<body>
	
	<div class="page_title">
		客户构成分析
	</div>
	<div class="button_bar">
		<button class="common_button" onclick="document.forms[1].submit();">
			查询
		</button>
	</div>
	
	<form action="${ctp}/report/constitute/list">
		<div id="listView" style="display:block;">
			<table class="query_form_table" border="0" cellPadding="3"
				cellSpacing="0">
				<tr>
					<th>
						查询方式
					</th>
					<td>
						<select name="search_EQS_type">
							<option value="CUSTOMER_LEVEL">
								按等级
							</option>
							<option value="CREDIT">
								按信用度
							</option>
							<option value="SATIFY">
								按满意度
							</option>
						</select>
					</td>
					<th>
						&nbsp;
					</th>
					<td>
						&nbsp;
					</td>
				</tr>
			</table>
			<!-- 列表数据 -->
			<br />
			<c:if test="${empty page.pageList }">
				暂时没有数据
			</c:if>
			<c:if test="${!empty page.pageList }">
			<table class="data_list_table" border="0" cellPadding="3"
				cellSpacing="0">
				<tr>
					<th>
						序号
					</th>
					<th>
						
					</th>
					<th>
						客户数量
					</th>
				</tr>
				<c:forEach items="${page.pageList }" var="item" varStatus="vs">
					<tr>
						<td class="list_data_number">${vs.index+1}</td>
						<td class="list_data_ltext">${item.type }</td>
						<td class="list_data_number">${item.count }</td>
					</tr>
				</c:forEach>
					</table>
				<atguigu:page page="${page}" queryString="${queryString}"></atguigu:page>		
			</c:if>
		</div>
	</form>
</body>
</html>