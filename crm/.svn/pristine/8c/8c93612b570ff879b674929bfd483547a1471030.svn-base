<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="atguigu" tagdir="/WEB-INF/tags"%>
<%@ include file="/commons/common.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>管理</title>
<script type="text/javascript">
	$(function(){
		$("#new").click(function(){
			window.location.href = "${ctp}/dicts/";
			return false;
		});
		$("img[id^='delete-']").click(function(){
			
			var flag = confirm("确定要删除这条信息吗?");
			if(flag){
				$("#_method").val("DELETE");
				var id = $(this).next().val();
				var action = "${ctp}/dicts/" + id;
				$("#hiddenForm").attr("action",action).submit();
			}
			return false;
		});
	})

</script>	
</head>
<body>
	<div class="page_title">
		基础数据管理
	</div>
	<div class="button_bar">
		<button id="new" class="common_button">
			新建
		</button>
		<button class="common_button" onclick="document.forms[1].submit();">
			查询
		</button>
	</div>
	
	<form action="${ctp}/dicts/list" method="POST">
		<table class="query_form_table" border="0" cellPadding="3"
			cellSpacing="0">
			<tr>
				<th>
					类别
				</th>
				<td>
					<input type="text" name="search_LIKES_type" />
				</td>
				<th>
					条目
				</th>
				<td>
					<input type="text" name="search_LIKES_item" />
				</td>
				<th>
					值
				</th>
				<td>
					<input type="text" name="search_LIKES_value" />
				</td>
			</tr>
		</table>
	</form>
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
					编号
				</th>
				<th>
					类别
				</th>
				<th>
					条目
				</th>
				<th>
					值
				</th>
				<th>
					操作
				</th>
			</tr>
			<c:forEach items="${page.pageList }" var="item">
				<tr>
					<td class="list_data_number">
						${item.id }
					</td>
					<td class="list_data_text">
						${item.type }
					</td>
					<td class="list_data_text">
						${item.item }
					</td>
					<td class="list_data_text">
						${item.value }
					</td>
				<c:if test="${item.editable }">
					<td class="list_data_op">
						<img onclick="window.location.href='${ctp}/dicts/create/${item.id}'" 
							title="编辑" src="${ctp}/static/images/bt_edit.gif" class="op_button" />
						
						<img id="delete-${item.id }" title="删除" src="${ctp}/static/images/bt_del.gif" class="op_button" />
						<input type="hidden" value="${item.id }"/>
						
					</td>
				</c:if>
				<c:if test="${!item.editable }">
					<td class="list_data_op">
					</td>
				</c:if>
				</tr>
			</c:forEach>				
		</table>
		<atguigu:page page="${page }" queryString="${queryString }"></atguigu:page>
	</c:if>	
</body>
</html>