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
    <c:url value="/resources/css" var="cssPath" />
    <link rel="stylesheet" href="${cssPath }/bootstrap.min.css">
    <link rel="stylesheet" href="${cssPath }/bootstrap-theme.min.css">
    <title><spring:message code="message.login.title" /></title>
</head>

<style type="text/css">
    body{
        background: -moz-linear-gradient(top, #f0f9ff 0%, #cbebff 47%, #A6E9FF 100%); /* FF3.6-15 */
        background: -webkit-linear-gradient(top, #f0f9ff 0%,#cbebff 47%,#A6E9FF 100%); /* Chrome10-25,Safari5.1-6 */
        background: linear-gradient(top, #f0f9ff 0%,#cbebff 47%,#A6E9FF 100%) !important; /* W3C, IE10+, FF16+, Chrome26+, Opera12+, Safari7+ */
    }
</style>

<body>

    <div class="container">
        <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
            <div class="panel panel-info" >

                <div class="panel-heading">
                    <div class="panel-title">Massage trader 1.0</div>
                </div>

                <c:set var = "error" scope = "session" value = ""/>

                <div style="padding-top:30px" class="panel-body" >
                    <form:form class="form-horizontal" action="/login" method="post" modelAttribute="login">

                        <img src="https://img.clipartxtras.com/ef113ce4d7f31594850dae6992d1c6e8_home-massage-clipart-images_980-755.svg" class="img-fluid" width="100%" alt="Responsive image">

                        <div style="margin-bottom: 25px" class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <form:input class="form-control" path="email" placeholder="email" />
                        </div>

                        <div style="margin-bottom: 25px" class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                            <form:password class="form-control" path="password" placeholder="password" />
                        </div>

                        <div style="margin-top:10px" class="form-group">
                            <div class="col-sm-12 controls">
                                <td><input class="btn btn-success" type="submit" value="Submit"/></td>
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

</body>
