
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


function sendPOST(url, data, callback){
	
	$.post('http://localhost:8080' + url,data,$.noop).done(function(response){
			if(response.codStatus == '200'){
				console.log(response);
				sendMessageSuccess(response.message);
				callback(response);
				//$('#usuarios').html(div);
			}else {	
				enviarMsgAlerta(response.message);
				console.log(response.message);
			}

    });
	
};



function sendPOSTOLD(url, data, callback){
	
	 $.ajax({

         type : 'POST',
         //url : '${pageContext.request.contextPath}' + url,
         url : 'http://localhost:8080' + url,
         data: data,
         contentType: "application/json",
         dataType : "application/json",
         success : function(response) {
        	 console.log(response);
        	 if(response.data.message == ""){
				return;
			}else {
				enviarMsgAlerta(response.data.message);
			}        	 

         },
         error : function(xhr, ajaxOptions, thrownError) {
        	 console.log(response);
             return false;
         }        

     });
	
};

function sendGET(url){
	
	 $.ajax({

        type : 'GET',
        //url : '${pageContext.request.contextPath}' + url,
        url : 'http://localhost:8080' + url,
        success : function(response) {
       	 console.log(response);
        },
        error : function(xhr, ajaxOptions, thrownError) {
       	 console.log(response);
            return false;
        }        

    });
	
};


function enviarMsgAlerta(msg){
	 $('h4:first').before('<div class="alert alert-danger validacaoAssistencia"><button type="button" class="close">&times;</button>'+ msg + '</div>');
};

function sendMessageSuccess(msg){
	 $('h4:first').before('<div class="alert alert-success validacaoAssistencia"><button type="button" class="close">&times;</button>'+ msg + '</div>');
};

$(document.body).on('click','div[class*="alert"] .close', function(){
	$(this).parent().hide();
});

