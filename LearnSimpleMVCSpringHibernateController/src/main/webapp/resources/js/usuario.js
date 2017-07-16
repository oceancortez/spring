
function alert(){
	var x = document.getElementById("usuarios");
	 x.style.color = "red";
}

$( document ).ready(function() {
	 
    alert("jqueri in action!!");
 
});


$("#listaUsuarios").on('click', function (){
	console.log("Você clicou na linha :");
});

$('.btn-cadastrar').on('click', function (){
	
	var data = {
		id : $('input[name="idUsuario"]').val(),
		nome : $('input[name="nome"]').val(),
		email : $('input[name="email"]').val()
	};
	
	sendPOST('/usuario/saveUser', data);
});


