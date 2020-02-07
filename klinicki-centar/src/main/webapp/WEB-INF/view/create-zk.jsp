<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="shortcut icon" href="#" />
<title>Novi zdraavstveni karton</title>
 <link href="/static/css/theme.css" rel="stylesheet" media="all">
 <link href="/static/css/bootstrap.min.css" rel="stylesheet">
<link href="/static/css/style.css" rel="stylesheet">
</head>
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
	
		<c:when test="${mode=='MODE_PREGLED' }">
			<div class="container text-center">
				<h3>Kreiranje zdravstvenog kartona</h3>
				<hr>
				<form class="form-horizontal" method="POST"
					action="/nov">

					<div class="form-group">
						<label class="control-label col-md-3">Korisnicko id</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="id"
								name="id" value="${korisnik.id }" readonly>
							<span id="free"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Korisnicko ime</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="username"
								name="username" value="${korisnik.username }" readonly>
							<span id="free"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Ime</label>
						<div class="col-md-6">
							<input type="text" class="form-control" name="ime"
								value="${korisnik.ime }" readonly>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Prezime</label>
						<div class="col-md-6">
							<input type="text" class="form-control" name="prezime"
								value="${korisnik.prezime }" readonly>
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
						<label class="control-label col-md-3">Datum rodjenja</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="datum"
								name="datum" value="${korisnik.datum }" required>
							<span id="free"></span>
						</div>
					</div>
			
					<div class="form-group">
						<label class="control-label col-md-3">Pol</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="pol"
								name="pol" value="${korisnik.pol }" required>
							<span id="free"></span>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-3">Tezina</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="tezina"
								name="tezina" value="${korisnik.tezina }" required>
							<span id="free"></span>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-3">Visina</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="visina"
								name="visina" value="${korisnik.visina }" required>
							<span id="free"></span>
						</div>
					</div>
			
					<div class="form-group">
						<label class="control-label col-md-3">Dioptrija</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="dioptrija"
								name="dioptrija" value="${korisnik.dioptrija }" required>
							<span id="free"></span>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-3">Krvna grupa</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="kgrupa"
								name="kgrupa" value="${korisnik.kgrupa }" required>
							<span id="free"></span>
						</div>
					</div>
					
			
					<div class="form-group">
						<label class="control-label col-md-3">Alergije</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="alergije"
								name="alergije" value="${korisnik.alergije }" required>
							<span id="free"></span>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-3">Anamneza</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="anamneza"
								name="anamneza" value="${korisnik.anamneza }" required>
							<span id="free"></span>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-3">Bolesti</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="bolesti"
								name="bolesti" value="${korisnik.bolesti }" required>
							<span id="free"></span>
						</div>
					</div>
					
						
					
					
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Sacuvaj">
					</div>
				</form>
			</div>


		</c:when>



	</c:choose>
</body>
</html>