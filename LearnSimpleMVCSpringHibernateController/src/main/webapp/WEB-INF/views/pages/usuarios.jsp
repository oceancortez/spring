<%@ page pageEncoding="UTF-8"%>   

<h4 class="expand">Consulta Usuarios
    <a href="javascript:void(0)" class="pull-right" title="Clique para ocultar ou exibir o conteúdo">
    <i class="fa fa-angle-up fa-lg"></i>
    </a>
</h4>
<h3><c:out value="${message}"></c:out></h3>
<hr>
<div>
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
			             <button type="button" class="btn btn-default btn-sm btn-cadastrar" data-url-especifica='<c:url value="/cliente/pesquisar"/>'>
			             	<i class="fa fa-search fa-fw"></i>
			             	cadastrar
			             </button>
			        </div>
			    </div>
			    <hr style="margin-top: 20px ! important;" class="divider">
			</div>
<hr> 

<div id="usuarios">
	<table id="listaUsuarios" class="table table-striped table-hover">
		<c:if test="${not empty usuarios}">
		<tr>
			<th>id</th>
			<th>nome</th>
			<th>email</th>
			<th>data ultima alteração</th>
			<th>Action</th>
		</tr>		
			<c:forEach items="${usuarios}" var="usuario">
			<tr>
				<td>${usuario.id}</td>
				<td>${usuario.nome}</td>
				<td>${usuario.email}</td>
				<td>${usuario.dtUltAlt}</td>
				<td><a onclick="alert();">Alert</a></td>
			</tr> 						
			</c:forEach>		
		</c:if>
	</table>		
</div>
<script type="text/javascript" src='<c:url value="/js/usuario.js"/>'></script>
