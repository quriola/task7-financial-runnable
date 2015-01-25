<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="pragma" content="no-cache">
<title>Mutual Fund from CFS</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">

</head>

<body>
	<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="page-header">
				<h1 class="text-danger">
					Carnegie Financial Services
					 <small>Ready to get started? <!--  <button type="button" class="btn btn-sm btn-danger">Sign Up an Account</button>  --> 
					 <div class="navbar-form navbar-right"><button type="submit" data-toggle="modal" data-target="#modal-container-353912"
						class="btn btn-success">Sign in</button></div>
			<div class="modal fade" id="modal-container-353912" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
				<div class="modal-dialog">
					<div class="modal-content">
						 <div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button><h4 class="modal-title" id="myModalLabel">
								Sign In
							</h4>
						</div> 
						<div class="modal-body">
							<div class="tabbable" id="tabs-373235">
				<ul class="nav nav-tabs">
					<li class="active">
						<a href="#panel-998277" data-toggle="tab"><font size="4">Customer</font></a>
					</li>
					<li class="">
						<a href="#panel-797162" data-toggle="tab"><font size="4">Employee</font></a>
					</li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane active" id="panel-998277">
						<p>
							</p><form class="form-horizontal" role="form">
				<div class="form-group">
					 <label for="inputEmail3" class="col-sm-2 control-label"><font size="3" face="Verdana">Username</font></label>
					<div class="col-sm-10">
						<input type="email" class="form-control" id="inputEmail3">
					</div>
				</div>
				<div class="form-group">
					 <label for="inputPassword3" class="col-sm-2 control-label"><font size="3" face="Verdana">Password</font></label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="inputPassword3">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<div class="checkbox">
							 <label><input type="checkbox"> <font size="3" face="Verdana">Remember me</font></label>
						</div>
					</div>
				</div>
			</form>
						<p></p>
					</div>
					<div class="tab-pane" id="panel-797162">
						<p>
							</p><form class="form-horizontal" role="form">
				<div class="form-group">
					 <label for="inputEmail3" class="col-sm-2 control-label"><font size="3" face="Verdana">Username</font></label>
					<div class="col-sm-10">
						<input type="email" class="form-control" id="inputEmail3">
					</div>
				</div>
				<div class="form-group">
					 <label for="inputPassword3" class="col-sm-2 control-label"><font size="3" face="Verdana">Password</font></label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="inputPassword3">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<div class="checkbox">
							 <label><input type="checkbox"> <font size="3" face="Verdana">Remember me</font></label>
						</div>
					</div>
				</div>
			</form>
						<p></p>
					</div>
				</div>
			</div>
						</div>
						<div class="modal-footer">
							 <!-- <button type="button" class="btn btn-default" data-dismiss="modal">Close</button> <button type="button" class="btn btn-primary">Save changes</button> -->
							 <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button> <button type="button" class="btn btn-primary">Login</button>
						</div>
					</div>
				</div>				
			</div>
			
					</small>
				</h1>
				<small>CFS serves the best service for you</small>
				Or give us a call at (412)888-8888.	
			</div>
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-3 column">
			<div class="panel-group" id="panel-872653">
				<c:if test="${empty user}">
				<div class="panel panel-default">
					<div class="panel-heading">
						<a id="modal-353912" href="#modal-container-353912" role="button" class="btn" data-toggle="modal">Sign In</a>
				</div>
				</div>
				</c:if>
				<c:if test="${not empty user}">
				
				</c:if>
			</div>
		</div>
			<div class="col-md-9 column">
			
	
	
	
	