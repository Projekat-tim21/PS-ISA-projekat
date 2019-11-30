<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta charset="ISO-8859-1">
<title>Lista klinika</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<body>
  
  	<div role="navigation">
		<div class="navbar navbar-inverse">
			<div class="navbar-collapse collapse">
			<h2>Pregled informacija</h2>
				<ul class="nav navbar-nav">
					<li><a href="/profilkaPregledu?username=${username}">Profil</a></li>
					<li><a href="/izmenaPodatakaizBara?username=${username}">Izmena podataka</a></li>
			<!-- 	<li><a href="/pokazikorisnikaSaLogina">Svi korisnici</a></li> 	 -->	
					<li><a href="/logout">Odjavi se</a></li> 
				</ul>

			</div>
		</div>
	</div>
  
  
	<c:choose>
		<c:when test="${mode=='ALL_KLINIKE' }">     
			<div class="container text-center" id="tasksDiv">
				<h3>Lista klinika</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Naziv</th>
								<th>Adresa</th>
								<th>Grad</th>
								<th>Drzava</th>
								<th>Prosecna ocena</th>
								<th>Cena</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="klinike" items="${klinike}">
								<tr>
									<td>${korisnik.id}</td>
									<td>${korisnik.naziv}</td>
									<td>${korisnik.adresa}</td>
									<td>${korisnik.grad}</td>
									<td>${korisnik.drzava}</td>
									<td>${korisnik.prosecna_ocena}</td>
									<td>${korisnik.cena}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>

			<!-- <div class="btn-group" >
 			   <button type="button" class="btn btn-primary center-block">Prikazi</button>
 			 </div>
	 -->



		</c:when>
	</c:choose>
 
</body>
</html>