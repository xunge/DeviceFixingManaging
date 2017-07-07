<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="edu.heusoft.DeviceFixingManaging.javabean.*" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- <!DOCTYPE html> -->
<html lang="en">
<head>

<!-- jsp start -->
<base href="<%=basePath%>">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<!-- jsp over -->

<meta http-equiv="description" content="This is my page">
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>分配维修师</title>
<!-- Import google fonts - Heading first/ text second -->
<!-- <link rel="stylesheet" type="text/css" href="http://fonts.useso.com/css?family=Open+Sans:400,700|Droid+Sans:400,700" /> -->
<!--[if lt IE 9]>
<link href="http://fonts.useso.com/css?family=Open+Sans:400" rel="stylesheet" type="text/css" />
<link href="http://fonts.useso.com/css?family=Open+Sans:700" rel="stylesheet" type="text/css" />
<link href="http://fonts.useso.com/css?family=Droid+Sans:400" rel="stylesheet" type="text/css" />
<link href="http://fonts.useso.com/css?family=Droid+Sans:700" rel="stylesheet" type="text/css" />
<![endif]-->
<!-- Favicon and touch icons -->
<link rel="shortcut icon" href="assets/ico/favicon.ico" type="image/x-icon" />
<!-- Css files -->
<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
<link href="assets/css/jquery.mmenu.css" rel="stylesheet" />
<link href="assets/css/font-awesome.min.css" rel="stylesheet" />
<link href="assets/plugins/jquery-ui/css/jquery-ui-1.10.4.min.css" rel="stylesheet" />
<link href="assets/css/style.min.css" rel="stylesheet" />
<link href="assets/css/add-ons.min.css" rel="stylesheet" />
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
			<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
			<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	    <![endif]-->
</head>
<body>
			<!-- start: Main Menu -->
			<div class="sidebar ">
								
				<div class="sidebar-collapse">
					<div class="sidebar-header t-center">
                        <span><img class="text-logo" src="/DeviceFixingManaging/assets/img/logo1.png" style="width:90%"></span>
                    </div>										
					<div class="sidebar-menu">						
						<ul class="nav nav-sidebar">
							<li><a href="/DeviceFixingManaging/index/TaskIndex.html"><i class="fa fa-laptop"></i><span class="text"> 主页</span></a></li>
							<li >
								<a href="#"><i class="fa fa-file-text"></i><span class="text"> 任务管理</span> <span class="fa fa-angle-down pull-right"></span></a>
								<ul class="nav sub">
									<li><a href="/DeviceFixingManaging/Task/QueryRepairRecord.jsp"><i class="fa fa-car"></i><span class="text"> 查询报修单</span></a></li>
									<li><a href="/DeviceFixingManaging/Task/QueryStaff.jsp"><i class="fa fa-envelope"></i><span class="text"> 查询工程师</span></a></li>
									<li><a href="/DeviceFixingManaging/Task/UpdateRepairRecord.jsp"><i class="fa fa-envelope"></i><span class="text"> 分配任务</span></a></li>
								</ul>	
							</li>
							
						</ul>
					</div>					
				</div>
				<div class="sidebar-footer">					
					
					<div class="sidebar-brand">
						Devicelite
					</div>
					
					<ul class="sidebar-terms">
						<li><a href="index.html#">Terms</a></li>
						<li><a href="index.html#">Privacy</a></li>
						<li><a href="index.html#">Help</a></li>
						<li><a href="index.html#">About</a></li>
					</ul>
					
					<div class="copyright text-center">
						<small>Devicelite <i class="fa fa-coffee"></i> from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></small>
					</div>					
				</div>	
				
			</div>
			<!-- end: Main Menu -->


<!-- start: Header --> 
<div class="navbar" role="navigation">
	
	<div class="container-fluid">		
		
		<ul class="nav navbar-nav navbar-actions navbar-left">
			<li class="visible-md visible-lg"><a href="index.html#" id="main-menu-toggle"><i class="fa fa-th-large"></i></a></li>
			<li class="visible-xs visible-sm"><a href="index.html#" id="sidebar-menu"><i class="fa fa-navicon"></i></a></li>			
		</ul>
		
		<form class="navbar-form navbar-left">
			<button type="submit" class="fa fa-search"></button>
			<input type="text" class="form-control" placeholder="Search..."></a>
		</form>
		<div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >免费模板</a></div>
	    <ul class="nav navbar-nav navbar-right">
			<li class="dropdown visible-md visible-lg">
	    		<a href="#" class="dropdown-toggle" data-toggle="dropdown"><img class="user-avatar" src="assets/img/avatar.jpg" alt="user-mail">${loginInfo}</a>
	    		<ul class="dropdown-menu">
					<li class="dropdown-menu-header">
						<strong>Account</strong>
					</li>						
					<li><a href="page-profile.html"><i class="fa fa-user"></i> Profile</a></li>
					<li><a href="page-login.html"><i class="fa fa-wrench"></i> Settings</a></li>
					<li><a href="page-invoice.html"><i class="fa fa-usd"></i> Payments <span class="label label-default">10</span></a></li>
					<li><a href="gallery.html"><i class="fa fa-file"></i> File <span class="label label-primary">27</span></a></li>
					<li class="divider"></li>						
					<li><a href="index.html"><i class="fa fa-sign-out"></i> Logout</a></li>	
	    		</ul>
	  		</li>
			<li><a href="index.html"><i class="fa fa-power-off"></i></a></li>
		</ul>
	</div>
