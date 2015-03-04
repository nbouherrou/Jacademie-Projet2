<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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

						<h1 class="page-header text-center">Mode edition</h1>

						<div class="container">
							<div class="row">
								<div class="col-lg-4 col-lg-offset-3">
									<div class="login-panel panel panel-default">
										<div class="panel-heading">
											<h3 class="panel-title">Editer un artiste</h3>
										</div>
										<div class="panel-body">
											
										<form:form method="POST" modelAttribute="Artiste" action="${pageContext.request.contextPath}/ArtisteToUpdate.do" data-toggle="validator">
											<fieldset>
												<div class="form-group">
													
													<form:label class="control-label" style="display:none" path="id">Id artiste</form:label>
											        <form:input class="form-control" style="display:none" path="id" type="text" value="${id}"/>
											        
													<form:label class="control-label" style="display:none" path="idArtiste">Code artiste</form:label>
											        <form:input class="form-control" style="display:none" path="idArtiste" type="text" value="${id}"/>
											        
											    
											        <form:label class="control-label" path="nom">Nom d'un artiste</form:label>
											        <form:input class="form-control" path="nom" type="text" value="${nom}"/>
											        
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