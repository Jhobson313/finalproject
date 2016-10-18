<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="login-bar">
	<c:choose>
		<c:when test="${ empty currentUser }">
			<a href="<c:url value="/login"/>">Log In</a>
		</c:when>
		<c:otherwise>
		Hello
		<c:out value="${ currentUser.firstName }" />
			<c:out value="${ currentUser.lastName }" />
			<a href="<c:url value="/logout"/>">(Log Out)</a>
		</c:otherwise>
	</c:choose>
</div>