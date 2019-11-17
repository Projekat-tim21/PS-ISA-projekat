<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="ISO-8859-1">
<title>Registrovanje</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">

<style>
.alert {
	padding: 25px;
	background-color: #f44336;
	color: white;
}

.closebtn {
	margin-left: 20px;
	color: white;
	font-weight: bold;
	float: right;
	font-size: 35px;
	line-height: 22px;
	cursor: pointer;
	transition: 0.3s;
}

.closebtn:hover {
	color: black;
}
</style>


</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<!--  			<a href="/welcome" class="navbar-brand">Klinika AB</a>   -->
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/login">Logovanje</a></li>
					<li><a href="/registracija">Registruj se</a></li>
					<li><a href="/pokazi-korisnika">Svi korisnici</a></li>
				</ul>
			</div>
		</div>
	</div>

	
	<div class="alert">
		<strong>Upozorenje!</strong>
		<div>Korisnik sa ovim username-om vec postoji.</div>
		<div>
		<span> Vratite se na registraciju: <a href="/registracija">Registruj se</a>
		</span>
		</div>
	</div>




</body>

</html>