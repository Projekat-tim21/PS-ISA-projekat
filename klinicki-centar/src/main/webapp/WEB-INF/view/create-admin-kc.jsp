<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Novi admin klinickog centra</title>
 <link href="static/css/theme.css" rel="stylesheet" media="all">
 <link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 
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
					<c:if test="${id eq 8}">
   						<li><a href="/pregledSvihAdmina">Administratori KC</a></li>
					</c:if>
					<li><a href="/pregledSvihAdminaKlinike">Administratori klinika</a></li>
					<li><a href="/lekovi">Lekovi</a></li>
					<li><a href="/dijagnoze">Dijagnoze</a></li>
					<li><a href="/logout">Odjavi se</a></li>
				</ul>
			
			</div>
		</div>
	</div>

<section class="h-100">
    <div class="container h-100">
        <div class="row justify-content-md-center h-100">
            <div class="card-wrapper">
                <div class="card fat">
                    <div class="card-body">
                        <h4 class="card-title">ADMINISTRATOR KLINICKOG CENTRA</h4>
                        <form action="/noviAdminKC" method="POST">

							<div class="form-group">
                                <label for="username">Korisnicko ime</label>
                                <input id="username" type="text" class="form-control" name="username" required
                                       autofocus>
                            </div>
							
                            <div class="form-group">
                                <label for="ime">Ime</label>
                                <input id="ime" type="text" class="form-control" name="ime" required
                                       autofocus>
                            </div>

                            <div class="form-group">
                                <label for="prezime">Prezime</label>
                                <input id="prezime" type="text" class="form-control" name="prezime" required>
                            </div>

                            <div class="form-group">
                                <label for="email">E-Mail</label>
                                <input id="email" type="email" class="form-control" name="email" required>
                            </div>

                            <div class="form-group">
                                <label for="password">Password</label>
                                <input id="password" type="password" class="form-control" name="password" required
                                       data-eye>
                            </div>
                            
                            <div class="form-group">
                                <label for="drzava">Drzava</label>
                                <input id="drzava" type="text" class="form-control" name="drzava" required>
                            </div>
                            <div class="form-group">
                                <label for="grad">Grad</label>
                                <input id="grad" type="text" class="form-control" name="grad" required>
                            </div>
                            
                            <div class="form-group">
                                <label for="adresa">Adresa</label>
                                <input id="adresa" type="text" class="form-control" name="adresa" required>
                            </div>
                            
                            <div class="form-group">
                                <label for="telefon">Telefon</label>
                                <input id="telefon" type="text" class="form-control" name="telefon" required>
                            </div>
                            
                            <div class="form-group">
                                <label for="jedBrOsig">Broj osiguranja</label>
                                <input id="jedBrOsig" type="text" class="form-control" name="jedBrOsig" required>
                            </div>

                            <div class="form-group no-margin">
                                <button type="submit" class="btn btn-primary btn-block">
                                    NOVI ADMINISTRATOR KLINICKOG CENTRA
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>
<script src="static/js/app.js"></script>
</body>
</html>