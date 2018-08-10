<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<head>
    <c:url value="/resources/css" var="cssPath" />
    <link rel="stylesheet" href="${cssPath }/bootstrap.min.css">
    <link rel="stylesheet" href="${cssPath }/bootstrap-theme.min.css">
</head>

<tags:sthTemplate>

    <div class="container">


        <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
            <div class="panel panel-info" >

                <c:set var = "error" scope = "session" value = ""/>

                <div style="padding-top:30px" class="panel-body" >
                    <form:form class="form-horizontal" action="/addUser" method="post" modelAttribute="newUser">

                        <div style="margin-bottom: 25px" class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <form:input id="login-username" type="text" class="form-control" path="email" placeholder="email" />
                        </div>

                        <div style="margin-bottom: 25px" class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                            <form:password class="form-control" path="password" placeholder="password" />
                        </div>

                        <div style="margin-bottom: 25px" class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                            <form:password class="form-control" path="passwordConfirmation" placeholder="password confirm" />
                        </div>

                        <div style="margin-top:10px" class="form-group">
                            <div class="col-sm-8 controls">
                                <td><a class="btn btn-warning" href="/">Voltar</a></td>
                                <td><input class="btn btn-success" type="submit" value="Cadastrar"/></td>
                            </div>
                        </div>

                    </form:form>
                </div>

                <c:if test = "${error ne ''}">
                    <div id="login-alert" class="alert alert-danger col-sm-12">
                            ${error}
                    </div>
                </c:if>
            </div>

            <a href="https://www.linkedin.com/in/oalmeidajavadeveloper/"> <span>made by Fernando Almeida</span></a>

        </div>

    </div>

</tags:sthTemplate>
