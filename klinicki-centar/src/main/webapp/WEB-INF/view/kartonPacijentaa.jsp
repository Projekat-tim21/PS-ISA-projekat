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
					action="sacuvajupdateNaLogin">

					<div class="form-group">
						<label class="control-label col-md-3">Id</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="id" name="id"
								value="${korisnik.id }" readonly> <span id="free"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Korisnicko ime</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="username"
								name="username" value="${korisnik.username }" required>
							<span id="free"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Ime</label>
						<div class="col-md-6">
							<input type="text" class="form-control" name="ime"
								value="${korisnik.ime }" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Prezime</label>
						<div class="col-md-6">
							<input type="text" class="form-control" name="prezime"
								value="${korisnik.prezime }" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Jedinstveni broj
							osiguranika-unesite samo brojeve </label>
						<div class="col-md-6">
							<input type="number" class="form-control" name="jedBrOsig"
								value="${korisnik.jedBrOsig }" readonly>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Email</label>
						<div class="col-md-6">
							<input type="email" class="form-control" name="email"
								value="${korisnik.email }" readonly>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Adresa prebivalista</label>
						<div class="col-md-6">
							<input type="text" class="form-control" name="adresa"
								value="${korisnik.adresa }" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Grad</label>
						<div class="col-md-6">
							<input type="text" class="form-control" name="grad"
								value="${korisnik.grad }" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Drzava</label>
						<div class="col-md-6">
							<input type="text" class="form-control" name="drzava"
								value="${korisnik.drzava }" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Telefon-unesite samo
							brojeve</label>
						<div class="col-md-6">
							<input type="number" class="form-control" name="telefon"
								value="${korisnik.telefon }" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Sifra</label>
						<div class="col-md-6">
							<input type="password" class="form-control" id="pass1"
								name="password" value="${korisnik.password}" required>
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