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

<style>
body {
  background-image: url("static/images/s.png");
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-position: bottom right; 
}
</style>

</head>
<body>
  
  	
  
  
	<c:choose>
	
		<c:when test="${mode=='ALL_KLINIKE' }">  
		
		   <div role="navigation">
		<div class="navbar navbar-inverse">
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a onclick="addIdPac(this)" href="/korakUnazadNaLogin">Vrati se nazad</a></li>	
					<li><a onclick="addIdPac(this)" href="/logout">Odjavi se</a></li> 
				</ul>

			</div>
		</div>
	</div>
		   
		   
			<div class="container text-center" id="tasksDiv">
				<h3>Lista klinika</h3>
				<hr>
		<!-- 	<h4>Sortiraj klinike</h4>
			<span class="form-group">	
			<button onclick="sortTablePoNazivu()">Po nazivu</button>
			<button onclick="sortTablePoGradu()">Po gradu</button>   
			</span>	 
			 -->
				<div class="table-responsive">
				
				<table class="table">
						<tr>
							<th><input  type="text" id="myInput1" onkeyup="myFunction1()"
								placeholder="ime klinike"></th>
							<th><input  type="text" id="myInput2" onkeyup="myFunction2()"
								placeholder="adresa"></th>
							<th><input  type="text" id="myInput3" onkeyup="myFunction3()"
								placeholder="tip pregleda"></th>
							<th><input  type="text" id="myInput5" onkeyup="myFunction5()"
								placeholder="grad"></th>
							<th><input  type="text" id="myInput6" onkeyup="myFunction6()"
								placeholder="drzava"></th>
							<th><input  type="text" id="myInput4" onkeyup="myFunction4()"
								placeholder="ocena"></th>
								
						</tr>
					</table>
				
				
				
				
					<table id="indextable" class="table table-striped table-bordered">
						<thead>
							<tr>
								<th><a href="javascript:SortTable(0,'N');">Id</a></th>
								<th><a href="javascript:SortTable(1,'T');">Naziv</a></th>
								<th><a href="javascript:SortTable(2,'T');">Adresa</a></th>
								<th><a href="javascript:SortTable(3,'T');">Grad</a></th>
								<th><a href="javascript:SortTable(4,'T');">Drzava</a></th>
								<th><a href="javascript:SortTable(5,'T');">Tip pregleda</a></th>
								<th><a href="javascript:SortTable(6,'N');">Ocena</a></th>
								<th>Zaposleni</th>
								<th>Zakazivanje</th>
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
									<td>${klinika.tip}</td>
									<td>${klinika.ocena}</td>
									<td>
										<a onclick="addIdPac2(this)" href="/lekariUKlinici?idklinike=${klinika.id}">Lista zaposlenih</a>
									</td>
									<td>
										<a onclick="addIdPac5(this)" href="/terminiUKlinici?idklinike=${klinika.id}">Slobodni termini</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>

		</c:when>
		
		<c:when test="${mode=='ALL_LEKARI_2' }">
		
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a onclick="addIdPac10(this)" href="/korakUnazadNaListuKlinika">Vrati se nazad</a></li>	
					<li><a onclick="addIdPac(this)" href="/logout">Odjavi se</a></li> 
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
							<th><input  type="text" id="myInput10" onkeyup="myFunction10()"
								placeholder="prezime"></th>
							<th><input  type="text" id="myInput11" onkeyup="myFunction11()"
								placeholder="tip pregleda"></th>
							<th><input  type="text" id="myInput12" onkeyup="myFunction12()"
								placeholder="ocena"></th>
						</tr>
					</table>

<input type="hidden" id="idHidden" name="idHidden">


					<table id="indextable" class="table table-striped table-bordered">

						<thead>
							<tr>
								<th><a href="javascript:SortTable(0,'N');">Id</a></th>
								<th><a href="javascript:SortTable(1,'T');">Ime</a></th>
								<th><a href="javascript:SortTable(2,'T');">Prezime</a></th>
								<th><a href="javascript:SortTable(3,'T');">Tip pregleda</a></th>
								<th><a href="javascript:SortTable(4,'N');">Ocena</a></th>
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
										<a onclick="addIdPac3(this)" href="/listaSvihTerminaPacijent?id=${lip.id}">Slobodni termini</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				
					
				</div>
			</div>


		</c:when>
		
		
		<c:when test="${mode=='ALL_TERMINI_2' }">


