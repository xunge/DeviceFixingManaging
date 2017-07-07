
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="com.apple.javaee.javabean.*" %>
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
                        <span><img class="text-logo" src="/DeviceFixingManaging/assets/img/logo1.png" style="width:90%"></span>
                    </div>										
					<div class="sidebar-menu">						
						<ul class="nav nav-sidebar">
							<li><a href="/DeviceFixingManaging/index/KeeperIndex.jsp"><i class="fa fa-laptop"></i><span class="text"> 主页</span></a></li>
							<li class="opened">
								<a href="#"><i class="fa fa-file-text"></i><span class="text"> 仓库管理</span> <span class="fa fa-angle-down pull-right"></span></a>
								<ul class="nav sub">
									<li><a href="/DeviceFixingManaging/Keeper/QueryPart.jsp"><i class="fa fa-car"></i><span class="text"> 查询库存</span></a></li>
									<li><a href="/DeviceFixingManaging/Keeper/QueryPartDetail.jsp"><i class="fa fa-envelope"></i><span class="text"> 查看流水明细</span></a></li>
								
									
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
						<small>Devicelite <i class="fa fa-coffee"></i> from <a href="http://www.cssmoban.com/" title="HEU" target="_blank">HEU</a></small>
					</div>					
				</div>	
				
			</div>
			<!-- end: Main Menu -->
						
		<!-- start: Content -->
		<div class="main ">
		
			<div class="row">
				<div class="col-lg-12">
					<h3 class="page-header"><i class="fa fa-heart-o"></i>查看流水明细</h3>
				</div>
			</div>


			<div class="row">
                    <div class="panel panel-default">                               
                        <div class="panel-heading">
                            <h2><i class="fa fa-heart-o red"></i><strong>查询条件</strong></h2>
							<div class="panel-actions">
								<a href="table.html#" class="btn-setting"><i class="fa fa-rotate-right"></i></a>
								<a href="table.html#" class="btn-minimize"><i class="fa fa-chevron-up"></i></a>
								<a href="table.html#" class="btn-close"><i class="fa fa-times"></i></a>
							</div>
                        </div>

					<div class="panel-body">
						<table class="table table-striped table-bordered bootstrap-datatable datatable">
							<thead>
								<tr>
									<th>备件流水明细编号</th>
									<th>备件编号</th>
									<th>维修记录编号</th>
									<th>备件流水明细数量</th>
									<th>备件状态</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${data}" var="u">
									<tr>
										<td>${u.part_detail_no}</td>
										<td>${u.part_no}</td>
										<td>${u.repair_record_no}</td>
										<td>${u.part_detail_num}</td>
										<td>${u.part_detail_status}</td>
										<td>
											<a href="/DeviceFixingManaging/servlet/ChuKuUpdatePartServlet?part_no=${u.part_no}&part_detail_num=${u.part_detail_num}&part_detail_no=${u.part_detail_no}">
												<button type="submit" class="btn btn-primary">出库</button>
											</a>
										</td>
									</tr>
								</c:forEach>
				
							</tbody>
						</table>
						<!-- teacher's fenye start -->
						<!-- <p align="center">总共${pages}页, 当前是${currentPage}页 &nbsp;&nbsp;&nbsp;&nbsp;
							<c:forEach begin="1" end="${pages}" var="p">
								<a href="javascript:goPage('${p}')">${p}</a>&nbsp;
							</c:forEach>
						</p> -->
						<!-- teacher's fenye over -->
                      
						<!-- my fenye start -->
						<ul class="pagination">
							<c:if test="${1!=currentPage}">
								<li> <a href="javascript:goPagePrev('${currentPage}')">上一页</a> </li>
							</c:if>
							<!-- <li> <a href="javascript:goPagePrev('${currentPage}')">Prev</a> </li> -->
							<c:forEach begin="1" end="${pages}" var="p">
								<!-- <li> <a href="javascript:goPage('${p}')">${p}</a> </li> -->
								<c:if test="${p==currentPage}">
									<li class="active"> <a href="javascript:goPage('${p}')">${p}</a> </li>
								</c:if>
								<c:if test="${p!=currentPage}">
									<li> <a href="javascript:goPage('${p}')">${p}</a> </li>
								</c:if>
							</c:forEach>
							<c:if test="${pages!=currentPage}">
								<li> <a href="javascript:goPageNext('${currentPage}')">下一页</a> </li>
							</c:if>
							<!-- <li> <a href="javascript:goPageNext('${currentPage}')">Next</a> </li> -->
							<li style="float:right"></li>
						</ul>
					    <form class="form-vertical hover-stripped" role="form"  action="/DeviceFixingManaging/servlet/QueryPartDetailKeeperServlet"  method="POST"  >
                                <button class="btn btn-primary" style="float:right">查询</button>  							
                        </form>
						<!-- my fenye over -->

						<!-- fenye start -->
					
						<!-- fenye over -->
					</div>
                    </div>
				<form action="/DeviceFixingManaging/servlet/QueryPartDetailKeeperServlet" method="post">
						<input type="hidden" name="part_detail_no" value="${param.part_detail_no }" />
						<input type="hidden" name="part_no" value="${param.part_no }" />
						<input type="hidden" name="repair_record_no" value="${param.repair_record_no }" />
						<input type="hidden" name="part_detail_num" value="${param.part_detail_num }" />
						<input type="hidden" name="part_detail_status" value="${param.part_detail_status }" />
						<input type="hidden" id="page" name="page" value="" />
						
					</form>
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
<script>

		function deque()
		{
			document.forms[1].submit();
		}
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
</html>