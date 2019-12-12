<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Odbijanje registracije</title>
<base href="/"> 
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<link href="static/css/theme.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>
<section class="h-100">
    <div class="container h-100">
        <div class="row justify-content-md-center">
            <div class="card">
                <div class="card-header">
 		<c:choose>
			<c:when test="${mode=='ODBIJANJE' }">
				<div class="container text-center">
					<h3>Razlog odbijanja</h3>
				<hr>
				<form class="form-horizontal" name="forma" method="POST" modelAttribute="korisnik" action="/razlogOdbijanja/${korisnik.getId()}">
					<div class="form-group">
						<label class="control-label col-md-3">Ime</label>
						<div class="col-md-6">
							<label>${korisnik.ime}</label>
							
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Prezime</label>
						<div class="col-md-6">
						<label>${korisnik.prezime}</label>
							
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-3">Email</label>
						<div class="col-md-6">
						<label name='mail'>${korisnik.email}</label>
							
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-3">Razlog odbijanja</label>
						<div class="col-md-6">
							<textarea rows="4" cols="80" class="form-control" id="razlog" name="razlog" ></textarea>
						</div>
					</div>
					
					
					
				
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Posalji">
					</div>
				</form>
			</div>
		</c:when>
	</c:choose>
	</div>
	</div>
	</div>
	</div>
	</section>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>
<script src="static/js/app.js"></script>
<script src="static/js/edit.js"></script>

</body>
</html>