<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta charset="ISO-8859-1">
<title>Zakazi pregled</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<body>
	<div>
  
 		 <h1 align = "center">Zakazite pregled</h1>
	</div>
	
	<div>
	<table border = "1" align = "center">
	
		<thead>
			<tr>
				<td width = "200" height = "50">Kreiraj termin:</td>
				<td>
				<input type = "text" id = "datepicker" width = "200" height = "50">
				</td>
				
			</tr>
		</thead>
		<tbody>
			<tr>
				<td width = "200" height = "50">Unesite ime pacijenta: </td>
				<td width = "200" >
				<input type = "text">
				</td>
			</tr>
			<tr>
				<td width = "200" height = "50">Unesite prezime pacijenta: </td>
				<td width = "200">
				<input type = "text">
				</td>
			</tr>
		</tbody>
	
	</table>
	</div> 
  
		
	<!-- <div class="form-group">
		<input type="submit" class="btn btn-secondary" value="Zakazi"/>
	</div> -->
	
    <div align = "center">
		<button type = "submit" style="background-color:light-blue;margin:auto;display:block" width = "20" height = "10"> Zakazi </button>
	</div>   
 	
	
	
	<!-- 	<h1 align = "center"> Zakazi pregled</h1>
	<p align = "center"> Datum pregleda: <input type="text" id="datepicker"></p>
	<p align = "center"> Ime pacijenta: <input type="text"></p>
	<p align = "center"> Prezime pacijenta: <input type = "text"></p> -->
	
	
</body>
</html>