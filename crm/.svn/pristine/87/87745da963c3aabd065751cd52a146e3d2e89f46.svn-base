<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="atguigu" tagdir="/WEB-INF/tags"%>
<%@ include file="/commons/common.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>客户基本信息管理</title>
<script type="text/javascript">
	$(function(){
		$("img[id^='delete-']").click(function(){
			var id = $(this).next().val();
			var flag = confirm("确定要删除这条信息吗？");
			if(flag) {
				var url = "${ctp}/customer/delete/" + id;
				$.post(url, function(data){
					if(data == "1") {
						$("#state-"+id).text("删除");
						$("#delete-"+id).remove();
					}
				});
			}
    		return false;
		});
	})
</script>
</head>
<body>

	<div class="page_title">客户基本信息管理</div>
	<div class="button_bar">
		<button class="common_button" onclick="document.forms[1].submit();">查询</button>
	</div>
	
	<form action="${ctp}/customer/list" method="POST">
		<table class="query_form_table" border="0" cellPadding="3"
			cellSpacing="0">
			<tr>
				<th>客户名称</th>
				<td>
					<input type="text" name="search_LIKES_name"/>
				</td>
				<th>地区</th>
				<td>
					<select name="search_EQS_region">
						<option value="">全部</option>
						<c:forEach items="${regionList }" var="item">
							<option value="${item }">${item}</option>
						</c:forEach>
					</select>
				</td>
				<th>&nbsp;</th>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<th>客户经理</th>
				<td><input type="text" name="search_LIKES_managerName" /></td>
				
				<th>客户等级</th>
				<td>
				<select name="search_EQS_level">
					<option value="">全部</option>
					<c:forEach items="${levelList }" var="item">
						<option value="${item}">${item}</option>
					</c:forEach>
				</select>
				</td>
				
				<th>状态</th>
				<td>
					<select name="search_EQS_state">
						<option value="">全部</option>
						<c:forEach items="${stateList }" var="item">
							<option value="${item}">${item}</option>
						</c:forEach>
					</select>
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
					<th>客户编号</th>
					<th>客户名称</th>
					<th>地区</th>
					<th>客户经理</th>
					<th>客户等级</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
				
				<c:forEach items="${page.pageList }" var="item">
					<tr>
						<td class="list_data_text">${item.no }&nbsp;</td>
						<td class="list_data_ltext">${item.name }&nbsp;</td>
						<td class="list_data_text">${item.region }&nbsp;</td>
						<td class="list_data_text">${item.manager.name }&nbsp;</td>
						<td class="list_data_text">${item.level }&nbsp;</td>
						<td id="state-${item.id}" class="list_data_text">${item.state }&nbsp;</td>
						<td class="list_data_op">
							<img onclick="window.location.href='${ctp}/customer/${item.id}'"
								title="编辑" src="${ctp}/static/images/bt_edit.gif" class="op_button" alt="" /> 
							<img onclick="window.location.href='${ctp}/contact/list/${item.id}'"
								title="联系人" src="${ctp}/static/images/bt_linkman.gif" class="op_button" alt="联系人信息" /> 
							<img onclick="window.location.href='${ctp}/activity/list/${item.id}'"
								title="交往记录" src="${ctp}/static/images/bt_acti.gif" class="op_button" alt="交往记录" /> 
							<img onclick="window.location.href='${ctp}/order/list/${item.id}'"
								title="历史订单" src="${ctp}/static/images/bt_orders.gif" class="op_button" alt="历史订单" /> 
							<c:if test="${item.state !='删除'}">
							<img id="delete-${item.id}" title="删除" src="${ctp}/static/images/bt_del.gif" class="op_button" alt="删除" />
								<input type="hidden" value="${item.id}"/>
							</c:if>	
							</td>					
					</tr>
				</c:forEach>
					
			</table>
			<atguigu:page page="${page}" queryString="${queryString}"></atguigu:page>	
		</c:if>
	</form>
</body>
</html>
