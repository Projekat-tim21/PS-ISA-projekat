<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
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
    	  var events = [
    	    {
    	      title: "Pregled",
    	      start: moment().format('YYYY-MM-DD'),
    	      url: '/zapocniOperacijeP'
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
                              console.log("startDate :"+termin);
                              console.log("isoString: " + startDate.toISOString());
                              var sala=result[i].sala;
                              var cena=result[i].cena;
                              var event={
                                      title:'Unapred definisan termin', 
                                      start:startDate.toISOString(),
                                      allDay: false,
                                      url:'/zapocniOperacijeP'
                                      };
                              
                              termini.push({
                                  title:"Unapred definisan termin", 
                                  start:startDate.toISOString(),
                                  allDay: false,
                                  url:'/zapocniOperacijeP'
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

	<div id='calendar'></div>

</body>
</html>
