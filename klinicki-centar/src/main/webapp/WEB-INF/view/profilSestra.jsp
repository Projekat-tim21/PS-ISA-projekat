<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta charset="ISO-8859-1">
<title>Pregled informacija</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<link rel="shortcut icon" href="#" />

</head>
<body>
 
	
<div role="navigation">
		<div class="navbar navbar-inverse">
			<div class="navbar-collapse collapse">
			<h2>MEDICINSKA SESTRA</h2>
				<ul class="nav navbar-nav">
					<li><a href="/sviSestraPacijenti">Svi pacijenti</a></li>
					<li><a href="/zahtevZaOdsustvo?id=${id}">Odsustvo/Odmor</a></li>
					<li><a href="/profilSestra?id=${id}">Profil</a></li>
					
					<li><a href="/radniKalendarSestre?id=${id}">Radni kalendar</a></li>
					<li><a href="/logout">Odjavi se</a></li>
				</ul>
			
			</div>
		</div>
	</div>


	<c:choose>
		<c:when test="${mode=='MODE_PREGLED' }">
			<div class="container text-center">
				<h3>Pregled podataka</h3>
				<hr>
					</div>
				<div>
						<label class="control-label col-md-4">Korisnicko ime</label>
						<label >${korisnik.username }</label>
				</div>
				<div>
						<label class="control-label col-md-4">Ime</label>
						<label >${korisnik.ime }</label>
				</div>
				<div>
						<label class="control-label col-md-4">Prezime</label>
						<label >${korisnik.prezime }</label>
				</div>
				<div>
						<label class="control-label col-md-4">JMBG</label>
							<label>${korisnik.jedBrOsig }</label>
				</div>
				<div>
						<label class="control-label col-md-4">Email</label>
						<label >${korisnik.email }</label>
				</div>
						<label class="control-label col-md-4">Adresa</label>
						<label >${korisnik.adresa }</label>
				<div>
						<label class="control-label col-md-4">Grad</label>
						<label >${korisnik.grad }</label>
					</div>
					<div>
						<label class="control-label col-md-4">Drzava</label>
						<label >${korisnik.drzava }</label>
				</div>
				<div>
						<label class="control-label col-md-4">Telefon</label>
						<label >${korisnik.telefon }</label>
						
						</div>
					<hr>
					<div class="form-group ">
					<!-- <input type="button" value="Izmeni podatke" style="position: absolute; center: 0;" formaction="/izmenaProfilaSestra?id=${id}"> -->
					<button class="au-btn au-btn-icon au-btn--green au-btn--small">
                                            <i class="zmdi zmdi-plus"><a class="nav-link" href="/izmenaPodatakaSestre/${id}">IZMENA PROFILA</a></i></button>
                                   
					</div>
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