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
<title>Pregled</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<style>
body {
	background-image: url("static/images/loupe.png");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: bottom right;
}

#myTable th, #myTable td {
  text-align: center; /* center-align text */
  padding: 12px; /* Add padding */
}


</style>
</head>
<body>


<div role="navigation">
		<div class="navbar navbar-inverse">
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/naPocetnu">Vrati se nazad</a></li>
					<li><a href="/logout">Odjavi se</a></li>
				</ul>

			</div>
		</div>
	</div>


<c:choose>
	<c:when test="${mode=='ALL_USERS' }">
			<div class="container text-center" id="tasksDiv">
				<h3>Svi korisnici</h3>
				
					
			<div class="table-responsive">
					

					<table class="table">
						<tr>
							<th><input  type="text" id="myInput1" onkeyup="myFunction1()"
								placeholder="Pretrazite po imenu..."></th>
							<th><input  type="text" id="myInput2" onkeyup="myFunction2()"
								placeholder="Pretrazite po prezimenu..."></th>
							<th><input  type="text" id="myInput3" onkeyup="myFunction3()"
								placeholder="Pretrazite po jedinstvenom broju..."></th>
							
						</tr>
					</table>
			
					<table class="table table-striped table-bordered" id = "myTable">
						<thead>
							<tr>
								<th>Id</th>
								<th>Ime</th>
								<th>Prezime</th>
								<th>Jedinstveni br. osiguranika</th>
								<th>Prikazi profil</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="korisnik" items="${korisnici }">
								<tr>
									<td>${korisnik.id}</td>
									<td>${korisnik.ime}</td>
									<td>${korisnik.prezime}</td>
									<td>${korisnik.jedBrOsig}</td>
									<td><a href="/profilPacijenta">Prikazi profil</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					
					
					
			
			
			<!--<div class="form-group ">
			
	     	  <input type="submit" class="btn btn-primary" value="Prikazi" />
	       			
	  
	    	</div>-->
			
			<!-- <div class="col-lg">
                    <a style="padding-left: 40px" class="btn btn-link" href="/profilkaPregledu" role="button">Prikazi</a>
                </div>
				
				</div>
			</div> -->
	    	
	    	
			
  		

		</c:when>
</c:choose>

<script>

function addItem(list, inputField) {
	var list = document.getElementById(list);
	var listItem = document.createElement("li");
	listItem.innerText = inputField.value; // passed the field. 
	list.appendChild(listItem);
	return false; // stop submission
}

//za sort
var TableIDvalue = "myTable";

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
	table = document.getElementById("myTable");
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
	table = document.getElementById("myTable");
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
	table = document.getElementById("myTable");
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