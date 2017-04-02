<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

<head>
<title>My Plain Financial</title>

<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
<spring:url value="/resources/startbootstrap/css/bootstrap.min.css" var="bootstrapCssCss" />
<spring:url value="/resources/startbootstrap/css/sb-admin.css" var="adminCss" />
<spring:url value="/resources/startbootstrap/css/plugins/morris.css" var="pluginsCss" />
<spring:url value="/resources/startbootstrap/font-awesome/css/font-awesome.min.css" var="fontCss" />
<spring:url value="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.min.css" var="datepicker" />
<spring:url value="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker3.min.css" var="datepicker3" /> 
<spring:url value="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.min.js" var="dp" />
<spring:url value="/resources/core/js/templateHeader.js" var="templateHeader" />

 

<!-- http://formvalidation.io/examples/bootstrap-datepicker/ -->
 <script src="${dp}"></script>

<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />

<!-- Bootstrap Core CSS -->
<link href="${bootstrapCssCss}" rel="stylesheet">
<!-- Custom CSS -->
<link href="${adminCss}" rel="stylesheet">
<!-- Morris Charts CSS -->
<link href="${pluginsCss}" rel="stylesheet">
<!-- Custom Fonts -->
<link href="${fontCss}" rel="stylesheet" type="text/css"> 
<link rel="stylesheet" href="${datepicker}" />
<link rel="stylesheet" href="${datepicker3}" />

</head>


<spring:url value="/user/home" var="home" />
<spring:url value="/recipe" var="recipe" />
<spring:url value="/user/expenses" var="expenses" />
<spring:url value="/account/create" var="accounts" />
<spring:url value="/user/creditCard" var="creditCard" />
<spring:url value="/user/detail" var="detail" />
<spring:url value="/recipeType/create" var="recipeType"></spring:url>
<spring:url value="/recipe/create" var="recipeCreate"></spring:url>
	

<nav class="navbar navbar-inverse">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${home}">Dashboard</a>
		</div>
		<div class="dropsown">
			<button class="btn btn-success dropdown-toggle" type="button" data-toggle="dropdown">Receitas				
			<span class="caret"></span>
			</button>				
					<ul class="dropdown-menu">
						<li class="active"><a href="${recipe}">Listar Receitas</a></li>
						<li class="active"><a href="${recipeCreate}">Cadastrar Receita</a></li>						
						<li class="active"><a href="${recipeType}">Cadastrar Tipo Receita</a></li>
					</ul>
			
		</div>
		<div id="navbar">
			<ul class="nav navbar-nav navbar-center">
				<li class="active"><a href="${expenses}">Despesa</a></li>
			</ul>
		</div>

		<div id="navbar">
			<ul class="nav navbar-nav navbar-center">
				<li class="active"><a href="${accounts}">Contas</a></li>
			</ul>
		</div>

		<div id="navbar">
			<ul class="nav navbar-nav navbar-center">
				<li class="active"><a href="${creditCard}">Cartão de Crédito</a></li>
			</ul>
		</div>

		<div id="navbar">
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="#" onclick="document.getElementById('logout').submit();">Logout</a></li>
			</ul>
		</div>

		<div id="navbar">
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="${detail}">					
						<tiles:insertAttribute name="li" ignore="true" />
						<c:out value="${loggedUser}"></c:out>					
				</a></li>
			</ul>
		</div>
	</div>
</nav>

    <c:url var="logoutUrl" value="/j_spring_security_logout" />
    <form action="${logoutUrl}" id="logout" method="post">
        <input type="hidden" name="${_csrf.parameterName}"
            value="${_csrf.token}" />
    </form>

