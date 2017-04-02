
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

	<!DOCTYPE html>
	<html lang="en">
	<spring:url value="/resources/core/js/recipeView.js" var="recipeView" />
	<spring:url value="/resources/core/js/jquery-3.0.0.min.js" var="jquery" />
	<jsp:include page="../template/header.jsp" />

	<body onload="init()">

		<div class="jumbotron">
			<div class="container">
				<h1>${title}</h1>
				
					<div class="row">
						 <div class="col-lg-3 col-md-6">
							<div class="panel panel-primary">
								<div class="panel-heading">
									<div class="row">                                    
										<div class="col-xs-9 text-right">                                    
											<div class="huge">
											<h3>Receitas</h3>
											<h2 id="hValueRecipeReceivedForMonth"></h2>                                        
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
											<div class="huge">
											<h4>Receitas a Receber</h4>
											<h2 id="hValueRecipeReceivableForMonth"></h2>                                        
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
											<div class="huge">
											<h3>Saldo Consolidado</h3>
											<h2 id="hValueRecipeConsolidatedForMonth"></h2>                                        
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
										<div class="col-xs-9 text-center">                                    
											<div class="row">
											<div class="huge">
											  <h5>Total de Receitas Cadastradas</h5>                          
											  <h2 id="hValueRecipeHasCreated"></h2>                                        
											  </div>                                                      
											</div>                                                                                
										</div>
									</div>
								</div>                            
							</div>
						</div>
					</div>
					
					
				
					<div class="panel panel-primary">
						<div class="row">							
							<div class="col-sm-12" align="center">
								<a data-toggle="modal" data-target="#modalCreate" class="btn btn-success col-sm-12 role="button">
								<h4>Cadastrar Receita</h4></a>
							</div>
						</div>
					</div>
					<c:if test="${listRecipes ne null}">
						<div class="table-responsive">
							<table id="tblRecipe" class="table">
								<thead style="color: black;">
									<tr>
										<th>Id de Cadastro</th>
										<th>Recebido</th>
										<th>Data</th>
										<th>Descricao</th>
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
										<tr id="trRecipe">
											<td id="tdId" align="center" ><c:out value="${list.id}"/></td>
											<td id="tdRecipeStatus"><c:out value="${list.recipeStatus}" /></td>
											<td id="tdCreationDate"><fmt:formatDate  value="${list.creationDate}" type="date" pattern="dd/MM/yyyy"/></td>
											<td id="tdDescription"><c:out value="${list.description}" /></td>
											<td id="tdRecipeType"><c:out value="${list.recipeType.type}" /></td>
											<td id="tdNumberAgencyAccount"><c:out value="${list.account.numberAgencyAccount}" /></td>
											<td id="tdValue"><c:out value="${list.value}" /></td>
											
											<td id="tdMakeReal">										
											<a id="buttonMakeReal"	data-toggle="modal" data-target="#modalMakeReal" class="btn btn-warning" onclick="setModalactualize();">
												 <span class="btn-label">
												 <i id="iCheck" class="fa fa-check"></i>
												 <i id="iBan"  class="fa fa-ban"></i>
												 </span>Efetivar
											 </a>
											</td>
					
											<td id="tdUpdate">
											<a data-toggle="modal" data-target="#modalUpdate" class="btn btn-primary" onclick="setModalUpdate();">
												 <span class="btn-label">
												 <i	class="glyphicon glyphicon-pencil"></i>
												 </span>Atualizar
											</a>
											</td>

											<td id="tdDelete">
											<a data-toggle="modal" data-target="#modalDelete" class="btn btn-danger" onclick="setModalDelete();">
												 <span class="btn-label">
												 <i class="glyphicon glyphicon-trash"></i>
												 </span>Deletar
											</a>
											</td>
											<!-- <td id="total"><input class="btn btn-warning" type="button" name="total" value="Ajax Test" onclick="showValueRecipe()"/></td> -->
										</tr>
									</tbody>
								</c:forEach>
							</table>
							</table>
					</c:if>
			</div>

		</div>
		</div>

		<!-- Modal Create -->
		<div class="modal" id="modalCreate" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header" align="center">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Cadastrar Receita</h4>
					</div>
					<div class="modal-body">
						<sf:form class="form-horizontal" role="form" modelAttribute="recipeForm" action="/recipe/create" method="post">

							<div class="form-group">
								<label class="control-label col-sm-4" for="inputRecipeStatusCreate">Estatus da Receita:</label>
								<div class="col-sm-6">
									<sf:select class="form-control" id="inputRecipeStatusCreate" path="recipeStatus">
										<sf:option value="" label="--- Selecione ---" />
										<sf:options items="${recipeStatus}" />
									</sf:select>
								</div>
								<div class="col-sm-6">
									<sf:errors path="recipeStatus" cssClass="error" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-4" for="inputCreationDateCreate">Data do Evento:</label>
								<div class="col-sm-6">
									<div class="input-group input-append date" id="datePicker">
										<sf:input id="inputCreationDateCreate" type="text" class="form-control" path="creationDate" name="date" />
										<span class="input-group-addon add-on"> <span class="glyphicon glyphicon-calendar"></span>
										</span>
									</div>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-4" for="inputRecipeTypeCreate">Tipo de Receita:</label>
								<div class="col-sm-6">
									<sf:select class="form-control" path="idRecipeType">
										<sf:option value="" label="--- Selecione ---"    id="inputRecipeTypeCreate" />
										<sf:options items="${listRecipeTypeEntities}" itemLabel="type" itemValue="id" />
									</sf:select>
								</div>
								<div class="col-sm-6">
									<sf:errors class="form-control" id="idRecipeType" path="idRecipeType" cssClass="error" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-4" for="inputDescriptionCreate">description:</label>
								<div class="col-sm-6">
									<sf:input class="form-control" id="inputDescriptionCreate" type="text" path="description" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-4" for="inputIdAccountCreate">Escolha uma conta:</label>
								<div class="col-sm-6">
									<sf:select class="form-control" path="idAccount">
										<sf:option value="" label="--- Selecione ---" id="inputIdAccountCreate" />
										<sf:options items="${listAccounts}" itemLabel="numberAgencyAccount" itemValue="id" />
									</sf:select>
								</div>
								<div class="col-sm-6">
									<sf:errors class="form-control" path="idAccount" cssClass="error" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-4" for="inputValueCreate">Valor:</label>
								<div class="col-sm-6">
									<sf:input class="form-control" id="inputValueCreate" type="text" path="value" />
								</div>
							</div>

							<div class="form-group" align="right">
								<div class="col-sm-offset-2 col-sm-6">
									<input class="btn btn-success btn-md" type="submit" value="Cadastrar" />
								</div>
							</div>

						</sf:form>
					</div>
					<div class="modal-footer" align="center"></div>
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
						<h4 class="modal-title text-center" id="myModalLabel">Efetivar Receita</h4>
					</div>
					<div class="modal-body">
						<sf:form id="recipeForm" class="form-horizontal" role="form" modelAttribute="recipeForm" action="#" method="post">

						<div class="form-group">										
							<label  class="form-control" id="labelMessage"><c:out value="${message}"/></label>			
						</div>		
					

						<div class="form-group">	
							<label class="control-label col-sm-4" for="id">Id:</label>																				
								<div class="col-sm-3">							
									<sf:input  class="form-control" id="inputIdRecipe" path="id" disabled="true" />
								</div>
						</div>				


							<div class="form-group">							
								
								<label class="control-label col-sm-4" for="creationDate">Data do Evento:</label>
								<div class="col-sm-3">
									<sf:input  class="form-control" id="inputCreationDate" value="${recipeForm.creationDate}" path="creationDate" disabled="true" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-4" for="idAccount">Conta:</label>
								<div class="col-sm-3">
									<sf:input class="form-control" id="inputIdAccount" path="idAccount" value="${recipeForm.idAccount}" disabled="true" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-4" for="value">Valor:</label>
								<div class="col-sm-3">
									<sf:input class="form-control" id="inputValue" path="value" name="value" disabled="true" />
								</div>
							</div>

							<div class="form-group">
								<div class="col-sm-offset-1 col-sm-10" align="center">
									<input id="btnEfetivar" onclick="actualizeRecipeGet()" class="btn btn-success btn-md" type="button" value="Efetivar" size="20" />
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
						<sf:form class="form-horizontal" role="form" modelAttribute="recipeForm" action="/recipe/update" method="post">

						<div class="form-group">	
							<label class="control-label col-sm-4" for="inputIdRecipeUpdate">Id:</label>																			
								<div class="col-sm-3">							
									<sf:input  class="form-control" id="inputIdRecipeUpdate" readonly="true" type="text" path="id"  />									
								</div>
						</div>

							<div class="form-group">
								<label class="control-label col-sm-4" for="inputRecipeStatusUpdate">Estatus da Receita:</label>
								<div class="col-sm-6">
									<sf:select class="form-control" id="inputRecipeStatusUpdate" path="recipeStatus">
										<sf:option value="" label="--- Selecione ---" />
										<sf:options items="${recipeStatus}" />
									</sf:select>
								</div>
								<div class="col-sm-6">
									<sf:errors path="recipeStatus" cssClass="error" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-4" for="inputCreationDateUpdate">Data do Evento:</label>
								<div class="col-sm-6">
									<div class="input-group input-append date" id="datePicker">
										<sf:input id="inputCreationDateUpdate" type="text" class="form-control" path="creationDate" name="date" />
										<span class="input-group-addon add-on"> <span class="glyphicon glyphicon-calendar"></span>
										</span>
									</div>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-4" for="inputRecipeTypeUpdate">Tipo de Receita:</label>
								<div class="col-sm-6">
									<sf:select class="form-control" path="idRecipeType">
										<sf:option value="" label="--- Selecione ---"    id="inputRecipeTypeUpdate" />
										<sf:options items="${listRecipeTypeEntities}" itemLabel="type" itemValue="id" />
									</sf:select>
								</div>
								<div class="col-sm-6">
									<sf:errors class="form-control" id="idRecipeType" path="idRecipeType" cssClass="error" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-4" for="inputDescriptionUpdate">description:</label>
								<div class="col-sm-6">
									<sf:input class="form-control" id="inputDescriptionUpdate" type="text" path="description" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-4" for="inputIdAccountUpdate">Escolha uma conta:</label>
								<div class="col-sm-6">
									<sf:select class="form-control" path="idAccount">
										<sf:option value="" label="--- Selecione ---" id="inputIdAccountUpdate" />
										<sf:options items="${listAccounts}" itemLabel="numberAgencyAccount" itemValue="id" />
									</sf:select>
								</div>
								<div class="col-sm-6">
									<sf:errors class="form-control" path="idAccount" cssClass="error" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-4" for="inputValueUpdate">Valor:</label>
								<div class="col-sm-6">
									<sf:input class="form-control" id="inputValueUpdate" type="text" path="value" />
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
						<sf:form id="recipeForm" class="form-horizontal" role="form" modelAttribute="recipeForm" action="/recipe/delete" method="post">

								<div class="form-group">										
									<label  class="form-control" id="labelMessage"><c:out value="${message}"/></label>			
								</div>	

							<div class="form-group">	
									<label class="control-label col-sm-4" for="inputIdRecipeDelete">Id:</label>
								<div class="col-sm-6">								
									<sf:input class="form-control" type="text" readonly="true" id="inputIdRecipeDelete" path="id" />
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-4" for="inputCreationDateDelete">Data do Evento:</label>
								<div class="col-sm-6">
									<sf:input class="form-control" id="inputCreationDateDelete" path="creationDate" value="${recipeForm.creationDate}" disabled="true" />
								</div>
							</div>					

							<div class="form-group">
								<label class="control-label col-sm-4" for="inputIdAccountDelete">Conta:</label>
								<div class="col-sm-6">
									<sf:input class="form-control" id="inputIdAccountDelete" path="idAccount" value="${recipeForm.idAccount}" disabled="true"/>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-4" for="inputValueDelete">Valor:</label>
								<div class="col-sm-6">
									<sf:input class="form-control" id="inputValueDelete" path="value"  value="${recipeForm.value}" disabled="true"  />
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

		<!-- Inclus�o do javascript  -->
	<script src="${recipeView}"></script>
	<script src="${jquery}"></script>

	</body>
	</html>