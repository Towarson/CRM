<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="atguigu" tagdir="/WEB-INF/tags"%>
<%@ include file="/commons/common.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>角色管理</title>
<script type="text/javascript">
	$(function(){
		
		$("#new").click(function(){
			window.location.href = "${ctp}/role/";
			return false;
		});
		
		$("img[id^='delete-']").click(function(){
			var name = $(this).prev().val();
			var flag = confirm("确定要删除【"+name+"】吗?");
			
			if(flag){
				$("#_method").val("DELETE");
				var id = $(this).next().val();
				var action = "${ctp}/role/" + id;
				$("#hiddenForm").attr("action",action).submit();
			}
			return false;
		});
	});
</script>
</head>
<body class="main">

	<div class="page_title">
		角色管理
	</div>
	
	<div class="button_bar">
		<button id="new" class="common_button">
			新建
		</button>
	</div>
	
	<form action="role-list">

		<!-- 列表数据 -->
		<br />
		
			<table class="data_list_table" border="0" cellPadding="3"
				cellSpacing="0">
				<tr>
					<th class="data_title" >
						编号
					</th>
					<th class="data_title" >
						角色名
					</th>
					<th class="data_title" >
						角色描述
					</th>
					<th class="data_title">
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
						<td class="data_cell" style="text-align:right;padding:0 10px;">${item.id }</td>
						<td class="data_cell" style="text-align:center;">${item.name }</td>
						<td class="data_cell" style="text-align:left;">${item.description }</td>
						<td class="data_cell" style="text-align:center;">${item.enabled }</td>
						<td class="data_cell">
							<img onclick="window.location.href='${ctp}/role/${item.id }'" title="分配权限" src="${ctp}/static/images/bt_linkman.gif" class="op_button" />
							<input type="hidden" value="${item.name }"/>
							<img id="delete-${item.id }" title="删除" src="${ctp}/static/images/bt_del.gif" class="op_button" />
							<input type="hidden" value="${item.id }"/>
						</td>
					</tr>
				</c:forEach>
				
				</c:if>
			</table>
	<atguigu:page page="${page}"></atguigu:page>		
	</form>
</body>
</html>