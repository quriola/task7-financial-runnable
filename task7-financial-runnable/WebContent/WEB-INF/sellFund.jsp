<jsp:include page="template-top.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<h2>Buy Fund</h2>
<h4 class="text-primary">Available Balance : ${customer.cash}</h4>
<table class="table table-striped">
	<thead>
		<tr>
			<th>Product</th>
			<th>Description</th>
			<th>Amount</th>
			<th>Operation</th>
		</tr>
	</thead>
	
		   
        <c:forEach var="item" items="${fundList}">
		   <form action="confirmbuy.do" method="POST">
         
        <tr>
			<td>${ item.name }</td>
			<td>${ item.symbol }</td>
			<td><input type="text" name="amount" /></td>
			<td><input type="submit" class="btn btn-success" value="Buy" /></td>
		</tr>
		
		<input type="hidden" name="fundId" value="${ item.id }" />
        
		
		        			
        </form>
		
	</c:forEach>
	
</table>
<jsp:include page="template-bottom.jsp" /> 