<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="atguigu" tagdir="/WEB-INF/tags"%>
<%@ include file="/commons/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>客户服务分析</title>
  <body>
	<div class="page_title">客户服务分析</div>
	<div class="button_bar">
		<button class="common_button" onclick="document.forms[0].submit();">查询</button>  
	</div>
  	<form action="/crm_/report/service">
		<div id="listView" style="display:block;">
			<table class="query_form_table" border="0" cellPadding="3" cellSpacing="0">
				<tr>
					<th>
						日期
					</th>
					<td>
						<input type="text" name="search_GTE_createDate" size="10" />
						-
						<input type="text" name="search_LTE_createDate" size="10" />
					</td>
					<th>&nbsp;</th>
					<td>&nbsp;</td>
				</tr>
			</table>
			<!-- 列表数据 -->
			<br />
			
			
				<table class="data_list_table" border="0" cellPadding="3" cellSpacing="0">
				<tr>
					<th>序号</th>
					<th>条目</th>
					<th>客户数量</th>
				</tr>
					
						<tr>
							<td class="list_data_number">1</td>
							<td class="list_data_ltext">大客户</td>
							<td class="list_data_number">2</td>
						</tr>			
					
						<tr>
							<td class="list_data_number">2</td>
							<td class="list_data_ltext">合作伙伴</td>
							<td class="list_data_number">1</td>
						</tr>			
					
						<tr>
							<td class="list_data_number">3</td>
							<td class="list_data_ltext">普通客户</td>
							<td class="list_data_number">1</td>
						</tr>			
					
						<tr>
							<td class="list_data_number">4</td>
							<td class="list_data_ltext">战略合作伙伴</td>
							<td class="list_data_number">3</td>
						</tr>			
					
				</table>
			








<div style="text-align:right; padding:6px 6px 0 0;">

	

	共 4 条记录 
	&nbsp;&nbsp;
	
	当前第 1 页/共 1 页
	&nbsp;&nbsp;
	
	
	 
	
	
	转到 <input id="pageNo" size='1'/> 页
	&nbsp;&nbsp;

</div>

<script type="text/javascript" src="/crm_/static/jquery/jquery-1.9.1.min.js"></script>
<script type="text/javascript">

	$(function(){
		
		$("#pageNo").change(function(){
			
			var pageNo = $(this).val();
			var reg = /^\d+$/;
			if(!reg.test(pageNo)){
				$(this).val("");
				alert("输入的页码不合法");
				return;
			}
			
			var pageNo2 = parseInt(pageNo);
			if(pageNo2 < 1 || pageNo2 > parseInt("1")){
				$(this).val("");
				alert("输入的页码不合法");
				return;
			}
			
			//查询条件需要放入到 class='condition' 的隐藏域中. 
			window.location.href = window.location.pathname
				+ "?page=" + pageNo2 + "&sortType=&&";
			
		});
	})
</script>
			
			
		</div>
	</form>	
  </body>
</html>