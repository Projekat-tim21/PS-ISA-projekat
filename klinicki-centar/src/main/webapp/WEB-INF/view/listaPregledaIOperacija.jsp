<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta charset="ISO-8859-1">
<title>Pregledi i Operacije</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<body>

	<div role="navigation">
		<div class="navbar navbar-inverse">
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/naLogin">Vrati se nazad</a></li>
					<li><a href="/prikaziListuOperacija">Lista operacija</a></li>
					<li><a href="/prikaziListuPregleda">Lista pregleda</a></li>
					<li><a href="/logout">Odjavi se</a></li>
				</ul>

			</div>
		</div>
	</div>
	
	<c:choose>
		<c:when test="${mode=='ALL_PREGLEDI' }">
			<div class="container text-center" id="tasksDiv">
				<h3>Lista pregleda</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Datum</th>
								<th>Vreme</th>
								<th>Tip</th>
								<th>Trajanje</th>
								<th>Sala</th>
								<th>Lekar</th>
								<th>Cena</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="pregled" items="${pregledi}">
								<tr>
									<td>${pregled.id}</td>
									<td>${pregled.datum}</td>
									<td>${pregled.vreme}</td>
									<td>${pregled.tip}</td>
									<td>${pregled.trajanje}</td>
									<td>${pregled.sala}</td>
									<td>${pregled.lekar}</td>
									<td>${pregled.cena}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		
		<c:when test="${mode=='ALL_OPERACIJE' }">
			<div class="container text-center" id="tasksDiv">
				<h3>Lista operacija</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Datum</th>
								<th>Vreme</th>
								<th>Tip</th>
								<th>Trajanje</th>
								<th>Sala</th>
								<th>Lekar</th>
								<th>Cena</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="operacija" items="${operacije}">
								<tr>
									<td>${operacija.id}</td>
									<td>${operacija.datum}</td>
									<td>${operacija.vreme}</td>
									<td>${operacija.tip}</td>
									<td>${operacija.trajanje}</td>
									<td>${operacija.sala}</td>
									<td>${operacija.lekar}</td>
									<td>${operacija.cena}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		
		
	</c:choose>

</body>
</html>