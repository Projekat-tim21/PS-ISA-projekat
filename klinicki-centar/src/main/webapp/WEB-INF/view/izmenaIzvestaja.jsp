<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<%ResultSet resultset =null;%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta charset="ISO-8859-1">
<title>Izmena izvestaja</title>
  <base href="/">
   <link rel="shortcut icon" href="#" />
<link href="/static/css/bootstrap.min.css" rel="stylesheet">
<link href="/static/css/style.css" rel="stylesheet">
<link href="/static/css/theme.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
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

<c:choose>
	
		<c:when test="${mode=='MODE_ZKARTON' }">
			<div class="container text-center">
				<h3>Izmena podataka izvestaja</h3>
				<hr>
				<div>
						<label class="control-label col-md-4">Pacijent</label>
						<label >${novi.pacijentId }</label>
				</div>
				<div>
						<label class="control-label col-md-4">Lekar</label>
						<label >${novi.lekarId }</label>
				</div>
				<div>
						<label class="control-label col-md-4">Pregled</label>
						<label >${novi.informacije }</label>
				</div>
				<div>
						<label class="control-label col-md-4">Dijagnoza</label>
						<label >${novi.dijagnozaId }</label>
				</div>
				<div>
						<label class="control-label col-md-4">Recept</label>
					<c:forEach var="lek" items="${novi.leks }">
					<label >${lek.naziv }</label>
					</c:forEach>
				</div>
		<hr>
				<form class="form-horizontal" method="POST"
					action="sacuvajIzmeneIzvestaja/${novi.id }/${novi.lekarId }/${novi.pacijentId }">

					<div class="form-group">
						<label class="control-label col-md-3">Informacije</label>
						<div >
							<textarea rows="6" cols="50" class="form-control" id="informacije" name="informacije"></textarea>
						</div>
					</div>
					<div class="form-group">
						<div class="form-group">
                        <label for="dijagnozaId">Dijagnoza</label>
                        <select name=dijagnozaId >
       						<%  while(resultset.next()){ %>
          						<option><%= resultset.getString(3)%></option>
      						<% } %>
     					</select> 
     				</div>
					</div>
					
					<div class="form-group">
						<label for="dijagnoza">Lekovi</label>
						<c:if test="${not empty lists}">
     						<select multiple="multiple" size="5" name="lekici" >
    							<c:forEach items="${lists}" var="lists">
      						 		<option value="${lists}">
      							  		${lists}
  							  		</option>
								</c:forEach>
							</select>
						</c:if>
					</div>

					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Izmeni">
					</div>
				</form>
			</div>


		</c:when>



	</c:choose>
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
</body>
</html>