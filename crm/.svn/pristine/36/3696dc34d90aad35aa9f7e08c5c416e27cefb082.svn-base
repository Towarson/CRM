<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="atguigu" tagdir="/WEB-INF/tags"%>
<%@ include file="/commons/common.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>产品查询</title>
<script type="text/javascript">
	$(function(){
		$("#new").click(function(){
			window.location.href = "${ctp}/product/";
			return false;
		});
		
		$("img[id^='delete-']").click(function(){
			var name = $(this).prev().val();
			var flag = confirm("确定要删除【" + name + "】的信息吗?");
			
			if(flag){
				$("#_method").val("DELETE");
				var id = $(this).next().val();
				var action = "${ctp}/product/" + id;
				$("#hiddenForm").attr("action",action).submit();
			}
			return false;
		});
	});
</script>
</head>
<body>
	
	<div class="page_title">
		产品管理
	</div>
	<div class="button_bar">
		<button id="new" class="common_button">
			产品添加
		</button>
		<button class="common_button" onclick="document.forms[1].submit();">
			查询
		</button>
	</div>
	
	<form action="${ctp}/product/list">
		<table class="query_form_table" border="0" cellPadding="3"
			cellSpacing="0">
			<tr>
				<th>
					名称
				</th>
				<td>
					<input type="text" name="search_LIKES_name" />
				</td>
				<th>
					型号
				</th>
				<td>
					<input type="text" name="search_LIKES_type" />
				</td>
				<th>
					批次
				</th>
				<td>
					<input type="text" name="search_LIKES_batch" />
				</td>
			</tr>
		</table>
		<!-- 列表数据 -->
		<br />
	</form>	
		
	<c:if test="${empty page.pageList}">
		暂时没有数据
	</c:if>
	<c:if test="${!empty page.pageList}">
		
	<table class="data_list_table" border="0" cellPadding="3"
		cellSpacing="0">
	
		<tr>
			<th>
				编号
			</th>
			<th>
				名称
			</th>
			<th>
				型号
			</th>
			<th>
				等级/批次
			</th>
			<th>
				单位
			</th>
			<th>
				单价（元）
			</th>
			<th>
				备注
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
				<td class="list_data_ltext">
					${item.name }
				</td>
				<td class="list_data_text">
					${item.type }
				</td>
				<td class="list_data_text">
					${item.batch }
				</td>
	
				<td class="list_data_text">
					${item.unit }
				</td>
				<td class="list_data_number">
					${item.price }
				</td>
				<td class="list_data_ltext">
					${item.memo }
				</td>
				<td class="list_data_op">
					<img onclick="window.location.href='${ctp}/product/${item.id }'" 
						title="编辑" src="${ctp}/static/images/bt_edit.gif" class="op_button" />
						
					<input type="hidden" value="${item.name }"/>
					<img id="delete-${item.id }" title="删除" src="${ctp}/static/images/bt_del.gif" class="op_button" />
					<input type="hidden" value="${item.id }"/>
				</td>
			</tr>
		</c:forEach>
	</table>
</c:if>

<atguigu:page page="${page }" queryString="${queryString }"></atguigu:page>
	
</body>
</html>