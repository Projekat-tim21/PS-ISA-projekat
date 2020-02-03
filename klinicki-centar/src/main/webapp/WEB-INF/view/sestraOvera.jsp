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
<link rel="shortcut icon" href="#">
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<style>
body,html {
  height: 100%;
}

.bg {
  /* The image used */
  background-image: url(static/images/hhh.jpg);

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
				<li><a href="/sviSestraPacijenti">Svi pacijenti</a></li>
				<li><a href="/overaRecepta">Overa recepata</a></li>
					<li><a href="/zahtevZaOdsustvo?id=${id}">Odsustvo/Odmor</a></li>
					<li><a href="/profilSestra?id=${id}">Profil</a></li>
					<li><a href="/logout">Odjavi se</a></li>
				</ul>
			
			</div>
		</div>
	</div>
	
	<c:choose>
	<c:when test="${mode=='ALL_USERS' }">
			<div class="container text-center" id="tasksDiv">
				<h3>Za overu</h3>
				<hr>
				<div class="table-responsive">
					<table id="myTable" class="table table-striped table-bordered">
						<thead>
							<tr>
								<th><a href="javascript:SortTable(0,'N');">Id</a></th>
							
								<th ><a href="javascript:SortTable(2,'T');">Dijagnoza</a></th>
								<th>Overi recept</th>
						<!--		<th>Sifra</th>  -->
							</tr>
						</thead>
						<tbody>
							<c:forEach var="inofr" items="${info }" >
								
								<tr>
									<td>${inofr.id}</td>
									
									<td>${inofr.dijagnoza}</td>
									<td><a href="/overi/${inofr.getId()}" >Overi</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				
				</div>
			</div>
		</c:when>
</c:choose>
	

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


  

    function addIdPac (element){
    	element.href = element.href+"?id="+idPacijenta;
    	console.log(element.href);
    }




    function sortTablePoNazivu() {
      var table, rows, switching, i, x, y, shouldSwitch;
      table = document.getElementById("myTable");
      switching = true;
      /*Make a loop that will continue until
      no switching has been done:*/
      while (switching) {
        //start by saying: no switching is done:
        switching = false;
        rows = table.rows;
        /*Loop through all table rows (except the
        first, which contains table headers):*/
        for (i = 1; i < (rows.length - 1); i++) {
          //start by saying there should be no switching:
          shouldSwitch = false;
          /*Get the two elements you want to compare,
          one from current row and one from the next:*/
          x = rows[i].getElementsByTagName("TD")[1];
          y = rows[i + 1].getElementsByTagName("TD")[1];
          //check if the two rows should switch place:
          if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
            //if so, mark as a switch and break the loop:
            shouldSwitch = true;
            break;
          }
        }
        if (shouldSwitch) {
          /*If a switch has been marked, make the switch
          and mark that a switch has been done:*/
          rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
          switching = true;
        }
      }
    }

    ///////////////////////////////////////////////////////

    function sortTablePoGradu() {
      var table, rows, switching, i, x, y, shouldSwitch;
      table = document.getElementById("myTable");
      switching = true;
      /*Make a loop that will continue until
      no switching has been done:*/
      while (switching) {
        //start by saying: no switching is done:
        switching = false;
        rows = table.rows;
        /*Loop through all table rows (except the
        first, which contains table headers):*/
        for (i = 1; i < (rows.length - 1); i++) {
          //start by saying there should be no switching:
          shouldSwitch = false;
          /*Get the two elements you want to compare,
          one from current row and one from the next:*/
          x = rows[i].getElementsByTagName("TD")[3];
          y = rows[i + 1].getElementsByTagName("TD")[3];
          //check if the two rows should switch place:
          if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
            //if so, mark as a switch and break the loop:
            shouldSwitch = true;
            break;
          }
        }
        if (shouldSwitch) {
          /*If a switch has been marked, make the switch
          and mark that a switch has been done:*/
          rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
          switching = true;
        }
      }
    }

    ///////////////////////////////////////////////ovo

    var TableIDvalue = "myTable";


    var TableLastSortedColumn = -1;
    function SortTable() {
    var sortColumn = parseInt(arguments[0]);
    var type = arguments.length > 1 ? arguments[1] : 'T';
    var dateformat = arguments.length > 2 ? arguments[2] : '';
    var table = document.getElementById(TableIDvalue);
    var tbody = table.getElementsByTagName("tbody")[0];
    var rows = tbody.getElementsByTagName("tr");
    var arrayOfRows = new Array();
    type = type.toUpperCase();
    dateformat = dateformat.toLowerCase();
    for(var i=0, len=rows.length; i<len; i++) {
    	arrayOfRows[i] = new Object;
    	arrayOfRows[i].oldIndex = i;
    	var celltext = rows[i].getElementsByTagName("td")[sortColumn].innerHTML.replace(/<[^>]*>/g,"");
    	if( type=='D' ) { arrayOfRows[i].value = GetDateSortingKey(dateformat,celltext); }
    	else {
    		var re = type=="N" ? /[^\.\-\+\d]/g : /[^a-zA-Z0-9]/g;
    		arrayOfRows[i].value = celltext.replace(re,"").substr(0,25).toLowerCase();
    		}
    	}
    if (sortColumn == TableLastSortedColumn) { arrayOfRows.reverse(); }
    else {
    	TableLastSortedColumn = sortColumn;
    	switch(type) {
    		case "N" : arrayOfRows.sort(CompareRowOfNumbers); break;
    		case "D" : arrayOfRows.sort(CompareRowOfNumbers); break;
    		default  : arrayOfRows.sort(CompareRowOfText);
    		}
    	}
    var newTableBody = document.createElement("tbody");
    for(var i=0, len=arrayOfRows.length; i<len; i++) {
    	newTableBody.appendChild(rows[arrayOfRows[i].oldIndex].cloneNode(true));
    	}
    table.replaceChild(newTableBody,tbody);
    } // function SortTable()

    function CompareRowOfText(a,b) {
    var aval = a.value;
    var bval = b.value;
    return( aval == bval ? 0 : (aval > bval ? 1 : -1) );
    } // function CompareRowOfText()

    function CompareRowOfNumbers(a,b) {
    var aval = /\d/.test(a.value) ? parseFloat(a.value) : 0;
    var bval = /\d/.test(b.value) ? parseFloat(b.value) : 0;
    return( aval == bval ? 0 : (aval > bval ? 1 : -1) );
    } // function CompareRowOfNumbers()

    function GetDateSortingKey(format,text) {
    if( format.length < 1 ) { return ""; }
    format = format.toLowerCase();
    text = text.toLowerCase();
    text = text.replace(/^[^a-z0-9]*/,"");
    text = text.replace(/[^a-z0-9]*$/,"");
    if( text.length < 1 ) { return ""; }
    text = text.replace(/[^a-z0-9]+/g,",");
    var date = text.split(",");
    if( date.length < 3 ) { return ""; }
    var d=0, m=0, y=0;
    for( var i=0; i<3; i++ ) {
    	var ts = format.substr(i,1);
    	if( ts == "d" ) { d = date[i]; }
    	else if( ts == "m" ) { m = date[i]; }
    	else if( ts == "y" ) { y = date[i]; }
    	}
    d = d.replace(/^0/,"");
    if( d < 10 ) { d = "0" + d; }
    if( /[a-z]/.test(m) ) {
    	m = m.substr(0,3);
    	switch(m) {
    		case "jan" : m = String(1); break;
    		case "feb" : m = String(2); break;
    		case "mar" : m = String(3); break;
    		case "apr" : m = String(4); break;
    		case "may" : m = String(5); break;
    		case "jun" : m = String(6); break;
    		case "jul" : m = String(7); break;
    		case "aug" : m = String(8); break;
    		case "sep" : m = String(9); break;
    		case "oct" : m = String(10); break;
    		case "nov" : m = String(11); break;
    		case "dec" : m = String(12); break;
    		default    : m = String(0);
    		}
    	}
    m = m.replace(/^0/,"");
    if( m < 10 ) { m = "0" + m; }
    y = parseInt(y);
    if( y < 100 ) { y = parseInt(y) + 2000; }
    return "" + String(y) + "" + String(m) + "" + String(d) + "";
    } // function GetDateSortingKey()

        

   
    </script>
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>
<script src="static/js/app.js"></script>
<script src="static/js/edit.js"></script>
</body>
</html>