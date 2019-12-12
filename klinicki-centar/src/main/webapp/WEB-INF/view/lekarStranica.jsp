<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta charset="ISO-8859-1">
<title>Lekar</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<style>
body {
	background-image: url("static/images/health1.png");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: bottom right;
}

#myTable th, #myTable td {
  text-align: center; /* center-align text */
  padding: 12px; /* Add padding */
}
</style>
</head>
<body>

	<div role="navigation">
		<div class="navbar navbar-inverse">
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/pregledSvihPacijenataMetoda">Pregled pacijenata</a></li>
					<li><a href="/kartonZ">Prikazi profil pacijenta</a></li>
					<li><a href="/zakazivanjePregleda">Zakazi pregled</a></li>

					<li><a href="/radniKalendar">Radni kalendar</a></li>

					<li><a href="/pretragaSale">Pregled sala</a></li>
					<li><a href="/logout">Odjavi se</a></li>
				</ul>
			</div>
		</div>
	
		
	</div>
	
	<h2>Dobrodosli ${ime}   ! Uspesno ste se ulogovali.</h2>
	

</body>
</html>