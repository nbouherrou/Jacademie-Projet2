<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Artistes</title>

<jsp:include page="header.jsp" />


<link href="${pageContext.request.contextPath}/css/jquery.bdt.css"
	rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/js/jquery.bdt.js"></script>
<script
	src="${pageContext.request.contextPath}/js/jquery.sortelements.js"></script>
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

						<h1 class="page-header text-center">Artistes</h1>

						<div class="container">
							<div class="row">
								<div class="col-lg-4 col-lg-offset-3">
									<div class="login-panel panel panel-default">
										<div class="panel-heading">
											<h3 class="panel-title">Inscription Artiste</h3>
										</div>
										<div class="panel-body">

											<form role="form" modelAttribute="artiste" action="registerArtiste.do" method="POST"
												data-toggle="validator">
												<fieldset>
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
												</fieldset>
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>






						<%
							int i = 0;
						%>
						<table class="table table-hover" id="bootstrap-table">
							<thead>
								<tr>
									<th>#ID</th>
									<th>Artistes</th>
									<th>Editer</th>
									<th>Supprimer</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="artistes" items="${artistes}">
									<%
										i++;
									%>
									<tr>
										<td><%=i%></td>
										<td><a href="/Albums.do"><c:out value="${artistes.nom}" /></a></td>
										<td><i class="fa fa-pencil-square-o"></i></td>
										<td><i class="fa fa-times"></i></td>
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

	<script>
		$(document).ready(function() {
			$('#bootstrap-table').bdt();
		});
	</script>



</body>
</html>