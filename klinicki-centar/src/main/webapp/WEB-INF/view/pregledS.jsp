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
    <title>Pregled m.sestra</title>

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
    <!-- Main CSS-->
    <link href="/static/css/theme.css" rel="stylesheet" media="all">
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

	<c:choose>
		<c:when test="${mode=='MODE_LEKAR' }">
			<h4 align="center">PREGLED</h4>
            	<h3>Pacijent: ${pacijent.ime } ${pacijent.prezime } ${ tipD}</h3>
            	<hr>
                <form action="/noviPregledS/${pacijent.id}/${lekar.id }/${sestra.id}/${pregled.id}/${ tipD}" method="POST">		
					<div class="form-group">
						<label>Informacije o pregledu</label>
						<div >
							<textarea rows="10" cols="60" class="form-control" id="informacije" name="informacije" required></textarea>
						</div>
					</div>
                            
                    <div class="form-group">
                        <label for="dijagnozaId">Dijagnoza</label>
                        <select name=dijagnozaId>
       						<%  while(resultset.next()){ %>
          						<option><%= resultset.getString(3)%></option>
      						<% } %>
     					</select> 
     				</div>
				<hr>	
    					<label for="dijagnoza">Recept</label> 
						<c:if test="${not empty lists}">
     						<select multiple="multiple" size="5" name="lekici" required>
    							<c:forEach items="${lists}" var="lists">
      						 		<option value="${lists}">
      							  		${lists}
  							  		</option>
								</c:forEach>
							</select>
						</c:if>
    <hr>		
    
    <div class="form-group no-margin">
                                <button type="submit" class="btn btn-primary btn-block">
                                    SACUVAJ
                                </button>
                            </div>
                             </form> 
     				</c:when>
	</c:choose>			
 							
                               
                      <hr>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<%
//**Should I input the codes here?**
        }
        catch(Exception e)
        {
             out.println("wrong entry"+e);
        }

%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="/static/js/bootstrap.min.js"></script>
<script src="/static/js/app.js"></script>
<script src="/static/js/editDijagnoza.js"></script>
</body>
</html>