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
					<li><a href="/profilkaPregledu?id=${id}">Profil</a></li>
					<li><a href="/izmenaPodataka?id=${id}">Izmena podataka</a></li>
					 	<li><a href="/listaSvihKlinika">Lista klinika</a></li> 	
				 	<li><a href="/preglediIoperacijePrikaz">Lista pregleda i operacija</a></li>
				 		<li><a href="/kartonZ?id=${id}">Zdravstveni karton</a>
				 		<li><a href="/prikaziListuLekara?idpac=${id}">Lista lekara</a>
				 		<li><a href="/zakaziPregledKojiJeDef">Zakazi pregled</a>
			<!-- 	<li><a href="/pokazikorisnikaSaLogina">Svi korisnici</a></li> 	 -->	
					<li><a href="/logout">Odjavi se</a></li>
				</ul>
			
			</div>
		</div>
	</div>

<!--  ZAKAZANI_PREGLEDI  -->








</body>
</html>