</div>
<!-- end: Header -->

<div class="container-fluid content">
<div class="row"> 
	
	<!-- start: Content -->
	<div class="main sidebar-minified">
		<div class="row">
			<div class="col-lg-12">
				<h3 class="page-header"><i class="fa fa-table"></i>Tables</h3>

			</div>
		</div>



		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					
					<div class="panel-body">
                        <form class="form-vertical hover-stripped" role="form"  action="/DeviceFixingManaging/servlet/UpdateRepairRecordTaskServlet"  method="POST"  >
                            <!-- <div class="form-group col-md-4">
                                <label class="control-label">维修师姓名</label>
                                <input type="text" class="form-control" value="" name="part_name">
                            </div>
 -->
 							<!-- get the param.no -->
                            <input type="hidden" name="repair_record_no" value="${param.repair_record_no}">
                            <!--  -->
							<div class="form-group col-md-4">
								<label class="control-label" for="selectError3">技术工程师编号</label>
								<div class="controls">
								<!-- 
									<select id="selectError3" class="form-control" name="repair_person_no">
										<option></option>
										<option>5</option>
										<option>6</option>
										<option>7</option>
										<option>8</option>
									</select>
								 -->
								 <input type="text" class="form-control" name="repair_person_no" />
								</div>
                                <!-- <input type="text" class="form-control" value="" name="repair_status"> -->
                            </div>
                            <br /><br /><br /><br />
                         
                            <div class="form-group pull-left" >
                                &nbsp;&nbsp;&nbsp;<button class="fa-save btn btn-primary">保存</button>
                            </div>    							
                        </form>
                    </div>

					<br />
					
				</div>
			</div>
			<!--/col--> 
		</div>
		<!--/row--> 
	</div>
	<!-- end: Content --> 
	<br />
	<br />
	<br />
	
	<!--/container-->
	<div class="modal fade" id="myModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title">Modal title</h4>
				</div>
				<div class="modal-body">
					<p>Here settings can be configured...</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Save changes</button>
				</div>
			</div>
			<!-- /.modal-content --> 
		</div>
		<!-- /.modal-dialog --> 
	</div>
	<!-- /.modal -->
	<div class="clearfix"></div>
	<!-- start: JavaScript--> 
	<!--[if !IE]>--> 
	<script src="assets/js/jquery-2.1.1.min.js"></script> 
	<!--<![endif]--> 
	<!--[if IE]>
	
		<script src="assets/js/jquery-1.11.1.min.js"></script>
	
	<![endif]--> 
	<!--[if !IE]>--> 
	<script type="text/javascript">
			window.jQuery || document.write("<script src='assets/js/jquery-2.1.1.min.js'>"+"<"+"/script>");
		</script> 
	<!--<![endif]--> 
	<!--[if IE]>
	
		<script type="text/javascript">
	 	window.jQuery || document.write("<script src='assets/js/jquery-1.11.1.min.js'>"+"<"+"/script>");
		</script>
		
	<![endif]--> 
	<script src="assets/js/jquery-migrate-1.2.1.min.js"></script> 
	<script src="assets/js/bootstrap.min.js"></script> 
	<!-- page scripts --> 
	<script src="assets/plugins/jquery-ui/js/jquery-ui-1.10.4.min.js"></script> 
	<script src="assets/plugins/datatables/js/jquery.dataTables.min.js"></script> 
	<script src="assets/plugins/datatables/js/dataTables.bootstrap.min.js"></script> 
	<!-- theme scripts --> 
	<script src="assets/js/SmoothScroll.js"></script> 
	<script src="assets/js/jquery.mmenu.min.js"></script> 
	<script src="assets/js/core.min.js"></script> 
	<!-- inline scripts related to this page --> 
	<!-- <script src="assets/js/pages/table.js"></script>  -->
	<script type="text/javascript">
		function goPage(p) {
			var page = document.getElementById("page");
			page.value = p;

			document.forms[1].submit();
		}

		function goPagePrev(p) {
			var page = document.getElementById("page");
			var integer = parseInt(p);
			integer--;
			page.value = integer;

			document.forms[1].submit();
		}

		function goPageNext(p) {
			var page = document.getElementById("page");
			var integer = parseInt(p);
			integer++;
			page.value = integer;
			document.forms[1].submit();
		}
	</script>
	<!-- end: JavaScript--> 
</div>
</body>
</html>