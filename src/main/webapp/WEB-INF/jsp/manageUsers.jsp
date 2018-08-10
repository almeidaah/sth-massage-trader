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
        <a class="btn btn-warning" href="/">Voltar</a>
        <a class="btn btn-warning" href="/addUserForm">Adicionar Usuário</a>

        <hr/>

        <c:if test = "${success ne null}">
            <div id="login-alert" class="alert alert-success col-sm-12">
                    ${success}
            </div>
        </c:if>

        <table class="table table-bordered table-striped table-hover" style="padding-top: 105px">
            <tr>
                <th>Login</th>
                <th>Nivel de Acesso</th>
                <th>Ações</th>
                <th></th>
            </tr>

            <c:forEach items="${users}" var="user">
                <tr>
                    <td><h4>${user.email}</h4></td>
                    <td><h4>${user.role}</h4></td>
                    <td><a class="btn btn-warning" href="/edit/${user.id}"  style="width:100%" disabled="disabled">Editar</a></td>
                    <td><a class="btn btn-danger" href="/delete/${user.id}" style="width:100%" >Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>

</tags:sthTemplate>
