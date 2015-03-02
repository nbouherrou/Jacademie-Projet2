<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Albums</title>
</head>
<body>

	<table>
		<tr>
			<th>Albums</th>
		</tr>
		<c:forEach var="album" items="${albums}">
			<tr>
				<td><c:out value="${album.nom}" /></td>
			</tr>
		</c:forEach>
	</table>



</body>
</html>