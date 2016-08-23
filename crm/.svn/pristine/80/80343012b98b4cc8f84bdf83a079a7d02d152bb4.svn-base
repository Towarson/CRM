<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/commons/common.jsp" %>
<%@ taglib prefix="atguigu" tagdir="/WEB-INF/tags" %>
    
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>执行计划</title>
    <script type="text/javascript">
    	$(function(){
    		$("button[id^='saveresult-']").click(function(){
    			var id = $(this).next(":hidden").val();
    			var result = $("#result-"+id).val();
    			
    			var url = "${ctp}/plan/saveresult/"+ id;
    			var args = {"result":result};
    			
   				$.post(url, args, function(data){
   					if(data == "1"){
   						$("#result-"+id).attr("disabled","disabled");
   					}
   				});
    		
    			return false;
    		});
    		$("#finish").click(function(){
    			$("#_method").val("PUT");
				var action = "${ctp}/chance/finish/" + "${chance.id}";
				$("#hiddenForm").attr("action",action).submit();
    		});
    		$("#stop").click(function(){
    			$("#_method").val("PUT");
				var action = "${ctp}/chance/stop/" + "${chance.id}";
				$("#hiddenForm").attr("action",action).submit();
    		});
    	})
    </script>
  </head>

  <body class="main">
	<span class="page_title">执行计划</span>
	<div class="button_bar">
		<button id="stop" class="common_button">终止开发</button>
		<button class="common_button" onclick="window.location.href='${ctp}/plan/make?id=2020'">制定计划</button>
		<button class="common_button" onclick="javascript:history.go(-1);">返回</button>			
		<button id="finish" class="common_button">开发成功</button>
	</div>
	<form:form action="${ctp}/plan/execute" method="post" modelAttribute="chance">
		<table class="query_form_table" border="0" cellPadding="3" cellSpacing="0">
			<tr>
				<th>编号</th>
				<td>${chance.id }&nbsp;</td>
				
				<th>机会来源</th>
				<td>${chance.source }&nbsp;</td>
			</tr>
			<tr>
				<th>客户名称</th>
				<td>${chance.custName }&nbsp;</td>
				
				<th>成功机率（%）</th>
				<td>${chance.rate }&nbsp;</td>
			</tr>
			
			<tr><th>概要</th>
				<td colspan="3">${chance.title }&nbsp;</td>
			</tr>
			
			<tr>
				<th>联系人</th>
				<td>${chance.contact }&nbsp;</td>
				<th>联系人电话</th>
				<td>${chance.contactTel }&nbsp;</td>
			</tr>
			<tr>
				<th>机会描述</th>
				<td colspan="3">${chance.description }&nbsp;</td>
			</tr>
			<tr>
				<th>创建人</th>
				<td>${chance.createBy.name }&nbsp;</td>
				<th>创建时间</th>
				<td>
					<fmt:formatDate value="${chance.createDate }" pattern="yyyy-MM-dd"/>&nbsp;
				</td>
			</tr>		
			<tr>					
				<th>指派给</th>
				<td>${chance.designee.name }&nbsp;</td>
			</tr>
		</table>
	
	<br />
	<c:if test="${empty chance.salesPlans }">
	还没有制定任何计划
	</c:if>
	<c:if test="${!empty chance.salesPlans }">
		<table class="data_list_table" border="0" cellPadding="3" cellSpacing="0">
			<tr>
				<th width="200px">日期</th>
				<th>计划</th>
				<th>执行效果</th>
			</tr>
			<c:forEach items="${chance.salesPlans }" var="item">
				<tr>
					<td class="list_data_text">
						<fmt:formatDate value="${item.date }" pattern="yyyy-MM-dd"/>&nbsp;
					</td>
					<td class="list_data_ltext">
						${item.todo }&nbsp;
					</td>
					<td>
					<c:if test="${item.result == null }">
						<input class="result" id="result-${item.id }" type="text" size="50" value="" />
					</c:if>
					<c:if test="${item.result != null }">
						<input class="result" id="result-${item.id }" type="text" size="50" value="${item.result}" disabled="disabled"/>
					</c:if>
						<input id="result-${item.id }" type="hidden" value="" />
						<button class="common_button" id="saveresult-${item.id }">保存</button>
						<input type="hidden" value="${item.id }"/>
					</td>
				</tr>
			</c:forEach>
		</table>	
	</c:if>
</form:form>
  </body>
</html>
