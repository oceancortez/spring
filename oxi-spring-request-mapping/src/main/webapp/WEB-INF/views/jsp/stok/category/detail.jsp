
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Maven + Spring MVC</title>

<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css"
	var="bootstrapCss" />

<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />

</head>

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Spring 3 MVC Project</a>
		</div>
	</div>
</nav>


<div class="jumbotron">
	<div class="container">
		<h1>${title}</h1>
		<p>

	</div>
</div>

<section>
	<div class="container">
		<div class="panel-group">
			<div class="panel panel-success">
				<div class="panel-heading">Create OK</div>
				<div class="panel-body">
					${categoryForm.categoryName}
				    foi
				    ${categoryForm.message}
				    </div>
				<label id="categoryName">${categoryName}</label>
			</div>
		<div>

	</div>

		<div>
		<label id="categoryName">${message}</label>
	</div>
	</div>
</div>
</section>

<div class="container">



	<div class="row">
		<div class="col-md-4">
			<h2>Rollback</h2>

			<p>
				<a class="btn btn-default" href="/spring3/category/list" role="button">Rollback</a>
			</p>
		</div>
		<div class="col-md-4">
			<h2>Heading</h2>
			<p>ABC</p>
			<p>
				<a class="btn btn-default" href="#" role="button">View details</a>
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
<spring:url value="/resources/core/css/bootstrap.min.js"
	var="bootstrapJs" />

<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

</body>
</html>