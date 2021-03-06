<jsp:include page="template-top.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

		
		
		<h2> Account Information </h2>
            <table class="table table-striped ">
				
				<tbody>
					<tr>
						<td>
							Name:
						</td>
						<td>
							${customer.firstname},   ${customer.lastname}
						</td>
						
					</tr>
					<tr>
						<td>
							Address:
						</td>
						<td>
							${customer.addrL1}  
						</td>
						
					</tr>
					<tr>
						<td>
							Address (line 2):
						</td>
						<td>
							${customer.addrL2}  
						</td>
						
					</tr>
					<tr>
						<td>
							City
						</td>
						<td>
							${customer.city}  
						</td>
						
					</tr>
					<tr>
						<td>
							State
						</td>
						<td>
							${customer.state}  
						</td>
						
					</tr>
					<tr>
						<td>
							Zipcode
						</td>
						<td>
							${customer.zip}  
						</td>
						
					</tr>
					
					<tr>
						<td>
							Cash Balance:
						</td>
						<td>
							${customer.cash} 
						</td>
						
					</tr>
				
				</tbody>
			</table>


			<table class="table table-hover">
				<thead>
					<tr>
						<th>
							FUND
						</th>
						<th>
							LAST TRADING DATE
						</th>
						<th>
							NUMBER OF SHARE
						</th>
						<th>
							FUND VALUE
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							Fund A
						</td>
						<td>
							01/15/2015
						</td>
						<td>
							
						</td>
						<td>
							
						</td>
					</tr>
					<tr class="active">
						<td>
							Fund B
						</td>
						<td>
							01/02/2015
						</td>
						<td>
							
						</td>
						<td>
							
						</td>
					</tr>
					<tr class="success">
						<td>
							Fund C
						</td>
						<td>
							12/22/2014
						</td>
						<td>
							
						</td>
						<td>
							
						</td>
					</tr>
					<tr class="warning">
						<td>
							Fund D
						</td>
						<td>
							11/30/2014
						</td>
						<td>
							
						</td>
						<td>
						
						</td>
					</tr>
					<tr class="danger">
						<td>
							Fund E
						</td>
						<td>
							08/18/2014
						</td>
						<td>
							
						</td>
						<td>
							
						</td>
					</tr>
				</tbody>
			</table>
	

<jsp:include page="template-bottom.jsp" />
