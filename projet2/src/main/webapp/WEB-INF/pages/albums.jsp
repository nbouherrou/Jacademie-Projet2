<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Albums</title>

<jsp:include page="header.jsp" />
<link href="${pageContext.request.contextPath}/css/jquery.bdt.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/js/jquery.bdt.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.sortelements.js"></script>
</head>
<body>

	<!-- Navigation -->
		<jsp:include page="navigation.jsp" />

		<!-- Page Content -->
		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						
						<div class="container">
							<div class="row">
								<div class="col-lg-4 col-lg-offset-3">
									<div class="login-panel panel panel-default">
										<div class="panel-heading">
											<h3 class="panel-title">Ajout album</h3>
										</div>
										<div class="panel-body">
											
										<form:form method="POST" modelAttribute="Album" action="${pageContext.request.contextPath}/AddAlbum.do" data-toggle="validator">
											<fieldset>
												<div class="form-group">
													
													<form:label class="control-label" style="display:none" path="albumID.idArtiste">Id artiste</form:label>
											        <form:input class="form-control" style="display:none" path="albumID.idArtiste" type="text" value="${id}"/>
											        
											        <br>
												
											        <form:label class="control-label" path="albumID.idAlbum">Code Album</form:label>
											        <form:input class="form-control" path="albumID.idAlbum" type="text" placeholder="code album"/>
											        
											        <br>
											    
											        <form:label class="control-label" path="nom">Titre album</form:label>
											        <form:input class="form-control" path="nom" type="text" placeholder="titre album"/>
											        
											        <br>
											  	</div>
											    
												<div class="form-group">
													<input type="submit" value="Submit" class="btn btn-lg btn-success btn-block"/>
												</div>
		
											</fieldset> 
										</form:form>
																						
										</div>
									</div>
								</div>
							</div>
						</div>
						
						<h1 class="page-header text-center">Listes des chansons</h1>
						
						<table class="table table-hover" id="bootstrap-table">
							<thead>
								<tr>
									<th>Code Album</th>
									<th>Nom Album</th>
								</tr>
							</thead>
							
							<tbody>
								<c:forEach var="album" items="${albums}">
									<tr>
										<td><c:out value="${album.albumID.idAlbum}" /></td>
										<td>
											<a href="Songs.do?codeArtiste=${album.albumID.idArtiste}&codeAlbum=${album.albumID.idAlbum}">
												<c:out value="${album.nom}" />
											</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.container-fluid -->
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->
	

</body>
</html>