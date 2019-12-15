<meta http-equiv="Cache-Control" content="no-cache">
<meta charset="ISO-8859-1">
<title>Admin</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">

</head>
<body class="my-login-page">
<div role="navigation">
		<div class="navbar navbar-inverse">
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/login">Logovanje</a></li>
					<li><a href="/registracija">Registruj se</a></li>
				</ul>
			
			</div>
		</div>
	</div>
	
<h1 align="center">VASA REGISTRACIJA NIJE OBRADJENA</h1>

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