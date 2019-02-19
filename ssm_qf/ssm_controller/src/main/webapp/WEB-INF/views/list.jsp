<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	//将项目路径 放到请求域中 。
	pageContext.setAttribute("path",request.getContextPath());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!--设置IE8 兼容 。-->
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<!--兼容手机端.-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
</head>
<body>

<div class="container">
  <!-- 主页的标题 -->
  <div class="row">
  	 <div class="col-md-12">
  	 	<h1>SSM-CRUD</h1>
  	 </div>
  </div>
   <!-- 一些功能按钮区域 -->
  <div class="row">
  	<div class="col-md-4 col-md-offset-8">
  		<button type="button" class="btn btn-primary ">新增</button>
  		<button type="button" class="btn btn-danger ">删除</button>
  	</div>
  </div>
   <!-- 表格数据的展示区 -->
  <div class="row">
  	<div class="col-md-12">
  		<table class="table table-hover">
 			<thead>
 				<tr>
 					<th>#</th>
 					<th>姓名</th>
 					<th>性别</th>
 					<th>邮箱</th>
 					<th>部门</th>
 					<th>操作</th>
 				</tr>
 			</thead>
 			<tbody>
 				<c:forEach items="${pageInfo.list}" var="emp">
	 				<tr>
	 					<td>#</td>
	 					<td>${emp.eName}</td>
	 					<td>${emp.eGender=="M"?'男':'女'}</td>
	 					<td>${emp.eEmail}</td>
	 					<td>${emp.department.dName}</td>
	 					<td>
	 						<button type="button" sb="${emp.eId}" class="btn btn-warning btn-sm" >
	  						<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>编辑
							</button>
							
							<button type="button" sb="${emp.eId}" class="btn btn-danger btn-sm del-btn" >
	  						<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>删除
							</button>
						</td>
	 				</tr>
 				</c:forEach>
 			</tbody>
		</table>
  	</div>
  </div>
  
   <!-- 分页的信息区 -->
  <div class="row">
  	<!--分页文字信息  -->
	<div class="col-md-6"><br>当前 ${pageInfo.pageNum} 页,总 ${pageInfo.pages} 页,总 ${pageInfo.total} 条记录</div>
    <div class="col-md-6">
    	<nav aria-label="Page navigation">
		  <ul class="pagination pagination-sm">
		   <li><a href="${path}/list">首页</a></li>
		   <c:if test="${pageInfo.hasPreviousPage==true}">
			    <li>
			     	<a href="${path}/list?page=${pageInfo.pageNum-1}" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      	</a>
			    </li>
		    </c:if>
		   <!--  <li><a href="#">1</a></li>
		    <li><a href="#">2</a></li>
		    <li><a href="#">3</a></li>
		    <li><a href="#">4</a></li>
		    <li><a href="#">5</a></li> -->
		    <c:forEach items="${pageInfo.navigatepageNums}" var="num">
		    	<c:if test="${pageInfo.pageNum==num}">
		    		<li class="active"><a href="${path}/list?page=${num}">${num}</a></li>
		    	</c:if>
		    	<c:if test="${pageInfo.pageNum!=num}">
		    		<li><a href="${path}/list?page=${num}">${num}</a></li>
		    	</c:if>
		    </c:forEach>
		    <c:if test="${pageInfo.hasNextPage==true}">
			    <li>
			      <a href="${path}/list?page=${pageInfo.pageNum+1}" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
			</c:if>    
		    <li><a href="${path}/list?page=${pageInfo.pages}">尾页</a></li>
		  </ul>
		</nav>
    </div>
</div>

<script src="${path}/static/js/jquery-1.9.1.min.js"></script>
<script src="${path}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function (){
		$(".del-btn").click(function(){
			//查看当前对象的 sb 自定义属性值 。
			var id = $(this).attr("sb");
			alert(id);
		})
	})
</script>
</body>
</html>