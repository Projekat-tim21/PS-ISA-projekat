<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
		<title>Prvi put ulogovan administrator</title>
		<link rel="stylesheet" href="static/css/bootstrap.min.css"/>
<link href="static/css/style.css" rel="stylesheet">
<link href="static/css/theme.css" rel="stylesheet">
		
	</head>
	<body>
		<c:choose>
		<c:when test="${mode=='MODE_LOGIN' }">
			<div class="container text-center">
				<h3>Molim Vas promenite lozinku</h3>
				<hr>
				<form class="form-horizontal" name="forma" method="POST" modelAttribute="korisnik" action="editpassword">>
					<div class="form-group">
						<label class="control-label col-md-3">Id</label>
						<div class="col-md-6">
							<input type="text"  class="form-control" id="id" name="id"
								value="${korisnik.id }" readonly>
								<span id="free"></span>
						</div>
					</div>
					
					<div class="form-group">
	 					<label class="control-label col-md-3">Korisnicko ime</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="username" name="username"
								value="${korisnik.username}" readonly> <span id="free"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Nova lozinka</label>
						<div class="col-md-6">
							<input type="password" class="form-control" name="password"

								value="${korisnik.password }" required>
						</div>
					</div>
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Izmeni">
					</div>
					
					<hr>
					<div>
					
				</form>
			</div>
		</c:when>







	</c:choose>
		<script src="static/js/jquery-1.11.1.min.js"></script>
		<script src="static/js/bootstrap.min.js"></script>
	</body>