
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<jsp:include page="../template/header.jsp" />

<body>
	<div class="jumbotron">
		<div class="container">
			<h1>${title}</h1>

			<section>
				<h3>Tipo de Receita</h3>
				<p>		
				<div class="row">
				 <c:if test="${message ne null}">
							<div>
					        <sf:label path="message">${message}</sf:label>
				             </div>
				             </c:if>
				</div>	
					<sf:form modelAttribute="recipeTypeForm" action="/recipeType/create" method="post">
						<table border="0">							
							<tr>
								<td><label for="id">id:</label></td>								
								<td><sf:input id="id" type="text" path="id" class="form-control" disabled="true" size="40" /></td>
							</tr>							
							<tr>
								<td colspan="2"></br></td>
							</tr>							
							<tr>
								<td><label for="type">type:</label></td>
								<td><sf:input id="type" type="text" path="type" class="form-control" size="40" /></td>
							</tr>
							<tr>
								<td colspan="2"></br></td>
							</tr>
							
							<tr>
								<td><label for="subType">Subtipo:</label></td>
								<td><sf:input id="subType" type="text" path="subType" class="form-control" size="40" /></td>
							</tr>
							<tr>
								<td colspan="2"></br></td>
							</tr>
							<tr align="center">
								<td colspan="2"><input class="btn btn-success btn-md" type="submit" value="Cadastrar" size="20" />
								 <a class="btn btn-default"	href="/recipe" role="button">Cancel</a></td>
							</tr>
						</table>
					</sf:form>
			</section>
		</div>
	</div>


	<jsp:include page="../template/footer.jsp" />

</body>
</html>