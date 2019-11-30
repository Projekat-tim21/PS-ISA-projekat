<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta charset="ISO-8859-1">
<title>Izmena Podataka</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<body>

	<div role="navigation">
		<div class="navbar navbar-inverse">
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<!--  <li><a href="/profilkaPregledu?username=${username}">Profil</a></li>
					<li><a href="/izmenaPodatakaizBara?username=${username}">Izmena podataka</a></li> -->
					<li><a href="/vratiSeNaPocetnu?id=${id}">Vrati se na
							pocetnu</a></li>
					<!-- 		<li><a href="/pokazikorisnikaSaLogina">Svi korisnici</a></li> 	 -->
					<li><a href="/logout">Odjavi se</a></li>
				</ul>

			</div>
		</div>
	</div>
	<h2>Uspesno ste izmenili svoje podatke.</h2>
	
</body>
</html>