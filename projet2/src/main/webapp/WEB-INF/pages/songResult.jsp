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
	
	<h2>Submitted Song Information</h2>
   <table>
	    <tr>
	        <td>song's title : </td>
	        <td>${titre}</td>
	    </tr>
	    <tr>
	        <td>song's duration : </td>
	        <td>${dureeChanson}</td>
	    </tr>
	</table>  
	
</body>
</html>