<%--
  Created by IntelliJ IDEA.
  User: almeida
  Date: 7/3/18
  Time: 1:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<head>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <title><spring:message code="message.login.title" /></title>
</head>

<tags:sthTemplate>

    <div class="container">
        <%--<div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">--%>
            <%--<div class="panel panel-info" >--%>
                <%--<div class="panel-heading">--%>
                    <%--<div class="panel-title">Massage trader 1.0</div>--%>
                <%--</div>--%>

                <%--<c:set var = "error" scope = "session" value = ""/>--%>

                <%--<div style="padding-top:30px" class="panel-body" >--%>

                    <%--<form:form class="form-horizontal" action="/login" method="post" modelAttribute="login">--%>

                        <%--<img src="resources/logo.png" class="img-fluid" width="100%" alt="Responsive image">--%>

                        <%--<div style="margin-bottom: 25px" class="input-group">--%>
                            <%--<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>--%>
                            <%--<form:input id="login-username" type="text" class="form-control" path="email" placeholder="email" />--%>
                        <%--</div>--%>

                        <%--<div style="margin-bottom: 25px" class="input-group">--%>
                            <%--<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>--%>
                            <%--<form:input id="login-password" type="password" class="form-control" path="password" placeholder="password" />--%>
                        <%--</div>--%>

                        <%--<div style="margin-top:10px" class="form-group">--%>
                            <%--<div class="col-sm-12 controls">--%>
                                <%--                    <td><input class="btn btn-success" type="submit" value="Submit"/></td>--%>
                                <%--<a class="btn btn-warning" href="/addUser">Cadastrar-me</a>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                    <%--</form:form>--%>

                <%--</div>--%>

                <%--<c:if test = "${error ne ''}">--%>
                    <%--<div id="login-alert" class="alert alert-danger col-sm-12">--%>
                            <%--${error}--%>
                    <%--</div>--%>
                <%--</c:if>--%>

            <%--</div>--%>

            <%--<a href="https://www.linkedin.com/in/oalmeidajavadeveloper/"> <span>made by Fernando Almeida</span></a>--%>

        <%--</div>--%>
        ADD USER :D
    </div>

</tags:sthTemplate>
