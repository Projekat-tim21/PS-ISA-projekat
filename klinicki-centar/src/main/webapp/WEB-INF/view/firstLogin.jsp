<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
		<title>Prvi put ulogovan administrator</title>
		<link rel="stylesheet" href="static/css/bootstrap.min.css"/>
	</head>
	<body>
		
		<div th:if = "${info}" class="alert alert-danger" th:text = "${info}"></div>
		
		<h1 th:text = "'Hello: ' + ${korisnik.username}"></h1>
		<h1 th:text = "'Ovo je Vasa stara lozinka:' + ${korisnik.password}"></h1>
		<h1>Molimo Vas izmenite Vasu lozinku!</h1>
		<form th:action="@{'/editpassword'+${korisnik.id}}" th:object="${korisnik}" th:method="PUT">
			<table>
				
				<tr>
					<td><strong>Password: </strong></td>
					<td><input type="text" th:field="*{password}" required/></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><input type = "submit" value="Izmeni">
						<input type = "hidden" th:field="*{id}">
					</td>
				</tr>
			</table>
		</form>
		<script src="static/js/jquery-1.11.1.min.js"></script>
		<script src="static/js/bootstrap.min.js"></script>
	</body>