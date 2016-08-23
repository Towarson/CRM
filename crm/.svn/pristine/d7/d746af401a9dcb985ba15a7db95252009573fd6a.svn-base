<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/commons/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>新建客户服务</title>
<script type="text/javascript">
	$(function(){
		$("#save").click(function(){
			$("#serviceForm").submit();
			return false;
		});
	})
</script>
</head>

<body class="main">

	<span class="page_title">新建客户服务</span>
	
	<div class="button_bar">
		<button class="common_button" onclick="javascript:history.go(-1);">
			返回
		</button>
		<button id="save" class="common_button">保存</button>
	</div>
	<form:form id="serviceForm" action="${ctp}/service/save" method="post" modelAttribute="customerService">
		<table class="query_form_table" border="0" cellPadding="3"
			cellSpacing="0">
			<tr>
				<th>
					服务类型
				</th>
				<td>
					<form:select path="serviceType">
						<form:option value="">未指定</form:option>
						<form:options items="${serviceTypeList }" />
					</form:select>
					<span class="red_star">*</span>
				</td>
				<th>&nbsp;</th>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<th>
					概要
				</th>
				<td colspan="3">
					<form:input path="serviceTitle" size="50"/>
					<span class="red_star">*</span>
				</td>
			</tr>
			<tr>
				<th>
					客户
				</th>
				<td>
					<form:select path="customer.id">
						<form:option value="">未指定</form:option>
						<form:options items="${custList }" 
									  itemLabel="name"
									  itemValue="id"/>
					</form:select>
					<span class="red_star">*</span>
				</td>
				<th>
					状态
				</th>
				<td>
					新创建 <form:hidden path="serviceState" value="新创建"/>
				</td>
			</tr>
			<tr>
				<th>
					服务请求
				</th>
				<td colspan="3">
					<form:textarea path="serviceRequest" rows="6" cols="50"/>
					<span class="red_star">*</span>
				</td>
			</tr>
			<tr>
				<th>
					创建人
				</th>
				<td>
					<form:hidden path="createdby.id" value="${createdby.id }"/>
					${createdby.name }(${createdby.role.name})
					<span class="red_star">*</span>
				</td>
				<th>
					创建时间
				</th>
				<td>
					<form:hidden path="createDate"/>
					<fmt:formatDate value="${customerService.createDate }" pattern="yyyy-MM-dd"/>
					<span class="red_star">*</span>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>