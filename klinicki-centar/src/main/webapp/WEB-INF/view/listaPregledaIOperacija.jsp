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
<title>Pregledi i Operacije</title>
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


.tooltip {
  position: relative;
  display: inline-block;
  border-bottom: 1px dotted black;
}

.tooltip .tooltiptext {
  visibility: hidden;
  width: 120px;
  background-color: #555;
  color: #fff;
  text-align: center;
  border-radius: 6px;
  padding: 5px 0;
  position: absolute;
  z-index: 1;
  bottom: 125%;
  left: 50%;
  margin-left: -60px;
  opacity: 0;
  transition: opacity 0.3s;
}

.tooltip .tooltiptext::after {
  content: "";
  position: absolute;
  top: 100%;
  left: 50%;
  margin-left: -5px;
  border-width: 5px;
  border-style: solid;
  border-color: #555 transparent transparent transparent;
}

.tooltip:hover .tooltiptext {
  visibility: visible;
  opacity: 1;
}

</style>
</head>
<body>



	<c:choose>

		<c:when test="${mode=='ALL_PREGLEDI' }">
		
		
		
		<div role="navigation">
		<div class="navbar navbar-inverse">
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">


					<li><a onclick="addIdPac(this)" href="/naLogin">Vrati se
							nazad</a></li>
					<li><a onclick="addIdPac(this)" href="/prikaziListuOperacija">Istorija
							operacija</a></li>
					<li><a onclick="addIdPac(this)" href="/prikaziListuPregleda">Istorija
							pregleda</a></li>
					<li><a onclick="addIdPac(this)" href="/logout">Odjavi se</a></li>

				</ul>

			</div>
		</div>
	</div>
		
		
		
			<div class="container text-center" id="tasksDiv">
				<h3>Istorija pregleda</h3>
				<hr>
				<div class="table-responsive">
					<input type="text" id="myInput" onkeyup="myFunction()"
						placeholder="Pretrazi tabelu po tipu pregleda..">
					<table id="indextable" class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th><a href="javascript:SortTable(1,'D','mdy');">Termin</a></th>
								<th>Tip</th>
								<th>Trajanje</th>
								<th>Sala</th>
								<th>Id lekara</th>
								<th>Ime lekara</th>
								<th>Prezime lekara</th>
								<th>Id pacijenta</th>
								<th><a href="javascript:SortTable(7,'N');">Cena</a></th>
								<th>Oceni lekara</th>
								<th>Oceni kliniku</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="pregled" items="${pregledi}">
								<tr>
									<td>${pregled.id}</td>
									<td>${pregled.terminpregled}</td>
									<td>${pregled.tip}</td>
									<td>${pregled.trajanje}</td>
									<td>${pregled.sala}</td>
									<td>${pregled.idlekarpregled}</td>
									<td>${pregled.lekarimepregled}</td>
									<td>${pregled.lekarprezimepregled}</td>
									<td>${pregled.idpacijenta}</td>
									<td>${pregled.cena }</td>
									<td><a
										href="/oceniLekaraPregled?idlekar=${pregled.idlekarpregled}&idpacijenta=${pregled.idpacijenta}&idpregleda=${pregled.id}">Oceni
											lekara</a></td>
									<td><a
										href="/oceniKlinikuPregled?idlekar=${pregled.idlekarpregled}&idpacijenta=${pregled.idpacijenta}&idpregleda=${pregled.id}">Oceni
											kliniku</a></td>

								</tr>

							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>


		
		<c:when test="${mode=='OCENA_LEKARA_SEKCIJA_PREGLED' }">
		
		
		<div role="navigation">
		<div class="navbar navbar-inverse">
			<div class="navbar-collapse collapse">
		
			</div>
		</div>
	</div>
		
		
			<section class="h-100">
				<div class="container h-100">
					<div class="row justify-content-md-center">
						<div class="card">
							<div class="card-header">

								<div class="container text-center">
									<h3>Ocenite lekara za izabrani pregled</h3>
									<hr>

									<form class="form-horizontal" name="forma" method="POST"
										action="/ocenaLekaraPregled/${pregled.id}/${lip.id}/${korisnik.id}">
										<div class="form-group">
						<!--  					<label class="control-label col-md-3">Id lekara</label>   -->
											<div class="col-md-6">
												<input type="hidden" class="form-control" id="id"
													name="id" value="${lip.id }" readonly> <span
													id="free"></span>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-3">Ime lekara</label>
											<div class="col-md-6">
												<input type="text" class="form-control" id="imelek"
													name="imelek" value="${lip.imelek }" readonly> <span
													id="free"></span>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-3">Prezime
												lekara</label>
											<div class="col-md-6">
												<input type="text" class="form-control" id="prezimelek"
													name="prezimelek" value="${lip.prezimelek }" readonly>
												<span id="free"></span>
											</div>
										</div>
										
										<div class="form-group">
											<label class="control-label col-md-3">Ocena</label>
											<div class="col-md-6">
												<input type="number" class="form-control" id="ocenapregleda" name="ocenapregleda"
													value="${pregled.ocenapregleda}" required>
											</div>
										</div>
									<div class="form-group">
											<div class="col-md-6">
												<input type="hidden" class="form-control" id="idk"
													name="idk" value="${korisnik.id }" readonly> <span
													id="free"></span>
											</div>
										</div>
										<div class="form-group">
											<div class="col-md-6">
												<input type="hidden" class="form-control" id="idp"
													name="idp" value="${pregled.id }" readonly> <span
													id="free"></span>
											</div>
										</div>

										<div class="form-group ">
											<input type="submit" class="btn btn-primary" onclick="alertzaocenu()" value="Oceni">
										</div>
										<div class="form-group ">
											<a onclick="addIdPac(this)" href='/odustaniOdOcenjivanjaLekaraPregled3'><input type="submit"  class="btn btn-primary" value="Odustani"></a>
										</div>
									</form>

								</div>

							</div>
						</div>
					</div>
				</div>
			</section>

		</c:when>



		<c:when test="${mode=='ALL_OPERACIJE' }">
		
		
		<div role="navigation">
		<div class="navbar navbar-inverse">
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">


					<li><a onclick="addIdPac(this)" href="/naLogin">Vrati se
							nazad</a></li>
					<li><a onclick="addIdPac(this)" href="/prikaziListuOperacija">Istorija
							operacija</a></li>
					<li><a onclick="addIdPac(this)" href="/prikaziListuPregleda">Istorija
							pregleda</a></li>
					<li><a onclick="addIdPac(this)" href="/logout">Odjavi se</a></li>

				</ul>

			</div>
		</div>
	</div>
		
		
			<div class="container text-center" id="tasksDiv">
				<h3>Istorija operacija</h3>
				<hr>
				<input type="text" id="myInput" onkeyup="myFunction()"
					placeholder="Pretrazi tabelu po tipu operacije..">
				<div class="table-responsive">
					<table id="indextable" class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th><a href="javascript:SortTable(1,'D','mdy');">Termin</a></th>
								<th>Tip</th>
								<th>Trajanje</th>
								<th>Sala</th>
								<th>Id lekara</th>
								<th>Ime lekara</th>
								<th>Prezime lekara</th>
								<th>Id pacijenta</th>
								<th><a href="javascript:SortTable(7,'N');">Cena</a></th>
								<th>Oceni lekara</th>
								<th>Oceni kliniku</th>
							
							</tr>
						</thead>
						<tbody>
							<c:forEach var="operacija" items="${operacije}">
									<tr>
									<td>${operacija.id}</td>
									<td>${operacija.terminoperacija}</td>
									<td>${operacija.tip}</td>
									<td>${operacija.trajanje}</td>
									<td>${operacija.sala}</td>
									<td>${operacija.idlekaroperacija}</td>
									<td>${operacija.lekarimeoperacija}</td>
									<td>${operacija.lekarprezimeoperacija}</td>
									<td>${operacija.idpacijenta}</td>
									<td>${operacija.cena }</td>
									<td><a
										href="/oceniLekaraOperacija?idlekar=${operacija.idlekaroperacija}&idpacijenta=${operacija.idpacijenta}&idoperacije=${operacija.id}">Oceni
											lekara</a></td>
									<td><a
										href="/oceniKlinikuOperacija?idlekar=${operacija.idlekaroperacija}&idpacijenta=${operacija.idpacijenta}&idoperacije=${operacija.id}">Oceni
											kliniku</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		
		
		
		
		
		<c:when test="${mode=='OCENA_LEKARA_SEKCIJA_OPERACIJA' }">
		
		<div role="navigation">
		<div class="navbar navbar-inverse">
			<div class="navbar-collapse collapse">
				

			</div>
		</div>
	</div>
		
		
			<section class="h-100">
				<div class="container h-100">
					<div class="row justify-content-md-center">
						<div class="card">
							<div class="card-header">

								<div class="container text-center">
									<h3>Ocenite lekara za izabranu operaciju</h3>
									<hr>

									<form class="form-horizontal" name="forma" method="POST"
										action="/ocenaLekaraOperacije/${operacija.id}/${lip.id}/${korisnik.id}">
										<div class="form-group">
								<!-- 			<label class="control-label col-md-3">Id lekara</label>   -->
											<div class="col-md-6">
												<input type="hidden" class="form-control" id="id"
													name="id" value="${lip.id }" readonly> <span
													id="free"></span>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-3">Ime lekara</label>
											<div class="col-md-6">
												<input type="text" class="form-control" id="imelek"
													name="imelek" value="${lip.imelek }" readonly> <span
													id="free"></span>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-3">Prezime
												lekara</label>
											<div class="col-md-6">
												<input type="text" class="form-control" id="prezimelek"
													name="prezimelek" value="${lip.prezimelek }" readonly>
												<span id="free"></span>
											</div>
										</div>
										
										<div class="form-group">
											<label class="control-label col-md-3">Ocena</label>
											<div class="col-md-6">
												<input type="number" class="form-control" id="ocenaoperacije" name="ocenaoperacije"
													value="${operacija.ocenaoperacije}" required>
											</div>
										</div>
									<div class="form-group">
											<div class="col-md-6">
												<input type="hidden" class="form-control" id="idk"
													name="idk" value="${korisnik.id }" readonly> <span
													id="free"></span>
											</div>
										</div>
										<div class="form-group">
											<div class="col-md-6">
												<input type="hidden" class="form-control" id="idp"
													name="idp" value="${operacija.id }" readonly> <span
													id="free"></span>
											</div>
										</div>

										<div class="form-group ">
											<input type="submit" onclick="alertzaocenu()" class="btn btn-primary" value="Oceni">
										</div>
										<div class="form-group ">
											<a onclick="addIdPac(this)" href='/odustaniOdOcenjivanjaLekaraPregled'><input type="submit"  class="btn btn-primary" value="Odustani"></a>
										</div>

									</form>

								</div>

							</div>
						</div>
					</div>
				</div>
			</section>

		</c:when>
		
		
		<c:when test="${mode=='OCENA_KLINIKE_SEKCIJA_OPERACIJA' }">
		
		<div role="navigation">
		<div class="navbar navbar-inverse">
			<div class="navbar-collapse collapse">

			</div>
		</div>
	</div>
		
		
			<section class="h-100">
				<div class="container h-100">
					<div class="row justify-content-md-center">
						<div class="card">
							<div class="card-header">

								<div class="container text-center">
									<h3>Ocenite kliniku na osnovu obavljene operacije</h3>
									<hr>

									<form class="form-horizontal" name="forma" method="POST"
										action="/ocenaKlinikeOperacija/${operacija.id}/${lip.getId()}/${korisnik.id}/${idKlinikeOvajTreba}">
										
										<input type="hidden" class="form-control" id="idKlinikeOvajTreba"
													name="idKlinikeOvajTreba" value="${klinika.id }" >
													
										<div class="form-group">
											<label class="control-label col-md-3">Ime Klinike</label>
											<div class="col-md-6">
												<input type="text" class="form-control" id="imeklin"
													name="imeklin" value="${klinika.naziv }" readonly> <span
													id="free"></span>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-3">Ime lekara</label>
											<div class="col-md-6">
												<input type="text" class="form-control" id="imelek"
													name="imelek" value="${lip.imelek }" readonly> <span
													id="free"></span>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-3">Prezime
												lekara</label>
											<div class="col-md-6">
												<input type="text" class="form-control" id="prezimelek"
													name="prezimelek" value="${lip.prezimelek }" readonly>
												<span id="free"></span>
											</div>
										</div>
										
										<div class="form-group">
											<label class="control-label col-md-3">Ocena</label>
											<div  class="col-md-6 ">
												<input type="number" class="form-control tooltiptext" id="ocenaoperacije" name="ocenaoperacije"
													value="${operacija.ocenaoperacije}" required>
											</div>
										</div>
									<div class="form-group">
											<div class="col-md-6">
												<input type="hidden" class="form-control" id="idk"
													name="idk" value="${korisnik.id }" readonly> <span
													id="free"></span>
											</div>
										</div>
										<div class="form-group">
											<div class="col-md-6">
												<input type="hidden" class="form-control" id="idp"
													name="idp" value="${operacija.id }" readonly> <span
													id="free"></span>
											</div>
										</div>

										<div class="form-group ">
											<input type="submit" onclick="alertzaocenu()" class="btn btn-primary" value="Oceni">
										</div>
										<div class="form-group ">
											<a onclick="addIdPac(this)" href='/odustaniOdOcenjivanjaKlinikePregled'><input type="submit"  class="btn btn-primary" value="Odustani"></a>
										</div>
									</form>

								</div>

							</div>
						</div>
					</div>
				</div>
			</section>

		</c:when>
		
		
		
		<c:when test="${mode=='OCENA_KLINIKE_SEKCIJA_PREGLED' }">
		
		<div role="navigation">
		<div class="navbar navbar-inverse">
			<div class="navbar-collapse collapse">

			</div>
		</div>
	</div>
		
		
			<section class="h-100">
				<div class="container h-100">
					<div class="row justify-content-md-center">
						<div class="card">
							<div class="card-header">

								<div class="container text-center">
									<h3>Ocenite kliniku na osnovu obavljenog pregleda</h3>
									<hr>

									<form class="form-horizontal" name="forma" method="POST"
										action="/ocenaKlinikePregled/${pregled.id}/${lip.getId()}/${korisnik.id}/${klinika.id}">
										
										<input type="hidden" class="form-control" id="klinikaPregled"
													name="klinikaPregled" value="${klinika.id }" readonly>
										<div class="form-group">
											<label class="control-label col-md-3">Ime Klinike</label>
											<div class="col-md-6">
												<input type="text" class="form-control" id="imeklin"
													name="imeklin" value="${klinika.naziv }" readonly> <span
													id="free"></span>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-3">Ime lekara</label>
											<div class="col-md-6">
												<input type="text" class="form-control" id="imelek"
													name="imelek" value="${lip.imelek }" readonly> <span
													id="free"></span>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-3">Prezime
												lekara</label>
											<div class="col-md-6">
												<input type="text" class="form-control" id="prezimelek"
													name="prezimelek" value="${lip.prezimelek }" readonly>
												<span id="free"></span>
											</div>
										</div>
										
										<div class="form-group">
											<label class="control-label col-md-3">Ocena</label>
											<div  class="col-md-6 ">
												<input type="number" class="form-control tooltiptext" id="ocenapregleda" name="ocenapregleda"
													value="${pregled.ocenapregleda}" required>
											</div>
										</div>
									<div class="form-group">
											<div class="col-md-6">
												<input type="hidden" class="form-control" id="idk"
													name="idk" value="${korisnik.id }" readonly> <span
													id="free"></span>
											</div>
										</div>
										<div class="form-group">
											<div class="col-md-6">
												<input type="hidden" class="form-control" id="idp"
													name="idp" value="${pregled.id }" readonly> <span
													id="free"></span>
											</div>
										</div>

										<div class="form-group ">
											<input type="submit" onclick="alertzaocenu()" class="btn btn-primary" value="Oceni">
										</div>
										<div class="form-group ">
											<a onclick="addIdPac(this)" href='/odustaniOdOcenjivanjaKlinikePregled2'><input type="submit"  class="btn btn-primary" value="Odustani"></a>
										</div>
									</form>

								</div>

							</div>
						</div>
					</div>
				</div>
			</section>

		</c:when>
		
		
	</c:choose>

	<script>
