<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="au theme template">
    <meta name="author" content="Hau Nguyen">
    <meta name="keywords" content="au theme template">
	<link rel="shortcut icon" href="#" />
	
    <!-- Title Page-->
    <title>Calendar</title>

  
    <!-- Bootstrap CSS-->
	<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
    <!-- Vendor CSS-->
  
    <link href="/static/js/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all">
    <link href="/static/js/wow/animate.css" rel="stylesheet" media="all">
    <link href="/static/js/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all">
    <link href="/static/js/slick/slick.css" rel="stylesheet" media="all">
    <link href="/static/js/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="/static/js/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all">

    <!-- FullCalendar -->
    <link href='/static/js/fullcalendar-3.10.0/fullcalendar.css' rel='stylesheet' media="all" />

    <!-- Main CSS-->
    <link href="static/css/theme.css" rel="stylesheet" media="all">

    <style type="text/css">
    /* force class color to override the bootstrap base rule
       NOTE: adding 'url: #' to calendar makes this unneeded
     */
    .fc-event, .fc-event:hover {
          color: #fff !important;
          text-decoration: none;
    }
    </style>

</head>

<body class="my-login-page">
<div role="navigation">
		<div class="navbar navbar-inverse">
			<div class="navbar-collapse collapse">
			<h2>LEKAR</h2>
				<ul class="nav navbar-nav">
					<li><a href="/pregledSvihPacijenataMetoda">Svi pacijenti</a></li>
					<li><a href="/pacijenti">Prikazi profil pacijenta</a></li>
					<li><a href="/zakazivanjePregleda">Zakazi pregled</a></li>
					<li><a href="/radniKalendar?id=${id}">Radni kalendar</a></li>
					<li><a href="/logout">Odjavi se</a></li>
				</ul>
			
			</div>
		</div>
	</div>
	
	<c:choose>
		<c:when test="${mode=='MODE_ZKARTON' }">
			<div class="container text-center">
				<h3>Pregled</h3>
				<hr>
			</div>
		</c:when>
	</c:choose>

    <!-- Jquery JS-->
    <script src="/static/js/jquery-3.2.1.min.js"></script>
    <!-- Bootstrap JS-->
    <script src="/static/js/bootstrap-4.1/popper.min.js"></script>
    <script src="/static/js/bootstrap-4.1/bootstrap.min.js"></script>
    <!-- Vendor JS       -->
    <script src="/static/js/slick/slick.min.js">
    </script>
    <script src="/static/js/wow/wow.min.js"></script>
    <script src="/static/js/bootstrap-progressbar/bootstrap-progressbar.min.js">
    </script>
    <script src="/static/js/counter-up/jquery.counterup.min.js">
    </script>
    <script src="/static/js/circle-progress/circle-progress.min.js"></script>
    <script src="/static/js/perfect-scrollbar/perfect-scrollbar.js"></script>
    <script src="/static/js/chartjs/Chart.bundle.min.js"></script>
    <script src="/static/js/select2/select2.min.js"></script>

    <!-- full calendar requires moment along jquery which is included above -->
    <script src="/static/js/fullcalendar-3.10.0/lib/moment.min.js"></script>
    <script src="/static/js/fullcalendar-3.10.0/fullcalendar.js"></script>


</body>

</html>
<!-- end document-->