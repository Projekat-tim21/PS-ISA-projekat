<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta charset="ISO-8859-1">
<title>Pregled</title>

<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">

<style type="text/css">
body {
  background-image: url("static/images/s.png");
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-position: bottom right; 
}

</style>
</head>
<body>

	<div role="navigation">
		<div class="navbar navbar-inverse">
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/profilPacijenta">Vrati se nazad</a></li>
					<li><a href="/logout">Odjavi se</a></li>
				</ul>

			</div>
		</div>
	</div>
	<c:choose>
	<c:when test="${mode=='HOME_PAGE_LEKAR' }">
			<div class="container" id="homediv">
				<div class="jumbotron text-center">
					<h1>Stranica lekara</h1>
				</div>
			</div>

		</c:when>
	<c:when test="${mode=='ZAPOCNI_PREGLED' }">
			<div class="container text-center">
				<hr>
				<!--onsubmit="return checkForm(this);"-->
				<form name="forma" class="form-horizontal" method="POST">
				<div class="form-group">
						<label class="control-label col-md-3">Ime:</label>
						<div class="col-md-6">
							<input type="text" class="form-control" required>
								<span id="free"></span>
						</div>
				</div>
				<div class="form-group">
						<label class="control-label col-md-3">Prezime:</label>
						<div class="col-md-6">
							<input type="text" class="form-control" required>
						</div>
				</div>
  				<div class="form-group">
						<label class="control-label col-md-3">Datum rodjenja:</label>
						<div class="col-md-6">
							<input type="text" class="form-control" required>
						</div>
				</div>
	 			<div class="form-group">
						<label class="control-label col-md-3">Jedinstveni broj osiguranika:</label>
						<div class="col-md-6">
							<input type="text" class="form-control" required>
						</div>
				</div>
				<div class="form-group">
						<label class="control-label col-md-3">Pol:</label>
						<div class="col-md-6">
							<input type="text" class="form-control" required>
						</div>
				</div>
	 			<div class="form-group">
						<label class="control-label col-md-3">Visina:</label>
						<div class="col-md-6">
							<input type="text" class="form-control" required>
						</div>
				</div>
	 			<div class="form-group">
						<label class="control-label col-md-3">Tezina:</label>
						<div class="col-md-6">
							<input type="text" class="form-control" required>
						</div>
				</div>
	 			<div class="form-group">
						<label class="control-label col-md-3">Krvna grupa:</label>
						<div class="col-md-6">
							<input type="text" class="form-control" required>
						</div>
				</div>
	 			<div class="form-group">
						<label class="control-label col-md-3">Dioptrija:</label>
						<div class="col-md-6">
							<input type="text" class="form-control" required>
						</div>
				</div>
	 			<div class="form-group">
						<label class="control-label col-md-3">Alergije na lek:</label>
						<div class="col-md-6">
							<input type="text" class="form-control" required>
						</div>
				</div>
	 			<div class="form-group">
						<label class="control-label col-md-3">Istorija bolesti:</label>
						<div class="col-md-6">
							<input type="text" class="form-control" required>
						</div>
				</div>
	 			<div class="form-group">
						<label class="control-label col-md-3">Porodicna anamneza:</label>
						<div class="col-md-6">
							<input type="text" class="form-control" required>
						</div>
				</div>
	 			<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Sacuvaj">
				</div>

				</form>
			</div>
		</c:when> 
	
	</c:choose>
	
</body>
</html>