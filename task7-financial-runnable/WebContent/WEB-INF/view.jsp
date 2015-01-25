<jsp:include page="template-top.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<table>
	<h2>Favorites for ${cur_user.firstName}  ${cur_user.lastName}</h2>
	<c:forEach var="item" items="${favoriteList}">
		   
        <table>
		<tr>
			<td valign="baseline"><a href="click.do?id=${item.favorite_id }" >${ item.url }</a></td>
		</tr>
		<tr>
			<td valign="baseline">${ item.comment }</td>
		</tr>
		<tr>
			<td valign="baseline">${ item.click_count } Clicks</td>
		</tr>
		
		
		</table>
		
	</c:forEach>
</table>

<jsp:include page="template-bottom.jsp" />