<div role="navigation">
		<div class="navbar navbar-inverse">
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a  href="/korakUnazadNaListuKlinika?id=${idpac}">Vrati se nazad</a></li>	
					<li><a onclick="addIdPac(this)" href="/logout">Odjavi se</a></li> 
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
var idPacijenta2 = getUrlParameter('idpac');
var idPacijenta = getUrlParameter('id');
console.log(idPacijenta);
var id2=getUrlParameter('id');
function addIdPac (element){
	element.href = element.href+"?id="+idPacijenta;
	console.log(element.href);
}

function addIdPac3 (element){
	element.href = element.href+"&idpac="+idPacijenta2;
	console.log(element.href);
}

function addIdPac10 (element){
	element.href = element.href+"?id="+idPacijenta2;
	console.log(element.href);
}

function addIdPac2 (element){
	element.href = element.href+"&idpac="+idPacijenta;
	console.log(element.href);
}

function addIdPac5 (element){
	element.href = element.href+"&id="+idPacijenta;
	console.log(element.href);
}

function izbaciAlert(element){
	alert("Uspesno ste zakazali pregled. Svoje zakazane preglede mozete pogledati na linku zakazani pregledi");
	element.href = element.href+"&id="+id2;
	}

function sortTablePoNazivu() {
  var table, rows, switching, i, x, y, shouldSwitch;
  table = document.getElementById("tabelaKlinike");
  switching = true;
  /*Make a loop that will continue until
  no switching has been done:*/
  while (switching) {
    //start by saying: no switching is done:
    switching = false;
    rows = table.rows;
    /*Loop through all table rows (except the
    first, which contains table headers):*/
    for (i = 1; i < (rows.length - 1); i++) {
      //start by saying there should be no switching:
      shouldSwitch = false;
      /*Get the two elements you want to compare,
      one from current row and one from the next:*/
      x = rows[i].getElementsByTagName("TD")[1];
      y = rows[i + 1].getElementsByTagName("TD")[1];
      //check if the two rows should switch place:
      if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
        //if so, mark as a switch and break the loop:
        shouldSwitch = true;
        break;
      }
    }
    if (shouldSwitch) {
      /*If a switch has been marked, make the switch
      and mark that a switch has been done:*/
      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
      switching = true;
    }
  }
}

///////////////////////////////////////////////////////

function sortTablePoGradu() {
  var table, rows, switching, i, x, y, shouldSwitch;
  table = document.getElementById("tabelaKlinike");
  switching = true;
  /*Make a loop that will continue until
  no switching has been done:*/
  while (switching) {
    //start by saying: no switching is done:
    switching = false;
    rows = table.rows;
    /*Loop through all table rows (except the
    first, which contains table headers):*/
    for (i = 1; i < (rows.length - 1); i++) {
      //start by saying there should be no switching:
      shouldSwitch = false;
      /*Get the two elements you want to compare,
      one from current row and one from the next:*/
      x = rows[i].getElementsByTagName("TD")[3];
      y = rows[i + 1].getElementsByTagName("TD")[3];
      //check if the two rows should switch place:
      if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
        //if so, mark as a switch and break the loop:
        shouldSwitch = true;
        break;
      }
    }
    if (shouldSwitch) {
      /*If a switch has been marked, make the switch
      and mark that a switch has been done:*/
      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
      switching = true;
    }
  }
}

///////////////////////////////////////////////ovo

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
for(var i=0, len=rows.length; i<len; i++) {
	arrayOfRows[i] = new Object;
	arrayOfRows[i].oldIndex = i;
	var celltext = rows[i].getElementsByTagName("td")[sortColumn].innerHTML.replace(/<[^>]*>/g,"");
	if( type=='D' ) { arrayOfRows[i].value = GetDateSortingKey(dateformat,celltext); }
	else {
		var re = type=="N" ? /[^\.\-\+\d]/g : /[^a-zA-Z0-9]/g;
		arrayOfRows[i].value = celltext.replace(re,"").substr(0,25).toLowerCase();
		}
	}
