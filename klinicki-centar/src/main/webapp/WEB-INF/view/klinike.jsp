<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta charset="ISO-8859-1">
<title>Klinike</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<link href="static/css/theme.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 <link rel="shortcut icon" href="#" />
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
        <div class="row justify-content-md-center">
            <div class="card">
                <div class="card-header">
	<div class="table-data__tool">
                                    <div class="table-data__tool-left">
                                        <h3>KLINIKE</h3>
                                          </div>
				
                                    <div class="table-data_tool-right">
                                        <button class="au-btn au-btn-icon au-btn--green au-btn--small">
                                            <i class="zmdi zmdi-plus"><a class="nav-link" href="/addNewKlinika">DODAJ NOVU KLINIKU</a></i></button>
                                    </div>
                                </div>
	
	<c:choose>
	<c:when test="${mode=='ALL_KLINIKE' }">
			<div class="container text-center" id="tasksDiv">
				<hr>
				<div class="table-responsive">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>Id</th>
								<th>Naziv</th>
								<th>Grad</th>
								<th>Drzava</th>
								<th>Ocena</th>
								<th>Adresa</th>
						<!--		<th>Sifra</th>  -->
							</tr>
						</thead>
						<tbody>
							<c:forEach var="klinika" items="${klinike }">
								<tr>
									<td>${klinika.id}</td>
									<td>${klinika.naziv}</td>
									<td>${klinika.grad}</td>
									<td>${klinika.drzava}</td>
									<td>${klinika.ocena}</td>
									<td>${klinika.adresa}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
</c:choose>
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