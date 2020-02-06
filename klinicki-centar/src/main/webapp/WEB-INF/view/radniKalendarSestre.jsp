<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<%ResultSet resultset =null;%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<style>
.btn-group button {
  background-color: #D3D3D3; /* Green background */
  border: 1px solid green; /* Green border */
  color: white; /* White text */
  padding: 30px 24px; /* Some padding */
  cursor: pointer; /* Pointer/hand icon */
  float: center; /* Float the buttons side by side */
}

/* Clear floats (clearfix hack) */
.btn-group:after {
  content: "";
  clear: both;
  display: table;
}

.btn-group button:not(:last-child) {
  border-right: none; /* Prevent double borders */
}

/* Add a background color on hover */
.btn-group button:hover {
  background-color: #3e8e41;
}
</style>
<meta charset='utf-8' />
<link rel="shortcut icon" href="#">
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<link href='/static/fullcalendar.css' rel='stylesheet' />
<link href='/static/fullcalendar.print.css' rel='stylesheet' media='print' />
<script src='/static/lib/moment.min.js'></script>
<script src='/static/lib/jquery.min.js'></script>
<script src='/static/fullcalendar.min.js'></script>
    <script type="text/javascript">
  
    var termini=[]
    $(function() {
    	  // for now, there is something adding a click handler to 'a'
    	  var tues = moment().day(2).hour(19);
    	  // build trival night events for example data
    	  var events = [ ];
    	
   	$.ajax({
              url: '/getCalendarSestra?id=${id}',
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
                              var tipEventa=result[i].tipEventa;
                              var startDate = new Date(termin);
                              var idkorisnika=result[i].idkorisnika;
                              var odobrenpregled=result[i].odobrenpregled;
                              var ime=result[i].pacijentime;
                              var prezime=result[i].pacijentprezime;
                              var tip=result[i].tippregleda;
                              var sala=result[i].sala;
                              var cena=result[i].cena;
                              var id=result[i].id;
                              var idEventa=result[i].idEventa;
                              var lekarId=result[i].lekarId;
                              
                              termini.push({
                                  title: tipEventa+" --> " +'Tip '+tip +'--'+'Sala: ' + sala+ '--'+'Pacijent: '+ ime+' '+prezime, 
                                  start:startDate.toISOString(),
                                  allDay: false,
                                  url:'/zapocniOperacijeS/'+idEventa+'/'+id+'/'+idkorisnika+'/'+lekarId+'/'+${korisnik.id }
                                  });

                              
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
                         	      right: 'year,month,agendaWeek,agendaDay,listWeek'
                         	    },
                         	   firstMonth: 1, // september
                   			//firstMonth: 0,
                   			//lastMonth: 6,
                   			
                   			selectable: true,
                   			selectHelper: true,
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



<style>
* {
        margin: 0;
        padding: 0;
        border: 0;
        outline: 0;
        font-size: 100%;
        vertical-align: baseline;
        background: transparent;
    }

	body {
		
		padding: 0;
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
		font-size: 14px;
	}

	#calendar {
		max-width: 900px;
		margin: 0 auto;
	}

</style>
</head>
<body>

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

<c:choose>
		<c:when test="${mode=='MODE_ZKARTON' }">
			<!-- <div class="container text-center">
				<h3>Radni kalendar -> ${korisnik.ime } ${korisnik.prezime }</h3>
				<hr>
			</div>-->
		</c:when>
	</c:choose>
	
	<div id='calendar'></div>

</body>
</html>
