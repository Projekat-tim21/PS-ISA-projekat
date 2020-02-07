<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta charset="ISO-8859-1">
<title>Admin</title>

<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<style>

body {
  background-image: url("static/images/s.png");
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-position: bottom right; 
}

#myInput {
  background-position: 10px 10px;
  background-repeat: no-repeat;
  width: 100%;
  font-size: 16px;
  padding: 12px 20px 12px 40px;
  border: 1px solid #ddd;
  margin-bottom: 12px;
}


</style>
</head>
<body>



<c:choose>
<c:when test="${mode=='ALL_ZAHTEVI_ODOBRENI' }">



<div role="navigation">
		<div class="navbar navbar-inverse">
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a onclick="addIdPac(this)" href="/korakUnazadNaLogin">Vrati se nazad</a></li>	
					<li><a href="/logout">Odjavi se</a></li> 
				</ul>

			</div>
		</div>
	</div>



			<div class="container text-center" id="tasksDiv">
				<h3>Vasi odobreni zahtevi</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Termin</th>
								<th>Ime lekara</th>
								<th>Prezime lekara</th>
								<th>Tip pregleda</th>
								<th>Sala</th>
								<th>Cena</th>
								<th>Popust</th>
								<th colspan="2">Prihvati/Odbij</th>
						<!--		<th>Sifra</th>  -->
							</tr>
						</thead>
						<tbody>
							<c:forEach var="termin" items="${termini }">
								<tr>
									<td>${termin.id}</td>
									<td>${termin.termin}</td>
									<td>${termin.lekarime}</td>
									<td>${termin.lekarprezime}</td>
									<td>${termin.tippregleda}</td>
									<td>${termin.sala}</td>
									<td>${termin.cena}</td>
									<td>${termin.popust}</td>
									
									<td>
                                        <a href="/enable3/${termin.getId()}" onclick="alertEnable()" class="saveData"><span class="btn-label"><img src="static/svg/check.svg"></span></a>
                                        </td>
                                        <td><a href="/disable3/${termin.getId()}" onclick="alertDisable()" class="deleteData"><span class="btn-label"><img src="static/svg/x.svg"></span></a>
                                        </td>
					
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>


<c:when test="${mode=='ALL_ZAHTEVI_ODOBRENI_SA_MAILA_KAD_ULAZIM' }">

<div role="navigation">
		<div class="navbar navbar-inverse">
			<div class="navbar-collapse collapse">
			

			</div>
		</div>
	</div>

			<div class="container text-center" id="tasksDiv">
				<h3>Vasi odobreni zahtevi</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Termin</th>
								<th>Ime lekara</th>
								<th>Prezime lekara</th>
								<th>Tip pregleda</th>
								<th>Sala</th>
								<th>Cena</th>
								<th>Popust</th>
								<th colspan="2">Prihvati/Odbij</th>
						<!--		<th>Sifra</th>  -->
							</tr>
						</thead>
						<tbody>
							<c:forEach var="termin" items="${termini }">
								<tr>
									<td>${termin.id}</td>
									<td>${termin.termin}</td>
									<td>${termin.lekarime}</td>
									<td>${termin.lekarprezime}</td>
									<td>${termin.tippregleda}</td>
									<td>${termin.sala}</td>
									<td>${termin.cena}</td>
									<td>${termin.popust}</td>
									
									<td>
                                        <a href="/enable3/${termin.getId()}" onclick="alertEnable()" class="saveData"><span class="btn-label"><img src="static/svg/check.svg"></span></a>
                                        </td>
                                        <td><a href="/disable3/${termin.getId()}" onclick="alertDisable()" class="deleteData"><span class="btn-label"><img src="static/svg/x.svg"></span></a>
                                        </td>
					
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>

</c:choose>


<script type="text/javascript">
function alertEnable(){
	alert("Uspesno ste prihvatili pregled. Vas pregled se nalazi u listi zakazanih pregleda");
}

function alertDisable(){
	alert("Pregled je uspesno odbijen");
}

		var getUrlParameter = function getUrlParameter(sParam) {
			var sPageURL = window.location.search.substring(1), sURLVariables = sPageURL
					.split('&'), sParameterName, i;

			for (i = 0; i < sURLVariables.length; i++) {
				sParameterName = sURLVariables[i].split('=');

				if (sParameterName[0] === sParam) {
					return sParameterName[1] === undefined ? true
							: decodeURIComponent(sParameterName[1]);
				}
			}
		};

		var termin ='${termin.id}';
		console.log(termin);
		
		var idPacijenta = getUrlParameter('id');
		console.log(idPacijenta);

		function addIdPac(element) {
			element.href = element.href + "?id=" + idPacijenta;
			console.log(element.href);
		}

		function addIdPac2(element) {
			element.href = element.href + "?idpac=" + idPacijenta;
			console.log(element.href);
		}
	</script>


</body>
</html>