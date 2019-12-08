<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta charset="ISO-8859-1">
<title>Lekovi</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<link href="static/css/theme.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<div class="navbar-collapse collapse">
			<h2>ADMINISTRATOR</h2>
			
				<ul class="nav navbar-nav">
				<li><a href="/sviIzBaze">Pregled svih</a></li>
					<li><a href="/zahteviRegistrovanje">Registrovanje korisnika</a></li>
					<li><a href="/klinike">Klinike</a></li>
					<li><a href="/pregledSvihAdmina">Administratori KC</a></li>
					<li><a href="/lekovi">Lekovi</a></li>
					<li><a href="/dijagnoze">Dijagnoze</a></li>
					<li><a href="/logout">Odjavi se</a></li>
				</ul>
			
			</div>
		</div>
	</div>
	
	
<section class="h-100">
    <div class="container h-100">
        <div class="row justify-content-md-center">
            <div class="card">
                <div class="card-header">
				<div class="table-data__tool">
                                    <div class="table-data__tool-left">
                                        <h3>LEKOVI</h3>
                                          </div>
				
                                    <div class="table-data_tool-right">
                                        <button class="au-btn au-btn-icon au-btn--green au-btn--small">
                                            <i class="zmdi zmdi-plus"><a class="nav-link" href="/addNewLek">DODAJ LEK</a></i></button>
                                    </div>
                                </div>
			
			<div class="card card-body table-responsive">
				<c:choose>
					<c:when test="${mode=='ALL_LEKOVI' }">
						<table class="table table-hover">
						<thead>
							<tr>
								<th>Id</th>
								<th>Sifra</th>
								<th>Naziv</th>
								<th>Dodatno</th>
								<th colspan="2">Izmeni/Obrisi</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="lek" items="${lekovi}">
								<tr>
									<td>
										<label>${lek.getId()}</label>
									</td>
									<td>
										<label>${lek.getSifra()}</label>
									</td>
									<td>
										<label id="fnaziv_${lek.getId()}">
											${lek.getNaziv()}
										</label>
										 <input required type="text" name="fnaziv" class="form-control"
                                                   value="${lek.getNaziv()}"
                                                   style="display: none;"
                                                   id="text_fnaziv_${lek.getId()}">
										
									</td>
									<td> <label id="fdodatno_${lek.getId()}">
                                                    ${lek.getDodatno()}
                                            </label>
                                            <input required class="form-control" type="text" name="fdodatno"
                                                   value="${lek.getDodatno()}"
                                                   style="display: none;"
                                                   id="text_fdodatno_${lek.getId()}"></td>
                                    <td>
                                            <a href="/update" id="update_${lek.getId()}" class="updateData"
                                               onclick="event.preventDefault();"><span class="btn-label"><img src="static/svg/tools.svg"></span></a>
                                            <a href="/saveLek" id="save_${lek.getId()}" class="saveData"
                                               onclick="event.preventDefault();saveData(${lek.getId()});"
                                               style="display: none;"><span class="btn-label"><img src="static/svg/diff.svg"></span></a>
                                        </td>
                                        <td><a href="/delete/${lek.getId()}" class="deleteData"><span class="btn-label"><img src="static/svg/trashcan.svg"></span></a>
                                        </td>       
									
								</tr>
							</c:forEach>
						</tbody>
					</table>
			</c:when>
	</c:choose>
	</div>
	</div>
	</div>
	</div>
	</div>
</section>
<script>
    function saveData(id) {
        console.log('save Data -  ' + id)
        var fnaziv = $('#text_fnaziv_' + id).val();
        var fdodatno = $('#text_fdodatno_' + id).val();
        if (fnaziv == "") {
            $('#text_fnaziv_' + id).css('border-color', 'red');
            return;
        }
        if (fdodatno == "") {
            $('#text_fdodatno_' + id).css('border-color', 'red');
            return;
        }
        $.ajax({
            type: "POST",
            url: "/saveLek",
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify({
                id: id,
                naziv: fnaziv,
                dodatno: fdodatno
            }),
            success: function (data, textStatus, xhr) {
                console.log("success  ---> ");
                window.location = "/lekovi";

            },
            error: function (data, xhr, textStatus) {
                console.log("failure ---> ");
                console.log(JSON.stringify(xhr));
            }
        });

    }

    function hideContent() {
        $('#loadingDiv').show();
        $('#contentDiv').hide();
    }

    function showContent() {
        $('#loadingDiv').hide();
        $('#contentDiv').show();
    }
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>
<script src="static/js/app.js"></script>
<script src="static/js/edit.js"></script>
</body>
</html>
