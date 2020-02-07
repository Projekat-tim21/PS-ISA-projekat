<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta charset="ISO-8859-1">
<title>Sale</title>
<link href="/static/css/bootstrap.min.css" rel="stylesheet">
<link href="/static/css/style.css" rel="stylesheet">
<link href="/static/css/theme.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<body>
 
<div role="navigation">
		<div class="navbar navbar-inverse">
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
				<li><a href="/AdminPraviPreglede">Prikaz lekara</a></li>
				<li><a href="/zahteviZaPregledom">Odobravanje zahteva</a></li>
				<li><a href="/prikaziOperacijeBezSale">Sale za operaciju</a></li>
				<li><a href="/logout">Odjavi se</a></li>
				</ul>

			</div>
		</div>
	</div>
	<c:choose>
		<c:when test="${mode=='MODE_LEKARI' }">
		
			<h4 align="center">Lekari koji moraju da prisustvuju operaciji</h4>
                <form action="/obavezniLekari/${operacija.id}/${sala.id }" method="POST">
						<hr>
						<div align="center">
						<c:if test="${not empty lists}">
     						<select multiple="multiple" size="5" name="lekari">
    							<c:forEach items="${lists}" var="lists">
      						 		<option value="${lists.id} ${lists.ime}  ${lists.prezime}">
      							  		 ${lists.id} ${lists.ime} ${lists.prezime}
  							  		</option>
								</c:forEach>
							</select>
						</c:if>
						</div>
   						 <hr>
   						 <div class="form-group no-margin">
                                <button type="submit" class="btn btn-primary btn-block">
                                    SACUVAJ
                                </button>	
                                </div>	
  					  </form>
     		
     		</c:when>
     		</c:choose>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="/static/js/bootstrap.min.js"></script>
<script src="/static/js/app.js"></script>
<script src="/static/js/editDijagnoza.js"></script>
</body>
</html>
