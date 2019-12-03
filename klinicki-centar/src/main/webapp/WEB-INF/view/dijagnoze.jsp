<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta charset="ISO-8859-1">
<title>Dijagnoze</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<body>
 
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<div class="navbar-collapse collapse">
			<h2>ADMINISTRATOR</h2>
				<ul class="nav navbar-nav">
					<li><a href="/zahteviRegistrovanje">Registrovanje korisnika</a></li>
					<li><a href="/klinike">Klinike</a></li>
					<li><a href="/adminKlinike">Administratori klinika</a></li>
					<li><a href="/lekovi">Lekovi</a></li>
					<li><a href="/dijagnoze">Dijagnoze</a></li>
					<li><a href="/logout">Odjavi se</a></li>
				</ul>
			
			</div>
		</div>
	</div>
	
	<c:choose>
	<c:when test="${mode=='ALL_DIJAGNOZE' }">
			<div class="container text-center" id="tasksDiv">
				<h3>DIJAGNOZE</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Sifra</th>
								<th>Naziv</th>
								<th>Opis</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="dijagnoza" items="${dijagnoze}">
								<tr>
									<td>${dijagnoza.id}</td>
									<td>${dijagnoza.sifra}</td>
									<td>${dijagnoza.naziv}</td>
									<td>${dijagnoza.dodatno}</td>
									
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
</c:choose>
</body>
</html></html>