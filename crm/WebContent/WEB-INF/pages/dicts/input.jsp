<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/commons/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑数据字典项</title>
<script type="text/javascript">
	$(function(){
		$("#save").click(function(){
			$("#dictForm").submit();
			return false;
		});
	});
</script>
</head>

<body class="main">
	<span class="page_title">编辑/新建数据字典项</span>
	<div class="button_bar">
		<button class="common_button" onclick="javascript:history.go(-1);">
			返回
		</button>
		<button id="save" class="common_button">
			保存
		</button>
	</div>
	<form:form id="dictForm" action="${ctp}/dicts/${dict.id }" method="POST" modelAttribute="dict">
		<c:if test="${dict.id != null }">
			<input type="hidden" name="_method" value="PUT"/>
		</c:if>
		<table class="query_form_table" border="0" cellPadding="3"
			cellSpacing="0">
			<tr>
				<th>
					编号
				</th>
				<td>
					<form:input path="id" readonly="true"/>
				</td>
				<th>
					类别
				</th>
				<td>
					<form:input path="type"/>
				</td>
			</tr>
			<tr>
				<th>
					条目
				</th>
				<td>
					<form:input path="item"/>
				</td>
				<th>
					值
				</th>
				<td>
					<form:input path="value"/>
				</td>
			</tr>
			<tr>
				<th>
					是否可编辑
				</th>
				<td>
					<form:select path="editable">
						<form:option value="true">是</form:option>
						<form:option value="false">否</form:option>
					</form:select>
				</td>
				<th>
					&nbsp;
				</th>
				<td>
					&nbsp;
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>