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

		<h3> Bem vindo(a) : ${username} </h3>

		<c:if test = "${message ne null}">
			<div id="login-alert" class="alert alert-danger col-sm-12">
					${message}
			</div>
		</c:if>
		<c:if test = "${success ne null}">
			<div id="login-alert" class="alert alert-success col-sm-12">
					${success}
			</div>
		</c:if>

		<h1>
			<h3>
				 <a class="btn btn-success" href="/massageForm"> <spring:message code="massages.mine.register" /> </a>
			</h3>

			<hr/>

			<c:forEach items="${myMassages}" var="myMassage">
				<b>Massagem atual:</b> ${myMassage.time} com <b>${myMassage.professional}</b>
				<c:choose>
					<c:when test="${myMassage.visible}">
						<a class="btn btn-info" href="/massage/exchange/${myMassage.id}/false"> <spring:message code="massages.mine.remove.of.exchange" /> </a>
					</c:when>
					<c:when test="${myMassage != null && !myMassage.donateMassage}">
								|
								<a class="btn btn-info btn-sm" href="/massage/exchange/${myMassage.id}/true"> <spring:message code="massages.mine.add.to.exchange" /> </a>
								<a class="btn btn-danger btn-sm" href="/massage/remove/${myMassage.id}"> <spring:message code="massages.mine.remove" /> </a>
						<br />
					</c:when>

				</c:choose>
				<br />
			</c:forEach>

		</h1>

		<hr />

		<h4 class="active" style="margin-bottom: 30px; margin-top: 30px">
			<b><spring:message code="massages.available.title" /></b>
			<a id="btn-refresh-table" class="btn btn-success pull-right"  href="/ativeExchangeMassages"> <spring:message code="massages.table.refresh" /> </a>
		</h4>

		<hr />

		<table class="table table-bordered table-striped table-hover" style="padding-top: 105px">
				<tr>
					<th><spring:message code="massages.table.hour" /></th>
					<th><spring:message code="massages.table.professional" /></th>
					<th><spring:message code="massages.table.user" /></th>
					<th><spring:message code="massages.table.obs" /></th>
					<th><spring:message code="massages.table.exchange"/>/<spring:message code="massages.table.donate"/></th>
				</tr>

				<c:forEach items="${massages}" var="massage">
					<tr>
						<td><h4>${massage.time}</h4></td>
						<td><h4>${massage.professional}</h4></td>
						<td><h4>${massage.login.email}</h4></td>
						<td><h4>${massage.detail}</h4></td>
						<td>
							<c:choose>
								<c:when test="${massage.donateMassage}">
									<a class="btn btn-warning" href="/getDonatedMassage/${massage.id}" style="width:100%" ><spring:message code="massages.table.getdonation" /></a>
								</c:when>
								<c:when test="${massage.login.email eq username}">
									<a class="btn btn-warning" style="width:100%" disabled ><spring:message code="massages.mine" /></a>
								</c:when>
								<c:otherwise>
										<a class="btn btn-info" href="/exchangeMessage/${massage.id}" style="width:100%" ><spring:message code="massages.table.exchange" /></a>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</table>


	</div>	<!-- /.container -->

	<script type="text/javascript">
		setInterval(
			function () {
				document.getElementById("btn-refresh-table").click();
				},30000
		);
	</script>

</tags:sthTemplate>
