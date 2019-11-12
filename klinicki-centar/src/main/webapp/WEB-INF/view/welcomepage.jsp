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
function validateForm(this)
{
  re = /^\w+$/;
  if(!re.test(form.korIme.value)) {
    alert("Error: Username must contain only letters, numbers and underscores!");
    form.username.focus();
    return false;
  }
  if(form.sifra.value != "" && form.sifra.value == form.sifra-confirm.value) {
    if(form.sifra.value.length < 6) {
      alert("Error: Password must contain at least six characters!");
      form.sifra.focus();
      return false;
    }
    if(form.sifra.value != form.sifra-confirm.value) {
        if(form.sifra.value.length < 6) {
          alert("Error: Polja za sifru i potvrdu sifre moraju biti ista!");
          form.sifra.focus();
          return false;
        }
    if(form.sifra.value == form.korIme.value) {
      alert("Error: Password must be different from Username!");
      form.sifra.focus();
      return false;
    }
    re = /[0-9]/;
    if(!re.test(form.sifra.value)) {
      alert("Error: password must contain at least one number (0-9)!");
      form.sifra.focus();
      return false;
    }
    re = /[a-z]/;
    if(!re.test(form.sifra.value)) {
      alert("Error: password must contain at least one lowercase letter (a-z)!");
      form.sifra.focus();
      return false;
    }
    re = /[A-Z]/;
    if(!re.test(form.sifra.value)) {
      alert("Error: password must contain at least one uppercase letter (A-Z)!");
      form.sifra.focus();
      return false;
    }
  } else {
    alert("Error: Please check that you've entered and confirmed your password!");
    form.sifra.focus();
    return false;
  }

  alert("You entered a valid password: " + form.sifra.value);
  return true;
  }}
</script>


</head>
<body style="background-color:#FFEFD5;">



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
				<hr>               <!--onsubmit="return checkForm(this);"-->
				<form class="form-horizontal" method="POST" action="sacuvaj" onsubmit="return validateForm(this)">
					<input type="hidden" name="id" value="${korisnik.id }" />
					<div class="form-group">
						<label class="control-label col-md-3">Korisnicko ime</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="korIme"
								value="${korisnik.korIme }" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Ime</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="ime"
								value="${korisnik.ime }" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Prezime</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="prezime"
								value="${korisnik.prezime }" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Jedinstveni broj osiguranika-unesite samo brojeve </label>
						<div class="col-md-3">
							<input type="number" class="form-control" name="jedBrOsig"
								value="${korisnik.jedBrOsig }" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Email</label>
						<div class="col-md-7">
							<input type="email" class="form-control" name="email"
								value="${korisnik.email }" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Adresa prebivalista</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="adresa" value="${korisnik.adresa }" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Grad</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="grad" value="${korisnik.grad }" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Drzava</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="drzava" value="${korisnik.drzava }" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Telefon-unesite samo brojeve</label>
						<div class="col-md-7">
							<input type="number" class="form-control" name="telefon" value="${korisnik.telefon }" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Sifra</label>
						<div class="col-md-7">
							<input type="password" class="form-control" name="sifra" value="${korisnik.sifra}" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Potvrda sifre</label>
						<div class="col-md-7">
							<input type="password" class="form-control" name="sifra-confirm" value="${korisnik.sifra-confirm}" required>
						</div>
					</div>
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Register" >
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