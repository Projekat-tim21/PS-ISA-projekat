<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta charset="ISO-8859-1">
<title>Zahtev za pregled</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">

<style>
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
					<li><a onclick="addIdPac(this)" href="/login">Logovanje</a></li>
				
				</ul>
			
			</div>
		</div>
	</div>

<c:choose>


<c:when test="${mode=='VRACAJ_SE_NAZAD' }">
		<a onclick="addIdPac(this)" href="/vratiSeNaLoginBezDobrodosli2">Vrati se nazad</a>
		</c:when>




	<c:when test="${mode=='ZAKAZI_PREGLED' }">
			<div class="container text-center">
				<h3>Posalji zahtev za pregled</h3>
				<hr>
				<form class="form-horizontal" method="GET" action="vratiSeNaLoginBezDobrodosli2"   >
				
					<div class="form-group">
						<label class="control-label col-md-3">Termin</label>
						<div class="col-md-6">
							<input type="text"  class="form-control" id="id" name="termin"
								value="${termini.termin }" readonly>
								<span id="free"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Ime lekara</label>
						<div class="col-md-6">
							<input type="text"  class="form-control" id="ime" name="ime"
								value="${lipi.ime }" readonly>
								<span id="free"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Prezime lekara</label>
						<div class="col-md-6">
							<input type="text"  class="form-control" id="prezime" name="prezime"
								value="${lipi.prezime }" readonly>
								<span id="free"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Tip specijalizacije</label>
						<div class="col-md-6">
							<input type="text"  class="form-control" id="tipspecijalizacije" name="tipspecijalizacije"
								value="${lipi.tipspecijalizacije }" readonly>
								<span id="free"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Ime pacijenta</label>
						<div class="col-md-6">
							<input type="text"  class="form-control" id="imepac" name="ime"
								value="${korisnik.ime }" readonly>
								<span id="free"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Prezime pacijenta</label>
						<div class="col-md-6">
							<input type="text"  class="form-control" id="prezimepac" name="prezime"
								value="${korisnik.prezime }" readonly>
								<span id="free"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Jedinstrveni broj osiguranika</label>
						<div class="col-md-6">
							<input type="text"  class="form-control" id="prezimepac" name="prezime"
								value="${korisnik.jedBrOsig }" readonly>
								<span id="free"></span>
						</div>
					</div>
					
					
				
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="posalji">
					</div>
				</form>
			</div>
			<a onclick="addIdPac(this)" href="/saljemoZahtevZaPregledom">Vrati se nazad</a>
		</c:when>
</c:choose>

<script type="text/javascript">
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

var idPacijenta = getUrlParameter('idpac');
console.log(idPacijenta);

function addIdPac (element){
	element.href = element.href+"?id="+idPacijenta;
	console.log(element.href);
}

//window.onload = function() {
//   var getInput = prompt("Hey type something here: ");
//   localStorage.setItem("storageName",getInput);
//}
</script>
</body>
</html>