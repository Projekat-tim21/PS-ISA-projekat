<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0);
//prevents caching at the proxy server
%>
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

  
    <!-- Bootstrap CSS-->
	<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<link rel="shortcut icon" href="favicon.ico">
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
				<h3>Postovani dr ${korisnik.ime } ${korisnik.prezime } ovako izgleda vas radni kalendar</h3>
				<hr>
			</div>
		</c:when>
	</c:choose>

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

    <!-- Main JS-->
    <script type="text/javascript">
    var termini=[]
    $(function() {
    	  // for now, there is something adding a click handler to 'a'
    	  var tues = moment().day(2).hour(19);
    	  // build trival night events for example data
    	  var events = [
    	    {
    	      title: "Pregled",
    	      start: moment().format('YYYY-MM-DD'),
    	      url: '/zapocniOperacijeP})'
    	    },
    	    {
    	      title: "Operacija",
    	      start: moment().hour(9).add(2, 'days').toISOString(),
    	      url: '/zapocniOperacijeP'
    	    },
    	    {
      	      title: "Operacija",
      	      start: "2019-12-19T10:30:00",
      	      url: '/zapocniOperacijeP'
      	    },
      	  {
        	      title: "Pregled",
        	      start: "2019-12-18T07:30:00",
        	      url: '/zapocniOperacijeP'
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
   	$.ajax({
              url: '/getCalendar?id=${id}',
              type: "GET",
              headers:{
                  'Accept' : 'application/json',
                  'Content-Type': 'application/json'
                  },
              success: function (result) {
              	
              	if(result!== null){
                      var len = result.length;
                      
                      if(len > 0){
                          var jsonString = JSON.stringify(result);
                          console.log(jsonString);
                          for(var i=0; i<len; i++){
                              console.log(result[i]);
                              var termin=result[i].termin;
                              var startDate = new Date(termin);
                              var sala=result[i].sala;
                              var idkorisnika=result[i].idkorisnika;
                              var odobrenpregled=result[i].odobrenpregled;
                              console.log("startDate :"+idkorisnika);
                             
                              console.log("isoString: " + startDate.toISOString());
                              var cena=result[i].cena;
                              var event={
                                      title:'Unapred definisan termin'+  '<br />' +'Ljuvbavvvvvvvvvvvvvv', 
                                      start:startDate.toISOString(),
                                      description: sala,
                                      allDay: false,
                                      url:'/zapocniOperacijeP/'+idkorisnika
                                      };
                              
                              termini.push({
                                  title:"Unapred definisan termin" +  '<br />' +'Ljuvbavvvvvvvvvvvvvv', 
                                  start:startDate.toISOString(),
                                  description: sala,
                                  allDay: false,
                                  url:'/zapocniOperacijeP/'+idkorisnika
                                  });

                              eventRender: function(event, element) {
                                  element.qtip({
                                      content: event.description + '<br />' + event.start,
                                      style: {
                                          background: 'black',
                                          color: '#FFFFFF'
                                      },
                                      position: {
                                          corner: {
                                              target: 'center',
                                              tooltip: 'bottomMiddle'
                                          }
                                      }
                                  });
                              }
                                 
                          }
                          console.log("Postoji li nesto ovde? :"+termini.length);
							var rare=termini.length;
							for(var i=0; i<rare; i++){
								
                            events: events.concat(termini[i]);
							}
                            console.log("NAKON SPAJANJA JE L' IMA STO :"+events.length);
                            for(var i=0; i<rare; i++){
                            console.log("TERMINI JESU LI PRAZNI? :"+termini[i]);
                            }
                      		console.log("VREDNOSTI U TERMINI "+termini.length)
                      		 $('#calendar').fullCalendar({
                         	    header: {
                         	      left: 'prev,next today',
                         	      center: 'title',
                         	      right: 'month,agendaWeek,agendaDay,listWeek'
                         	    },
                         	       events: events.concat(termini)
                         	     
                         	       
                         	  });
                      } 
                  }else{
                      console.log("NO events");
                  }
            
              },error: function (result) {
                      console.log("AJAX error");
              }
          
           
      
    }) 
    	  // setup a few events
    	 
    	});
	
    
    </script>

</body>

</html>
<!-- end document-->