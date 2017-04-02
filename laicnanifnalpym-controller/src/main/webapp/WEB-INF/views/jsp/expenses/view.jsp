
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">


<spring:url value="/resources/core/js/recipeView.js" var="recipeView" />


<jsp:include page="../template/header.jsp" />

<body>
	<!-- Inclusão do javascript  -->
	<script src="${recipeView}"></script>
	<div class="jumbotron">
		<div class="container">
			<h1>${title}</h1>
			
				<div class="row">
					 <div class="col-lg-3 col-md-6">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <div class="row">                                    
                                    <div class="col-xs-9 text-right">
                                    <div>Receitas</div>
                                        <div class="huge">
                                        <label>R$</label>
                                        <label>5000</label>
                                        </div>                                        
                                    </div>
                                </div>
                            </div>                            
                        </div>
                    </div>
                    
                     <div class="col-lg-3 col-md-6">
                        <div class="panel panel-danger">
                            <div class="panel-heading">
                                <div class="row">                                    
                                    <div class="col-xs-9 text-right">
                                    <div>Receitas à Receber</div>
                                        <div class="huge">
                                        <label>R$</label>
                                        <label>2000</label>
                                        </div>                                        
                                    </div>
                                </div>
                            </div>                            
                        </div>
                    </div>
                    
                     <div class="col-lg-3 col-md-6">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <div class="row">                                    
                                    <div class="col-xs-9 text-right">
                                    <div>Total do Mês</div>
                                        <div class="huge">
                                        <label>R$</label>
                                        <label>5000</label>
                                        </div>                                        
                                    </div>
                                </div>
                            </div>                            
                        </div>
                    </div>
                    
                     <div class="col-lg-3 col-md-6">
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <div class="row">                                    
                                    <div class="col-xs-9 text-right">
                                    <div>Saldo fechado no ano!</div>
                                        <div class="huge">
                                        <label>R$</label>
                                        <label>40</label>
                                        </div>                                        
                                    </div>
                                </div>
                            </div>                            
                        </div>
                    </div>				
				
				</div>
				
				
			
				<div class="panel panel-primary">
					<div class="row">
						<div class="col-sm-3" align="center">
							<h4 class="">Cadastre suas Receitas</h4>
						</div>
						<div class="col-sm-3">
							<a href="/receita/cadastrar" class="btn btn-primary btn-md active" role="button">Cadatrar</a>
						</div>
					</div>
				</div>
				<c:if test="${listRecipes ne null}">
					<div class="table-responsive">
						<table class="table">
							<thead style="color: black;">
								<tr>
									<th>Recebido</th>
									<th>Data</th>
									<th>Descrição</th>
									<th>Tipo de Receita</th>
									<th>Conta</th>
									<th>Valor</th>
									<th>Efetivar Receita</th>
									<th>Editar Receita</th>
									<th>Deletar Receita</th>
								</tr>
							</thead>

							<c:forEach var="list" items="${listRecipes}">
								<tbody>
									<tr>
										<td id="tdReceivedStatus"><c:out value="${list.receivedStatus}" /></td>
										<td id="tdCreationDate"><fmt:formatDate value="${list.creationDate}" type="date" pattern="dd/MM/yyyy" /></td>
										<td id="tdDescription"><c:out value="${list.description}" /></td>
										<td id="tdType"><c:out value="${list.recipeType.type}" /></td>
										<td id="tdNumberAgencyAccount"><c:out value="${list.account.numberAgencyAccount}" /></td>
										<td id="tdValue"><c:out value="${list.value}" /></td>

										<td id="tdMakeReal"><c:url value="/WEB-INF/views/jsp/template/modalMakeReal.jsp" var="urlModalMakeReal"></c:url> <a
											data-toggle="modal" data-target="#modalMakeReal" href="${urlModalMakeReal}" class="btn btn-success"
											onclick="setaDadosModal('${list.id}')"> <span class="btn-label"><i class="fa fa-check"></i></span> Efetivar
										</a></td>

										<td id="tdUpdate"><a data-toggle="modal" role="button" data-target="#modalUpdate" href="/receita/atualizar/${list.id}"
											class="btn btn-primary" onclick="setaDadosModal('${list}')"> <span class="btn-label"><i
													class=" glyphicon glyphicon-pencil"></i></span> Atualizar
										</a></td>


										<td id="tdDelete"><a data-toggle="modal" data-target="#modalDelete" class="btn btn-danger"
											onclick="setaDadosModal('${list.id}')"> <span class="btn-label"><i class="glyphicon glyphicon-trash"></i></span> Deletar
										</a></td>
									</tr>
								</tbody>
							</c:forEach>
						</table>
						</table>
				</c:if>
		</div>

	</div>
	</div>


	<!-- Modal Efetivar -->
	<div class="modal" id="modalMakeReal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Efetivar Receita</h4>
				</div>
				<div class="modal-body">
					<sf:form class="form-horizontal" role="form" modelAttribute="recipeForm" action="/receita/atualizar" method="post">

						<div class="form-group">
							<label class="control-label col-sm-4" for="creationDate">Data do Evento:</label>
							<div class="col-sm-6">
								<sf:label class="form-control" id="creationDate" path="creationDate" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-4" for="idAccount">Escolha uma conta:</label>
							<div class="col-sm-6">
								<sf:label class="form-control" id="idAccount" path="idAccount" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-4" for="value">Valor:</label>
							<div class="col-sm-6">
								<sf:label class="form-control" id="value" path="value" name="value" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10" align="center">
								<input class="btn btn-success btn-md" type="submit" value="Efetivar" size="20" />
							</div>
						</div>

					</sf:form>
				</div>
				<div class="modal-footer" align="center"></div>
			</div>
		</div>
	</div>


	<!-- Modal Update -->
	<div class="modal" id="modalUpdate" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Atualizar Receita</h4>
				</div>
				<div class="modal-body">
					<sf:form class="form-horizontal" role="form" modelAttribute="recipeForm" action="/receita/atualizar" method="post">

						<div class="form-group">
							<label class="control-label col-sm-4" for="receivedStatus">Estatus da Receita:</label>
							<div class="col-sm-6">
								<sf:select class="form-control" id="receivedStatus" path="receivedStatus">
									<sf:option value="" label="--- Selecione ---" />
									<sf:options items="${receivedStatus}" />
								</sf:select>
							</div>
							<div class="col-sm-6">
								<sf:errors path="receivedStatus" cssClass="error" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-4" for="creationDate">Data do Evento:</label>
							<div class="col-sm-6">
								<div class="input-group input-append date" id="datePicker">
									<sf:input id="creationDate" type="text" class="form-control" path="creationDate" name="date" />
									<span class="input-group-addon add-on"> <span class="glyphicon glyphicon-calendar"></span>
									</span>
								</div>
							</div>
						</div>

						<div class="form-group">

							<label class="control-label col-sm-4" for="idRecipeType">Tipo de Receita:</label>
							<div class="col-sm-6">
								<sf:select class="form-control" path="idRecipeType" id="idRecipeType">
									<sf:option value="" label="--- Selecione ---" />
									<sf:options items="${recipeForm.recipeTypes}" itemLabel="type" itemValue="id" />
								</sf:select>
							</div>
							<div class="col-sm-6">
								<sf:errors class="form-control" id="idRecipeType" path="idRecipeType" cssClass="error" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-4" for="description">description:</label>
							<div class="col-sm-6">
								<sf:input class="form-control" id="description" type="text" path="description" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-4" for="idAccount">Escolha uma conta:</label>
							<div class="col-sm-6">
								<sf:select class="form-control" id="idAccount" path="idAccount">
									<sf:option value="" label="--- Selecione ---" />
									<sf:options items="${recipeForm.accounts}" itemLabel="numberAgencyAccount" itemValue="id" />
								</sf:select>
							</div>
							<div class="col-sm-6">
								<sf:errors class="form-control" path="idAccount" cssClass="error" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-4" for="value">Valor:</label>
							<div class="col-sm-6">
								<sf:input class="form-control" id="value" type="text" path="value" />
							</div>
						</div>

						<div class="form-group" align="right">
							<div class="col-sm-offset-2 col-sm-6">
								<input class="btn btn-primary btn-md" type="submit" value="Atualizar" />
							</div>
						</div>

					</sf:form>
				</div>
				<div class="modal-footer" align="center"></div>
			</div>
		</div>
	</div>

	<!-- Modal Deletar -->
	<div class="modal" id="modalDelete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" align="center" id="myModalLabel">Deletar Receita?</h4>
				</div>
				<div class="modal-body">
					<sf:form class="form-horizontal" role="form" modelAttribute="recipeForm" action="/receita/deletar" method="post">

						<div class="form-group">
							<label class="control-label col-sm-4" for="creationDate">Data do Evento:</label>
							<div class="col-sm-6">
								<sf:label class="form-control" id="creationDate" path="creationDate" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-4" for="description">Descrição:</label>
							<div class="col-sm-6">
								<sf:label class="form-control" id="description" path="description" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-4" for="idAccount">Conta:</label>
							<div class="col-sm-6">
								<sf:label class="form-control" id="idAccount" path="idAccount" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-4" for="value">Valor:</label>
							<div class="col-sm-6">
								<sf:label class="form-control" id="value" path="value" name="value" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10" align="center">
								<input class="btn btn-danger btn-md" type="submit" value="Deletar" size="40" />
							</div>
						</div>

					</sf:form>
				</div>
				<div class="modal-footer" align="center"></div>
			</div>
		</div>
	</div>

	<jsp:include page="../template/footer.jsp" />

</body>
</html>