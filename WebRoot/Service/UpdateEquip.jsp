
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="edu.heusoft.DeviceFixingManaging.javabean.*" %>
<%@ page import="edu.heusoft.DeviceFixingManaging.common.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html>
<html lang="en">
	<head>
    	<meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <title>Devicelite - Admin Template</title>		
		
		<!-- Import google fonts - Heading first/ text second -->
        <!--<link rel='stylesheet' type='text/css' href='http://fonts.useso.com/css?family=Open+Sans:400,700|Droid+Sans:400,700' />-->
        <!--[if lt IE 9]>
<link href="http://fonts.useso.com/css?family=Open+Sans:400" rel="stylesheet" type="text/css" />
<link href="http://fonts.useso.com/css?family=Open+Sans:700" rel="stylesheet" type="text/css" />
<link href="http://fonts.useso.com/css?family=Droid+Sans:400" rel="stylesheet" type="text/css" />
<link href="http://fonts.useso.com/css?family=Droid+Sans:700" rel="stylesheet" type="text/css" />
<![endif]-->

		<!-- Favicon and touch icons -->
		<link rel="shortcut icon" href="/DeviceFixingManaging/assets/ico/favicon.ico" type="image/x-icon" /> 

	    <!-- Css files -->
	    <link href="/DeviceFixingManaging/assets/css/bootstrap.min.css" rel="stylesheet">		
		<link href="/DeviceFixingManaging/assets/css/jquery.mmenu.css" rel="stylesheet">		
		<link href="/DeviceFixingManaging/assets/css/font-awesome.min.css" rel="stylesheet">
		<link href="/DeviceFixingManaging/assets/plugins/jquery-ui/css/jquery-ui-1.10.4.min.css" rel="stylesheet">	   
	    <link href="/DeviceFixingManaging/assets/css/style.min.css" rel="stylesheet">
		<link href="/DeviceFixingManaging/assets/css/add-ons.min.css" rel="stylesheet">		

	    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	    <!--[if lt IE 9]>
			<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
			<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	    <![endif]-->
	</head>
</head>

