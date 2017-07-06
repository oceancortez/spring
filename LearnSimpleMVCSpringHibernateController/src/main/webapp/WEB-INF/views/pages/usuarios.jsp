<%@ page pageEncoding="UTF-8"%>    

<div id="listaUsuarios">
	<table border="1">
		<c:if test="${not empty listaUsuarios}">
		<tr>
			<th>id</th>
			<th>nome</th>
			<th>data ultima alteração</th>
			<th>Action</th>
		</tr>		
			<c:forEach items="${listaUsuarios}" var="usuario">
			<tr>
				<td>${usuario.id}</td>
				<td>${usuario.nome}</td>
				<td>${usuario.dtUltAlt}</td>
				<td><a onclick="alert();">Alert</a></td>
			</tr> 						
			</c:forEach>		
		</c:if>
	</table>		
</div>
<script type="text/javascript" src='<c:url value="/js/main.js"/>'></script>