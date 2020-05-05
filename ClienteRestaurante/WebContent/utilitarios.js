//Funcion Generica
function invocarRest(accion,url,objeto,funcion){
	
	  var request = new XMLHttpRequest();
	  
	  request.open(  
			  accion, 
			  url,  
	          true); 
	  
	  if (accion=="PUT"){
		  if(objeto != null){
			  var cadenaJson = JSON.stringify(objeto);	
			  request.setRequestHeader("Content-Type", "application/json");	
			  request.send(cadenaJson);
		  }	  
	  }else if(accion=="GET"){
		  request.send(null);
	  }
	  
	  request.onreadystatechange = function(){  
		  if(request.readyState == 4){ 
			  var respuesta = request.responseText;
			  
				  if(request.status == 200){
					    if(accion=="GET"){
					 // if(funcion!=undefined){
						  var listaRest = JSON.parse(respuesta);
						  funcion(listaRest);
						  console.log(request.status + " : " + request.statusText);
					  }else{			  
						  console.log(respuesta + " " + request.status + " : " + request.statusText);
					  }		
				  }else{
					  console.log(respuesta + " " + request.status + " : " + request.statusText);
					  console.log("error en el servidor");
				  }		 
			  }
	  	}; 
	  
}