<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta charset="ISO-8859-1">
<title>Dobrodosli</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">

<style>
body {
	background-image: url("static/images/slika.jpg");
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
				<ul class="nav navbar-nav">
					<li><a onclick="addIdPac(this)" href="/profilkaPregledu">Profil</a></li>
					<li><a onclick="addIdPac(this)" href="/izmenaPodataka">Izmena
							podataka</a></li>
					<li><a onclick="addIdPac(this)" href="/listaSvihKlinika">Lista klinika</a></li>
					<li><a onclick="addIdPac(this)" href="/preglediIoperacijePrikaz">Lista pregleda i
							operacija</a></li>
					<li><a onclick="addIdPac(this)" href="/kartonZ">Zdravstveni
							karton</a>
					<li><a onclick="addIdPac2(this)" href="/prikaziListuLekara">Lista lekara</a>
					<li><a onclick="addIdPac(this)" href="/zakaziPregledKojiJeDef">Zakazi pregled</a> 
					<li><a onclick="addIdPac(this)" href="/listaZakazanihPregleda">Zakazani pregledi</a>
					<li><a href="/logout">Odjavi se</a></li>
				</ul>

			</div>
		</div>
	</div>


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
		console.log(idPacijenta);

		function addIdPac(element) {
			element.href = element.href + "?id=" + idPacijenta;
			console.log(element.href);
		}

		function addIdPac2(element) {
			element.href = element.href + "?idpac=" + idPacijenta;
			console.log(element.href);
		}
	</script>


</body>
</html>