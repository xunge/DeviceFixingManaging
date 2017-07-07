

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
				<li class="visible-md visible-lg"><a href="form-wizard.html#" id="main-menu-toggle"><i class="fa fa-th-large"></i></a></li>
				<li class="visible-xs visible-sm"><a href="form-wizard.html#" id="sidebar-menu"><i class="fa fa-navicon"></i></a></li>			
			</ul>
			
			<form class="navbar-form navbar-left">
				<button type="submit" class="fa fa-search"></button>
				<input type="text" class="form-control" placeholder="Search..."></a>
			</form>
			
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
					<h3 class="page-header"><i class="fa fa-tags"></i>添加报修记录</h3>

				</div>
			</div>
			
			<div class="row">
				
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h2><i class="fa fa-tags red"></i><strong>报修信息</strong></h2>
							<div class="panel-actions">
								<a href="form-elements.html#" class="btn-setting"><i class="fa fa-rotate-right"></i></a>
								<a href="form-elements.html#" class="btn-minimize"><i class="fa fa-chevron-up"></i></a>
								<a href="form-elements.html#" class="btn-close"><i class="fa fa-times"></i></a>
							</div>
						</div>
						<div class="panel-body">
							<div id="wizard1" class="wizard-type1">
								<ul class="steps">
								  	<li><a href="form-wizard.html#tab11" data-toggle="tab"><span class="badge badge-info"><i class="fa fa-star"></i></span> 客户信息</a></li>
									<li><a href="form-wizard.html#tab12" data-toggle="tab"><span class="badge badge-info"><i class="fa fa-credit-card"></i></span> 设备信息</a></li>
									<li><a href="form-wizard.html#tab13" data-toggle="tab"><span class="badge badge-info"><i class="fa fa-building"></i></span> 错误信息</a></li>
								</ul>
								<div class="progress thin">
									<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%;">
									</div>
								</div>								
								<form class="form-horizontal" role="form" action="/DeviceFixingManaging/servlet/AddReportServlet" method="post">
									<div class="tab-content">
										<div class="tab-pane" id="tab11">
											
											<div class="row">
												<div class="col-sm-11">
													<div class="form-group has-feedback">
														<label for="name-w1">身份证号码</label>
														<input type="text" class="form-control" id="name-w1" name="customer_idno" placeholder="请填写身份证号码">
														<span class="fa fa-asterisk form-control-feedback"></span>
													</div>			
												</div>									
											</div>

											<div class="row">
												<div class="col-sm-11">
													<div class="form-group has-feedback">
														<label for="name-w1">联系人</label>
														<input type="text" class="form-control" id="name-w1" name="customer_linkman" placeholder="请填写联系人姓名">
														<span class="fa fa-asterisk form-control-feedback"></span>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-sm-11">
													<div class="form-group has-feedback">
														<label for="name-w1">移动电话</label>
														<input type="text" class="form-control" id="name-w1" name="customer_mobilephone" placeholder="请填写移动电话号码">
														<span class="fa fa-asterisk form-control-feedback"></span>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-sm-11">
													<div class="form-group has-feedback">
														<label for="name-w1">单位名称</label>
														<input type="text" class="form-control" id="name-w1" name="customer_companyname" placeholder="请填写单位名称">
														<span class="fa fa-asterisk form-control-feedback"></span>
													</div>
												</div>
											</div>
										</div>
										<div class="tab-pane" id="tab12">
											<div class="row">
												<div class="col-sm-5">
													<div class="form-group has-feedback">
														<label for="ccnumber-w1">机器品牌</label>
														<input type="text" class="form-control"  placeholder="" name="report_equip_brand">
														<span class="fa fa-asterisk form-control-feedback"></span>
													</div>
												</div>		

												<div class="form-group col-sm-4">
													<label for="ccmonth-w1">产品类型</label>
													<select class="form-control" id="ccmonth-w1" name="product_type">
														<option>台式机</option>
														<option>笔记本</option>
														<option>投影仪</option>
														<option>打印机</option>
														<option>其他</option>						
													</select>
												</div>



											</div><!--/row-->

											<div class="row">
												<div class="col-sm-5">
													<div class="form-group has-feedback">
														<label for="ccnumber-w1">机器型号</label>
														<input type="text" class="form-control"  placeholder="" name="report_equip_model">
														<span class="fa fa-asterisk form-control-feedback"></span>
													</div>
												</div>
												<div class="col-sm-4">
													<div class="form-group has-feedback">
														<label for="name-w1">接修日期</label>
														<input type="date" class="form-control" id="name-w1" placeholder="" name="report_time">
														<span class="fa fa-asterisk form-control-feedback"></span>
													</div>
												</div>				

											</div><!--/row-->

											<div class="row">
												<div class="col-sm-5">
													<div class="form-group has-feedback">
														<label for="ccnumber-w1">系列号</label>
														<input type="text" class="form-control"  placeholder="" name="report_equip_series">
														<span class="fa fa-asterisk form-control-feedback"></span>
													</div>
												</div>		
												
												<div class="form-group col-sm-4">
													<label for="ccmonth-w1">故障类型</label>
													<select class="form-control" id="ccmonth-w1" name="report_equip_problem_type">
														<option>固定性故障</option>
														<option>间隙性故障</option>																	
													</select>
												</div>
											</div><!--/row-->
										</div>
										<div class="tab-pane" id="tab13">

											<div class="row">
												<div class="col-sm-8">
													<div class="form-group has-feedback">
														<label for="name-w1">故障现象</label>
														<textarea id="limit" class="form-control" rows="6" style="width:100%" name="report_equip_problem"></textarea>
														<span class="fa fa-asterisk form-control-feedback"></span>
													</div>
												</div>
											</div>

											<div class="row">
												<div class="col-sm-8">
													<div class="form-group has-feedback">
														<label for="name-w1">缺少零件</label>
														<textarea id="limit" class="form-control" rows="6" style="width:100%" name="report_equip_absent"></textarea>
														<span class="fa fa-asterisk form-control-feedback"></span>
													</div>
												</div>
											</div>

											<div class="row">
												<div class="col-sm-8">
													<div class="form-group has-feedback">
														<label for="name-w1">随机附件</label>
														<textarea id="limit" class="form-control" rows="6" style="width:100%" name="Attachment"></textarea>
														<span class="fa fa-asterisk form-control-feedback"></span>
													</div>
												</div>
											</div>
										</div>
									</div>
								</form>
								<div class="actions">				
									<input type="button" class="btn btn-default button-previous" name="prev" value="Prev" />
									<input type="button" class="btn btn-success button-next pull-right" name="next" value="Next" />
									<!--<input type="button" class="btn btn-primary button-finish pull-right" name="finish" value="Finish" style="display:none"/>-->
									<button type=""  class="btn btn-primary button-finish pull-right" name="finish" style="display:none" onclick="doQuery();">提交</button>
								</div>
									
							</div>

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
	</div><!-- /.modal -->
	
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
	<script src="/DeviceFixingManaging/assets/plugins/chosen/js/chosen.jquery.min.js"></script>
	<script src="/DeviceFixingManaging/assets/plugins/autosize/jquery.autosize.min.js"></script>
	<script src="/DeviceFixingManaging/assets/plugins/placeholder/jquery.placeholder.min.js"></script>
	<script src="/DeviceFixingManaging/assets/plugins/wizard/jquery.bootstrap.wizard.min.js"></script>
	<script src="/DeviceFixingManaging/assets/plugins/maskedinput/jquery.maskedinput.min.js"></script>

	<!-- theme scripts -->
	<script src="/DeviceFixingManaging/assets/js/SmoothScroll.js"></script>
	<script src="/DeviceFixingManaging/assets/js/jquery.mmenu.min.js"></script>
	<script src="/DeviceFixingManaging/assets/js/core.min.js"></script>

	<!-- inline scripts related to this page -->
	<script src="/DeviceFixingManaging/assets/js/pages/form-wizard.js"></script>

	<!-- end: JavaScript-->

</body>
</html>