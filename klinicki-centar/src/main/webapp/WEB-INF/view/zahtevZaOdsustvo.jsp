<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta charset="ISO-8859-1">
<title>Sestra</title>
<base href="/"> 
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<link href="static/css/theme.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 <link rel="shortcut icon" href="#" />
</head>
<body class="my-login-page">
<div role="navigation">
		<div class="navbar navbar-inverse">
			<div class="navbar-collapse collapse">
			<h2>MEDICINSKA SESTRA</h2>
				<ul class="nav navbar-nav">
				<li><a href="/sviSestraPacijenti">Svi pacijenti</a></li>
				<li><a href="/overaRecepta">Overa recepata</a></li>
				<li><a href="/zahtevZaOdsustvo?id=${id}">Odsustvo/Odmor</a></li>
				<li><a href="/radniKalendarSestre?id=${id}">Radni kalendar</a></li>
				<li><a href="/profilSestra?id=${id}">Profil</a></li>
					<li><a href="/logout">Odjavi se</a></li>
				</ul>
			
			</div>
		</div>
	</div>
	
<section class="h-100">
    <div class="container h-100">
        <div class="row justify-content-md-center h-100">
            <div class="card-wrapper">
                <div class="card fat">
                    <div class="card-body">
                        <h3 class="card-title">Kreiraj zahtev za odsustvo/odmor</h3>
                        <hr>
                        <c:if test="${not empty param.error}">
                            <label id="error" class="alert alert-danger">${param.error}</label>
                        </c:if>
			<form method="POST" action="zahtevZaOdsustvoo/${id}">
			 <hr>
				<label>Pocetak odsustva/odmora</label>
				<input type="date" name="pocetak" id="pocetak"
					/>
					 <hr>
					<label>Kraj odsustva/odmora</label>
				<input type="date" name="kraj" id="kraj"
					 />	
				 <hr>
					<div>
					<input type="submit" name="Posalji" onclick="izbaciAlert()">
					</div>
			</form>

			<!-- ovaj button za sada nije potreban -->

			<!-- 	<button onclick="ispis();">ispisi</button>   -->
</div>
                </div>
              
            </div>
        </div>
    </div>
</section>
		
	
<script type="text/javascript">
$( "#datepicker" ).datepicker({ minDate: 0});


function izbaciAlert(){
	alert("Zahtev za odsustvo/odmor uspesno poslat");
	}


var dateToday = new Date(); 
$(function() {
    $( "#pocetak" ).datepicker({
        numberOfMonths: 3,
        showButtonPanel: true,
        minDate: dateToday
    });
});



</script>	



<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>
<script src="static/js/app.js"></script>
<script src="static/js/edit.js"></script>
</body>
</html>