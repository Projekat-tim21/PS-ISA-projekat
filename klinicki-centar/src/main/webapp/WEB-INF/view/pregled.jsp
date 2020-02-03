<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<%ResultSet resultset =null;%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <title>Pregled</title>

  
    <!-- Bootstrap CSS-->
	<link href="/static/css/bootstrap.min.css" rel="stylesheet">
<link href="/static/css/style.css" rel="stylesheet">
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
    <link href="/static/css/theme.css" rel="stylesheet" media="all">

    <style type="text/css">
    /* force class color to override the bootstrap base rule
       NOTE: adding 'url: #' to calendar makes this unneeded
     */
    .fc-event, .fc-event:hover {
          color: #fff !important;
          text-decoration: none;
    }
      body {
      height:100%;
      margin:0;
      padding:0;
      font-family: Arial, Helvetica, sans-serif;
      }
      h2 {
      font-size: 20px;
      color: #000000;
      }
      #example {
      visibility: hidden;
      position: absolute;
      left: 0;
      top: 0;
      width:100%;
      height:100%;
      text-align:center;
      z-index: 1000;
      }
      #example div {
      width:400px;
      height:300px;
      margin: 100px auto;
      background-color: #f2f2f2;
      border-radius: 10px;
      -webkit-border-radius: 10px;
      -moz-border-radius:  10px;
      border:1px solid #666666;
      padding:15px;
      text-align:center;
      font-weight: bold;
      font-size: 15px;
      border: 3px solid #cccccc;
      position: absolute;
      left: 50%;
      top: 100px;
      transform: translate(-50%, -50%);
      -ms-transform: translate(-50%, -50%);
      -webkit-transform: translate(-50%, -50%);
      }
      
      .button {
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 16px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 12px;
  margin: 2px 500px;
  -webkit-transition-duration: 0.4s; /* Safari */
  transition-duration: 0.4s;
  cursor: pointer;
}

.button1 {
  background-color: white; 
  color: black; 
  border: 2px solid #4CAF50;
}

.button1:hover {
  background-color: #4CAF50;
  color: white;
}

.button2 {
  background-color: white; 
  color: black; 
  border: 2px solid #008CBA;
}

.button2:hover {
  background-color: #008CBA;
  color: white;
}

.wrapper {
    text-align: center;
}

.example_e {
border: none;
background: #404040;
color: #ffffff !important;
font-weight: 100;
padding: 20px;
text-transform: uppercase;
border-radius: 6px;
display: inline-block;
transition: all 0.3s ease 0s;
}

.example_e:hover {
color: #404040 !important;
font-weight: 700 !important;
letter-spacing: 3px;
background: none;
-webkit-box-shadow: 0px 5px 40px -10px rgba(0,0,0,0.57);
-moz-box-shadow: 0px 5px 40px -10px rgba(0,0,0,0.57);
transition: all 0.3s ease 0s;
}

