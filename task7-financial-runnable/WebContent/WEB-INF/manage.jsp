<jsp:include page="template-top.jsp" />

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<p style="font-size:medium">
	Add a new bookmark:
</p>

<jsp:include page="error-list.jsp" />

<p>
	<form method="post" action="upload.do">
		<table>
			<tr>
				<td>URL: </td>
				<td colspan="2"><input type="text" name="url" value="${url}"/></td>
			</tr>
			<tr>
				<td>Comment: </td>
				<td><input type="text" name="comment" value="${comment}"/></td>
				
			</tr>
			<tr>
				<td colspan="3" align="center">
					<input type="submit" name="button" value="Add"/>
				</td>
			</tr>
		</table>
	</form>
</p>
<hr/>

<table>
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
		 <form action="remove.do" method="POST">
                			<input type="hidden" name="id" value="${ item.favorite_id }" />
                			<input type="submit" name="button" value="remove" />
           				</form>
		
	</c:forEach>
</table>



<jsp:include page="template-bottom.jsp" />
