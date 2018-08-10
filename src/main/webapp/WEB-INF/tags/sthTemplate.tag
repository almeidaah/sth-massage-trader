<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<!doctype html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
</head>

<body>

    <style type="text/css">
        body{
            background: -moz-linear-gradient(top, #f0f9ff 0%, #cbebff 47%, #A6E9FF 100%); /* FF3.6-15 */
            background: -webkit-linear-gradient(top, #f0f9ff 0%,#cbebff 47%,#A6E9FF 100%); /* Chrome10-25,Safari5.1-6 */
            background: linear-gradient(top, #f0f9ff 0%,#cbebff 47%,#A6E9FF 100%) !important; /* W3C, IE10+, FF16+, Chrome26+, Opera12+, Safari7+ */
        }
    </style>

    <nav class="navbar navbar-inverse">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">Massage Trader 1.0</a>
            </div>
            <div id="navbar" class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li><a style="color: red" href="/logout">Logout</a></li>
                    <c:if test="${login.role eq 'ADMIN'}">
                        <li><a style="color: lightblue" href="/manageUsers"><spring:message code="massages.users.manage" /></a></li>
                    </c:if>


                </ul>
            </div>
        </div>
    </nav>

    <jsp:doBody />

    <%@include file="/WEB-INF/jsp/rodape.jsp" %>
</body>

