<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Albums</title>

<jsp:include page="header.jsp" />


<link 	href="${pageContext.request.contextPath}/css/jquery.bdt.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/js/jquery.bdt.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.sortelements.js"></script>
	
</head>
<body>

	<div id="wrapper">

		<!-- Navigation -->
		<jsp:include page="navigation.jsp" />
		
		<!-- Page Content -->
		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
					
					<h1 class="page-header text-center">Albums</h1>
					
					<div class="container">
							<div class="row">
								<div class="col-lg-4 col-lg-offset-3">
									<div class="login-panel panel panel-default">
										<div class="panel-heading">
											<h3 class="panel-title">Creation d'un Album</h3>
										</div>
										<div class="panel-body">

											<form role="form" name="album" action="registerArtiste.do" method="POST" data-toggle="validator">
												
												    <div class="form-group">
														<label class="control-label">Nom de l'artiste : </label> <input
															class="form-control" placeholder="Name" name="name"
															type="text" data-delay="10" required>
														<div class="help-block with-errors"></div>
													</div>

													<div class="form-group">
														<button type="submit"
															class="btn btn-lg btn-success btn-block">Submit</button>
													</div>
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>
					
					<table class="table table-hover" id="bootstrap-table">
							<thead>
								<tr>
									<th>Code Album</th>
									<th>Nom</th>
									<th>Editer</th>
									<th>Supprimer</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="album" items="${albums}">
									<tr>
										<td><c:out value="${album.albumID.idAlbum}" /></td>
										<td><a href="#"><c:out value="${album.nom}" /></a></td>
										<td><i class="fa fa-pencil-square-o"></i></td>
										<td>
											<a href="#">
												<i class="fa fa-times"></i>
											</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>