<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta charset="ISO-8859-1">
<title>Karton pacijenta</title>

    <!-- Bootstrap CSS-->
	<link href="/static/css/bootstrap.min.css" rel="stylesheet">
	<link href="/static/css/style.css" rel="stylesheet">
    <!-- Vendor CSS-->
  
    <link href="/static/js/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all">
    <link href="/static/js/wow/animate.css" rel="stylesheet" media="all">
    <link href="/static/js/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all">
    <link href="/static/js/slick/slick.css" rel="stylesheet" media="all">
    <link href="/static/js/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="/static/js/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all">

    <!-- FullCalendar -->
    <link href='/static/js/fullcalendar-3.10.0/fullcalendar.css' rel='stylesheet' media="all" />

    <!-- Main CSS-->
    <link href="/static/css/theme.css" rel="stylesheet" media="all">


<style>
body {
	background-image: url("/static/images/slika.jpg");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: bottom right;
}
</style>

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
				<h3>Pregled podataka</h3>
				<hr>
				<form class="form-horizontal" method="POST"
					action="/sacuvajKarton">

					<div class="form-group">
						<label class="control-label col-md-3">Id</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="id" name="id"
								value="${korisnik.id }" readonly> <span id="free"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Ime</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="ime"
								name="ime" value="${korisnik.ime }" readonly>
							<span id="free"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Prezime</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="prezime"
								name="prezime" value="${korisnik.prezime }" readonly>
							<span id="free"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Alergija</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="alergije"
								name="alergije" value="${korisnik.alergije }" required>
							<span id="free"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Anamneza</label>
						<div class="col-md-6">
							<input type="text" class="form-control" name="anamneza"
								value="${korisnik.anamneza }" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Bolesti</label>
						<div class="col-md-6">
							<input type="text" class="form-control" name="bolesti"
								value="${korisnik.bolesti }" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Datum</label>
						<div class="col-md-6">
							<input type="text" class="form-control" name="datum"
								value="${korisnik.datum }" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Dioptrija</label>
						<div class="col-md-6">
							<input type="text" class="form-control" name="dioptrija"
								value="${korisnik.dioptrija }" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Krvna grupa</label>
						<div class="col-md-6">
							<input type="text" class="form-control" name="kgrupa"
								value="${korisnik.kgrupa }" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Pol</label>
						<div class="col-md-6">
							<input type="text" class="form-control" name="pol"
								value="${korisnik.pol }" required>
						</div>
					</div>
				
					<div class="form-group">
						<label class="control-label col-md-3">Tezina</label>
						<div class="col-md-6">
							<input type="text" class="form-control" name="tezina"
								value="${korisnik.tezina }" required>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-3">Visina</label>
						<div class="col-md-6">
							<input type="text" class="form-control" name="visina"
								value="${korisnik.visina }" required>
						</div>
					</div>

					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Izmeni">
					</div>
				</form>
			</div>


		</c:when>


		<c:when test="${mode=='MODE'}">
<h2>Uspesno ste izmenili svoje podatke.  <a href="/vratiSeNaPocetnu?id=${id}">Vrati se na pocetnu</a>   </h2>
		</c:when>



	</c:choose>






	<script type="text/javascript">

	</script>


</body>
</html>