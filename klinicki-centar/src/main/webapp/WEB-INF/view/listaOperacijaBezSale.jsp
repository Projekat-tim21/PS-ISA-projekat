<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta charset="ISO-8859-1">
<title>Sale</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<link href="static/css/theme.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<body>
 
<div role="navigation">
		<div class="navbar navbar-inverse">
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
				<li><a href="/AdminPraviPreglede">Prikaz lekara</a></li>
				<li><a href="/zahteviZaPregledom">Odobravanje zahteva</a></li>
				<li><a href="/prikaziOperacijeBezSale">Sale za operaciju</a></li>
				<li><a href="/logout">Odjavi se</a></li>
				</ul>

			</div>
		</div>
	</div>
	
	
	<section class="h-100">
    <div class="container h-100">
        <div class="row justify-content-md-center">
			<c:choose>
				<c:when test="${mode=='ALL_OPERACIJE' }">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>Id</th>
								<th>Ime lekara</th>
								<th>Prezime lekara</th>
								<th>Datum operacije</th>
								<th>Dodaj salu</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="operacija" items="${operacije}">
								<tr>
									<td><label>${operacija.id}</label></td>
									<td><label>${operacija.lekarimeoperacija}</label></td>
									<td><label>${operacija.lekarprezimeoperacija}</label></td>
									<td><label>${operacija.terminoperacija} </label></td>
                                    <td><a href="/dodajSalu/${operacija.id}">Rezervisi salu</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:when>
		</c:choose>
		</div>
		</div>
		</section>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>
<script src="static/js/app.js"></script>
<script src="static/js/editDijagnoza.js"></script>
</body>
</html>