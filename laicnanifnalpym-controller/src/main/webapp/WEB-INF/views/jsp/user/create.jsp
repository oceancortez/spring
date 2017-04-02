
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>multipart/form-data</title>

<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />

<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />

</head>

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Criação de Usuário</a>
		</div>
	</div>
</nav>


<div class="jumbotron">
	<div class="container">
		<h1>${title}</h1>


		<p>
			<sf:form modelAttribute="userForm" action="/user/create" method="post">				
		<table border="0">

			<tr>
				<td><label for="nameUser">Nome:</label></td>

				<td><sf:input type="text" id="nameUser" class="form-control" path="nameUser" size="40" /></td>

				<td><span><sf:errors path="nameUser" cssClass="erro" /></span></td>
			</tr>
			<tr>
				<td colspan="2"></br></td>
			</tr>
			<tr>
				<td><label for="email">Email:</label></td>

				<td><sf:input id="email" type="email" path="email" class="form-control" size="40" /></td>
			</tr>
			<tr>
				<td colspan="2"></br></td>
			</tr>
			<tr>
				<td><label for="password">Senha:</label></td>

				<td><sf:input id="password" type="password" path="password" class="form-control" size="40" /></td>
			</tr>
			<tr>
				<td colspan="2"></br></td>
			</tr>
			<tr>
				<td><label for="confirmPassword">Repita a Senha:</label></td>

				<td><sf:input id="confirmPassword" type="password" path="confirmPassword" class="form-control" size="40" /></td>
			</tr>
			<tr>
				<td colspan="2"></br></td>
			</tr>
			<tr align="center">
				<td colspan="2"><input class="btn btn-success btn-md" type="submit" value="Cadastrar" size="20" />
				 <a class="btn btn-default"
					href="/user/signIn" role="button">Cancel</a>
				</td>
			</tr>
		</table>
	 	<p>
				<div align="center">
					<label id="message">${message}</label>
				</div>
		</p>

		</sf:form>

	</div>
</div>



<div class="container">

	<div class="row">
		<div class="col-md-4">
			<h2>Search</h2>

			<p>
				<a class="btn btn-default" href="/spring3/category/search" role="button">Search</a>
			</p>
		</div>
		<div class="col-md-4">
			<h2>List All</h2>
			<p>
				<a class="btn btn-default" href="/spring3/category/list" role="button">List All</a>
			</p>
		</div>
		<div class="col-md-4">
			<h2>Heading</h2>
			<p>ABC</p>
			<p>
				<a class="btn btn-default" href="#" role="button">View details</a>
			</p>
		</div>
	</div>

	<hr>
	<footer>
		<p>© Mkyong.com 2015</p>
	</footer>
</div>

<spring:url value="/resources/core/css/hello.js" var="coreJs" />
<spring:url value="/resources/core/css/bootstrap.min.js" var="bootstrapJs" />

<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

</body>
</html>