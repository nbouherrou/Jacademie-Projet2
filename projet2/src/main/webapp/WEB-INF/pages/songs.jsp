<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Songs</title>
</head>
<body>
	
	<p>Hello World</p>
	
	<table>
		<tr>
			<th>Songs</th>
		</tr>
		<c:forEach var="song" items="${songs}">
			<tr>
				<td><c:out value="${song.titre}" /></td>
			</tr>
		</c:forEach>
	</table>
	
	
</body>
</html>