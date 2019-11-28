<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container text-center" id="tasksDiv">
				<h3>Svi korisnici</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Korisnicko ime</th>
								<th>Ime</th>
								<th>Prezime</th>
								<th>Jedinstveni br. osiguranika</th>
								<th>Email</th>
								<th>Adresa prebivalista</th>
								<th>Grad</th>
								<th>Drzava</th>
								<th>Telefon</th>
								<th>Sifra</th>
								<th>Obrisi</th>
								<th>Izmeni</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="korisnik" items="${korisnici }">
								<tr>
									<td>${korisnik.id}</td>
									<td>${korisnik.username}</td>
									<td>${korisnik.ime}</td>
									<td>${korisnik.prezime}</td>
									<td>${korisnik.jedBrOsig}</td>
									<td>${korisnik.email}</td>
									<td>${korisnik.adresa}</td>
									<td>${korisnik.grad}</td>
									<td>${korisnik.drzava}</td>
									<td>${korisnik.telefon}</td>
									<td>${korisnik.password}</td>
									<td><a href="/delete-user?id=${korisnik.id }"><span
											class="glyphicon glyphicon-trash"></span></a></td>
									<td><a href="/edit-user?id=${korisnik.id }"><span
											class="glyphicon glyphicon-pencil"></span></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
</body>
</html>