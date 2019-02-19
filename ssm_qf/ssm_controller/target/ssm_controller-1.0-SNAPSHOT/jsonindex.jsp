<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	//String path = request.getContextPath();
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
		<!-- 标题 -->
		<div class="row">
			<div class="col-md-12">
				<h1>SSM-CRUD</h1>
			</div>
		</div>
		<!-- 按钮 -->
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<button class="btn btn-primary">新增</button>
				<button class="btn btn-danger">删除</button>
			</div>
		</div>
		<!-- 显示表格数据 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover" id="emps_tab">
					<thead>
						<tr>
							<th>#</th>
							<th>empName</th>
							<th>gender</th>
							<th>email</th>
							<th>deptName</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
					
					</tbody>
				</table>
			</div>
		</div>

		<!-- 显示分页信息 -->
		<div class="row">
			<div class="col-md-6" id="page_info">
				<br/>
			</div>
			<div class="col-md-6" id="page_bar">
			
			</div>
		</div>
		
	</div>

<script src="${path}/static/js/jquery-1.9.1.min.js"></script>
<script src="${path}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript">
	<!-- 当页面加载完成的时候 ，就去发送一个ajax请求 。拿到方法的返回的json数据 。 -->
	$(function (){
		//alert("asd");
		//发送一个ajax请求 。
		to_page(1);
	})
	
	function to_page(page){
		$.ajax({
			   type: "GET",
			   url: "${path}/emps?page="+page,
			   success: function(msg){
			     //alert(msg.data.pageInfo.pageNum);
			     //构建三部分  。
			     //1.构建表格的数据 。
			     //2.构建分页的数据。
			     //3.构建分页的板。
				   build_table(msg);
			       build_page_info(msg);
			       build_page_bar(msg);
			   }
		});
	}
	
	function build_table(msg){
		//$("#emps_tab tbody").empty();
		//先拿到表格要显示的数据 。 代表了所有的列表数据 。
		var data = msg.data.pageInfo.list;
		$.each(data,function(index,item){
		/* 	//拿到每一个 td里面的数据 。
			var id = obj.eId;//拿到 id
			var name = obj.eName;
			var gender = obj.eGender=="M"?'男':'女';
			var email = obj.eEmail;
			var dId = obj.dId;
			var dName = obj.department.dName;
			//alert(id+"=="+name+"=="+gender+"=="+email+"=="+dId+"=="+dName);
			
			//首先创建tr
			//var tr = $("<tr><tr>");
			var id_td = $("<td></td>").append(id);
			var name_td = $("<td></td>").append(name);
			var gender_td = $("<td></td>").append(gender);
			var email_td = $("<td></td>").append(email);
			var dName_td = $("<td></td>").append(dName);
			//先来创建btn
			var edit_btn = $("<button></button>").addClass("btn btn-warning btn-sm").append($("<span></span>").addClass("glyphicon glyphicon-pencil").attr("aria-hidden",true));
			var del_btn = $("<button></button>").addClass("btn btn-danger btn-sm").append($("<span></span>").addClass("glyphicon glyphicon-trash").attr("aria-hidden",true));
			var btn_td = $("<td></td>").append(edit_btn).append(" ").append(del_btn);
			
			$("<tr><tr>").append(id_td).
			append(name_td).
			append(gender_td).
			append(email_td).
			append(dName_td).
			append(btn_td).appendTo("#emps_tab tbody");
			
			//alert(tr);
			//$("#emps_tab tbody").html(tr); */
			var id = item.eId;
			var name = item.eName;
			var gender = item.eGender=="M"?'男':'女';
			var email = item.eEmail;
			var dept_name = item.department.dName;
			//alert(id+"=="+name+"=="+gender+"=="+email+"=="+dept_name);
			/* $("#emps_tab tbody").append("<tr><td>"+id+"</td><td>"+name+"</td><td>"+gender+"</td><td>"+email+"</td><td>"+dept_name+"</td>"
			+"<td><button class='btn btn-primary btn-sm'><span class='glyphicon glyphicon-pencil' aria-hidden='true'></span>编辑</button>"
			+" <button class='btn btn-danger btn-sm'><span class='glyphicon glyphicon-trash' aria-hidden='true'></span>删除</button></td></tr>"); */
			var empIdTd = $("<td></td>").append(id);
			var empNameTd = $("<td></td>").append(name);
			var genderTd = $("<td></td>").append(gender);
			var emailTd = $("<td></td>").append(email);
			var deptNameTd = $("<td></td>").append(dept_name);
			var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
			.append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
			editBtn.attr("edit-id",id);
			var delBtn =  $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
			.append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
			delBtn.attr("del-id",id);
			var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);
			$("<tr></tr>").append(empIdTd)
			.append(empNameTd)
			.append(genderTd)
			.append(emailTd)
			.append(deptNameTd)
			.append(btnTd)
			.appendTo("#emps_tab tbody");
		});
	}
	
	function build_page_info(msg){
		
		$("#page_info").append("当前 "+msg.data.pageInfo.pageNum+" 页,总 "+msg.data.pageInfo.pages+" 页,总 "+msg.data.pageInfo.total+" 条记录");
	}
	
	function build_page_bar(msg){
		//构建分页的信息
		/* var nav = $("<nav></nav>").attr("aria-label","Page navigation");
		var ul = $("<ul></ul>").addClass("pagination pagination-sm");
		var li = $("<li></li>").append($("<a></a>").attr("href","${path}/emps").append("首页"));
		var n_ul=ul.append(li);
		nav.append(n_ul).appendTo("#page_bar"); */
		//$("#page_bar").empty();
		var nav = $("<nav></nav>").attr("aria-label","Page navigation");
		var ul = $("<ul></ul>").addClass("pagination pagination-sm");
		var home = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
		var left = $("<li></li>").append($("<a></a>").append("&laquo;"));
		//添加判断 如果没有上一页  就把首页跟上一页给禁用掉 。否则的话跳转页面 。
		ul.append(home).append(left);
		$.each(msg.data.pageInfo.navigatepageNums,function(index,item){
			var numLi = $("<li></li>").append($("<a></a>").append(item));
			//判断添加当前页==集合中的页数  高亮显示。 然后每一个numLi添加一个点击事件 跳转具体的页面。
			ul.append(numLi);
		})
		var right = $("<li></li>").append($("<a></a>").append("&raquo;"));
		var end = $("<li></li>").append($("<a></a>").append("尾页").attr("href","#"));
		//添加判断  如果没有下一页，就把尾页跟下一页禁用掉 。否则的话就跳转页面 。
		ul.append(right);
		ul.append(end);
		ul.appendTo(nav);
		nav.appendTo($("#page_bar"));
	}
</script>	

</body>
</html>