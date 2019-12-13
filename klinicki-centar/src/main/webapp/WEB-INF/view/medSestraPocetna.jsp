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
<title>Sestra</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<style>
body,html {
  height: 100%;
}

.bg {
  /* The image used */
  background-image: url(static/images/sestra.jpg);

  /* Full height */
  height: 100%; 

  /* Center and scale the image nicely */
  background-position: center;
  background-repeat: no-repeat;
  background-size: 100% 100%;
}
</style>
</head>
<body class="my-login-page">
<div role="navigation">
		<div class="navbar navbar-inverse">
			<div class="navbar-collapse collapse">
			<h2>MEDICINSKA SESTRA</h2>
				<ul class="nav navbar-nav">
					<li><a href="sviSestraPacijenti">Svi Pacijenti</a></li>
					<li><a href="/logout">Odjavi se</a></li>
				</ul>
			
			</div>
		</div>
	</div>
	
 <div class="bg"></div>
<div class="footer">
    Copyright &copy; 2019
</div>

<script>
    function saveData(id) {
        console.log('save Data -  ' + id)
        var fname = $('#text_fname_' + id).val();
        var lname = $('#text_lname_' + id).val();
        if (fname == "") {
            $('#text_fname_' + id).css('border-color', 'red');
            return;
        }
        if (lname == "") {
            $('#text_lname_' + id).css('border-color', 'red');
            return;
        }
        $.ajax({
            type: "POST",
            url: "/save",
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify({
                id: id,
                firstName: fname,
                lastName: lname
            }),
            success: function (data, textStatus, xhr) {
                console.log("success  ---> ");
                window.location = "/";

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