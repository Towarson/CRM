<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="page" type="com.atguigu.crm.orm.Page" rtexprvalue="true" required="true"%>
<%@ attribute name="queryString" type="java.lang.String" rtexprvalue="true" required="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div style="text-align:right; padding:6px 6px 0 0;">
	共 ${page.totalRecordNo } 条记录 
	&nbsp;&nbsp;
	
	当前第 ${page.pageNo } 页/共 ${page.totalPage } 页
	&nbsp;&nbsp;
	
	<c:if test="${page.hasPre }">
		<a href='?pageNoStr=1${queryString}'>首页</a>
		&nbsp;&nbsp;
		<a href='?pageNoStr=${page.pre }${queryString}'>上一页</a>
		&nbsp;&nbsp;
	</c:if> 
	
	<c:if test="${page.hasNext }">
		<a href='?pageNoStr=${page.next }${queryString}'>下一页</a>
		&nbsp;&nbsp;
		<a href='?pageNoStr=${page.totalPage }${queryString}'>末页</a>
		&nbsp;&nbsp;
	</c:if> 
	
	转到 <input id="pageNoStr" size='1'/> 页
	&nbsp;&nbsp;

</div>
<script type="text/javascript" src="${ctp}/static/jquery/jquery-1.9.1.min.js"></script>
<script type="text/javascript">		
	$("#pageNoStr").change(function(){
			
		var pageNoStr = $(this).val();
		var reg = /^\d+$/;
		if(!reg.test(pageNoStr)){
			$(this).val("");
			alert("输入的页码不合法");
			return;
		}
		
		var pageNo = parseInt(pageNoStr);
		if(pageNo < 1 || pageNo > parseInt("${page.totalPage}")){
			$(this).val("");
			alert("输入的页码不合法");
			return;
		}
		//查询条件需要放入到 class='condition' 的隐藏域中. 
		window.location.href = window.location.pathname + "?pageNoStr=" + pageNoStr + "${queryString}";
		
	});
</script>