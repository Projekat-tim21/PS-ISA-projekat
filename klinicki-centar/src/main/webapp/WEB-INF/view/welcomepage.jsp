<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta charset="ISO-8859-1">
<title>Registrovanje</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">

<script>
	function validateForm() {
		var korIme = document.forms["forma"]["korIme"];
		var ime = document.forms["forma"]["ime"];
		var prezime = document.forms["forma"]["prezime"];
		var jedBrOsig = document.forms["forma"]["jedBrOsig"];
		var email = document.forms["forma"]["email"];
		var adresa = document.forms["forma"]["adresa"];
		var grad = document.forms["forma"]["grad"];
		var drzava = document.forms["forma"]["drzava"];
		var telefon = document.forms["forma"]["telefon"];
		var sifra = document.forms["forma"]["sifra"];
		var sifra_confirm = document.forms["forma"]["sifra_confirm"];
		var pass1 = document.getElementById('pass1');
		var pass2 = document.getElementById('pass2');
		var goodColor = "#FFFFFF";
		var badColor = "#ff6666";
		
		if (korIme.value == sifra.value) {
			window.alert("Korisnicko ime i sifra moraju biti razliciti");
			korIme.focus();
			return false;
		}
		if (sifra.value.length < 6) {
			window.alert("Sifra mora da sadrzi najmanje 6 karaktera");
			sifra.focus();
			return false;
		}
		if (sifra.value != sifra_confirm.value) {
			window.alert("Sifra i potvrda sifre moraju biti iste");
			sifra.focus();
			return false;
		}
		
		return true;

	}
</script>


</head>
<body >



	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/welcome" class="navbar-brand">Klinika AB</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/login">Logovanje</a></li>
					<li><a href="/registracija">Registruj se</a></li>
					<li><a href="/pokazi-korisnika">Svi korisnici</a></li>
				</ul>
			</div>
		</div>
	</div>

	<c:choose>
		<c:when test="${mode=='MODE_HOME' }">
			<div class="container" id="homediv">
				<div class="jumbotron text-center">
					<h1>Dobrodosli u aplikaciju Klinika AB</h1>
				</div>
			</div>

		</c:when>

		<c:when test="${mode=='MODE_REGISTER' }">
			<div class="container text-center">
				<h3>Registruj se</h3>
				<hr>
				<!--onsubmit="return checkForm(this);"-->
				<form name="forma" class="form-horizontal" method="POST"
					action="sacuvaj" onsubmit="return validateForm()">
					<input type="hidden" name="id" value="${korisnik.id }" />
					<div class="form-group">
						<label class="control-label col-md-3">Korisnicko ime</label>
						<div class="col-md-6">
							<input type="text" class="form-control" name="korIme"
								value="${korisnik.korIme }" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Ime</label>
						<div class="col-md-6">
							<input type="text" class="form-control" name="ime"
								value="${korisnik.ime }" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Prezime</label>
						<div class="col-md-6">
							<input type="text" class="form-control" name="prezime"
								value="${korisnik.prezime }" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Jedinstveni broj
							osiguranika-unesite samo brojeve </label>
						<div class="col-md-6">
							<input type="number" class="form-control" name="jedBrOsig"
								value="${korisnik.jedBrOsig }" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Email</label>
						<div class="col-md-6">
							<input type="email" class="form-control" name="email"
								value="${korisnik.email }" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Adresa prebivalista</label>
						<div class="col-md-6">
							<input type="text" class="form-control" name="adresa"
								value="${korisnik.adresa }" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Grad</label>
						<div class="col-md-6">
							<input type="text" class="form-control" name="grad"
								value="${korisnik.grad }" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Drzava</label>
						<div class="col-md-6">
							<input type="text" class="form-control" name="drzava"
								value="${korisnik.drzava }" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Telefon-unesite samo
							brojeve</label>
						<div class="col-md-6">
							<input type="number" class="form-control" name="telefon"
								value="${korisnik.telefon }" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Sifra</label>
						<div class="col-md-6">
							<input type="password" class="form-control" id="pass1"
								name="sifra" value="${korisnik.sifra}" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Potvrda sifre</label>
						<div class="col-md-6">
							<input type="password" class="form-control" id="pass2"
								name="sifra_confirm" value="${korisnik.sifra_confirm}" required>
						</div>
					</div>
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Register">
					</div>
				</form>
			</div>
		</c:when>
		<c:when test="${mode=='ALL_USERS' }">
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
									<td>${korisnik.korIme}</td>
									<td>${korisnik.ime}</td>
									<td>${korisnik.prezime}</td>
									<td>${korisnik.jedBrOsig}</td>
									<td>${korisnik.email}</td>
									<td>${korisnik.adresa}</td>
									<td>${korisnik.grad}</td>
									<td>${korisnik.drzava}</td>
									<td>${korisnik.telefon}</td>
									<td>${korisnik.sifra}</td>
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
		</c:when>

		<c:when test="${mode=='MODE_UPDATE' }">
			<div class="container text-center">
				<h3>Update User</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="sacuvaj">
					<input type="hidden" name="id" value="${korisnik.id }" />
					<div class="form-group">
						<label class="control-label col-md-3">Korisnicko ime</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="username"
								value="${korisnik.korIme }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">First Name</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="firstname"
								value="${korisnik.firstname }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Last Name</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="lastname"
								value="${korisnik.lastname }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Age </label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="age"
								value="${korisnik.age }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Password</label>
						<div class="col-md-7">
							<input type="password" class="form-control" name="password"
								value="${korisnik.password }" />
						</div>
					</div>
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Update" />
					</div>
				</form>
			</div>
		</c:when>

		<c:when test="${mode=='MODE_LOGIN' }">
			<div class="container text-center">
				<h3>User Login</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="/login-user">
					<c:if test="${not empty error }">
						<div class="alert alert-danger">
							<c:out value="${error }"></c:out>
						</div>
					</c:if>
					<div class="form-group">
						<label class="control-label col-md-3">Username</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="username"
								value="${korisnik.username }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Password</label>
						<div class="col-md-7">
							<input type="password" class="form-control" name="password"
								value="${korisnik.password }" />
						</div>
					</div>
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Login" />
					</div>
				</form>
			</div>
		</c:when>
	</c:choose>






</body>

</html>