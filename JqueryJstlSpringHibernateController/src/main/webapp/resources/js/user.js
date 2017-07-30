
function alert(){
	var x = document.getElementById("usuarios");
	if(x){
		
		x.style.color = "red";
	}
}

$( document ).ready(function() {
	 
    alert("jqueri in action!!");
 
});


$("#listaUsuarios").on('click', function (){
	console.log("Você clicou na linha :");
});

$('.btn-save').on('click', function (){
	
	var data = {
		idUsuario : $('input[name="idUsuario"]').val(),
		nome : $('input[name="nome"]').val(),
		email : $('input[name="email"]').val()
	};
	
    sendPOST('/user/save', data, responseSaveUsuario);
	console.log(response);
	
	$( "usuarios" ).fadeOut( "slow" );

	
});

//Get callback  .btn-save 
//function responseSaveUser(data){
//	console.log(data);
// 
//	setTimeout(function (){
//		window.location = 'http://localhost:8080/user/getUsers';
//	},1000);
//	
//	
//};

//Get callback  .btn-save atualiza o DOM a table
function responseSaveUsuario(data){
console.log(data);
$("#listaUsuarios tbody").empty(); 
$.each(data.users, function (i, user){
	$("#listaUsuarios").append(
            "<tr><td>" + user.idUsuario + "</td>" +
            "<td>" + user.nome + "</td>" +
            "<td>" + user.email + "</td>" +
            "<td>" + user.dtUltAlt + "</td>" +
            "<td><a onclick='alert();'>Alert</a></td>" 
            );
	
});
	
};




//$('#listaUsuarios').val(data.users).fadeIn('slow', function (){
//	window.location = 'http://localhost:8080/user/getUsers';
//});
//};


//Mostrar/Esconder filtro
function showHideSection() {
	$(this).parent().next().next().slideToggle(300);
	if ($(this).find("i").hasClass("fa-angle-down")) {
		$(this).find("i").removeClass('fa-angle-down').addClass('fa-angle-up');
	} else {
		$(this).find("i").removeClass('fa-angle-up').addClass('fa-angle-down');
	}
};

//Exibir/Ocultar filtro
$(document.body).off('click', '.expand a').on('click', '.expand a', showHideSection);

$('.expand a, .btn-configurar-exibicao-lista, .btn-recalcular-cotacao')
.tooltip({
	'placement' : 'left'
});

$('.expand a').on('click', function (){
	
	if ($(this).find("i").hasClass("fa-angle-up")) {
		$(this).find("i").removeClass('fa-angle-down').addClass('fa-angle-up');
		$('#usuarios').hide();
	} else {
		$(this).find("i").removeClass('fa-angle-up').addClass('fa-angle-down');
		$('#usuarios').show();
	}
	
});




$('.btn-save-user').on('click', function (){
	
	var data = {
		idUsuario : $('input[name="idUsuario"]').val(),
		nome : $('input[name="nome"]').val(),
		email : $('input[name="email"]').val()
	};
	
    sendPOST('/user/save', data, fetchDataTable);
	console.log(response);
	
	$( "usuarios" ).fadeOut( "slow" );

	
});

function fetchDataTable(data){
	//TODO Não está atualizando a table ainda rs
	$('#usersTable').DataTable().data(data);
}


$(document).ready(function (){
	try {
	$('#usersTable').DataTable({
		"ajax": {
			"url": "/user/getUsersJqueryDataTable",
			"dataSrc": "users"
		},
		"columns":[
			{data: 'idUsuario'},
			{data: 'nome'},
			{data: 'email'},
			{data: 'dtUltAlt'}
		],
		
	
		"processing": true,
		//"serverSide": true,
		"destroy": true,
		"searchDelay": 1000,
		"oLanguage" : {
			"sProcessing": "Carregando...",
			"sZeroRecords" : "Nenhum registro encontrado",
			"sEmptyTable" : "Nenhum registro encontrado",
			"sSortAscending" : " - click/return to sort ascending ",
			"sSortDescending" : " - click/return to sort descending ",
			"sInfo" : " Mostrando _START_ a _END_ de um total de _TOTAL_ registros",
			"sInfoEmpty" : "",
			"sInfoFiltered" : " (filtrada de _MAX_ registros)",
			"sLengthMenu" : "Exibir _MENU_ registros",
			"oPaginate" : {
				"sFirst" : "<<",
				"sLast" : ">>",
				"sNext" : ">",
				"sPrevious" : "<"
			}
		},
	});	
	}catch (e){
		alert(e);
	};
});



