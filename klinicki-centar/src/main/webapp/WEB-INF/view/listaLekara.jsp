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
<title>Lista lekara</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<style>
body {
	background-image: url("static/images/s.png");
	background-position: 10px 12px;
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
	
	
		<c:when test="${mode=='ALL_LEKARI' }">
		
		
		<div role="navigation">
		<div class="navbar navbar-inverse">
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a onclick="addIdPac2(this)" href="/naLogin">Vrati se nazad</a></li>
					<li><a href="/logout">Odjavi se</a></li>
				</ul>

			</div>
		</div>
	</div>
		
	
			<div class="container text-center" id="tasksDiv">
				<h3>Lista lekara</h3>
				
				<div class="table-responsive">
					<h4>Pretrazite tabelu po sledecim kriterijumima:</h4>

					<table class="table">
						<tr>
							<th><input  type="text" id="myInput1" onkeyup="myFunction1()"
								placeholder="ime"></th>
							<th><input  type="text" id="myInput2" onkeyup="myFunction2()"
								placeholder="prezime"></th>
							<th><input  type="text" id="myInput3" onkeyup="myFunction3()"
								placeholder="tip pregleda"></th>
							<th><input  type="text" id="myInput4" onkeyup="myFunction4()"
								placeholder="ocena"></th>
						</tr>
					</table>

<input type="hidden" id="idHidden" name="idHidden">


					<table id="indextable" class="table table-striped table-bordered">

						<thead>
							<tr>
								<th>Id</th>
								<th>Ime</th>
								<th>Prezime</th>
								<th>Tip pregleda</th>
								<th>Ocena</th>
								<th>Termin pregleda</th>
							</tr>
						</thead>
						
						<tbody>

							<c:forEach var="lip" items="${lipi}">
								<tr>
									<td>${lip.id}</td>
									<td>${lip.imelek}</td>
									<td>${lip.prezimelek}</td>
									<td>${lip.tipspecijalizacije}</td>
									<td>${lip.ocena}</td>
									<td>
										<a onclick="addIdPac(this)" href="/listaSvihTerminaPacijent?id=${lip.id}">Slobodni termini</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				
					
				</div>
			</div>


		</c:when>

		<c:when test="${mode=='ALL_TERMINI' }">
		
		
		<div role="navigation">
		<div class="navbar navbar-inverse">
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a onclick="addIdPac2(this)" href="/naLogin">Vrati se nazad</a></li>
					<li><a href="/logout">Odjavi se</a></li>
				</ul>

			</div>
		</div>
	</div>
		
		
			<div class="container text-center" id="tasksDiv">
				<h3>Lista slobodnih termina  </h3>
				<hr>
				<!-- 	<h4>Sortiraj klinike</h4>
			<span class="form-group">	
			<button onclick="sortTablePoNazivu()">Po nazivu</button>
			<button onclick="sortTablePoGradu()">Po gradu</button>   
			</span>	 
			 -->
<input type="hidden" id="idHidden" name="idHidden">
				<div class="table-responsive">
					<table id="indextable" class="table table-striped table-bordered">
						<thead>
							<tr>
								<th><a href="javascript:SortTable(6,'N');">Id</a></th>
								<th><a href="javascript:SortTable(1,'D','mdy');">Termin</a></th>
								<th><a href="javascript:SortTable(6,'N');">Id lekara</a></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="termini" items="${termini}">
								<tr>
									<td>${termini.id}</td>
									<td>${termini.termin}</td>
									<td>${termini.lekarId}</td>
									<td><a onclick="addIdPac(this)" href="/zakazivanjePregledaIzaListeLekara?id=${termini.id}">Zakazi pregled</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

			</div>

		</c:when>


<c:when test="${mode=='ALL_TERMINI2' }">
			<div class="container text-center" id="tasksDiv">
				<h3>Lista slobodnih termina  </h3>
				<hr>
				<!-- 	<h4>Sortiraj klinike</h4>
			<span class="form-group">	
			<button onclick="sortTablePoNazivu()">Po nazivu</button>
			<button onclick="sortTablePoGradu()">Po gradu</button>   
			</span>	 
			 -->
<input type="hidden" id="idHidden" name="idHidden">
				<div class="table-responsive">
					<table id="indextable" class="table table-striped table-bordered">
						<thead>
							<tr>
								<th><a href="javascript:SortTable(6,'N');">Id</a></th>
								<th><a href="javascript:SortTable(1,'D','mdy');">Termin</a></th>
								<th><a href="javascript:SortTable(6,'N');">Id lekara</a></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="termini" items="${termini}">
								<tr>
									<td>${termini.id}</td>
									<td>${termini.termin}</td>
									<td>${termini.lekarId}</td>
									<td><a onclick="addIdPac(this)" href="/zakazivanjePregledaIzaListeLekara?id=${termini.id}">Zakazi pregled</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<h2>Nema slobodnih termina za izabranog lekara</h2>
				</div>

			</div>

		</c:when>



<c:when test="${mode=='ALL_PREGLEDI_SA_LOGINA' }">


<div role="navigation">
		<div class="navbar navbar-inverse">
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a onclick="addIdPac3(this)" href="/naLogin">Vrati se nazad</a></li>
					<li><a href="/logout">Odjavi se</a></li>
				</ul>

			</div>
		</div>
	</div>



			<div class="container text-center" id="tasksDiv">
				<h3>Lista pregleda</h3>
				<hr>
				<div class="table-responsive">

					<table id="indextable" class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id pregleda</th>
								<th>Ime lekara</th>
								<th>Prezime lekara</th>
								<th>Tip pregleda</th>
								<th>Termin</th>
								<th>Sala</th>
								<th>Cena</th>
								<th>Popust</th>
								<th>Zakazi pregled</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="termin" items="${termini}">
								<tr>
									<td>${termin.id}</td>
									<td>${termin.lekarime}</td>
									<td>${termin.lekarprezime}</td>
									<td>${termin.tippregleda }</td>
									<td>${termin.termin}</td>
									<td>${termin.sala}</td>
									<td>${termin.cena}</td>
									<td>${termin.popust}</td>
									<td><a onclick="izbaciAlert(this)" href="/uspesnoZakazanPregled?idter=${termin.id}">Zakazi pregled</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

				</div>
			</div>
		</c:when>




	</c:choose>

	<script>

	
	
	var getUrlParameter = function getUrlParameter(sParam) {
	    var sPageURL = window.location.search.substring(1),
	        sURLVariables = sPageURL.split('&'),
	        sParameterName,
	        i;

	    for (i = 0; i < sURLVariables.length; i++) {
	        sParameterName = sURLVariables[i].split('=');

	        if (sParameterName[0] === sParam) {
	            return sParameterName[1] === undefined ? true : decodeURIComponent(sParameterName[1]);
	        }
	    }
	};

	var idPacijenta = getUrlParameter('idpac');
	var id2=getUrlParameter('id');
	//var a = document.getElementById('id-pac-id');
	//console.log('OVDEEEEEEEE    '+a.href+ "&idpac="+idPacijenta);

	function addIdPac (element){
			element.href = element.href+"&idpac="+idPacijenta;
		}

	function addIdPac2 (element){
		element.href = element.href+"?id="+idPacijenta;
	}

	function addIdPac3 (element){
		element.href = element.href+"?id="+id2;
	}
	
	function izbaciAlert(element){
		alert("Uspesno ste zakazali pregled. Svoje zakazane preglede mozete pogledati na linku zakazani pregledi");
		element.href = element.href+"&id="+id2;
		}
	

	
	
		//za listu
		function addItem(list, inputField) {
			var list = document.getElementById(list);
			var listItem = document.createElement("li");
			listItem.innerText = inputField.value; // passed the field. 
			list.appendChild(listItem);
			return false; // stop submission
		}

		//za sort
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

		function myFunction1() {
			var input, filter, table, tr, td, i, txtValue;
			input = document.getElementById("myInput1");
			filter = input.value.toUpperCase();
			table = document.getElementById("indextable");
			tr = table.getElementsByTagName("tr");
			for (i = 0; i < tr.length; i++) {
				td = tr[i].getElementsByTagName("td")[1];
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

		function myFunction2() {
			var input, filter, table, tr, td, i, txtValue;
			input = document.getElementById("myInput2");
			filter = input.value.toUpperCase();
			table = document.getElementById("indextable");
			tr = table.getElementsByTagName("tr");
			for (i = 0; i < tr.length; i++) {
				td = tr[i].getElementsByTagName("td")[2];
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

		function myFunction3() {
			var input, filter, table, tr, td, i, txtValue;
			input = document.getElementById("myInput3");
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

		function myFunction5() {
			var input, filter, table, tr, td, i, txtValue;
			input = document.getElementById("myInput5");
			filter = input.value.toUpperCase();
			table = document.getElementById("indextable");
			tr = table.getElementsByTagName("tr");
			for (i = 0; i < tr.length; i++) {
				td = tr[i].getElementsByTagName("td")[5];
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

		function myFunction4() {
			var input, filter, table, tr, td, i, txtValue;
			input = document.getElementById("myInput4");
			filter = input.value.toUpperCase();
			table = document.getElementById("indextable");
			tr = table.getElementsByTagName("tr");
			for (i = 0; i < tr.length; i++) {
				td = tr[i].getElementsByTagName("td")[4];
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

		function getInputValue() {
			// Selecting the input element and get its value 
			var inputVal = document.getElementById("datumInput").value;

			// Displaying the value
			alert(inputVal);
		}
	</script>


</body>
</html>
<!--  
  <form  method="POST" action="sacuvajDatum">
  	<label>Datum:</label>
  	<input type="datetime-local"/><br>
  	<input type="submit"/>
  </form>
  
  -->