/* The Modal (background) */
.modal {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  padding-top: 100px; /* Location of the box */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* The Modal (background) */
.modall {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  padding-top: 100px; /* Location of the box */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}


/* Modal Content */
.modal-content {
  background-color: #fefefe;
  margin: auto;
  padding: 20px;
  border: 1px solid #888;
  width: 80%;
}

/* Modal Content */
.modal-contentt {
  background-color: #fefefe;
  margin: auto;
  padding: 20px;
  border: 1px solid #888;
  width: 80%;
}

/* The Close Button */
.close {
  color: #aaaaaa;
  float: right;
  font-size: 28px;
  font-weight: bold;
}

/* The Close Button */
.closee {
  color: #aaaaaa;
  float: right;
  font-size: 28px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: #000;
  text-decoration: none;
  cursor: pointer;
}

    </style>

</head>

<body class="my-login-page">

<%
    try{
//Class.forName("com.mysql.jdbc.Driver").newInstance();
Connection connection = 
         DriverManager.getConnection
            ("jdbc:postgresql://localhost:5432/jpa?user=postgres&password=root");

       Statement statement = connection.createStatement() ;

       resultset =statement.executeQuery("select * from dijagnoza") ;
%>


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

<section class="h-100">
    <div class="container h-100">
        <div class="row justify-content-md-center h-100">
            <div class="card-wrapper">
                <div class="card fat">
                    <div class="card-body">
                    <c:choose>
		<c:when test="${mode=='MODE_ZKARTON' }">
			<div class="container text-center">
				<h3>Pacijent: ${korisnik.ime } ${korisnik.prezime } </h3>
				<hr>
			</div>
		</c:when>
	</c:choose>
	
	   <c:choose>
		<c:when test="${mode=='MODE_LEKAR' }">
			
		</c:when>
	</c:choose>
                        <h4 align="center">PREGLED</h4>
                        <hr>
                        <form action="/noviPregled/${korisnik.id}/${lekar.id }" method="POST">
					<div class="form-group">
						<label>Informacije o pregledu</label>
						<div >
							<textarea rows="10" cols="100" class="form-control" id="informacije" name="informacije" ></textarea>
						</div>
					</div>
                            
                             <div class="form-group">
                                <label for="dijagnozaId">Dijagnoza</label>
                                <hr>
                                <select name=didi>
       								 <%  while(resultset.next()){ %>
          							  <option><%= resultset.getString(3)%></option>
      									  <% } %>
     						   </select> </div>
     					
    <label for="dijagnoza">Recept</label> 
     				  <hr>

<c:if test="${not empty lists}">
     				<select multiple="multiple" size="5" name="database1">
    					<c:forEach items="${lists}" var="lists">
      						 <option value="${lists}">
      							  ${lists}
  							  </option>
						</c:forEach>
					</select>
					</c:if>
     		<hr>		
     				<div class="button_cont" id="myBtn" align="center"><button class="example_e" target="_blank" rel="nofollow noopener">Zakazi operaciju</button></div>
     				<!-- The Modal -->
						<div id="myModal" class="modal">

 					 <!-- Modal content -->
  						<div class="modal-content">
  						  <span class="close">&times;</span>
   							 <p>Zakazivanje operacije</p>
   							 <form method="POST" action="sacuvajOperaciju">
   							 <input type="datetime-local" name="terminoperacija" id="terminoperacija"/>
									<input type="hidden" id="idlekaroperacija" name="idlekaroperacija" value="${lekar.id }"> 
									<input type="hidden" id="pacijentId" name="pacijentId" value="${korisnik.id}"> 
  							<input type="submit" name="zakazi">
  							</div>

						</div>
     				<hr>
     				
     				<div class="button_cont" id="myBtn1" align="center"><button class="example_e"  target="_blank" rel="nofollow noopener">Zakazi pregled</button></div>
					<!-- The Modal -->
						<div id="myModal1" class="modall">

 					 <!-- Modal content -->
  						<div class="modal-contentt">
  						  <span class="closee">&times;</span>
   							 <p>Novi</p>
  							</div>

						</div>
<hr>
<%
//**Should I input the codes here?**
        }
        catch(Exception e)
        {
             out.println("wrong entry"+e);
        }

%>
							
 							<div class="form-group no-margin">
                                <button type="submit" class="btn btn-primary btn-block">
                                    SACUVAJ
                                </button>
                            </div>
                        </form>
                        
                        	   <hr>
     				
     				
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<script>// Get the modal
var modal = document.getElementById("myModal");

//Get the button that opens the modal
var btn = document.getElementById("myBtn");

//Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

//When the user clicks the button, open the modal 
btn.onclick = function() {
modal.style.display = "block";
}

//When the user clicks on <span> (x), close the modal
span.onclick = function() {
modal.style.display = "none";
}

//When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
if (event.target == modal) {
 modal.style.display = "none";
}
}

var modal1 = document.getElementById("myModal1");

//Get the button that opens the modal
var btn1 = document.getElementById("myBtn1");

//Get the <span> element that closes the modal
var span1 = document.getElementsByClassName("closee")[0];
//When the user clicks the button, open the modal 
btn1.onclick = function() {
modal1.style.display = "block";
}

//When the user clicks on <span> (x), close the modal
span1.onclick = function() {
modal1.style.display = "none";
}

//When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
if (event.target == modal1) {
 modal1.style.display = "none";
}
}

function izbaciAlert(){
	alert("Uspesno kreirana operacija");
	}

function izbaciAlertP(){
	alert("Uspesno kreiran pregled");
	}
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="/static/js/bootstrap.min.js"></script>
<script src="/static/js/app.js"></script>
</body>
</html>