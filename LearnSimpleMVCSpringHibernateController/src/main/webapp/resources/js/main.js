
function alert(){
	var x = document.getElementById("usuarios");
	 x.style.color = "red";
}

function pageTransition1(url, data, target, callback){
	$.get(url,data,$.noop).done(function(response){

		console.log(response);
		try {

			if (Object.keys(response.mensagens).length) {

				return;
			}
		} catch (e) {
			console.log("Erro no metodo pageTransition1 e["+e+"]");
		}


			target.fadeOut(200, function(){
				target.html(response);
				target.fadeIn(800);
				if(callback){
					callback();
				}
			})
		});
};

function pageTransitionPOST(url, data, target, callback){
	$.post(url,data,$.noop).done(function(response){

		console.log(response);
		try {

			if (Object.keys(response.mensagens).length) {

				return;
			}
		} catch (e) {
			console.log("Erro no metodo pageTransition1 e["+e+"]");
		}


			target.fadeOut(200, function(){
				target.html(response);
				target.fadeIn(800);
				if(callback){
					callback();
				}
			})
		});
};



function sendPOST(url, data){
	
	 $.ajax({

         type : 'POST',
         url : '${pageContext.request.contextPath}' + url,
         data:data,
         contentType: "application/json",
         dataType : "application/json",
         success : function(response) {
        	 console.log(response);     

         },
         error : function(xhr, ajaxOptions, thrownError) {
             return false;
         }        

     });
	
};