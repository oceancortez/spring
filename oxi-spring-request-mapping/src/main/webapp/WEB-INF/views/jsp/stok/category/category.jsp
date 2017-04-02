
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
			<sf:form modelAttribute="categoryForm" action="categoryName"
				method="get">
				<table border="0">
					<tr>
						<td><label for="categoryName">Category Name:</label></td>

						<td><sf:input type="text" class="form-control"
								id="categoryName" path="categoryName" size="30" /></td>

						<td colspan="1"></td>

						<td style="" colspan="1"><input
							class="btn btn-primary btn-md" type="submit" value="Pesquisar"
							size="20" /></td>
					</tr>
					<tr>
						<td><span><sf:errors path="categoryName"
									cssClass="erro" /></span></td>
					</tr>

				</table>
				<div>
					<sf:label path="message">${message}</sf:label>
				</div>
			</sf:form>
	</div>
</div>

<section>
	<div>
		<c:if test="${categoryEntity ne null}">

			<div class="container">
				<h3>Detail of Category</h3>
				<div class="panel-group">

					<div class="panel panel-info class">

						<div class="panel-heading">Category ID</div>
						<div class="panel-body">${categoryEntity.categoryId}</div>

						<div class="panel-heading">Category Name</div>
						<div class="panel-body">${categoryEntity.categoryName}</div>

						<div class="panel-heading">Description</div>
						<div class="panel-body">${categoryEntity.description}</div>

						<div class="panel-heading">Picture Name</div>
						<div class="panel-body">${categoryEntity.pictureName}</div>

						<div class="panel-heading">Picture</div>
						<div class="panel-body">
							<img  src='<c:url value="picture/${categoryEntity.categoryId}"/>' class="img-rounded"
								alt="Cinque Terre" width="204" height="200" />
						</div>
					</div>
				</div>

			</div>
		</c:if>

	</div>

</section>

<div class="container">

	<div class="row">
		<div class="col-md-4">
			<h2>Create New Category</h2>

			<p>
				<a class="btn btn-default" href="save" role="button">Create New
					Category</a>
			</p>
		</div>



		<div class="col-md-4">
			<h2>Rollback</h2>

			<p>
				<a class="btn btn-default" href="search" role="button">Rollback</a>
			</p>
		</div>
		<div class="col-md-4">
			<h2>List All</h2>
			<p>ABC</p>
			<p>
				<a class="btn btn-default" href="list" role="button">List All</a>
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