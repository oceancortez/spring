	console.log("bem-vindo");

	function init(){
		showValueRecipeReceivedForMonth();
		showValueRecipeReceivableForMonth();
		showValueRecipeConsolidatedForMonth();
		showTotalValueRecipeHasCreated();
		isReceivedDisableButton();

	}

	function setModalactualize() {

		 /*Recuperando o objeto click*/
		var idRecipe = document.getElementById("tdId").innerHTML;
		var creationDate = document.getElementById("tdCreationDate").innerHTML;
		var numberAgencyAccount = document.getElementById("tdNumberAgencyAccount").innerHTML;
		var valor = document.getElementById("tdValue").innerHTML;

		/*Preenchendo o Modal*/		
		document.getElementById("inputIdRecipe").value = idRecipe;		
		document.getElementById("inputCreationDate").value = creationDate;		
		document.getElementById("inputIdAccount").value = numberAgencyAccount;	
		document.getElementById("inputValue").value = valor;


		console.log(value);	
		
	}


	function setModalDelete(){
		/*Recuperando o objeto onclick*/
		var idRecipe = document.getElementById("tdId").innerHTML;
		var creationDate = document.getElementById("tdCreationDate").innerHTML;
		var numberAgencyAccount = document.getElementById("tdNumberAgencyAccount").innerHTML;
		var valor = document.getElementById("tdValue").innerHTML;

		/*Populando o modal*/
		document.getElementById("inputIdRecipeDelete").value = idRecipe;
		document.getElementById("inputCreationDateDelete").value = creationDate;
		document.getElementById("inputIdAccountDelete").value = numberAgencyAccount;
		document.getElementById("inputValueDelete").value = valor;

	}

		function setModalUpdate(){
		/*Recuperando o objeto onclick*/
		var idRecipe = document.getElementById("tdId").innerHTML;
		var recipeStatus = document.getElementById("tdRecipeStatus").innerHTML;
		var creationDate = document.getElementById("tdCreationDate").innerHTML;
		var recipeType = document.getElementById("tdRecipeType").innerHTML;
		var description = document.getElementById("tdDescription").innerHTML;
		var numberAgencyAccount = document.getElementById("tdNumberAgencyAccount").innerHTML;
		var valor = document.getElementById("tdValue").innerHTML;	

		/*Populando o modal*/
		document.getElementById("inputIdRecipeUpdate").value = idRecipe;
		document.getElementById("inputRecipeStatusUpdate").value = recipeStatus;
		document.getElementById("inputCreationDateUpdate").value = creationDate;
		document.getElementById("inputRecipeTypeUpdate").value = recipeType;
		document.getElementById("inputDescriptionUpdate").value = description;
		document.getElementById("inputIdAccountUpdate").value = numberAgencyAccount;
		document.getElementById("inputValueUpdate").value = valor;

	}

	function setModalCreate(){
		/*Recuperando o objeto onclick*/
		var idRecipe = document.getElementById("tdId").innerHTML;
		var recipeStatus = document.getElementById("tdRecipeStatus").innerHTML;
		var creationDate = document.getElementById("tdCreationDate").innerHTML;
		var recipeType = document.getElementById("tdRecipeType").innerHTML;
		var description = document.getElementById("tdDescription").innerHTML;
		var numberAgencyAccount = document.getElementById("tdNumberAgencyAccount").innerHTML;
		var valor = document.getElementById("tdValue").innerHTML;	

		/*Populando o modal*/
		document.getElementById("inputIdRecipeCreate").value = idRecipe;
		document.getElementById("inputRecipeStatusCreate").value = recipeStatus;
		document.getElementById("inputCreationDateCreate").value = creationDate;
		document.getElementById("inputRecipeTypeCreate").value = recipeType;
		document.getElementById("inputDescriptionCreate").value = description;
		document.getElementById("inputIdAccountCreate").value = numberAgencyAccount;
		document.getElementById("inputValueCreate").value = valor;

	}

	/*Function Chamando uma url POST via ajax com  javascrip e jquery*/

	function getActualizeRecipe(){
			var idRecipe = document.getElementById("tdId").innerHTML;	
			var recipeform = [{id : idRecipe}];
	}





	function actualizeRecipePost(){
			
			// var recipeform = getActualizeRecipe();
			var idRecipe = document.getElementById("tdId").innerHTML;
			var recipeform = [{id : idRecipe}];             
			var recipeDataForm = document.getElementById("recipeForm").value = recipeform;
			

		$.ajax({
			url : 'http://localhost:8088/recipe/actualize',
			type : "POST",
			data : recipeDataForm,
			dataType : 'json',
			success : function(retorno){
				console.log(retorno);	
				document.getElementById("labelMessage").value = retorno;
				}
			// $.ajax({
			// 				url : 'http://localhost:8088/receita',
			// 				dataType : 'json',
			// 				success : success
			// 				});
				});
	}

	function actualizeRecipeGet(){					
			var idRecipe = document.getElementById("tdId").innerHTML;					
		$.ajax({
			url : 'http://localhost:8088/recipe/actualize/'+idRecipe+'',
			type : "GET",        
			dataType : 'json',
			success : function(retorno){            
				window.parent.document.getElementById("modalMakeReal").close();
				location.reload();            
					}        
			});
	}

	function deleteRecipeGet(){
		var idRecipe = document.getElementById("tdId").innerHTML;

		$.ajax({
			url : 'http://localhost:8088/recipe/delete/'+idRecipe+'',
			type: 'GET',
			dataType: 'json',})
			.done(function(retorno){  
			    console.log(retorno);	          
				window.parent.document.getElementById("modalDelete").close();
				location.reload();            
					});        
			}


	// $.$.ajax({
	// 	url: '/path/to/file',
	// 	type: 'default GET (Other values: POST)',
	// 	dataType: 'default: Intelligent Guess (Other values: xml, json, script, or html)',
	// 	data: {param1: 'value1'},
	// })
	// .done(function() {
	// 	console.log("success");
	// })
	// .fail(function() {
	// 	console.log("error");
	// })
	// .always(function() {
	// 	console.log("complete");
	// });
	


	/*Disable button actualize when status = received*/
	function isReceivedDisableButton(){

		var tblRecipe = document.getElementById("tblRecipe").innerHTML;	    

		for (var i = 0; i < tblRecipe.length; i++) {
			var status = document.getElementById("tdReceivedStatus").innerHTML;
			
		if(status == "RECEIVED"){	   
		   document.getElementById("tdMakeReal").disabled = true;
		   document.getElementById("buttonMakeReal").disabled = true;
		   document.getElementById("iCheck").style.visibility = "hidden";
		   document.getElementById("iBan").style.visibility = "visible";
		   status = "";
		}

	 }
	}

	/*Function Chamando uma url via ajax com  javascrip e jquery*/
	function showValueRecipeReceivedForMonth(){
		$.ajax({
			type : "GET",
			url : 'http://localhost:8088/recipe/showValueRecipeReceivedForMonth',		
			dataType : 'json',
			success : function(retorno){
				var total = retorno;
				if(total == null){
				total = "R$ " + 0;	
				}
				total = "R$ " + total;
				$('#hValueRecipeReceivedForMonth').text(total);
			}
		});

	}

	/*Function Chamando uma url via ajax com  javascrip e jquery*/
	function showValueRecipeReceivableForMonth(){
		$.ajax({
			url : 'http://localhost:8088/recipe/showValueRecipeReceivableForMonth',
			dataType : 'json',
			success : function(retorno){
				var total = retorno;
				if(total == null){
				total = "R$ " + 0;	
				}
				total = "R$ " + total;
				$('#hValueRecipeReceivableForMonth').text(total);
			}
		});

	}

	/*Function Chamando uma url via ajax com  javascrip e jquery*/
	function showValueRecipeConsolidatedForMonth(){
		$.ajax({
			url : 'http://localhost:8088/recipe/showValueRecipeConsolidatedForMonth',
			dataType : 'json',
			success : function(retorno){
				var total = retorno;
				if(total == null){
				total = "R$ " + 0;	
				}
				total = "R$ " + total;
				$('#hValueRecipeConsolidatedForMonth').text(total);
			}
		});

	}



	/*Function Chamando uma url via ajax com  javascrip e jquery*/
	function showTotalValueRecipeHasCreated(){
		$.ajax({
			url : 'http://localhost:8088/recipe/showTotalValueRecipeHasCreated',
			dataType : 'json',
			success : function(retorno){
				var total = retorno;
				if(total == null){
				total = "R$ " + 0;	
				}
				total = "R$ " + total;
				$('#hValueRecipeHasCreated').text(total);
			}
		});

	}



	/*$('#buttonMakeReal').click(function(){
		var texto = $('#tdCreationDate').innerHTML
		$('#inputCreationDate').text(texto);
	});
	*/


	/*$('#totalRecipe').click(function(){

		$.ajax({
			url : 'http://localhost:8088/recipe/sumTotal',
			dataType : 'json',
			success : function(retorno){
				var total = this;
				$('#totalRecipe').text(total);			
			}
		});
		
	});*/


// function updateRecipePost(){
// 		var idRecipe = document.getElementById("tdId").innerHTML;
		
// 		$.$.ajax({
// 			url : 'http://localhost:8088/recipe/update',
// 		 	type: 'POST',
// 		 	dataType: 'json',
// 			data: {idRecipe: 'idRecipe'},
// 		})
// 		.done(function() {
// 			window.parent.document.getElementById("modalUpdate").close();
// 			location.reload();  
// 			console.log("success");
// 		})
// 		.fail(function() {
// 			console.log("error");
// 		})
// 		.always(function() {
// 			console.log("complete");
// 		});
// 	}