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
<body>

	<div role="navigation">
		<div class="navbar navbar-inverse">
			<div class="navbar-collapse collapse">
			<h2>Pocetna stranica</h2>
				<ul class="nav navbar-nav">
					<li><a href="/profilkaPregledu?id=${id}">Profil</a></li>
					<li><a href="/izmenaPodataka?id=${id}">Izmena podataka</a></li>
			<!-- 	<li><a href="/pokazikorisnikaSaLogina">Svi korisnici</a></li> 	 -->	
					<li><a href="/logout">Odjavi se</a></li>
				</ul>
			
			</div>
		</div>
	</div>

</body>
</html>