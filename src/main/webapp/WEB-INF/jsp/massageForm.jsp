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
        <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
            <div class="panel panel-info" >
                <div class="panel-heading">
                    <div class="panel-title">Cadastrar Massagem</div>
                </div>

                <c:set var = "error" scope = "session" value = ""/>


                <div style="padding-top:30px" class="panel-body" >

                    <form:form class="form-horizontal" action="/addMassage" method="post" modelAttribute="massage">

                        <div style="margin-bottom: 25px" class="input-group">
                            <form:label cssClass="title" cssErrorClass="title error" path="professional">Selecione o(a) professor(a): </form:label>
                            <form:select path="professional" items="${professionals}" />
                        </div>

                        <div style="margin-bottom: 25px" class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-time"></i> Horário : </span>
                            <form:input id="massage-detail" maxlength="5" class="form-control" path="time" placeholder="HH:mm" />
                        </div>

                        <div style="margin-bottom: 25px" class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-th-large"></i> Observação : </span>
                            <form:input id="massage-detail" type="text" class="form-control" path="detail" placeholder="Observação" />
                        </div>

                        <div style="margin-bottom: 25px" class="input-group">
                            <span class="input-group-addon" style="width: 65%">Doar horário? </span>
                            <form:checkbox id="massage-donate" cssStyle="float: left" cssClass="form-control" path="donateMassage" />
                        </div>

                        <div class="form-group">
                            <div class="col-sm-10 controls">
                                <a class="btn btn-warning" href="/">Voltar</a>
                                <td><input class="btn btn-success" type="submit" value="Cadastrar"/></td>
                        </div>

                    </form:form>

                </div>

                <c:if test = "${error ne ''}">
                    <div id="login-alert" class="alert alert-danger col-sm-12">
                            ${error}
                    </div>
                </c:if>
            </div>
        </div>

    </div>
</tags:sthTemplate>