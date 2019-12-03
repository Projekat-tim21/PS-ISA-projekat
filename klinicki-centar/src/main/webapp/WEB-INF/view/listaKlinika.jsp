<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta charset="ISO-8859-1">
<title>Lista klinika</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<body>
  
  	<div role="navigation">
		<div class="navbar navbar-inverse">
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/korakUnazadNaLogin">Vrati se nazad</a></li>	
					<li><a href="/logout">Odjavi se</a></li> 
				</ul>

			</div>
		</div>
	</div>
  
  
	<c:choose>
		<c:when test="${mode=='ALL_KLINIKE' }">     
			<div class="container text-center" id="tasksDiv">
				<h3>Lista klinika</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Naziv</th>
								<th>Adresa</th>
								<th>Grad</th>
								<th>Drzava</th>
								<th>Cena</th>
								<th>Ocena</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="klinika" items="${klinike}">
								<tr>
									<td>${klinika.id}</td>
									<td>${klinika.naziv}</td>
									<td>${klinika.adresa}</td>
									<td>${klinika.grad}</td>
									<td>${klinika.drzava}</td>
									<td>${klinika.cena}</td>
									<td>${klinika.ocena}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>

			<!-- <div class="btn-group" >
 			   <button type="button" class="btn btn-primary center-block">Prikazi</button>
 			 </div>
	 -->



		</c:when>
	</c:choose>
 
</body>
</html>