
//Sincrona false
function test1(){
	
	alert("Inicio");
	
    var request = new XMLHttpRequest();    
    request.open(
        "GET","http://localhost:8080/ProyectoRestaurante/rest/restauranteService/recuperarTodos",
        false);
    request.send(null);
    var respuesta = request.responseText;
    
    alert(respuesta);
    console.log(request.status + " : " + request.statusText);
    
    alert("Fin");
    
}


//Asincrona true  --No hay respuesta aun
//no se queda esperando el resto del codigo sigue ejecutandose
function test2(){
	
	alert("Inicio");
	
    var request = new XMLHttpRequest();    
    request.open(
        "GET","http://localhost:8080/ProyectoRestaurante/rest/restauranteService/recuperarTodos",
        true);
    request.send(null);
    var respuesta = request.responseText;
    
    alert(respuesta);
    console.log(request.status + " : " + request.statusText);
    
    alert("Fin");
    
}


//Asincrona true  
function test3(){ //Recuperar
	
  alert("Inicio");
	
  var request = new XMLHttpRequest();    
  request.open(
      "GET","http://localhost:8080/ProyectoRestaurante/rest/restauranteService/recuperarTodos",
      true);
  request.send(null);
  request.onreadystatechange = function(){  //llama a este metodo cada vez que cambia de estado
	  if(request.readyState == 4){ //El 4 es porque termino de responder
		  var respuesta = request.responseText;		  
		  //alert(respuesta);
		  console.log(respuesta + " " + request.status + " : " + request.statusText);  
	  }
  	};  
    
  alert("Fin");
  
}


function test4(){  //Insertar
	
	  alert("Inicio");
	  
	  var restaurante = {
				codigo: 23,
		        nombre: "KLM",
		        telefono: "29023" 
		}
		
	  var cadenaJson = JSON.stringify(restaurante);		
		
		
	  var request = new XMLHttpRequest();    
	  request.open(  //abrimos la conexion
	      "PUT",  //accion
	      "http://localhost:8080/ProyectoRestaurante/rest/restauranteService/insertar",  //URL
	      true); //SINCRONA/ASINCRONA
	  request.setRequestHeader("Content-Type", "application/json");
	  request.send(cadenaJson);	
	  request.onreadystatechange = function(){  //llama a este metodo cada vez que cambia el estado del request
		  if(request.readyState == 4){ //El 4 es porque termino de responder
			  var respuesta = request.responseText;		  
			  //alert(respuesta);
			  console.log(respuesta + " " + request.status + " : " + request.statusText);  
			  // request.status  --> ex: 500 codigos
			  // request.statusText  --> ex:"File not found"
		  }
	  	};  
	    
	  alert("Fin");
	  
	}

//SINCRONA (false)--espera que responda
//ASINCRONA (true)--no espera que reponda, sigue la ejecucion

//Estados:
/*
 * 0 request no inicializado
 * 1 coneccion del servidor establecida
 * 2 request recibida
 * 3 procesando request
 * 4 request terminada y respuesta lista
 *
 * */

//var objeto = JSON.parse(objetoJSon);  //array de objetos




