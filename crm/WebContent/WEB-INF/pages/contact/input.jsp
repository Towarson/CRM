<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/commons/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>新建/编辑联系人</title>
    <script type="text/javascript">
    	$(function(){
    		var val = $("#name").val();
    		if(val != null && $.trim(val) != ""){
    			$("#name").attr("readonly", "true");
    		}
    		$("#save").click(function(){
    			$("#contactFrom").submit();
    			return false;
    		});
    	})
    </script>
  </head>

  <body class="main">
 	<span class="page_title">新建/编辑联系人</span>
	<div class="button_bar">
		<button class="common_button" onclick="javascript:history.go(-1);">返回</button>
		<button class="common_button" id="save">保存</button>
	</div>
	<form:form id="contactFrom" action="${ctp}/contact/${custId}" method="POST" modelAttribute="contact">
		<c:if test="${contact.id != null }">
			<input type="hidden" name="_method" value="PUT"/>
		</c:if>
		 <form:hidden path="id"/>
  		
			<input id="customer.id" name="customer.id" type="hidden" value="154"/>
  		
  		
		<table class="query_form_table" border="0" cellPadding="3" cellSpacing="0">
			<tr>
				<th>姓名</th>
				<td>
					<form:input path="name" id="name"/>
				<th>性别</th>
				<td>
					<form:select path="sex">
						<form:option value="女"/>
						<form:option value="男"/>
					</form:select>
					<span class="red_star">*</span> 
				</td>
			</tr>
			
			<tr>
				<th>职位</th>
				<td><form:input path="position"/><span class="red_star">*</span></td>
				<th>办公电话</th>
				<td><form:input path="tel"/><span class="red_star">*</span></td>
			</tr>
			<tr>
				<th>手机</th>
				<td><form:input path="mobile"/></td>
				<th>备注</th>
				<td><form:input path="memo"/></td>
			</tr>
		</table>
	</form:form>
	
  </body>
</html>
