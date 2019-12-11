<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta charset="ISO-8859-1">
<title>Dobrodosli</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">

</head>
<body>



<c:choose>


<c:when test="${mode=='ZAKAZANI_PREGLEDI' }">
			<div class="container text-center" id="tasksDiv">
				<h3>Lista zakazanih pregleda</h3>
				<hr>
				<div class="table-responsive">

					<table id="indextable" class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id pregleda</th>
								<th>Ime lekara</th>
								<th>Prezime lekara</th>
								<th>Tip pregleda</th>
								<th>Termin</th>
								<th>Sala</th>
								<th>Cena</th>
								<th>Popust</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="termin" items="${termini}">
								<tr>
									<td>${termin.id}</td>
									<td>${termin.lekarime}</td>
									<td>${termin.lekarprezime}</td>
									<td>${termin.tippregleda }</td>
									<td>${termin.termin}</td>
									<td>${termin.sala}</td>
									<td>${termin.cena}</td>
									<td>${termin.popust}</td>
									
								</tr>
							</c:forEach>
						</tbody>
					</table>

				</div>
			</div>
			<a onclick="addIdPac(this)" href="/vratiSeNaLoginBezDobrodosli2">Vrati se nazad</a>
		</c:when>




	</c:choose>

<script type="text/javascript">
		var getUrlParameter = function getUrlParameter(sParam) {
			var sPageURL = window.location.search.substring(1), sURLVariables = sPageURL
					.split('&'), sParameterName, i;

			for (i = 0; i < sURLVariables.length; i++) {
				sParameterName = sURLVariables[i].split('=');

				if (sParameterName[0] === sParam) {
					return sParameterName[1] === undefined ? true
							: decodeURIComponent(sParameterName[1]);
				}
			}
		};

		var idPacijenta = getUrlParameter('id');
		console.log(idPacijenta);

		function addIdPac(element) {
			element.href = element.href + "?id=" + idPacijenta;
			console.log(element.href);
		}
	</script>

</body>
</html>