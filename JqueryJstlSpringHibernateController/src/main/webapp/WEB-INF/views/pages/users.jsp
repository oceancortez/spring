<%@ page pageEncoding="UTF-8"%>   

<h4 class="expand">Consulta Usuarios
    <a href="javascript:void(0)" class="pull-right" title="Clique para ocultar ou exibir o conteúdo">
    <i class="fa fa-angle-up fa-lg"></i>
    <i class="fa fa-angle-down" aria-hidden="true"></i>
    </a>
</h4>
<h3 class="show-message"><c:out value="${message}"></c:out></h3>
<hr>
<div>	<div class="form-create-user">
			    <fieldset class="fieldset-border">
			    	<legend class="legend-border">Cadastro de Usuário</legend>
			        <div class="row">
			            <div class="col-md-2 col-sm-3 col-xs-6">
			                <div class="form-group">
			                    <label>Código Usuário:</label>
			                    <input type="text" name="idUsuario" class="form-control input-sm" disabled="disabled">
			                </div>
			            </div>
			            <div class="col-md-5 col-sm-3 col-xs-6">
			                <div class="form-group">
			                    <label>Nome:</label>
			                    <input type="text" name="nome" class="form-control input-sm">
			                </div>
			            </div>
			            <div class="col-md-4 col-sm-3 col-xs-6">
			                <div class="form-group">
			                    <label>Email:</label>
			                    <input type="email" name="email" class="form-control input-sm" >
			                </div>
			            </div>
			        </div>
			        <div class="row">
			            <div class="col-md-4 col-sm-6 col-xs-6">
			                <div class="form-group">
			                    <label>Data Última Alteração:</label>
			                    <span class="help" data-content="Após o preenchimento do 'Nome cliente' o campo 'Tipo pessoa' também deve ser informado.">?</span>
			                    <input type="text" name="dtUltAlt" disabled="disabled" class="form-control input-sm">
			                </div>
			            </div>
			        </div>
			    </fieldset>
			    
			    <!--<hr style="margin-top:10px !important">-->
			    <div class="clearfix">
			        <div class="pull-right">
			             <!-- button type="button" class="btn btn-default btn-sm btn-pesquisar"><i class="fa fa-search fa-fw"></i>Pesquisar</button-->
			             <button type="button" class="btn btn-default btn-sm btn-save-user">
			             	<i class="fa fa-search fa-fw"></i>
			             	cadastrar
			             </button>
			        </div>
			    </div>
			    <hr style="margin-top: 20px ! important;" class="divider">
			</div>
	</div>		
<hr> 

	<h4 class="expand">
		Cadastro de Usuário
		<a href="javascript:void(0)"
			class="pull-right" title="Clique para ocultar ou exibir o conteúdo"><i
			class="fa fa-angle-up fa-lg"></i></a>
	</h4>

<div id="users">
<hr style="margin-top: 20px ! important;" class="divider">
	<div class="row">
			<div class="col-md-12">	

			<table id="usersTable"
						class="table table-striped table-hover">
						<thead>
							<tr>								
									<th>id</th>
									<th>nome</th>
									<th>email</th>
									<th>Data de Alterção</th>
							
							</tr>
						
						</thead>		
			<%-- <tbody>
						
							<c:forEach items="${userOut.users}" var="user"> 
						<tr>
								<td>${user.idUsuario}</td>
								<td>${user.nome}</td>
								<td>${user.email}</td>
								<td>${user.dtUltAlt}</td>
						</tr>
							</c:forEach>
						
			</tbody> --%>
			</table>
		</div>
		</div>
</div>
<script type="text/javascript" src='<c:url value="/js/user.js"/>'></script>
