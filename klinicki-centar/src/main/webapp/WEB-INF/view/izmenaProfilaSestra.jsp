<html>
<head>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta charset="ISO-8859-1">
<title>Pregled informacija</title>
  <base href="/">
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
 <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
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
	<c:when test="${mode=='MODE_PREGLED' }">
			<div class="container text-center">
				<h3>Pregled podataka</h3>
				<hr>
				<form class="form-horizontal" method="POST"
					action="sacuvajIzmeneProfila/${id}">

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
	</c:choose>




<script type="text/javascript">
		var getUrlParameter = function getUrlParameter(sParam) {
			var sPageURL = window.location.search.substring(1), sURLVariables = sPageURL
					.split('&'), sParameterName, i;

			for (i = 0; i < sURLVariables.length; i++) {
				sParameterName = sURLVariables[i].split('=');

				if (sParameterName[0] === sParam) {
					return sParameterName[1] === undefined ? true
							: decodeURIComponent(sParameterName[1]);
				}
			}
		};

		var idPacijenta = getUrlParameter('id');

		function addIdPac(element) {
			console.log("proba");
			element.href = element.href + "?id=" + idPacijenta;
			console.log(element.href);
		}

		function addIdPac2(element) {
			element.href = element.href + "?idpac=" + idPacijenta;
			console.log(element.href);
		}

		function checkredirect() {
			window.location = 'http://localhost:8081/sacuvajIzmeneProfila/'
					+ napokooon;
			console.log(window.location);
			return false;
		}
	</script>


</body>
</html>