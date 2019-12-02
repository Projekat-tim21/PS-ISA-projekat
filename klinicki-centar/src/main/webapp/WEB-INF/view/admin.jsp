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
<title>Admin</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">

</head>
<body class="my-login-page">
<nav class="navbar sticky-top navbar-expand-lg navbar-dark bg-primary">
    <a class="navbar-brand" href="/">
        <img src="resources/images/logo.png" width="50" height="50" class="d-inline-block align-top" alt="">
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>


    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/addNewUser">Add User</a>
            </li>
        </ul>
        <div >
            <a style="text-align: right; color: #fff;" href="<c:url value="logout" />">Logout <i class="fa fa-sign-out fa-lg"></i>

            </a>
        </div>
    </div>
</nav>
<section class="h-100">
    <div class="container h-100">
        <div class="row justify-content-md-center">
            <div class="card">
                <div class="card-header">
                    <h4 class="float-left">List of Users</h4>
                    <ul class="float-right">
                        <li>
                            <form action="/searchBox" class="form-inline my-2 my-lg-0 ">
                                <input class="form-control mr-sm-2" name="searchTerm" type="search" placeholder="Search"
                                       aria-label="Search">
                                <input type="hidden" name="page" value="0"/>
                                <input type="hidden" name="size" value="${maxTraySize}"/>
                                <input class="btn btn-outline-primary my-2 my-sm-0" value="Search" type="submit">
                            </form>
                        </li>
                        <li class="text-right">
                            <a href="/search">Advanced Search</a>
                        </li>
                    </ul>
                </div>
                <div class="card card-body table-responsive">
                    <c:choose>
                        <c:when test="${allUsers.totalPages > 0}">
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th>User Id</th>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Email</th>
                                    <th colspan="2">Action</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="user" items="${allUsers.content}">
                                    <tr>
                                        <td>
                                            <label>${user.getId()}</label>
                                        </td>
                                        <td>
                                            <label id="fname_${user.getId()}">
                                                    ${user.getFirstName()}
                                            </label>
                                            <input required type="text" name="firstName" class="form-control"
                                                   value="${user.getFirstName()}"
                                                   style="display: none;"
                                                   id="text_fname_${user.getId()}">
                                        </td>
                                        <td>
                                            <label id="lname_${user.getId()}">
                                                    ${user.getLastName()}
                                            </label>
                                            <input required class="form-control" type="text" name="firstName"
                                                   value="${user.getLastName()}"
                                                   style="display: none;"
                                                   id="text_lname_${user.getId()}">
                                        </td>
                                        <td>
                                            <label>
                                                    ${user.getEmail()}
                                            </label>
                                        </td>
                                        <td>
                                            <a href="/update" id="update_${user.getId()}" class="updateData"
                                               onclick="event.preventDefault();"><i class="fa fa-edit"></i></a>
                                            <a href="/save" id="save_${user.getId()}" class="saveData"
                                               onclick="event.preventDefault();saveData(${user.getId()});"
                                               style="display: none;"><i class="fa fa-save"></i></a>
                                        </td>
                                        <td><a href="/delete/${user.getId()}" class="deleteData"><i
                                                class="fa fa-trash"></i></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>

                            </table>
                        </c:when>
                        <c:otherwise>
                            <h5>No users Found... Search again!</h5>
                        </c:otherwise>
                    </c:choose>

                </div>
            </div>
            <c:if test="${allUsers.totalPages > 0}">
                <nav aria-label="Page navigation example" style="margin:auto;">
                    <ul class="pagination">
                        <c:set var="prev" value="0"/>
                        <c:if test="${param.page > 0}">
                            <c:set var="prev" value="${param.page -1}"/>
                        </c:if>
                        <c:if test="${allUsers.totalPages > 0}">
                            <li class='page-item <c:if test="${empty param.page || param.page eq 0}">disabled</c:if>'>
                                <a class="page-link" href="/?page=${prev}&size=${maxTraySize}">Prev</a></li>
                        </c:if>
                        <c:forEach var="i" begin="0" end="${allUsers.totalPages -1}">
                            <li class='page-item <c:if test="${param.page eq i || (empty param.page && i eq 0)}">active</c:if>'>
                                <a class="page-link" href="/?page=${i}&size=${maxTraySize}">${i+1}</a>
                            </li>
                        </c:forEach>
                        <c:if test="${allUsers.totalPages > 0}">
                            <li class='page-item <c:if test="${allUsers.totalPages <= (param.page + 1)}">disabled</c:if>'>
                                <a class="page-link" href="/?page=${param.page + 1}&size=${maxTraySize}">Next</a>
                            </li>
                        </c:if>
                    </ul>
                </nav>
            </c:if>

            <%--<nav aria-label="Page navigation example" style="margin:auto;">
                <ul class="pagination">
                    <li class="page-item"><a href="/prev/${currentPage-1}" class="page-link pageClickEvent">Previous</a>
                    </li>
                    <c:choose>
                        <c:when test="${totalPages gt maxTraySize}">
                            <c:set var="upperLimit" value="${totalPages - maxTraySize}"></c:set>
                            <c:choose>
                                <c:when test="${upperLimit gt maxTraySize}">
                                    <c:forEach var="page" begin="${currentPage}" end="${currentPage + maxTraySize - 1}">
                                        <li class="page-item"><a href="/page/${page}"
                                                                 class="page-link pageClickEvent">${page}</a></li>
                                    </c:forEach>
                                    <li class="page-item"><a href="/next/${currentPage+1}"
                                                             class="page-link pageClickEvent">Next</a></li>
                                </c:when>
                                <c:otherwise>
                                    <c:forEach var="page" begin="${currentPage}" end="${currentPage + upperLimit}">
                                        <li class="page-item"><a href="/page/${page}"
                                                                 class="page-link pageClickEvent">${page}</a></li>
                                    </c:forEach>
                                    <li class="page-item"><a href="/next/${currentPage+1}"
                                                             class="page-link pageClickEvent">Next</a></li>
                                </c:otherwise>
                            </c:choose>
                            <c:if test="${upperLimit gt maxTraySize}">
                            </c:if>
                        </c:when>
                        <c:otherwise>
                            <c:forEach var="page" begin="1" end="${totalPages}">
                                <li class="page-item"><a href="/page/${page}"
                                                         class="page-link pageClickEvent">${page}</a></li>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </ul>
                --%>
            <input type="hidden" name="currentPage" value="${currentPage}" id="currentPageNo">
            <%--</nav>--%>
        </div>
    </div>
</section>
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
<script src="resources/bootstrap/js/bootstrap.min.js"></script>
<script src="resources/js/app.js"></script>
<script src="resources/js/edit.js"></script>
</body>
</html>