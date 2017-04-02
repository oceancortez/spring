
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
			<a class="navbar-brand" href="#">SING IN</a>
		</div>
	</div>
</nav>


<div class="jumbotron">
	<div class="container">
		<h1>${title}</h1>
			

		<p>
			<form name="login" action="<c:url value='j_spring_security_check'/>" method="post">				
		<table border="0">
			
			<tr>
				<td><label for="j_username">Email:</label></td>

				<td><input id="j_username" type="email" name="j_username"  class="form-control" size="40" /></td>
			</tr>
			<tr>
				<td colspan="2"></br></td>
			</tr>
			<tr>
				<td><label for="j_password">Senha:</label></td>

				<td><input id="j_password" type="password" name="j_password"  class="form-control" size="40" /></td>
			</tr>
			<tr>
				<td colspan="2"></br></td>
			</tr>
		
			<tr align="right">
				<td colspan="3"><input class="btn btn-success btn-md" type="submit" value="Entrar" size="20" />	
				</td>
			</tr>
		</table>
		 	<p>
		 	
		 	 <c:if test="${param.erro == true}">
		 	 <div align="center">
                                <label style="color: red; font-size: small;" id="message">${message}</label> <br/> <br/>
                            </c:if>				
					
				</div>
				
				
				<c:if test="${message ne null}">
		 	 <div align="center">
                                <label style="color: red; font-size: small;" id="message">${message}</label> 
                                <br/> <br/>              		
					
				</div>
				 </c:if>
		</p>
		
	<%-- 	<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" /> --%>

		</form>

	</div>
</div>



<div class="container">

	
	<footer>
		<p>© oxi.com.br 2016</p>
	</footer>
</div>

<spring:url value="/resources/core/css/hello.js" var="coreJs" />
<spring:url value="/resources/core/css/bootstrap.min.js" var="bootstrapJs" />

<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

</body>
</html>