<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta charset="ISO-8859-1">
<title>Novi pregled</title>
  <base href="/">
   <link rel="shortcut icon" href="#" />
<link href="/static/css/bootstrap.min.css" rel="stylesheet">
<link href="/static/css/style.css" rel="stylesheet">
<link href="/static/css/theme.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>

	<div role="navigation">
		<div class="navbar navbar-inverse">
			<div class="navbar-collapse collapse">
			<h2>LEKAR</h2>
				<ul class="nav navbar-nav">
					<li><a href="/pregledSvihPacijenataMetoda">Svi pacijenti</a></li>
					<li><a href="/pacijenti">Prikazi profil pacijenta</a></li>
					<li><a href="/zakazivanjePregleda">Zakazi pregled</a></li>
					<li><a href="/radniKalendar?id=${id}">Radni kalendar</a></li>
					<li><a href="/logout">Odjavi se</a></li>
				</ul>
			
			</div>
		</div>
	</div>

<c:choose>
	
		<c:when test="${mode=='MODE_PREGLED' }">
			<div class="container text-center">
				
		<hr>
				<form class="form-horizontal" method="POST"
					action="sacuvajNoviPregled/${lekar.id  }/${korisnik.id }">
					<label>Zakazi novi pregled</label>
					<input type="datetime-local" name="terminpregled" id="terminpregled"/>
					<input type="hidden" id="idlekarpregled" name="idlekarpregled" value="${lekar.id }"> 
					<input type="hidden" id="idpacijenta" name="idpacijenta" value="${korisnik.id}"> 
  				
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Sacuvaj">
					</div>
				</form>
			</div>


		</c:when>



	</c:choose>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="/static/js/bootstrap.min.js"></script>
<script src="/static/js/app.js"></script>
</body>
</html>