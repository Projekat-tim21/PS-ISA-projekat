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
<title>Pregled sala</title>
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
	<c:when test="${mode=='ALL_SALE' }">
			<div class="container text-center" id="tasksDiv">
				<h3>Sve sale</h3>
				
					
			<div class="table-responsive">
					

					<table class="table">
						<tr>
							<th><input  type="text" id="myInput1" onkeyup="myFunction1()"
								placeholder="Pretrazite po nazivu..."></th>
							<th><input  type="text" id="myInput2" onkeyup="myFunction2()"
								placeholder="Pretrazite po broju sale.."></th>
							<th><input  type="text" id="myInput3" onkeyup="myFunction3()"
								placeholder="Pretrazite po datumu..."></th>
							
						</tr>
					</table>
			
					<table class="table table-striped table-bordered" id = "myTable">
						<thead>
							<tr>
								<th>Id</th>
								<th>Naziv</th>
								<th>Br</th>
								<th>Datum</th>
								<th>Slobodne sale</th>
		
							</tr>
						</thead>
						<tbody>
							<c:forEach var="sala" items="${sale }">
								<tr>
									<td>${sala.id}</td>
									<td>${sala.naziv}</td>
									<td>${sala.br}</td>
									<td>${sala.datum}</td>
									<td><a href = "/prikazKalendaraSala"> Kalendar sala</a></td>
					
								</tr>
							</c:forEach>
						</tbody>
					</table>
			
				</div>
			</div>
			
  		

		</c:when>
		
		<c:when test="${mode=='SVE_SLOBODNE_SALE'}">
		
		<div class="container text-center" id="tasksDiv">
				<h3>Lista slobodnih sala</h3>
				<hr>
				<div class="table-responsive">

					<table id="myTable" class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Naziv</th>
								<th>Br sale</th>
								<th>Datum</th>	
								<th>Rezervisi salu</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="sala" items="${sale}">
								<tr>
									<td>${sala.id}</td>
									<td>${sala.naziv}</td>
									<td>${sala.br}</td>
									<td>${sala.datum}</td>	
									<td><a onclick="izbaciAlert(this)" >Rezervisi salu</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

				</div>
			</div>
		</c:when>
		
		
</c:choose>

<script>

function izbaciAlert(element){
	alert("Uspesno ste rezervisali salu.");
	
}

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