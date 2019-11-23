<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta charset="ISO-8859-1">
<title>Update</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">

<script>
	function validateForm() {
		var korIme = document.forms["forma"]["username"];
		var ime = document.forms["forma"]["ime"];
		var prezime = document.forms["forma"]["prezime"];
		var jedBrOsig = document.forms["forma"]["jedBrOsig"];
		var email = document.forms["forma"]["email"];
		var adresa = document.forms["forma"]["adresa"];
		var grad = document.forms["forma"]["grad"];
		var drzava = document.forms["forma"]["drzava"];
		var telefon = document.forms["forma"]["telefon"];
		var sifra = document.forms["forma"]["password"];
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
	

		<c:url var="action" value="/update2"></c:url>
			<div class="container text-center">
				<h3>Registruj se</h3>
				<hr>
				
				<form:form action="${action}" class="form-horizontal" method="post" modelAttribute="korisnik">
					
					<div class="form-group">
					
						<form:label path="username" class="control-label col-md-3">Korisnicko ime</form:label>
					  	<div class="col-md-6">
							<form:input type="text" class="form-control" path="username" name="username" value="${korisnik.username}" />
								<span id="free"></span>
						</div>
					</div>
					<div class="form-group">
						<form:label path="ime" class="control-label col-md-3">Ime</form:label>
						<div class="col-md-6">
							<form:input type="text" path="ime" class="form-control" name="ime"
								value="${korisnik.ime }" />
						</div>
					</div>
					<div class="form-group">
						<form:label path="prezime" class="control-label col-md-3">Prezime</form:label>
						<div class="col-md-6">
							<form:input type="text" path="prezime" class="form-control" name="prezime"
								value="${korisnik.prezime }" />
						</div>
					</div>
					<div class="form-group">
						<form:label path="jedBrOsig" class="control-label col-md-3">Jedinstveni broj
							osiguranika-unesite samo brojeve </form:label>
						<div class="col-md-6">
							<form:input type="number" path="jedBrOsig" class="form-control" name="jedBrOsig"
								value="${korisnik.jedBrOsig }" />
						</div>
					</div>
					<div class="form-group">
						<form:label path="email" class="control-label col-md-3">Email</form:label>
						<div class="col-md-6">
							<form:input type="email" path="email" class="form-control" name="email"
								value="${korisnik.email }"/>
						</div>
					</div>
					<div class="form-group">
						<form:label path="adresa" class="control-label col-md-3">Adresa prebivalista</form:label>
						<div class="col-md-6">
							<form:input type="text" path="adresa" class="form-control" name="adresa"
								value="${korisnik.adresa }" />
						</div>
					</div>
					<div class="form-group">
						<form:label path="grad" class="control-label col-md-3">Grad</form:label>
						<div class="col-md-6">
							<form:input type="text" path="grad" class="form-control" name="grad"
								value="${korisnik.grad }"/>
						</div>
					</div>
					<div class="form-group">
						<form:label path="drzava" class="control-label col-md-3">Drzava</form:label>
						<div class="col-md-6">
							<form:input type="text" path="drzava" class="form-control" name="drzava"
								value="${korisnik.drzava }" />
						</div>
					</div>
					<div class="form-group">
						<form:label path="telefon" class="control-label col-md-3">Telefon-unesite samo
							brojeve</form:label>
						<div class="col-md-6">
							<form:input type="number" path="telefon" class="form-control" name="telefon"
								value="${korisnik.telefon }" />
						</div>
					</div>
					<div class="form-group">
						<form:label path="password" class="control-label col-md-3">Sifra</form:label>
						<div class="col-md-6">
							<form:input path="password" type="password" class="form-control" id="pass1"
								name="password" value="${korisnik.password}" />
						</div>
					</div>
					
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Update">
					</div>
				</form:form>
			</div>
		

		






</body>

</html>