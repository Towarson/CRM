<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/commons/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑库存</title>
<script type="text/javascript">
	$(function(){
		$("#save").click(function(){
			$("#storageForm").submit();
			return false;
		});
	});
</script>
</head>

<body class="main">

	<span class="page_title">编辑库存</span>
	<div class="button_bar">
		<button class="common_button" onclick="javascript:history.go(-1);">
			返回
		</button>
		<button id="save" class="common_button">
			保存
		</button>
	</div>
	<form:form id="storageForm" action="${ctp}/storage/${storage.id}" method="POST" modelAttribute="storage">
		<form:hidden path="id"/>
		<table class="query_form_table" border="0" cellPadding="3"
			cellSpacing="0">
			
	<c:if test="${storage.id == null }">
		<tr>
			<th>
				产品 -false-
			</th>
			<td>
				<form:select path="product.id" >
					<form:option value="请选择" />
					<form:options  items="${productList }" itemLabel="name" itemValue="id"/>
				</form:select>
			</td>
			<th>
				仓库
			</th>
			<td>
				<form:input path="wareHouse"/>
			</td>
		</tr>
		<tr>
			<th>
				货位
			</th>
			<td>
				<form:input path="stockWare"/>
			</td>
			<th>
				数量
			</th>
			<td>
				<form:input path="stockCount"/>
			</td>
		</tr>
		<tr>
			<th>
				备注
			</th>
			<td>
				<form:input path="memo"/>
			</td>
		</tr>
	</c:if>
	
	
	<c:if test="${storage.id != null }">
		<input type="hidden" name="_method" value="PUT"/>
		<tr>
			<th>
				产品 -true-
			</th>
			<td>
				<input type="text" value="${storage.product.name }" readonly="readonly"/>	
			</td>
			<th>
				仓库
			</th>
			<td>
				<form:input path="wareHouse" readonly="true"/>
			</td>
		</tr>
		<tr>
			<th>
				货位
			</th>
			<td>
				<form:input path="stockWare" readonly="true"/>
			</td>
			<th>
				新增数量
			</th>
			<td>
				<input type="text" name="incrementCount" />
			</td>
		</tr>
		<tr>
			<th>
				备注
			</th>
			<td>
				<form:input path="memo" readonly="true"/>
			</td>
		</tr>
	</c:if>
</table>
</form:form>
</body>
</html>
