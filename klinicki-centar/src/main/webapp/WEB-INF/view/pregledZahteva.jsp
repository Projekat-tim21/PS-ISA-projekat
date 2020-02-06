<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta charset="ISO-8859-1">
<title>Zahtevi za registraciju</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<link href="static/css/theme.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<body>
 
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<div class="navbar-collapse collapse">
			<h2>ADMINISTRATOR</h2>
				<ul class="nav navbar-nav">
				<li><a href="/sviIzBaze">Pregled svih</a></li>
					<li><a href="/zahteviRegistrovanje">Registrovanje korisnika</a></li>
					<li><a href="/addNewZK">Zdravstevni karton</a></li>
					<li><a href="/klinike">Klinike</a></li>
					<li><a href="/pregledSvihAdmina">Administratori KC</a></li>
					<li><a href="/pregledSvihAdminaKlinike">Administratori klinika</a></li>
					<li><a href="/lekovi">Lekovi</a></li>
					<li><a href="/dijagnoze">Dijagnoze</a></li>
					<li><a href="/logout">Odjavi se</a></li>
				</ul>
			
			</div>
		</div>
	</div>
	
	<c:choose>
	<c:when test="${mode=='ALL_USERS' }">
			<div class="container text-center" id="tasksDiv">
				<h3>Pristigli zahtevi</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>Id</th>
								<th>Korisnicko ime</th>
								<th>Ime</th>
								<th>Prezime</th>
								<th>JBO</th>
								<th>Email</th>
								<th>Adresa</th>
								<th>Grad</th>
								<th>Drzava</th>
								<th>Telefon</th>
								<th colspan="2">Prihvati/Odbij</th>
						<!--		<th>Sifra</th>  -->
							</tr>
						</thead>
						<tbody>
							<c:forEach var="korisnik" items="${korisnici }">
								<tr>
									<td>${korisnik.id}</td>
									<td>${korisnik.username}</td>
									<td>${korisnik.ime}</td>
									<td>${korisnik.prezime}</td>
									<td>${korisnik.jedBrOsig}</td>
									<td>${korisnik.email}</td>
									<td>${korisnik.adresa}</td>
									<td>${korisnik.grad}</td>
									<td>${korisnik.drzava}</td>
									<td>${korisnik.telefon}</td>
									<td>
                                        <a href="/enable/${korisnik.getId()}" class="saveData"><span class="btn-label"><img src="static/svg/check.svg"></span></a>
                                        </td>
                                        <td><a href="/disable/${korisnik.getId()}" class="deleteData"><span class="btn-label"><img src="static/svg/x.svg"></span></a>
                                        </td>
					<!--  				<td>${korisnik.password}</td>  -->
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
</c:choose>
</body>
</html>