if (sortColumn == TableLastSortedColumn) { arrayOfRows.reverse(); }
else {
	TableLastSortedColumn = sortColumn;
	switch(type) {
		case "N" : arrayOfRows.sort(CompareRowOfNumbers); break;
		case "D" : arrayOfRows.sort(CompareRowOfNumbers); break;
		default  : arrayOfRows.sort(CompareRowOfText);
		}
	}
var newTableBody = document.createElement("tbody");
for(var i=0, len=arrayOfRows.length; i<len; i++) {
	newTableBody.appendChild(rows[arrayOfRows[i].oldIndex].cloneNode(true));
	}
table.replaceChild(newTableBody,tbody);
} // function SortTable()

function CompareRowOfText(a,b) {
var aval = a.value;
var bval = b.value;
return( aval == bval ? 0 : (aval > bval ? 1 : -1) );
} // function CompareRowOfText()

function CompareRowOfNumbers(a,b) {
var aval = /\d/.test(a.value) ? parseFloat(a.value) : 0;
var bval = /\d/.test(b.value) ? parseFloat(b.value) : 0;
return( aval == bval ? 0 : (aval > bval ? 1 : -1) );
} // function CompareRowOfNumbers()

function GetDateSortingKey(format,text) {
if( format.length < 1 ) { return ""; }
format = format.toLowerCase();
text = text.toLowerCase();
text = text.replace(/^[^a-z0-9]*/,"");
text = text.replace(/[^a-z0-9]*$/,"");
if( text.length < 1 ) { return ""; }
text = text.replace(/[^a-z0-9]+/g,",");
var date = text.split(",");
if( date.length < 3 ) { return ""; }
var d=0, m=0, y=0;
for( var i=0; i<3; i++ ) {
	var ts = format.substr(i,1);
	if( ts == "d" ) { d = date[i]; }
	else if( ts == "m" ) { m = date[i]; }
	else if( ts == "y" ) { y = date[i]; }
	}
d = d.replace(/^0/,"");
if( d < 10 ) { d = "0" + d; }
if( /[a-z]/.test(m) ) {
	m = m.substr(0,3);
	switch(m) {
		case "jan" : m = String(1); break;
		case "feb" : m = String(2); break;
		case "mar" : m = String(3); break;
		case "apr" : m = String(4); break;
		case "may" : m = String(5); break;
		case "jun" : m = String(6); break;
		case "jul" : m = String(7); break;
		case "aug" : m = String(8); break;
		case "sep" : m = String(9); break;
		case "oct" : m = String(10); break;
		case "nov" : m = String(11); break;
		case "dec" : m = String(12); break;
		default    : m = String(0);
		}
	}
m = m.replace(/^0/,"");
if( m < 10 ) { m = "0" + m; }
y = parseInt(y);
if( y < 100 ) { y = parseInt(y) + 2000; }
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

function myFunction5() {
	var input, filter, table, tr, td, i, txtValue;
	input = document.getElementById("myInput5");
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

function myFunction6() {
	var input, filter, table, tr, td, i, txtValue;
	input = document.getElementById("myInput6");
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

function myFunction4() {
	var input, filter, table, tr, td, i, txtValue;
	input = document.getElementById("myInput4");
	filter = input.value.toUpperCase();
	table = document.getElementById("indextable");
	tr = table.getElementsByTagName("tr");
	for (i = 0; i < tr.length; i++) {
		td = tr[i].getElementsByTagName("td")[6];
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

function myFunction10() {
	var input, filter, table, tr, td, i, txtValue;
	input = document.getElementById("myInput10");
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

function myFunction11() {
	var input, filter, table, tr, td, i, txtValue;
	input = document.getElementById("myInput11");
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

function myFunction12() {
	var input, filter, table, tr, td, i, txtValue;
	input = document.getElementById("myInput12");
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

function myFunction12() {
	var input, filter, table, tr, td, i, txtValue;
	input = document.getElementById("myInput12");
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


</script>	
		
		
	
 
 
 
 
 
</body>
</html>