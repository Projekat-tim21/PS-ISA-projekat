<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta charset="ISO-8859-1">
<title>Sestra</title>
<base href="/"> 
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<link href="static/css/theme.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body class="my-login-page">
<div role="navigation">
		<div class="navbar navbar-inverse">
			<div class="navbar-collapse collapse">
			<h2>MEDICINSKA SESTRA</h2>
				<ul class="nav navbar-nav">
				<li><a href="/sviSestraPacijenti">Svi pacijenti</a></li>
					<li><a href="/logout">Odjavi se</a></li>
				</ul>
			
			</div>
		</div>
	</div>
	
	<c:choose>
		<c:when test="${mode=='MODE_ZKARTON' }">
			<div class="container text-center">
				<h3>Zdravstveni karton</h3>
				<hr>
				<form class="form-horizontal" name="forma" method="POST" modelAttribute="korisnik">
					<div>
						<h4>Licni podaci</h4>
						<hr>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Ime</label>
						<div class="col-md-6">
							<label>${korisnik.ime}</label>
							
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Prezime</label>
						<div class="col-md-6">
						<label>${korisnik.prezime}</label>
							
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Datum rodjenja</label>
						<div class="col-md-6">
						<label>${korisnik.datum}</label>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Jedinstveni broj
							osiguranika</label>
						<div class="col-md-6">
							<label>${korisnik.jedBrOsig}</label>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Pol</label>
						<div class="col-md-6">
							<label>${korisnik.pol}</label>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Visina</label>
						<div class="col-md-6">
					<label>${korisnik.visina}</label>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Tezina</label>
						<div class="col-md-6">
							<label>${korisnik.tezina}</label>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Krvna grupa</label>
						<div class="col-md-6">
							<label>${korisnik.kgrupa}</label>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Dioptrija</label>
						<div class="col-md-6">
							<label>${korisnik.dioptrija}</label>
						</div>
					</div>
					<p></p>
					<hr>
					<div>
					<h4>Podaci o istoriji bolesti</h4>
					</div>
					<hr>
					<div class="form-group">
						<label class="control-label col-md-3">Alergije na lek</label>
						<div class="col-md-6">
							<textarea rows="4" cols="80" class="form-control" id="alergije" name="alergije" ></textarea>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Istorija bolesti</label>
						<div class="col-md-6">
							<textarea rows="4" cols="80" class="form-control" id="bolesti" name="bolesti"></textarea>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Porodicna anamneza</label>
						<div class="col-md-6">
							<textarea rows="4" cols="80" class="form-control" id="anamneza" name="anamneza" ></textarea>
						</div>
					</div>
				
					<div class="form-group ">
						<button type="submit" formaction="/idiNaLoginBezDobrodosli">Pocetna</button>
					</div>
				</form>
			</div>
		</c:when>







	</c:choose>

	

<script type="text/javascript">
var alergijee ='${korisnik.alergije}';
var bolestii= '${korisnik.bolesti}';
var anamnezaa='${korisnik.anamneza}';
document.getElementById('alergije').value = alergijee;
document.getElementById('bolesti').value = bolestii;
document.getElementById('anamneza').value = anamnezaa;
</script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>
<script src="static/js/app.js"></script>
<script src="static/js/edit.js"></script>
</body>
</html>