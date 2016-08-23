<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/commons/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>增加用户</title>
    <script type="text/javascript">
	$(function(){
		$("#save").click(function(){
			$("#userForm").submit();
			return false;
		});
	});
</script>
  </head>

  <body class="main">
    <form:form id="userForm" action="${ctp}/user/${user.id }" method="post" modelAttribute="user">
    	<form:hidden path="id"/>
    	<c:if test="${user.id != null }">
			<input type="hidden" name="_method" value="PUT"/>
		</c:if>
	  	<span class="page_title">用户管理　&gt;　新建用户</span>
		<div class="button_bar">
			<button class="common_button" onclick="javascript:history.go(-1);">返回</button>
			<button id="save" class="common_button">保存</button>
		</div>
		
		<table class="query_form_table" border="0" cellPadding="3" cellSpacing="0">
			<tr>
				<th class="input_title">用户名</th>
				<td class="input_content">
					<form:input path="name"/>
					<div id='divCheck'></div>
				</td>
				
				<th class="input_title">密码</th>
				<td class="input_content">
					<form:password path="password"/>
				</td>
			</tr>
			<tr>
				<th class="input_title">角色</th>
				<td class="input_content">
					<form:select path="role.id">
						<form:option value="1">管理员</form:option>
						<form:option value="2">测试</form:option>
						<form:option value="3">测试管理员</form:option>
					</form:select>
				</td>
				<th class="input_title">状态</th>
				<td class="input_content">
					<span>
						<form:radiobutton id="enabled1" path="enabled" value="0" />
						<label for="enabled1">无效</label>
					</span>
					<span>
						<form:radiobutton id="enabled2" path="enabled" value="1" />
						<label for="enabled2">有效</label>
					</span>
				</td>
			</tr>
		</table>
	</form:form>
	
  </body>
</html>
