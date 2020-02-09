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
body, html {
	/*height: 100%;*/
	background-image: url(static/images/adminHome.png);
	background-repeat: no-repeat;
	backround-position: bottom-right;
	backround-position: 10px, 12px;
	
}


</style>
</head>
<body>


	<div role="navigation">
		<div class="navbar navbar-inverse">
			<div class="navbar-collapse collapse">
				<h2>Admin klinike</h2>
				<ul class="nav navbar-nav">
					<li><a href="/AdminPraviPreglede">Prikaz lekara</a></li>
					<li><a href="/zahteviZaPregledom">Odobravanje zahteva</a></li>

					<li><a href="/prikaziOperacijeBezSale">Sale za operaciju</a></li>
					<li><a href="/vratiSe?id=${lip.id}">Vrati se</a></li>
					<li><a href="/logout">Odjavi se</a></li>
				</ul>

			</div>
			
			
			
		</div>
	</div>

	<c:choose>
		<c:when test="${mode=='ALL_LEKARI' }">
			<div class="container text-center" id="tasksDiv">
				<h3>Lista lekara</h3>
				<hr>
				<div class="table-responsive">

					<table id="indextable" class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Ime</th>
								<th>Prezime</th>
								<th>Tip pregleda</th>
								<th>Ocena</th>
								<th>Zakazivanje pregleda</th>
								<th>Lista svih slobodnih termina</th>
								<th>Lista svih definisanih pregleda</th>
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
									<td><a href="/kreirajPregledZaLekara?id=${lip.id}">Zakazi
											preglede</a></td>
									<td><a href="/listaSvihTermina?id=${lip.id}">Slobodni termini</a></td>
									<td><a href="/listaSvihDefinisanihPregledaZaLekara?id=${lip.id}">Definisani pregledi</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

				</div>
			</div>
		</c:when>



<c:when test="${mode=='ALL_ZAHTEVI' }">
			<div class="container text-center" id="tasksDiv">
				<h3>Pristigli zahtevi</h3>
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
								<th>Ime pacijenta</th>
								<th>Prezime pacijenta</th>
								<th>JBO</th>
								<th>Cena pregleda</th>
								<th>Popust</th>
								<th>Sala</th>
								<th colspan="2">Prihvati/Odbij</th>
						<!--		<th>Sifra</th>  -->
							</tr>
						</thead>
						<tbody>
							<c:forEach var="op" items="${opi }">
								<tr>
									<td>${op.id}</td>
									<td>${op.terminzahtev}</td>
									<td>${op.imelekara}</td>
									<td>${op.prezimelekara}</td>
									<td>${op.tipspecijalizacije}</td>
									<td>${op.imepacijenta}</td>
									<td>${op.prezimepacijenta}</td>
									<td>${op.jedbrosigpac}</td>
									<td>${op.cenaop}</td>
									<td>${op.popustop}</td>
									<td>${op.salaop}</td>
									
									<td>
                                        <a href="/enable2/${op.getId()}" class="saveData"><span class="btn-label"><img src="static/svg/check.svg"></span></a>
                                        </td>
                                        <td><a href="/disable2/${op.getId()}" class="deleteData"><span class="btn-label"><img src="static/svg/x.svg"></span></a>
                                        </td>
					
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>






<c:when test="${mode=='ALL_PREGLEDI_SA_ADMINA' }">
			<div class="container text-center" id="tasksDiv">
				<h3>Lista pregleda <strong>${imeLekaraTransfer} ${przLekaraTransfer}</strong>  </h3>
				<hr>
				<div class="table-responsive">

					<table id="indextable" class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Termin</th>
								<th>Sala</th>
								<th>Cena</th>
								<th>Popust</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="termin" items="${termini}">
								<tr>
									
									<td>${termin.id}</td>
									<td>${termin.termin}</td>
									<td>${termin.sala}</td>
									<td>${termin.cena}</td>
									<td>${termin.popust}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

				</div>
			</div>
		</c:when>




		<c:when test="${mode=='ALL_PRAVIMOO' }">
			<h3>Kreiraj pregled za lekara <strong>${imeLekaraTransfer} ${przLekaraTransfer}</strong> </h3>
			<!-- 
				<form onsubmit="return addItem('list', this.inputItem)">
					<input type="datetime-local" id="inputItem"
						placeholder="Unesi datum"> 
					<input type="submit">
				</form>
				
				<ul id="list">
				</ul>
 -->

			<form method="POST" action="sacuvajTermine2">
			
				<input type="datetime-local" name="termin" id="inputText"
					value="${termini.termin}" />
				<!-- 		<button onclick="pushData();">Show</button>   -->
				<input type="hidden" id="lekarId" name="lekarId" value="${termini.lekarId}"> 
					
				<p id="pText"></p>
				<div>
						<label>sala</label>
						
							<input type="text"  id="sala" name="sala"
								value="${termini.sala }" required>
								<span id="free"></span>
					</div>
					<div>
						<label>cena pregleda</label>
					
							<input type="number" id="cena" name="cena"
								value="${termini.cena }" required>
								<span id="free"></span>
						
					</div>
					<div>
						<label >popust</label>
						
							<input type="number"   id="popust" name="popust"
								value="${termini.popust}" required><label>%</label>
								<span id="free"></span>
					</div>
				
					<div>
					<input type="submit" name="zakazi" id="potvrda" name="potvrdi" onclick="izbaciAlert();">
					</div>
			</form>
		</c:when>


		<c:when test="${mode=='VRATISE' }">
			<h3>
				<a href="/vratiSe?id=${lip.id}">Povratak na listu lekara</a>
			</h3>
		</c:when>



		<c:when test="${mode=='ALL_TERMINI' }">
			<div class="container text-center" id="tasksDiv">
				<h3>Lista slobodnih termina za lekara <strong>${imeLekaraTransfer} ${przLekaraTransfer}</strong></h3>
				<hr>


				<div class="table-responsive">
					<table id="indextable" class="table table-striped table-bordered">
						<thead>
							<tr>
								<th><a href="javascript:SortTable(0,'N');">Id termina</a></th>
								<th><a href="javascript:SortTable(1,'D','mdy');">Termin</a></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="termini" items="${termini}">
								<tr>
									<td>${termini.id}</td>
									<td>${termini.termin}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

			</div>

		</c:when>


	</c:choose>

	<script>

	var url = window.location.href;
	var idx = url.indexOf("=");
	var idd = url.substring(idx+1, idx+3);
	  console.log(idd);
	  console.log(idd);
	document.getElementById('lekarId').value = idd;


	function izbaciAlert(){
		alert("Uspesno kreiran pregled za izabranog lekara");
		}
	
	 var myArr = [];
	  function pushData()
      {
          // get value from the input text
          var inputText = document.getElementById('inputText').value;
          
          // append data to the array
         
          myArr.push(inputText);
          
          var pval = "";
          
          for(i = 0; i < myArr.length; i++)
          {
              pval = pval + myArr[i] + "<br/>";
          }

         
          var listaTermina=document.getElementById('pText').innerHTML = pval;

      }


	  function ispis(){
			var iterator = myArr.values(); 
			// Here all the elements of the array is being printed. 
			for (let elements of iterator) { 
			  console.log(elements); 
			  alert(elements);
			} 

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