<body>
	<!-- start: Header -->
	<div class="navbar" role="navigation">
	
		<div class="container-fluid">		
			
			<ul class="nav navbar-nav navbar-actions navbar-left">
				<li class="visible-md visible-lg"><a href="page-profile.html#" id="main-menu-toggle"><i class="fa fa-th-large"></i></a></li>
				<li class="visible-xs visible-sm"><a href="page-profile.html#" id="sidebar-menu"><i class="fa fa-navicon"></i></a></li>			
			</ul>
			
			<div class="navbar-form navbar-left">
				<button type="submit" class="fa fa-search"></button>
				<input type="text" class="form-control" placeholder="Search..."></a>
			</div>
			
	        <ul class="nav navbar-nav navbar-right">
				<li class="dropdown visible-md visible-lg">
	        		<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-envelope-o"></i><span class="badge">5</span></a>
	        		<ul class="dropdown-menu">
						<li class="dropdown-menu-header">
							<strong>Messages</strong>
							<div class="progress thin">
							  <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100" style="width: 30%">
							    <span class="sr-only">30% Complete (success)</span>
							  </div>
							</div>
						</li>
						<li class="avatar">
							<a href="page-inbox.html">
								<img class="avatar" src="/DeviceFixingManaging/assets/img/avatar1.jpg">
								<div>New message</div>
								<small>1 minute ago</small>
								<span class="label label-info">NEW</span>
							</a>
						</li>
						<li class="avatar">
							<a href="page-inbox.html">
								<img class="avatar" src="/DeviceFixingManaging/assets/img/avatar2.jpg">
								<div>New message</div>
								<small>3 minute ago</small>
								<span class="label label-info">NEW</span>
							</a>
						</li>
						<li class="avatar">
							<a href="page-inbox.html">
								<img class="avatar" src="/DeviceFixingManaging/assets/img/avatar3.jpg">
								<div>New message</div>
								<small>4 minute ago</small>
								<span class="label label-info">NEW</span>
							</a>
						</li>
						<li class="avatar">
							<a href="page-inbox.html">
								<img class="avatar" src="/DeviceFixingManaging/assets/img/avatar4.jpg">
								<div>New message</div>
								<small>30 minute ago</small>
							</a>
						</li>
						<li class="avatar">
							<a href="page-inbox.html">
								<img class="avatar" src="/DeviceFixingManaging/assets/img/avatar5.jpg">
								<div>New message</div>
								<small>1 hours ago</small>
							</a>
						</li>						
						<li class="dropdown-menu-footer text-center">
							<a href="page-inbox.html">View all messages</a>
						</li>	
	        		</ul>
	      		</li>
				<li class="dropdown visible-md visible-lg">
	        		<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bell-o"></i><span class="badge">3</span></a>
	        		<ul class="dropdown-menu">
						<li class="dropdown-menu-header">
							<strong>Notifications</strong>
							<div class="progress thin">
							  <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100" style="width: 30%">
							    <span class="sr-only">30% Complete (success)</span>
							  </div>
							</div>
						</li>							
                        <li class="clearfix">
							<i class="fa fa-comment"></i> 
                            <a href="page-activity.html" class="notification-user"> Sharon Rose </a> 
                            <span class="notification-action"> replied to your </span> 
                            <a href="page-activity.html" class="notification-link"> comment</a>
                        </li>
                        <li class="clearfix">
                            <i class="fa fa-pencil"></i> 
                            <a href="page-activity.html" class="notification-user"> Nadine </a> 
                            <span class="notification-action"> just write a </span> 
                            <a href="page-activity.html" class="notification-link"> post</a>
                        </li>
                        <li class="clearfix">
                            <i class="fa fa-trash-o"></i> 
                            <a href="page-activity.html" class="notification-user"> Lorenzo </a> 
                            <span class="notification-action"> just remove <a href="#" class="notification-link"> 12 files</a></span> 
                        </li>                        
						<li class="dropdown-menu-footer text-center">
							<a href="page-activity.html">View all notification</a>
						</li>
	        		</ul>
	      		</li>
				<li class="dropdown visible-md visible-lg">
					 <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-gears"></i></a>					
					<ul class="dropdown-menu update-menu" role="menu">
						<li><a href="#"><i class="fa fa-database"></i> Database </a>
                        </li>
                        <li><a href="#"><i class="fa fa-bar-chart-o"></i> Connection </a>
                        </li>
                        <li><a href="#"><i class="fa fa-bell"></i> Notification </a>
                        </li>
                        <li><a href="#"><i class="fa fa-envelope"></i> Message </a>
                        </li>
                        <li><a href="#"><i class="fa fa-flash"></i> Traffic </a>
                        </li>
						<li><a href="#"><i class="fa fa-credit-card"></i> Invoices </a>
                        </li>
                        <li><a href="#"><i class="fa fa-dollar"></i> Finances </a>
                        </li>
                        <li><a href="#"><i class="fa fa-thumbs-o-up"></i> Orders </a>
                        </li>
						<li><a href="#"><i class="fa fa-folder"></i> Directories </a>
                        </li>
                        <li><a href="#"><i class="fa fa-users"></i> Users </a>
                        </li>		
					</ul>
				</li>
				<li class="dropdown visible-md visible-lg">
	        		<a href="#" class="dropdown-toggle" data-toggle="dropdown"><img class="user-avatar" src="/DeviceFixingManaging/assets/img/avatar.jpg" alt="user-mail">${loginInfo}</a>
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
				<li><a href="/DeviceFixingManaging/login.html"><i class="fa fa-power-off"></i></a></li>
			</ul>
			
		</div>
		
	</div>
	<!-- end: Header -->
	
	<div class="container-fluid content">
	
		<div class="row">
				
			<!-- start: Main Menu -->
			<div class="sidebar ">
								
				<div class="sidebar-collapse">
					<div class="sidebar-header t-center">
                        <span><img class="text-logo" src="/DeviceFixingManaging/assets/img/logo1.png" style="width:100%;"></span>
                    </div>										
					<div class="sidebar-menu">						
						<ul class="nav nav-sidebar">
							<li><a href="/DeviceFixingManaging/index/ServiceIndex.jsp"><i class="fa fa-laptop"></i><span class="text"> 主页</span></a></li>
							<li >
								<a href="#"><i class="fa fa-file-text"></i><span class="text"> 客户管理</span> <span class="fa fa-angle-down pull-right"></span></a>
								<ul class="nav sub">
									<li><a href="/DeviceFixingManaging/Service/addCustomer.jsp"><i class="fa fa-car"></i><span class="text"> 添加客户</span></a></li>
									<li><a href="/DeviceFixingManaging/Service/queryCustomer.jsp"><i class="fa fa-envelope"></i><span class="text"> 查询客户</span></a></li>
								</ul>	
							</li>
							<li>
								<a href="#"><i class="fa fa-list-alt"></i><span class="text"> 报修管理</span> <span class="fa fa-angle-down pull-right"></span></a>
								<ul class="nav sub">
									<li><a href="/DeviceFixingManaging/Service/addReport.jsp"><i class="fa fa-indent"></i><span class="text"> 添加报修单</span></a></li>
									<li><a href="/DeviceFixingManaging/Service/queryreportrecord.jsp"><i class="fa fa-tags"></i><span class="text"> 查询报修单</span></a></li>
								</ul>
							</li>
							<li><a href="/DeviceFixingManaging/Service/z-querycheckout.jsp"><i class="fa fa-table"></i><span class="text"> 结算信息</span></a></li>
							
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
						<small>Devicelite <i class="fa fa-coffee"></i> from <a href="http://www.cssmoban.com/" title="HEU" target="_blank">HEU</a></small>
					</div>					
				</div>	
				
			</div>
			<!-- end: Main Menu -->
						
		<!-- start: Content -->
		<div class="main ">
		
			<div class="row">
				<div class="col-lg-12">
					<h3 class="page-header"><i class="fa fa-heart-o"></i>编辑设备信息</h3>
				</div>
			</div>

			<div class="row">
                    <div class="panel panel-default">                               
                        <div class="panel-heading">
                            <h2><i class="fa fa-heart-o red"></i><strong>编辑设备信息</strong></h2>
                        </div>
                        <div class="panel-body">
                            <form class="form-vertical hover-stripped" role="form"  action="/DeviceFixingManaging/servlet/UpdateEquipServlet"  method="POST"  >
				                <div class="row">
												<div class="col-sm-5">
													<div class="form-group has-feedback">
														<label for="ccnumber-w1">机器编号</label>
														<input type="text" class="form-control" readonly="readonly"  placeholder="" name="report_equip_no" value="${data.report_equip_no}">
														<span class="fa fa-asterisk form-control-feedback"></span>
													</div>
												</div>		
												
												<div class="col-sm-5">
													<div class="form-group has-feedback">
														<label for="ccnumber-w1">机器品牌</label>
														<input type="text" class="form-control"  placeholder="" name="report_equip_brand" value="${data.report_equip_brand}">
														<span class="fa fa-asterisk form-control-feedback"></span>
													</div>
												</div>	





								</div><!--/row-->
											
											<div class="row">
											
											<div class="form-group col-sm-5">
													<label for="ccmonth-w1">产品类型</label>
													<select class="form-control" id="ccmonth-w1" name="product_type">
													
														<c:if test="${data.product_type=='台式机'}">
														<option selected="selected">台式机</option>
														</c:if>
														<c:if test="${data.product_type!='台式机'}">
														<option>台式机</option>
														</c:if>
														<c:if test="${data.product_type=='笔记本'}">
														<option selected="selected">笔记本</option>
														</c:if>
														<c:if test="${data.product_type!='笔记本'}">
														<option>笔记本</option>
														</c:if>
														<c:if test="${data.product_type=='投影仪'}">
														<option selected="selected">投影仪</option>
														</c:if>
														<c:if test="${data.product_type!='投影仪'}">
														<option>投影仪</option>
														</c:if>
														<c:if test="${data.product_type=='打印机'}">
														<option selected="selected">打印机</option>
														</c:if>
														<c:if test="${data.product_type!='打印机'}">
														<option>打印机</option>
														</c:if>
														<c:if test="${data.product_type=='其他'}">
														<option selected="selected">其他</option>
														</c:if>
														<c:if test="${data.product_type!='其他'}">
														<option>其他</option>
														</c:if>
				
													</select>
												</div>
											
												<div class="col-sm-5">
													<div class="form-group has-feedback">
														<label for="ccnumber-w1">机器型号</label>
														<input type="text" class="form-control"  placeholder="" name="report_equip_model" value="${data.report_equip_model}">
														<span class="fa fa-asterisk form-control-feedback"></span>
													</div>
												</div>		

											</div><!--/row-->

											<div class="row">
												<div class="col-sm-5">
													<div class="form-group has-feedback">
														<label for="ccnumber-w1">系列号</label>
														<input type="text" class="form-control"  placeholder="" name="report_equip_series" value="${data.report_equip_series}">
														<span class="fa fa-asterisk form-control-feedback"></span>
													</div>
												</div>		
												
												<div class="form-group col-sm-5">
													<label for="ccmonth-w1">故障类型</label>
													<select class="form-control" id="ccmonth-w1" name="report_equip_problem_type">
														<c:if test="${data.report_equip_problem_type=='固定性故障'}">
														<option selected="selected">固定性故障</option>
														<option>间隙性故障</option>		
														</c:if>
														<c:if test="${data.report_equip_problem_type!='固定性故障'}">
														<option>固定性故障</option>
														<option selected="selected">间隙性故障</option>		
														</c:if>															
													</select>
												</div>
											</div><!--/row-->
		                        
																					
                                <div class="form-group pull-right" >
                                    <button class="btn btn-primary" >添加</button>
                                </div>
                                        
                            </form>

							
                        </div>
                    </div>
				
			</div>
				
	     	</div>
		<!-- end: Content -->
		<br><br><br>
		
		
	</div><!--/container-->
		
	
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
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div> <!--/.modal -->
	
	<div class="clearfix"></div>
	
	
	<!-- start: JavaScript-->
	<!--[if !IE]>-->

			<script src="/DeviceFixingManaging/assets/js/jquery-2.1.1.min.js"></script>

	<!--<![endif]-->

	<!--[if IE]>
	
		<script src="/DeviceFixingManaging/assets/js/jquery-1.11.1.min.js"></script>
	
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
	<script src="/DeviceFixingManaging/assets/js/jquery-migrate-1.2.1.min.js"></script>
	<script src="/DeviceFixingManaging/assets/js/bootstrap.min.js"></script>	
	
	
	<!-- page scripts -->
	<script src="/DeviceFixingManaging/assets/plugins/jquery-ui/js/jquery-ui-1.10.4.min.js"></script>
	<script src="http://localhost:8888/bootstrap/originAdmin/assets/js/jquery.easy-pie-chart.min.js"></script>
	
	<!-- theme scripts -->
	<script src="/DeviceFixingManaging/assets/js/SmoothScroll.js"></script>
	<script src="/DeviceFixingManaging/assets/js/jquery.mmenu.min.js"></script>
	<script src="/DeviceFixingManaging/assets/js/core.min.js"></script>
	
	<!-- inline scripts related to this page -->
	<script src="/DeviceFixingManaging/assets/js/pages/page-profile.js"></script>
	
	<!-- end: JavaScript-->
	
</body>
</html>