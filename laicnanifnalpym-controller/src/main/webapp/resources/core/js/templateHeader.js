	

	function initTemplateHeader(){
		getUserNameLogged();		
	}
	


	/*Function Chamando uma url via ajax com  javascrip e jquery*/
	function getUserNameLogged(){
			console.log("bem-vindo");
		$.ajax({
			url : 'http://localhost:8088/user/logged',
			dataType : 'json',
			success : function(retorno){
				var user = retorno;
				if(user == null){
				user = "not user";	
				}
				
				$('#liUser').text(user);
			}
		});

	}