function a(){}

	
function alertzaocenu(){
	alert("Uspesno ste ostavili ocenu za izabranog lekara");
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

		var idPacijenta = getUrlParameter('id');
		var idPacijenta2 = getUrlParameter('idpacijenta');
		console.log(idPacijenta);

		function addIdPac(element) {
			element.href = element.href + "?id=" + idPacijenta;
			console.log(element.href);
		}

		function addIdPac2(element) {
			element.href = element.href + "?id=" + idPacijenta2;
			console.log(element.href);
		}
		
		var TableIDvalue = "indextable";

		var TableLastSortedColumn = -1;
		function SortTable() {
			var sortColumn = parseInt(arguments[0]);
			var type = arguments.length > 1 ? arguments[1] : 'T';
			var dateformat = arguments.length > 2 ? arguments[2] : '';
			var table = document.getElementById(TableIDvalue);
			var tbody = table.getElementsByTagName("tbody")[0];
			var rows = tbody.getElementsByTagName("tr");
			var arrayOfRows = new Array();
			type = type.toUpperCase();
			dateformat = dateformat.toLowerCase();
			for (var i = 0, len = rows.length; i < len; i++) {
				arrayOfRows[i] = new Object;
				arrayOfRows[i].oldIndex = i;
				var celltext = rows[i].getElementsByTagName("td")[sortColumn].innerHTML
						.replace(/<[^>]*>/g, "");
				if (type == 'D') {
					arrayOfRows[i].value = GetDateSortingKey(dateformat,
							celltext);
				} else {
					var re = type == "N" ? /[^\.\-\+\d]/g : /[^a-zA-Z0-9]/g;
					arrayOfRows[i].value = celltext.replace(re, "").substr(0,
							25).toLowerCase();
				}
			}
			if (sortColumn == TableLastSortedColumn) {
				arrayOfRows.reverse();
			} else {
				TableLastSortedColumn = sortColumn;
				switch (type) {
				case "N":
					arrayOfRows.sort(CompareRowOfNumbers);
					break;
				case "D":
					arrayOfRows.sort(CompareRowOfNumbers);
					break;
				default:
					arrayOfRows.sort(CompareRowOfText);
				}
			}
			var newTableBody = document.createElement("tbody");
			for (var i = 0, len = arrayOfRows.length; i < len; i++) {
				newTableBody.appendChild(rows[arrayOfRows[i].oldIndex]
						.cloneNode(true));
			}
			table.replaceChild(newTableBody, tbody);
		} // function SortTable()

		function CompareRowOfText(a, b) {
			var aval = a.value;
			var bval = b.value;
			return (aval == bval ? 0 : (aval > bval ? 1 : -1));
		} // function CompareRowOfText()

		function CompareRowOfNumbers(a, b) {
			var aval = /\d/.test(a.value) ? parseFloat(a.value) : 0;
			var bval = /\d/.test(b.value) ? parseFloat(b.value) : 0;
			return (aval == bval ? 0 : (aval > bval ? 1 : -1));
		} // function CompareRowOfNumbers()

		function GetDateSortingKey(format, text) {
			if (format.length < 1) {
				return "";
			}
			format = format.toLowerCase();
			text = text.toLowerCase();
			text = text.replace(/^[^a-z0-9]*/, "");
			text = text.replace(/[^a-z0-9]*$/, "");
			if (text.length < 1) {
				return "";
			}
			text = text.replace(/[^a-z0-9]+/g, ",");
			var date = text.split(",");
			if (date.length < 3) {
				return "";
			}
			var d = 0, m = 0, y = 0;
			for (var i = 0; i < 3; i++) {
				var ts = format.substr(i, 1);
				if (ts == "d") {
					d = date[i];
				} else if (ts == "m") {
					m = date[i];
				} else if (ts == "y") {
					y = date[i];
				}
			}
			d = d.replace(/^0/, "");
			if (d < 10) {
				d = "0" + d;
			}
			if (/[a-z]/.test(m)) {
				m = m.substr(0, 3);
				switch (m) {
				case "jan":
					m = String(1);
					break;
				case "feb":
					m = String(2);
					break;
				case "mar":
					m = String(3);
					break;
				case "apr":
					m = String(4);
					break;
				case "may":
					m = String(5);
					break;
				case "jun":
					m = String(6);
					break;
				case "jul":
					m = String(7);
					break;
				case "aug":
					m = String(8);
					break;
				case "sep":
					m = String(9);
					break;
				case "oct":
					m = String(10);
					break;
				case "nov":
					m = String(11);
					break;
				case "dec":
					m = String(12);
					break;
				default:
					m = String(0);
				}
			}
			m = m.replace(/^0/, "");
			if (m < 10) {
				m = "0" + m;
			}
			y = parseInt(y);
			if (y < 100) {
				y = parseInt(y) + 2000;
			}
			return "" + String(y) + "" + String(m) + "" + String(d) + "";
		} // function GetDateSortingKey()

		function myFunction() {
			var input, filter, table, tr, td, i, txtValue;
			input = document.getElementById("myInput");
			filter = input.value.toUpperCase();
			table = document.getElementById("indextable");
			tr = table.getElementsByTagName("tr");
			for (i = 0; i < tr.length; i++) {
				td = tr[i].getElementsByTagName("td")[3];
				if (td) {
					txtValue = td.textContent || td.innerText;
					if (txtValue.toUpperCase().indexOf(filter) > -1) {
						tr[i].style.display = "";
					} else {
						tr[i].style.display = "none";
					}
				}
			}
		}
	</script>


</body>
</html>