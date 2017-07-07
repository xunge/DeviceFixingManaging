<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="edu.heusoft.DeviceFixingManaging.javabean.*"  %>
<%@ page import="java.text.*"  %>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>



<!DOCTYPE html>
<html lang="en">
	<head>
	<base href="<%=basePath%>">
    	<meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <title>主页</title>		
		
		<!-- Import google fonts - Heading first/ text second -->
        <!-- <link rel='stylesheet' type='text/css' href='http://fonts.useso.com/css?family=Open+Sans:400,700|Droid+Sans:400,700' /> -->
        <!--[if lt IE 9]>
<link href="http://fonts.useso.com/css?family=Open+Sans:400" rel="stylesheet" type="text/css" />
<link href="http://fonts.useso.com/css?family=Open+Sans:700" rel="stylesheet" type="text/css" />
<link href="http://fonts.useso.com/css?family=Droid+Sans:400" rel="stylesheet" type="text/css" />
<link href="http://fonts.useso.com/css?family=Droid+Sans:700" rel="stylesheet" type="text/css" />
<![endif]-->

		<!-- Fav and touch icons -->
		<link rel="shortcut icon" href="assets/ico/favicon.ico" type="image/x-icon" />    

	    <!-- Css files -->
	    <link href="assets/css/bootstrap.min.css" rel="stylesheet">		
		<link href="assets/css/jquery.mmenu.css" rel="stylesheet">		
		<link href="assets/css/font-awesome.min.css" rel="stylesheet">
		<link href="assets/css/climacons-font.css" rel="stylesheet">
		<link href="assets/plugins/xcharts/css/xcharts.min.css" rel=" stylesheet">		
		<link href="assets/plugins/fullcalendar/css/fullcalendar.css" rel="stylesheet">
		<link href="assets/plugins/morris/css/morris.css" rel="stylesheet">
		<link href="assets/plugins/jquery-ui/css/jquery-ui-1.10.4.min.css" rel="stylesheet">
		<link href="assets/plugins/jvectormap/css/jquery-jvectormap-1.2.2.css" rel="stylesheet">	    
	    <link href="assets/css/style.min.css" rel="stylesheet">
		<link href="assets/css/add-ons.min.css" rel="stylesheet">		

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
								<img class="avatar" src="assets/img/avatar1.jpg">
								<div>New message</div>
								<small>1 minute ago</small>
								<span class="label label-info">NEW</span>
							</a>
						</li>
						<li class="avatar">
							<a href="page-inbox.html">
								<img class="avatar" src="assets/img/avatar2.jpg">
								<div>New message</div>
								<small>3 minute ago</small>
								<span class="label label-info">NEW</span>
							</a>
						</li>
						<li class="avatar">
							<a href="page-inbox.html">
								<img class="avatar" src="assets/img/avatar3.jpg">
								<div>New message</div>
								<small>4 minute ago</small>
								<span class="label label-info">NEW</span>
							</a>
						</li>
						<li class="avatar">
							<a href="page-inbox.html">
								<img class="avatar" src="assets/img/avatar4.jpg">
								<div>New message</div>
								<small>30 minute ago</small>
							</a>
						</li>
						<li class="avatar">
							<a href="page-inbox.html">
								<img class="avatar" src="assets/img/avatar5.jpg">
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
		<div class="main">
		
			<div class="row">
				<div class="col-lg-12">
					<h3 class="page-header"><i class="fa fa-laptop"></i> 首页</h3>
				</div>
			</div>
			


			
			<div class="row">
				
				<div class="col-lg-4 col-md-12">
					<div class="panel panel-default calendar" style="padding-bottom:0px;">	
						<div class="calendar-small"></div>
								
					</div>
				</div><!--/col-->
				
				<div class="col-lg-8 col-md-12">

					<div class="panel panel-default">
						<div class="panel-heading">
							<h2><i class="fa fa-check red"></i><strong>To Do</strong></h2>
							<div class="panel-actions">
								<a href="index.html#" class="btn-setting"><i class="fa fa-rotate-right"></i></a>
								<a href="index.html#" class="btn-minimize"><i class="fa fa-chevron-up"></i></a>
								<a href="index.html#" class="btn-close"><i class="fa fa-times"></i></a>
							</div>
						</div>
						<div class="panel-body no-padding">
							<div class="todo-list">									
								<div class="header">Today</div>
								<ul id="todo-2" class="todo-list-tasks">
									<li>
										<label class="custom-checkbox-item pull-left">
											<input class="custom-checkbox" type="checkbox"/>
											<span class="custom-checkbox-mark"></span>
										</label>
										<span class="desc">管理仓库。</span> 
									</li>
									<li>
										<label class="custom-checkbox-item pull-left">
											<input class="custom-checkbox" type="checkbox"/>
											<span class="custom-checkbox-mark"></span>
										</label>
										<span class="desc">新备件入库时填写入库报表。</span> 
									</li>
									<li>
										<label class="custom-checkbox-item pull-left">
											<input class="custom-checkbox" type="checkbox"/>
											<span class="custom-checkbox-mark"></span>
										</label>
										<span class="desc">定时检查备件申请表，根据库存决定出库。</span> 
									</li>
									<li>
										<label class="custom-checkbox-item pull-left">
											<input class="custom-checkbox" type="checkbox"/>
											<span class="custom-checkbox-mark"></span>
										</label>
										<span class="desc">为维修工程师准备备件。</span> 
									</li>
									<li>
										<label class="custom-checkbox-item pull-left">
											<input class="custom-checkbox" type="checkbox"/>
											<span class="custom-checkbox-mark"></span>
										</label>
										<span class="desc">缺货时不予出库。</span> 
									</li>
									<li>
										<label class="custom-checkbox-item pull-left">
											<input class="custom-checkbox" type="checkbox"/>
											<span class="custom-checkbox-mark"></span>
										</label>
										<span class="desc">入库时注意安全。</span> 
									</li>

								</ul>
								<div class="header">Completed</div>
								<ul class="completed"></ul>		
							</div>
						</div>					
					</div>

				</div><!--/col-->
				
			</div><!--/row--> 
			<div class="row">	

				<div class="col-lg-6 col-md-12">
					
					<div class="panel panel-default">
						<div class="panel-heading">
							<h2><i class="fa fa-map-marker red"></i><strong>Countries</strong></h2>
							<div class="panel-actions">
								<a href="index.html#" class="btn-setting"><i class="fa fa-rotate-right"></i></a>
								<a href="index.html#" class="btn-minimize"><i class="fa fa-chevron-up"></i></a>
								<a href="index.html#" class="btn-close"><i class="fa fa-times"></i></a>
							</div>	
						</div>
						<div class="panel-body">
							<div id="map" style="height:286px;"></div>	
						</div>
	
					</div>
						
					<div class="panel panel-default">
						<div class="panel-heading">
							<h2><i class="fa fa-flag-o red"></i><strong>Registered Users</strong></h2>
							<div class="panel-actions">
								<a href="index.html#" class="btn-setting"><i class="fa fa-rotate-right"></i></a>
								<a href="index.html#" class="btn-minimize"><i class="fa fa-chevron-up"></i></a>
								<a href="index.html#" class="btn-close"><i class="fa fa-times"></i></a>
							</div>
						</div>
						<div class="panel-body">
							<table class="table bootstrap-datatable countries">
								<thead>
									<tr>
										<th></th>
										<th>Country</th>
										<th>Users</th>
										<th>Online</th>
										<th>Performance</th>
									</tr>
								</thead>   
								<tbody>
									<tr>
										<td><img src="assets/ico/flags/Germany.png" style="height:18px; margin-top:-2px;"></td>
										<td>Germany</td>
										<td>2563</td>
										<td>1025</td>
										<td>
											<div class="progress thin">
												<div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="73" aria-valuemin="0" aria-valuemax="100" style="width: 73%">
												</div>
												<div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="27" aria-valuemin="0" aria-valuemax="100" style="width: 27%">
											  	</div>
											</div>
											<span class="sr-only">73%</span>   	
										</td>
									</tr>
									<tr>
										<td><img src="assets/ico/flags/India.png" style="height:18px; margin-top:-2px;"></td>
										<td>India</td>
										<td>3652</td>
										<td>2563</td>
										<td>
											<div class="progress thin">
												<div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="57" aria-valuemin="0" aria-valuemax="100" style="width: 57%">
												</div>
												<div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="43" aria-valuemin="0" aria-valuemax="100" style="width: 43%">
												</div>
											</div>
											<span class="sr-only">57%</span>   	
										</td>
									</tr>
									<tr>
										<td><img src="assets/ico/flags/Spain.png" style="height:18px; margin-top:-2px;"></td>
										<td>Spain</td>
										<td>562</td>
										<td>452</td>
										<td>
											<div class="progress thin">
												<div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="93" aria-valuemin="0" aria-valuemax="100" style="width: 93%">
												</div>
												<div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="7" aria-valuemin="0" aria-valuemax="100" style="width: 7%">
											  	</div>
											</div>
											<span class="sr-only">93%</span>   	
										</td>
									</tr>
									<tr>
										<td><img src="assets/ico/flags/Russia.png" style="height:18px; margin-top:-2px;"></td>
										<td>Russia</td>
										<td>1258</td>
										<td>958</td>
										<td>
											<div class="progress thin">
											  	<div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
											  	</div>
												<div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
											  	</div>
											</div>
											<span class="sr-only">20%</span>   	
										</td>
									</tr>
									<tr>
										<td><img src="assets/ico/flags/usa.png" style="height:18px; margin-top:-2px;"></td>
										<td>USA</td>
										<td>4856</td>
										<td>3621</td>
										<td>
											<div class="progress thin">
											  	<div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
											  	</div>
												<div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
											  	</div>
											</div>
											<span class="sr-only">20%</span>   	
										</td>
									</tr>
									<tr>
										<td><img src="assets/ico/flags/brazil.png" style="height:18px; margin-top:-2px;"></td>
										<td>Brazil</td>
										<td>265</td>
										<td>102</td>
										<td>
											<div class="progress thin">
											  	<div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
											  	</div>
												<div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
											  	</div>
											</div>
											<span class="sr-only">20%</span>   	
										</td>
									</tr>
								</tbody>
							</table>
						</div>
	
					</div>	

				</div><!--/col-->
				
				
				<div class="col-lg-3 col-md-12">
					
					<div class="panel panel-default">

						<div class="panel-body weather widget">
							
							<div class="today text-center">
								
								<h4 class="blue"><strong><i class="fa fa-map-marker fa-3x red"></i> 大连</strong></h4>
								<i class="climacon sun"></i>
								
								
								<div class="row">
									
									<div class="col-xs-5 text-right date">
										<div>星期三</div>
										<small>八月三日</small>
									</div><!--/.col-->
									
									<div class="col-xs-7 text-left temp">
										29°C
									</div><!--/.col-->	
									
								</div><!--/.row-->		
								
							</div>
							
							<div class="forecast row text-center">
								
								<div class="col-xs-4">
									<i class="climacon lightning sun"></i>
									<span class="label label-primary">WED</span>
									<p>40°C</p>
								</div><!--/.col-->
								
								<div class="col-xs-4">
									<i class="climacon snow moon"></i>
									<span class="label label-primary">THU</span>
									<p>18°C</p>
								</div><!--/.col-->
								
								<div class="col-xs-4">
									<i class="climacon hail sun"></i>
									<span class="label label-primary">FRI</span>
									<p>25°C</p>
								</div><!--/.col-->
								
							</div>												
							
						</div>
					</div>		
				
				</div><!--/.col-->
				
				<div class="col-lg-3 col-md-12">
					
					<div class="panel panel-default">

						<div class="panel-body weather widget">
							
							<div class="today text-center">
								
								<h4 class="blue"><strong><i class="fa fa-map-marker fa-3x red"></i> 哈尔滨</strong></h4>
								<i class="climacon sun"></i>
								<div class="row">
									
									<div class="col-xs-5 text-right date">
										<div>星期三</div>
										<small>八月三日</small>
									</div><!--/.col-->
									
									<div class="col-xs-7 text-left temp">
										34°C
									</div><!--/.col-->	
									
								</div><!--/.row-->		
								
							</div>
							
							<div class="forecast row text-center">
								
								<div class="col-xs-4">
									<i class="climacon lightning sun"></i>
									<span class="label label-primary">MON</span>
									<p>35°C</p>
								</div><!--/.col-->
								
								<div class="col-xs-4">
									<i class="climacon fog sun"></i>
									<span class="label label-primary">TUE</span>
									<p>28°C</p>
								</div><!--/.col-->
								
								<div class="col-xs-4">
									<i class="climacon rain"></i>
									<span class="label label-primary">WED</span>
									<p>17°C</p>
								</div><!--/.col-->
								
							</div>												
							
						</div>
					</div>		
				
				</div><!--/.col-->
				
				<div class="col-lg-3 col-md-6">
					
					<div class="panel panel-default">
						
						<div class="panel-body text-center" style="height:230px">
							<h2 class="lime">Sold Out</h2>
							<div style="width:300px;left:50%;position:absolute;margin-left:-150px;">
								<canvas id="gauge1"></canvas>
							</div>
							<span class="pull-left"><strong class="blue">$256.256,25</strong></span>
							<span class="pull-right"><i class="fa fa-arrow-circle-o-up text-success"></i> 52%</span>
						</div>							
						
					</div>	
										
				</div><!--/.col-->
				
				<div class="col-lg-3 col-md-6">
					
					<div class="panel panel-default">
						
						<div class="panel-body text-center" style="height:230px">
							<h2 class="lime">Profit</h2>
							<div style="width:300px;left:50%;position:absolute;margin-left:-150px;">
								<canvas id="gauge2"></canvas>
							</div>
							<span class="pull-left"><strong class="blue">$125.365,56</strong></span>
							<span class="pull-right"><i class="fa fa-arrow-circle-o-up text-success"></i> 70%</span>
						</div>	
						
					</div>	
										
				</div><!--/.col-->
			</div><!--/row-->	
			
						
			<div class="row">
				
				<div class="col-lg-9 col-md-12">
					
					<div class="panel panel-default">
						
						<div class="panel-heading">
							<i class="fa fa-refresh red"></i><h2><strong>Real-time updates</strong></h2>
							
							<div class="panel-actions">
								<a href="index.html#" class="btn-setting"><i class="fa fa-rotate-right"></i></a>
								<a href="index.html#" class="btn-minimize"><i class="fa fa-chevron-up"></i></a>
								<a href="index.html#" class="btn-close"><i class="fa fa-times"></i></a>
							</div>					
						</div>
						
						<div class="panel-body">						
							</br/>							
							<div id="realtime-update" style="height:200px;color:#484848;"></div>
						</div>						
					</div>						
				</div><!--/col-->				
				<div class="col-lg-3 col-md-12">
					<div class="panel panel-default">					
						<div class="panel-body white-bg">						
							</br/>
							<div class="graph-container text-center">
								<div id="hero-donut" class="graph" style="height:236px;"></div>
							</div>	
						</div>
					</div>		
				</div><!--/.col-->		
				
			</div><!--/.row-->						
				
			<div class="row">	
				
				<div class="col-sm-12">
					
					<div class="panel panel-default">
						<div class="panel-heading">
							<h2><i class="fa fa-bar-chart-o red"></i><strong>xCharts</strong></h2>
							<div class="panel-actions">
								<a href="charts-xcharts.html#" class="btn-setting"><i class="fa fa-rotate-right"></i></a>
								<a href="charts-xcharts.html#" class="btn-minimize"><i class="fa fa-chevron-up"></i></a>
								<a href="charts-xcharts.html#" class="btn-close"><i class="fa fa-times"></i></a>
							</div>
						</div>
						<div class="panel-body">
							<figure class="demo" id="chart" style="height: 300px"></figure>
						</div>
					</div>
				
				</div><!--/col-->				
			
			</div><!--/row-->			
			
			
    
					
		</div>
		<!-- end: Content -->
		<br><br><br>
		
		
		
		
	</div><!--/container-->
		
	
	<div class="modal fade" id="myModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title">Warning Title</h4>
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
	</div><!-- /.modal -->
	
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
	<script src="assets/plugins/touchpunch/jquery.ui.touch-punch.min.js"></script>
	<script src="assets/plugins/moment/moment.min.js"></script>
	<script src="assets/plugins/fullcalendar/js/fullcalendar.min.js"></script>
	<!--[if lte IE 8]>
		<script language="javascript" type="text/javascript" src="assets/plugins/excanvas/excanvas.min.js"></script>
	<![endif]-->
	<script src="assets/plugins/flot/jquery.flot.min.js"></script>
	<script src="assets/plugins/flot/jquery.flot.pie.min.js"></script>
	<script src="assets/plugins/flot/jquery.flot.stack.min.js"></script>
	<script src="assets/plugins/flot/jquery.flot.resize.min.js"></script>
	<script src="assets/plugins/flot/jquery.flot.time.min.js"></script>
	<script src="assets/plugins/flot/jquery.flot.spline.min.js"></script>
	<script src="assets/plugins/xcharts/js/xcharts.min.js"></script>
	<script src="assets/plugins/autosize/jquery.autosize.min.js"></script>
	<script src="assets/plugins/placeholder/jquery.placeholder.min.js"></script>
	<script src="assets/plugins/datatables/js/jquery.dataTables.min.js"></script>
	<script src="assets/plugins/datatables/js/dataTables.bootstrap.min.js"></script>
	<script src="assets/plugins/raphael/raphael.min.js"></script>
	<script src="assets/plugins/morris/js/morris.min.js"></script>
	<script src="assets/plugins/jvectormap/js/jquery-jvectormap-1.2.2.min.js"></script>
	<script src="assets/plugins/jvectormap/js/jquery-jvectormap-world-mill-en.js"></script>
	<script src="assets/plugins/jvectormap/js/gdp-data.js"></script>	
	<script src="assets/plugins/gauge/gauge.min.js"></script>
	
	
	<!-- theme scripts -->
	<script src="assets/js/SmoothScroll.js"></script>
	<script src="assets/js/jquery.mmenu.min.js"></script>
	<script src="assets/js/core.min.js"></script>
	<script src="assets/plugins/d3/d3.min.js"></script>	
	
	<!-- inline scripts related to this page -->
	<script src="assets/js/pages/index.js"></script>	
	
	<!-- end: JavaScript-->
	
</body>
</html>