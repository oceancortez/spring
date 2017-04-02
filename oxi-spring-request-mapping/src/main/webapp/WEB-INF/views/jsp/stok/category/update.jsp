
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
			<a class="navbar-brand" href="#">multipart/form-data - UPDATE</a>
		</div>
	</div>
</nav>


<div class="jumbotron">
	<div class="container">
		<h1>${title}</h1>
		<p>
			<sf:form modelAttribute="categoryForm" action="/spring3/category/update" enctype="multipart/form-data" method="post">
				<table border="0">
					<tr>
						<c:if test="${categoryForm.categoryId ne null}">

							<td><sf:label path="categoryId">Category Id</sf:label></td>
							<td><sf:input id="categoryId" type="text" path="categoryId" class="form-control" size="30" /></td>
						</c:if>

					</tr>
					<tr><td colspan="2"></br></td></tr>
					<tr>
						<td><label for="categoryName">Category Name:</label></td>

						<td><sf:input type="text" id="categoryName" class="form-control" path="categoryName" size="30" /></td>

						<td><span><sf:errors path="categoryName" cssClass="erro" /></span></td>
					</tr>
					<tr><td colspan="2"></br></td></tr>
					<tr>
						<td><label for="description">Description:</label></td>

						<td><sf:input id="description" type="text" path="description" class="form-control" size="30" /></td>
					</tr>
					<tr><td colspan="2"></br></td></tr>
					<tr>
						<td><label for="pictureNew">Picture New:</label></td>

						<td><sf:input id="pictureNew" cssClass="btn btn-primary btn-md" type="file" path="pictureNew" size="30" /></td>
					</tr>
					<tr><td colspan="2"></br></td></tr>
					
					<tr  align="center" style="margin-top: 5px;">
						<td colspan="2">
						<input class="btn btn-success btn-md" type="submit" value="Update" size="20" />						
						<a class="btn btn-default" href="/spring3/category/list" role="button">Cancel</a>
						</td>
						
					</tr>
					
					<tr><td colspan="2"></br></td></tr>
					<tr>

						<td><label for="picture">Picture Name:</label> </br> <label for="picture">${pictureName}</label></td>

						<td><img src='/spring3/category/picture/<c:out value="${categoryForm.categoryId}"/>' class="img-rounded" alt="Cinque Terre"
							width="304" height="236" /></td>
					</tr>
					<tr><td colspan="2"></br></td></tr>
					
					
				</table>
				<div>
					<sf:label path="message">${message}</sf:label>
				</div>
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