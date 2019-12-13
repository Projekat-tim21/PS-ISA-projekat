<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta charset="ISO-8859-1">
<title>Zdravstveni Karton</title>

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
					<li><a href="/naLogin?id=${id}">Vrati se nazad</a></li>
					<li><a href="/logout">Odjavi se</a></li>
				</ul>

			</div>
		</div>
	</div>



	<c:choose>
		<c:when test="${mode=='MODE_ZKARTON' }">
			<div class="container text-center">
				<h3>Zdravstveni karton</h3>
				<hr>
				<form class="form-horizontal" name="forma" >
					<div class="form-group">
	 					<label class="control-label col-md-3">Id</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="id" name="id"
								value="${korisnik.id}" readonly> <span id="free"></span>
						</div>
					</div>
					<div>
						<h4>Licni podaci</h4>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Ime</label>
						<div class="col-md-6">
							<input type="text" class="form-control" name="ime"
								value="${korisnik.ime }" readonly>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Prezime</label>
						<div class="col-md-6">
							<input type="text" class="form-control" name="prezime"
								value="${korisnik.prezime }" readonly>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Datum rodjenja</label>
						<div class="col-md-6">
							<input type="text" class="form-control" name="datum"
								value="${korisnik.datum }" readonly>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Jedinstveni broj
							osiguranika-unesite samo brojeve </label>
						<div class="col-md-6">
							<input type="number" class="form-control" name="jedBrOsig"
								value="${korisnik.jedBrOsig }" readonly>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Pol</label>
						<div class="col-md-6">
							<input type="text" class="form-control" name="pol"
								value="${korisnik.pol }" readonly>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Visina</label>
						<div class="col-md-6">
							<input type="text" class="form-control" name="visina"
								value="${korisnik.visina }" readonly>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Tezina</label>
						<div class="col-md-6">
							<input type="text" class="form-control" name="tezina"
								value="${korisnik.tezina }" readonly>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Krvna grupa</label>
						<div class="col-md-6">
							<input type="text" class="form-control" name="kgrupa"
								value="${korisnik.kgrupa }" readonly>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Dioptrija</label>
						<div class="col-md-6">
							<input type="text" class="form-control" name="dioptrija"
								value="${korisnik.dioptrija }" readonly>
						</div>
					</div>
					<p></p>
					<hr>
					<div>
					<h4>Podaci o istoriji bolesti</h4>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Alergije na lek</label>
						<div class="col-md-6">
							<textarea rows="4" cols="80" class="form-control" id="alergije" name="alergije" readonly></textarea>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Istorija bolesti</label>
						<div class="col-md-6">
							<textarea rows="4" cols="80" class="form-control" id="bolesti" name="bolesti" readonly></textarea>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Porodicna anamneza</label>
						<div class="col-md-6">
							<textarea rows="4" cols="80" class="form-control" id="anamneza" name="anamneza" readonly></textarea>
						</div>
					</div>
					
					
				
					<div class="form-group ">
				<h3>		<a href="/naLogin?id=${id}">Vrati se nazad</a> </h3>
					</div>
				</form>
			</div>
		</c:when>







	</c:choose>



<script type="text/javascript">
var alergijee ='${korisnik.alergije}';
var bolestii= '${korisnik.bolesti}';
var anamnezaa='${korisnik.anamneza}';
document.getElementById('alergije').value = alergijee;
document.getElementById('bolesti').value = bolestii;
document.getElementById('anamneza').value = anamnezaa;


var getUrlParameter = function getUrlParameter(sParam) {
    var sPageURL = window.location.search.substring(1),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : decodeURIComponent(sParameterName[1]);
        }
    }
};

var idPacijenta = getUrlParameter('id');
console.log(idPacijenta);

function addIdPac (element){
	element.href = element.href+"?id="+idPacijenta;
	console.log(element.href);
}


</script>


	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>