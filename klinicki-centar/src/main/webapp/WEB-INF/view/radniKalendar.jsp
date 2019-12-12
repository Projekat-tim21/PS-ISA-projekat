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

    <!-- Title Page-->
    <title>Calendar</title>

    <!-- Fontfaces CSS-->
    <link href="/static/css/font-face.css" rel="stylesheet" media="all">
    <link href="/static/js/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <link href="/static/js/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
    <link href="/static/js/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">

    <!-- Bootstrap CSS-->
	<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
    <!-- Vendor CSS-->
    <link href="/static/js/animsition/animsition.min.css" rel="stylesheet" media="all">
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

<!-- animsition overrides all click events on clickable things like a,
      since calendar doesn't add href's be default,
      it leads to odd behaviors like loading 'undefined'
      moving the class to menus lead to only the menu having the effect -->
<body class="my-login-page">
<div role="navigation">
		<div class="navbar navbar-inverse">
			<div class="navbar-collapse collapse">
			<h2>ADMINISTRATOR</h2>
				<ul class="nav navbar-nav">
					<li><a href="/pregledSvihPacijenataMetoda">Svi pacijenti</a></li>
					<li><a href="/pacijenti">Prikazi profil pacijenta</a></li>
					<li><a href="/zakazivanjePregleda">Zakazi pregled</a></li>
					<li><a href="/radniKalendar">Radni kalendar</a></li>
				</ul>
			
			</div>
		</div>
	</div>

                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col">
                              <div class="au-card">
                                <div id="calendar"></div>
                              </div>
                            </div><!-- .col -->
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="copyright">
                                    <p>Copyright © 2018 Colorlib. All rights reserved. Template by <a href="https://colorlib.com">Colorlib</a>.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

    <!-- Jquery JS-->
    <script src="/static/js/jquery-3.2.1.min.js"></script>
    <!-- Bootstrap JS-->
    <script src="/static/js/bootstrap-4.1/popper.min.js"></script>
    <script src="/static/js/bootstrap-4.1/bootstrap.min.js"></script>
    <!-- Vendor JS       -->
    <script src="/static/js/slick/slick.min.js">
    </script>
    <script src="/static/js/wow/wow.min.js"></script>
    <script src="/static/js/animsition/animsition.min.js"></script>
    <script src="/static/js/bootstrap-progressbar/bootstrap-progressbar.min.js">
    </script>
    <script src="/static/js/counter-up/jquery.waypoints.min.js"></script>
    <script src="/static/js/counter-up/jquery.counterup.min.js">
    </script>
    <script src="/static/js/circle-progress/circle-progress.min.js"></script>
    <script src="/static/js/perfect-scrollbar/perfect-scrollbar.js"></script>
    <script src="/static/js/chartjs/Chart.bundle.min.js"></script>
    <script src="/static/js/select2/select2.min.js"></script>

    <!-- full calendar requires moment along jquery which is included above -->
    <script src="/static/js/fullcalendar-3.10.0/lib/moment.min.js"></script>
    <script src="/static/js/fullcalendar-3.10.0/fullcalendar.js"></script>

    <!-- Main JS-->
    <script src="/static/js/main.js"></script>

    <script type="text/javascript">
$(function() {
  // for now, there is something adding a click handler to 'a'
  var tues = moment().day(2).hour(19);

  // build trival night events for example data
  var events = [
    {
      title: "Special Conference",
      start: moment().format('YYYY-MM-DD'),
      url: '#'
    },
    {
      title: "Doctor Appt",
      start: moment().hour(9).add(2, 'days').toISOString(),
      url: '#'
    }

  ];

  var trivia_nights = []

  for(var i = 1; i <= 4; i++) {
    var n = tues.clone().add(i, 'weeks');
    console.log("isoString: " + n.toISOString());
    trivia_nights.push({
      title: 'Trival Night @ Pub XYZ',
      start: n.toISOString(),
      allDay: false,
      url: '#'
    });
  }

  // setup a few events
  $('#calendar').fullCalendar({
    header: {
      left: 'prev,next today',
      center: 'title',
      right: 'month,agendaWeek,agendaDay,listWeek'
    },
    events: events.concat(trivia_nights)
  });
});


$(document).ready(function() {
	$('#calendar').fullCalendar({
		header: {
			left: 'prev,next today',
			center: 'title',
			right: 'month,agendaWeek,agendaDay'
		},
		defaultDate: '2019-06-01',
		editable: true,
		eventLimit: true, // allow "more" link when too many events
		events: {
	        url: '/lekaruu',
	        type: 'GET',
	        error: function() {
	            alert('there was an error while fetching events!');
	        },
	        //color: 'blue',   // a non-ajax option
	        //textColor: 'white' // a non-ajax option
	    }
	});
});

</script>
</body>

</html>
<!-- end document-->