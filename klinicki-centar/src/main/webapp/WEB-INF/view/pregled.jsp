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
                        <h4 align="center">PREGLED</h4>
                        <hr>
                        <form action="/noviPregeld" method="POST">
					<div class="form-group">
						<label>Informacije o pregledu</label>
						<div >
							<textarea rows="10" cols="100" class="form-control" id="pregled" name="pregled" ></textarea>
						</div>
					</div>
                            
                             <div class="form-group">
                                <label for="dijagnoza">Dijagnoza</label>
                                <hr>
                                <select name=odabrana>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="/static/js/bootstrap.min.js"></script>
<script src="/static/js/app.js"></script>
</body>
</html>