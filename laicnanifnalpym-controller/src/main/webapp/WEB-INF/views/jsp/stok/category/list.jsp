
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
			
			<div align="center" class="col-md-2">						
						<p><h3>Create New</h3>						
							<a class="btn btn-success" href="/spring3/category/save" role="button">GO</a>
						</p>
					</div>


			<div class="container">

				<c:if test="${listCategory ne null}">

					<table class="table table-striped">
						<thead style="color: black;">
							<tr>
								<th>Category Id</th>
								<th>Category Name</th>
								<th>Description</th>
								<th>Picture Name</th>
								<th>Picture</th>
								<th>Edit</th>
								<th>Delete</th>
							</tr>
						</thead>
						<c:forEach var="list" items="${listCategory}">
			    <tbody>
								<tr>
									<td><c:out value="${list.categoryId}" /></td>
									<td><c:out value="${list.categoryName}" /></td>
									<td><c:out value="${list.description}" /></td>
									<td><c:out value="${list.pictureName}" /></td>
									<td><img
										src='picture/<c:out value="${list.categoryId}"/>'
										class="img-rounded" alt="Cinque Terre" width="304" height="236" />
									</td>
									<td><a class="glyphicon glyphicon-pencil" href="/spring3/category/update/${list.categoryId}"> Update</a></td>
									<td><a class="glyphicon glyphicon-pencil" href="/spring3/category/delete/${list.categoryId}"> Delete</a></td>

								</tr>
							</tbody>
						</c:forEach>
					</table>
				</c:if>
			</div>




			<div class="container">

				<div class="row">
					<div class="col-md-4">
						<h2>Rollback</h2>

						<p>
							<a class="btn btn-default" href="search" role="button">Rollback</a>
						</p>
					</div>
					<div class="col-md-4">
						<h2>Heading</h2>
						<p>ABC</p>
						<p>
							<a class="btn btn-default" href="saveOrUpdate" role="button">saveOrUpdate</a>
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