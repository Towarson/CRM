<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/commons/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>添加角色</title>
<script type="text/javascript">
	$(function(){
		$("#save").click(function(){
			$("#roleForm").submit();
			return false;
		});
	});
</script>
</head>

<body>

		<div class="page_title">
			系统角色添加
		</div>
		<form:form id="roleForm" action="${ctp}/role/" method="POST" modelAttribute="role">
			<div class="button_bar">
				<button class="common_button" onclick="javascript:history.back(-1);">
					返回
				</button>
				<button id="save" class="common_button" >
					保存
				</button>
			</div>
			
			<table class="query_form_table">
				<tr>
					<th>
						角色名称
					</th>
					<td>
						<form:input path="name"/>
					</td>
					<th>
						角色描述
					</th>
					<td>
						<form:input path="description"/>
					</td>
				</tr>
				<tr>
					<th>
						状态
					</th>
					<td>
						<form:select path="enabled">
							<option value="true">有效</option>
							<option value="false">无效</option>
						</form:select>
						<span class="red_star">*</span>
					</td>
					
				</tr>
			</table>
		</form:form>
	</body>
</html>
