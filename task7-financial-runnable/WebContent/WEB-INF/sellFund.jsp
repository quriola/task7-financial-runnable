<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mutual Fund from CFS</title>
<link href="css/style1.css" rel="stylesheet" type="text/css">
<link href="css/style1.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="css/style-viewaccount.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="dist/css/bootstrap.min.css">
<script src="js/jquery-1.11.1.js"></script>
<script src="js/bootstrap.min.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/scripts.js"></script>
</head>
<body>
<div class="page-header">
				<h1>
					Mutual Fund
					 <small>Ready to get started? <!--  <button type="button" class="btn btn-sm btn-danger">Sign Up an Account</button>  --> 
					<a id="modal-353912" href="#modal-container-353912" role="button" class="btn" data-toggle="modal">Sign In</a>
			
			<div class="modal fade" id="modal-container-353912" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						 <div class="modal-header">
							 <button type="button" class="close" data-dismiss="modal" aria-hidden="true"> x </button>
							<h4 class="modal-title" id="myModalLabel">
								Sign Up
							</h4>
						</div> 
						<div class="modal-body">
							<div class="tabbable" id="tabs-373235">
				<ul class="nav nav-tabs">
					<li>
						<a href="#panel-998277" data-toggle="tab"><font size="4">Customer</font></a>
					</li>
					<li class="active">
						<a href="#panel-797162" data-toggle="tab"><font size="4">Employee</font></a>
					</li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane" id="panel-998277">
						<p>
							<form class="form-horizontal" role="form">
				<div class="form-group">
					 <label for="inputEmail3" class="col-sm-2 control-label"><font size="3" face="Verdana">Username</font></label>
					<div class="col-sm-10">
						<input type="email" class="form-control" id="inputEmail3" />
					</div>
				</div>
				<div class="form-group">
					 <label for="inputPassword3" class="col-sm-2 control-label"><font size="3" face="Verdana">Password</font></label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="inputPassword3" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<div class="checkbox">
							 <label><input type="checkbox" /> <font size="3" face="Verdana">Remember me</font></label>
						</div>
					</div>
				</div>
			</form>
						</p>
					</div>
					<div class="tab-pane active" id="panel-797162">
						<p>
							<form class="form-horizontal" role="form">
				<div class="form-group">
					 <label for="inputEmail3" class="col-sm-2 control-label"><font size="3" face="Verdana">Username</font></label>
					<div class="col-sm-10">
						<input type="email" class="form-control" id="inputEmail3" />
					</div>
				</div>
				<div class="form-group">
					 <label for="inputPassword3" class="col-sm-2 control-label"><font size="3" face="Verdana">Password</font></label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="inputPassword3" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<div class="checkbox">
							 <label><input type="checkbox" /> <font size="3" face="Verdana">Remember me</font></label>
						</div>
					</div>
				</div>
			</form>
						</p>
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


<!--header end-->
<!--Paste part stop here, except the product detail and search result -->
<div class="row clearfix">
		<div class="col-md-2 column" id="sidemenu" style="margin-top: 40">
		  <nav>
  <ul>
 
		    <h4>Stock Trading</h4>            
		  	<li><a href="buyFund.jsp">Buy Fund</a></li>   
		  	<li><a href="sellFund.jsp">Sell Fund</a></li> 
		  	<li><a href="research.html">Research Fund</a></li>
		  	<li><a href="RequestCheck.html">Request Check</a></li> 
		  	<li><a href="transaction history.html">Transaction History</a></li>  
		  	<h4>Personal Account</h4> 
		  	<li><a href="resetPassword.html">Change Password</a></li> 
		  	<li><a href="viewAccoutByCus.jsp">View Account</a></li>  
		  	<li>Logout</li>  
  
  </ul>
  </nav>
		</div>
		
		
		<div class="col-md-6 column" style="margin-top: 40">
		
		<p id="is" align="left"><a href="Home.html" style="padding-left: 350px; margin-top: 20px;">
	Home </a> &gt; <a href="">Stock Trading Management</a> &gt;Sell Fund
</p>
<form method="post" action="sellfund.do">
            <table class="table">
				
				<tbody>
					<tr>
						<td>
							Please choose fund:
						</td>
						<td>
						
							<select name="fund">
							<option value="funda">Fund A</option>
							<option value="fundb">Fund B</option>
							<option value="fundc">Fund C</option>
							<option valud="fundd">Fund D</option>
							</select>
						</td>
						
					</tr>
					<tr class="active">
						<td>
							Number of Shares:
						</td>
						<td>
							<input type="text" name="shareNumber" value="${form.shareNumber}"></input>
						</td>
						
					</tr>
				    
					<tr class="warning">
						<td>
							<button id="cancel">Cancel</button>
						</td>
						
						<td>
							<input type="submit" name="button" value="Submit" />
						</td>
						
					</tr>
				
				</tbody>
			</table>
</form>

			
		</div>
		
	</div>
</body>
</html>