<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Songs</title>

<jsp:include page="header.jsp" />
<link href="${pageContext.request.contextPath}/css/jquery.bdt.css" rel="stylesheet" type="text/css" />
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

						<h1 class="page-header text-center">Listes des chansons</h1>
						
						<table class="table table-hover" id="bootstrap-table">
							<thead>
								<tr>
									<th>#ID chanson</th>
									<th>titre</th>
									<th>duree</th>
									<th>Supprimer</th>
								</tr>
							</thead>
							
							<tbody>
								<c:forEach var="song" items="${songs}">
									<tr>
										<td><c:out value="${song.chansonID.idChanson}" /></td>
										<td><c:out value="${song.titre}" /></td>
										<td><c:out value="${song.dureeChanson}" /></td>
										<td><a href=""><i class="fa fa-times"></i></a></td>
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
							
							
						<!-- table>
							<tr>
								<th>Songs</th>
							</tr>
							<c:forEach var="song" items="${songs}">
								<tr>
									<td><c:out value="${song.chansonID.idChanson}" /></td>
								</tr>
								<tr>
									<td><c:out value="${song.chansonID.albumID.idAlbum}" /></td>
								</tr>
								<tr>
									<td><c:out value="${song.chansonID.albumID.idArtiste}" /></td>
								</tr>
								<tr>
									<td><c:out value="${song.titre}" /></td>
								</tr>
								<tr>
									<td><c:out value="${song.dureeChanson}" /></td>
								</tr>
							</c:forEach>
						</table -->
	
</body>
</html>