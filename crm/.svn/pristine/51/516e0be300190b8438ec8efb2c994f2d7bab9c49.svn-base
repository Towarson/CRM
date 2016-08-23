<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="atguigu" tagdir="/WEB-INF/tags"%>
<%@ include file="/commons/common.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>用户列表</title>
<script type="text/javascript">
	$(function(){
		
		$("#new").click(function(){
			window.location.href = "${ctp}/user/";
			return false;
		});
		
		$("img[id^='delete-']").click(function(){
			var name = $(this).prev().val();
			var flag = confirm("确定要删除【"+name+"】吗?");
			
			if(flag){
				$("#_method").val("DELETE");
				var id = $(this).next().val();
				var action = "${ctp}/user/" + id;
				$("#hiddenForm").attr("action",action).submit();
			}
			return false;
		});
	});
</script>
</head>
<body class="main">
	<form:form action="${ctp}/user/list" method="POST" modelAttribute="users">
		<div class="page_title">
			用户管理
		</div>
		<div class="button_bar">
			<button class="common_button" id="new">新建</button>
			<button class="common_button" onclick="document.forms[1].submit();">
				查询
			</button>
		</div>
		<table class="query_form_table" border="0" cellPadding="3"
			cellSpacing="0">
			<tr>
				<th class="input_title">
					用户名
				</th>
				<td class="input_content">
					<input type="text" name="search_LIKES_name" />
				</td>
				<th class="input_title">
					状态
				</th>
				<td class="input_content">
				
					<select name="search_EQI_enabled">
						<option value="">
							全部
						</option>
						<option value="1">
							正常
						</option>
						<option value="0">
							已删除
						</option>
					</select>
				</td>
			</tr>
		</table>
		<!-- 列表数据 -->
		<br />
		
		
			<table class="data_list_table" border="0" cellPadding="3"
				cellSpacing="0">
				<tr>
					<th class="data_title" style="width: 40px;">
						编号
					</th>
					<th class="data_title" style="width: 50%;">
						用户名
					</th>
					<th class="data_title" style="width: 20%;">
						状态
					</th>
					<th class="data_title">
						操作
					</th>
				</tr>
				<c:if test="${empty page.pageList }">
					暂时没有数据
				</c:if>
				<c:if test="${!empty page.pageList }">
				<c:forEach items="${page.pageList }" var="item">
					<tr>
						<td class="data_cell" style="text-align: right; padding: 0 10px;">
						${item.id }
						</td>
						<td class="data_cell" style="text-align: center;">
						${item.name }
						</td>
						<td class="data_cell">
						${item.enabled }
						</td>
						<td class="data_cell">
						
							<input type="hidden" value="${item.name }"/>
							<img id="delete-${item.id }" title="删除" src="${ctp}/static/images/bt_del.gif" class="op_button" />
							<input type="hidden" value="${item.id }"/>
							
							<img onclick="window.location.href='${ctp}/user/${item.id }'" 
								class="op_button" src="${ctp}/static/images/bt_edit.gif" title="编辑" />
						</td>
					</tr>
					</c:forEach>
				</c:if>
			</table>
		<atguigu:page page="${page}" queryString="${queryString }"></atguigu:page>	
	</form:form>
</body>
</html>