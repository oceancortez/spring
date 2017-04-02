
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
				<h3>Nova Receita!</h3>

				<p>
					<sf:form modelAttribute="recipeForm" action="/recipe/create" method="post">
						<table border="0">
							<tr>
								<td><label for="recipeStatus">Estatus da Receita:</label></td>
								<td>
								<sf:select path="recipeStatus">
										<sf:option value="" label="--- Selecione ---" />
										<sf:options items="${recipeStatus}"/>
									</sf:select>
								</td>
								<td><sf:errors path="recipeStatus" cssClass="error" /></td>
							</tr>
							<tr>
								<td colspan="2"></br></td>
							</tr>
							<tr>
								<td><label for="creationDate">Data do Evento:</label></td>
								<td>
									<div class="input-group input-append date" id="datePicker">
										<sf:input type="text" class="form-control" path="creationDate" name="date" />
										<span class="input-group-addon add-on">
										<span class="glyphicon glyphicon-calendar">
										</span>
										</span>
									</div>
								</td>
							</tr>
							<tr>
								<td colspan="2"></br></td>
							</tr>
							<tr>
								<td><label for="idRecipeType">Tipo de Receita:</label></td>
								<td><sf:select path="idRecipeType">
										<sf:option value="" label="--- Selecione ---" />
										<sf:options items="${recipeForm.recipeTypes}" itemLabel="type" itemValue="id" />
									</sf:select>
								</td>
								<td><sf:errors path="idRecipeType" cssClass="error" /></td>
							</tr>
							<tr>
								<td colspan="2"></br></td>
							</tr>
							<tr>
								<td><label for="description">description:</label></td>
								<td><sf:input id="description" type="text" path="description" class="form-control" size="40" /></td>
							</tr>
							<tr>
								<td colspan="2"></br></td>
							</tr>
							<tr>
								<td><label for="idAccount">Escolha uma conta:</label></td>
									<td><sf:select path="idAccount">
										<sf:option value="" label="--- Selecione ---" />
										<sf:options items="${recipeForm.accounts}" itemLabel="numberAgencyAccount" itemValue="id" />
									    </sf:select>
									</td>
								<td><sf:errors path="idAccount" cssClass="error"/></td>
							</tr>
							<tr>
								<td colspan="2"></br></td>
							</tr>
							<tr>
								<td><label for="value">Valor:</label></td>
								<td><sf:input id="value" type="text" path="value" class="form-control" size="40" /></td>
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

	<script>
$(document).ready(function() {
    $('#datePicker')
        .datepicker({
            format: 'mm/dd/yyyy'
        })
        .on('changeDate', function(e) {
            // Revalidate the date field
            $('#recipeForm').formValidation('revalidateField', 'date');
        });

    $('#recipeForm').formValidation({
        framework: 'bootstrap',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            name: {
                validators: {
                    notEmpty: {
                        message: 'The name is required'
                    }
                }
            },
            date: {
                validators: {
                    notEmpty: {
                        message: 'The date is required'
                    },
                    date: {
                        format: 'MM/DD/YYYY',
                        message: 'The date is not a valid'
                    }
                }
            }
        }
    });
});
</script>


	<jsp:include page="../template/footer.jsp" />

</body>
</html>