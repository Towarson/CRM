<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="atguigu" tagdir="/WEB-INF/tags"%>
<%@ include file="/commons/common.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>交往记录管理</title>
<script type="text/javascript">
	$(function(){
		$("img[id^='delete-']").click(function(){
			var id = $(this).next().val();
			var flag = confirm("确定要删除这条信息吗？");
			if(flag) {
				var action = "${ctp}/activity/"+id+"/${customer.id}";
				$("#_method").val("DELETE");
				$("#hiddenForm").attr("action",action).submit();
				return false;
			}
		});
		$("#new").click(function(){
			window.location.href = "${ctp}/activity/${customer.id}";
			return false;
		});
	})
</script>
</head>
<body>
	
	<div class="page_title">
		交往记录管理
	</div>
	<div class="button_bar">
		<button id="new" class="common_button">新建</button>
		<button class="common_button" onclick="javascript:history.go(-1);">返回</button>
	</div>
	
	<form action="${ctp}/activity/list" method="POST">
		<table class="query_form_table" border="0" cellPadding="3"
			cellSpacing="0">
			<tr>
				<th>
					客户编号
				</th>
				<td>${customer.no}</td>
				<th>
					客户名称
				</th>
				<td>${customer.name}</td>
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
						时间
					</th>
					<th>
						地点
					</th>
					<th>
						概要
					</th>
					<th>
						详细信息
					</th>
					<th>
						操作
					</th>
				</tr>
				<c:forEach items="${page.pageList }" var="item">
					<tr>
						<td class="list_data_text">
							<fmt:formatDate value="${item.date }" pattern="yyyy-MM-dd"/>
						</td>
						<td class="list_data_ltext">
							${item.place }
						</td>
						<td class="list_data_ltext">
							${item.title }
						</td>
						<td class="list_data_ltext">
							${item.description }
						</td>
						<td class="list_data_op">
							<img onclick="window.location.href='${ctp}/activity/${item.id }/${customer.id}'" 
								title="编辑" src="${ctp}/static/images/bt_edit.gif" class="op_button" />
							<img id="delete-${item.id }" title="删除" src="${ctp}/static/images/bt_del.gif" class="op_button" />
							<input type="hidden" value="${item.id }"/>
						</td>
					</tr>
				</c:forEach>
			</table>
			<atguigu:page page="${page}"></atguigu:page>	
		</c:if>	
	</form>
</body>
</html>
		
