<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="atguigu" tagdir="/WEB-INF/tags"%>
<%@ include file="/commons/common.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>库存查询</title>
<script type="text/javascript">
	$(function(){
		
		$("#new").click(function(){
			window.location.href = "${ctp}/storage/";
			return false;
		});
		
		$("img[id^='delete-']").click(function(){
			
			var flag = confirm("确定要删除这条信息吗?");
			
			if(flag){
				$("#_method").val("DELETE");
				var id = $(this).next().val();
				var action = "${ctp}/storage/" + id;
				$("#hiddenForm").attr("action",action).submit();
			}
			return false;
		});
	});
</script>
</head>
<body>
	<div class="page_title">
		库存管理
	</div>
	<div class="button_bar">
		<button id="new" class="common_button">
			库存添加
		</button>
		<button class="common_button" onclick="document.forms[1].submit();">
			查询
		</button>
	</div>
	
	<form action="${ctp}/storage/list" method="POST">
		<table class="query_form_table" border="0" cellPadding="3"
			cellSpacing="0">
			<tr>
				<th>
					产品
				</th>
				<td>
					<input type="text" name="search_LIKEO_productName" />
				</td>
				<th>
					仓库
				</th>
				<td>
					<input type="text" name="search_LIKES_wareHouse" />
				</td>
				<th>
					&nbsp;
				</th>
				<td>
					&nbsp;
				</td>
			</tr>
		</table>
		<!-- 列表数据 -->
		<br />
		
		<c:if test="${empty page.pageList }">
			没有任何数据信息
		</c:if>	
		<c:if test="${!empty page.pageList }">
		<table class="data_list_table" border="0" cellPadding="3"
			cellSpacing="0">
			<tr>
				<th>
					编号
				</th>
				<th>
					产品
				</th>
				<th>
					仓库
				</th>
				<th>
					货位
				</th>
				<th>
					件数
				</th>
				<th>
					备注
				</th>
				<th>
					操作
				</th>
			</tr>
			<c:forEach items="${page.pageList}" var="item">
				<tr>
					<td class="list_data_number">
						${item.id}
					</td>
					<td class="list_data_ltext">
						${item.product.name }
					</td>
					<td class="list_data_ltext">
						${item.wareHouse }
					</td>
					<td class="list_data_text">
						${item.stockWare }
					</td>

					<td class="list_data_number">
						${item.stockCount }
					</td>
					<td class="list_data_ltext">
						${item.memo}
					</td>
					<td class="list_data_op">
						<img onclick="window.location.href='${ctp}/storage/${item.id }'" 
							title="修改" src="${ctp}/static/images/bt_edit.gif" class="op_button" />
						<img id="delete-${item.id }" title="删除" src="${ctp}/static/images/bt_del.gif" class="op_button" />
						<input type="hidden" value="${item.id}"/>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<atguigu:page page="${page}" queryString="${queryString}"></atguigu:page>	
	</form>
</body>
</html>