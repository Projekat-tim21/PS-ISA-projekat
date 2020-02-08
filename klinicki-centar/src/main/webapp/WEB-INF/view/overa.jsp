<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Overa</title>
<style>

.example_d {
color: #20bf6b !important;
text-transform: uppercase;
background: #ffffff;
padding: 20px;
border: 4px solid #20bf6b !important;
border-radius: 6px;
display: inline-block;
transition: all 0.3s ease 0s;
}

.example_d:hover {
color: #494949 !important;
border-radius: 50px;
border-color: #494949 !important;
transition: all 0.3s ease 0s;
}
</style>
<link href="/static/css/bootstrap.min.css" rel="stylesheet">
<link href="/static/css/style.css" rel="stylesheet">
 <link rel="shortcut icon" href="#" />
</head>
<body>
<div role="navigation">
		<div class="navbar navbar-inverse">
			<div class="navbar-collapse collapse">
			<h2>MEDICINSKA SESTRA</h2>
				<ul class="nav navbar-nav">
				<li><a href="/sviSestraPacijenti">Svi pacijenti</a></li>
				<li><a href="/overaRecepta">Overa recepata</a></li>
					<li><a href="/zahtevZaOdsustvo?id=${id}">Odsustvo/Odmor</a></li>
					<li><a href="/radniKalendarSestre?id=${id}">Radni kalendar</a></li>
					<li><a href="/profilSestra?id=${id}">Profil</a></li>
					<li><a href="/logout">Odjavi se</a></li>
				</ul>
			
			</div>
		</div>
	</div>
	
	<c:choose>
		<c:when test="${mode=='MODE_OVERA' }">
			<div class="container text-center">
				<h3>Informacije</h3>
				<hr>
					</div>
				<div>
						<label class="control-label col-md-4">Pacijent</label>
						<label >${korisnik.pacijentId }</label>
				</div>
				<div>
						<label class="control-label col-md-4">Lekar</label>
						<label >${korisnik.lekarId }</label>
				</div>
				<div>
						<label class="control-label col-md-4">Pregled</label>
						<label >${korisnik.informacije }</label>
				</div>
				<div>
						<label class="control-label col-md-4">Lekovi</label>
					<c:forEach var="lek" items="${lekici }">
					<label >${lek.naziv }</label>
					</c:forEach>
					
				</div>
		
				
					<hr>
					<div class="button_cont" align="center"><a class="example_d"  href="/overaRecepta">OVERI</a></div>


		</c:when>
</c:choose>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="/static/js/bootstrap.min.js"></script>
<script src="/static/js/app.js"></script>
<script src="/static/js/edit.js"></script>
</body>
</html>