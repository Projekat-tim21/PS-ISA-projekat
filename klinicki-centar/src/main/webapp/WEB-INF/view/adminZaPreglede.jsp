<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<!-- ovo je samo da bi student 1 odradio tacku 3.12 -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta charset="ISO-8859-1">
<title>Za def pregleda</title>

<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<style>
body, html {
	height: 100%;
}

.bg {
	/* The image used */
	background-image: url(static/images/hhh.jpg);
	/* Full height */
	height: 100%;
	/* Center and scale the image nicely */
	background-position: center;
	background-repeat: no-repeat;
	background-size: 100% 100%;
}
</style>
</head>
<body>


	<div role="navigation">
		<div class="navbar navbar-inverse">
			<div class="navbar-collapse collapse">
				<h2>ADMIN-privremeno krenirano zbog definisanja pregleda</h2>
				<ul class="nav navbar-nav">
					<li><a href="/AdminPraviPreglede">Prikaz lekara</a></li>
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
								<th>Termin pregleda</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="lip" items="${lipi}">
								<tr>
									<td>${lip.id}</td>
									<td>${lip.ime}</td>
									<td>${lip.prezime}</td>
									<td>${lip.tipspecijalizacije}</td>
									<td>${lip.ocena}</td>
									<td><a href="/kreirajPregledZaLekara?id=${lip.id}">Zakazi
											preglede</a></td>
									<td><a href="/listaSvihTermina?id=${lip.id}">Slobodni termini</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

				</div>
			</div>
		</c:when>




		<c:when test="${mode=='ALL_PRAVIMOO' }">
			<h1>Kreiraj slobodne termine pregleda za lekara</h1>
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
				<input type="hidden" id="lekarId" name="lekarId"
					value="${termini.lekarId}"> <input type="submit"
					name="zakazi" onclick="izbaciAlert();">
				<p id="pText"></p>
			</form>

			<!-- ovaj button za sada nije potreban -->

			<!-- 	<button onclick="ispis();">ispisi</button>   -->

		</c:when>

		<c:when test="${mode=='VRATISE' }">
			<h3>
				<a href="/vratiSe?id=${lip.id}">Povratak na listu lekara</a>
			</h3>
		</c:when>



		<c:when test="${mode=='ALL_TERMINI' }">
			<div class="container text-center" id="tasksDiv">
				<h3>Lista slobodnih termina</h3>
				<hr>
				<!-- 	<h4>Sortiraj klinike</h4>
			<span class="form-group">	
			<button onclick="sortTablePoNazivu()">Po nazivu</button>
			<button onclick="sortTablePoGradu()">Po gradu</button>   
			</span>	 
			 -->

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
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

			</div>

		</c:when>


	</c:choose>

	<script>
	//var querystring = require('querystring');
	//var qs = new Querystring();
	//var v1 = querystring.get("id");
	var url = window.location.href;
	var idx = url.indexOf("=");
	var idd = url.substring(idx+1, idx+3);
	  console.log(idd);
	//var id = parseInt(idd);
	  console.log(idd);
	document.getElementById('lekarId').value = idd;


	function izbaciAlert(){
		alert("Uspesno kreiran termin za izabranog lekara");
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

	  
	/*
	//za listu
	function addItem(list, inputField) { 
		  var list = document.getElementById(list);
		  var listItem = document.createElement("li");
		  var mojaLista=new Array();
		  listItem.innerText = inputField.value; // passed the field. 
		  list.appendChild(listItem);
		  mojaLista.push(listItem);
		  return false; // stop submission
		}
*/
   

   // for (var i = 0; i < mojaLista .length; i ++ ){
    //   window.console.log(mojaLista[i]);
   // }
	
/*
	var Foo = function(){
	    document.getElementById( "a" ).setAttribute( "onClick", "javascript: Boo();" );
	}

	var Boo = function loadFilter() {
	    var element = document.getElementById('list');
	    var children = element.children;
	    var filtered = [];
	    for (var i = 0; i < children.length; i++) {
	        if (children[i].textContent.startsWith('--')) {
	            filtered.push(children[i].textContent);
	        }
	    }
	    return filtered;
	    alert (filtered);
	}

		*/
		
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
/*
		function getInputValue() {
			// Selecting the input element and get its value 
			var inputVal = document.getElementById("datumInput").value;

			// Displaying the value
			alert(inputVal);
		}*/
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



