<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Song</title>
</head>
<body>
	
	<!-- url to reach the page : http://localhost:8080/projet2/SongForm.do -->
	
	<form:form method="POST" action="${pageContext.request.contextPath}/CreateNewSong.do">
	   <table>
	   
	   		<tr>
		        <td><form:label path="chansonID.idChanson">id chanson</form:label></td>
		        <td><form:input path="chansonID.idChanson" type="text" value="9"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="chansonID.albumID.idAlbum">album id</form:label></td>
		        <td><form:input path="chansonID.albumID.idAlbum" type="text" value="8"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="chansonID.albumID.idArtiste">artist id</form:label></td>
		        <td><form:input path="chansonID.albumID.idArtiste" type="text" value="12"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="titre">titre</form:label></td>
		        <td><form:input path="titre" type="text" value="salut"/></td>
		    </tr>
		    <tr>
		        <td><form:label path="dureeChanson">duree</form:label></td>
		        <td><form:input path="dureeChanson" type="text" value='3' /></td>
		    </tr>
		    
		    <tr>
		        <td colspan="2">
		            <input type="submit" value="Submit"/>
		        </td>
		    </tr>
		    
		</table> 
	</form:form> 
	
	
	
</body>
</html>