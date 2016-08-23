<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="atguigu" tagdir="/WEB-INF/tags"%>
<%@ include file="/commons/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>客户贡献分析</title>
</head>
<body>

	<div class="page_title">
		客户贡献分析
	</div>
	<div class="button_bar">
		<button class="common_button" onclick="document.forms[1].submit();">
			查询
		</button>
	</div>
	
	<form action="${ctp}/report/contribute/list">
		<div id="listView" style="display:block;">
			<table class="query_form_table" border="0" cellPadding="3"
				cellSpacing="0">
				<tr>
					<th>
						客户名称
					</th>
					<td>
						<input type="text" name="search_LIKES_customerName" />
					</td>
					<th>
						日期
					</th>
					<td>
						<input type="text" name="search_LED_minDate" size="10" />
						-
						<input type="text" name="search_GED_maxDate" size="10" />
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
						
						<th>
							客户名称
						</th>
						<th>
							订单金额（元）
						</th>
					</tr>
					<c:forEach items="${page.pageList }" var="item">
						<tr>
							
							<td align="center">
								${item.customerName }
							</td>
							<td align="center">
								${item.totalMoney }
							</td>
		
						</tr>
					</c:forEach>
				</table>
				<atguigu:page page="${page}" queryString="${queryString}"></atguigu:page>	
			</c:if>
		</div>
	</form>
</body>
</html>