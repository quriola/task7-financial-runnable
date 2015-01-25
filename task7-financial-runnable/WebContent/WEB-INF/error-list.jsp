<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<c:if test="${not empty errors}">
	<p style="font-size: medium; color: red">
		<c:forEach var="error" items="${errors}">
		  ${error} 
		  <br />
		</c:forEach>
	</p>
</c:if>