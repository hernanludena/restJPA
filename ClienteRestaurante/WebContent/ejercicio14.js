function insertar(){  //Insertar Restaurante
		  
	  var restaurante = {
				codigo: document.p.codigo.value,
		        nombre: document.p.nombre.value,
		        telefono: document.p.telefono.value 
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
	  	
	  	recuperar();
	  
}


function recuperar(){ //RecuperarTodos
	
	  var request = new XMLHttpRequest();    
	  request.open(
	      "GET","http://localhost:8080/ProyectoRestaurante/rest/restauranteService/recuperarTodos",
	      true); 
	  request.send(null);
	  
	  request.onreadystatechange = function(){  //llama a este metodo cada vez que cambia de estado
		  if(request.readyState == 4){ //El 4 es porque termino de responder
			  var respuesta = request.responseText;	
			  var listaRest = JSON.parse(respuesta);  //array de objetos
			  
			  //alert(respuesta);
			  console.log(respuesta + " " + request.status + " : " + request.statusText);  
			  console.log(listaRest[0].codigo);
			  
			  dibujarTabla(listaRest);
		  }
	  	};  	  	
	  
	}

function dibujarTabla(listaR) {

    var table = document.getElementById("listaRestaurantes");  
    table.innerHTML="";
    //Creación de filas
    //  table.appendChild(document.createElement('tbody'));
    for (var j = 0; j < listaR.length; j++) {
        //  var row2 = table.tBodies[0].insertRow(-1);
        var row1 = table.insertRow(j); //j
        var cell1 = row1.insertCell(0);
        var cell2 = row1.insertCell(1);
        var cell3 = row1.insertCell(2);       
        
       cell1.innerHTML = listaR[j].codigo;
       cell2.innerHTML = listaR[j].nombre;
       cell3.innerHTML = listaR[j].telefono;       
  
    }

    var header = table.createTHead();
    
    var row2 = header.insertRow(0);
    row2.innerHTML = "<b>RESTAURANTES</b>";
    row2.style.textAlign = 'right';
    
    var row3 = header.insertRow(1);
    var cell = row3.insertCell(0);
    cell.innerHTML = "<b>CODIGO</b>";
    
    var cell2 = row3.insertCell(1);
    cell2.innerHTML = "<b>NOMBRE</b>";
    
     var cell3 = row3.insertCell(2);
    cell3.innerHTML = "<b>TELEFONO</b>";    
  
}



function RecuperarGenerico() { 	
	var accion = "GET";	
	var url = "http://localhost:8080/ProyectoRestaurante/rest/restauranteService/recuperarTodos";
	var objeto = null;
	invocarRest(accion,url,objeto,function(listaR){
	    var table = document.getElementById("listaRestaurantes");  
	    table.innerHTML="";
	    //Creación de filas
	    //  table.appendChild(document.createElement('tbody'));
	    for (var j = 0; j < listaR.length; j++) {
	        //  var row2 = table.tBodies[0].insertRow(-1);
	        var row1 = table.insertRow(j); //j
	        var cell1 = row1.insertCell(0);
	        var cell2 = row1.insertCell(1);
	        var cell3 = row1.insertCell(2);       
	        
	       cell1.innerHTML = listaR[j].codigo;
	       cell2.innerHTML = listaR[j].nombre;
	       cell3.innerHTML = listaR[j].telefono;       
	  
	    }

	    var header = table.createTHead();
	    
	    var row2 = header.insertRow(0);
	    row2.innerHTML = "<b>RESTAURANTES</b>";
	    row2.style.textAlign = 'right';
	    
	    var row3 = header.insertRow(1);
	    var cell = row3.insertCell(0);
	    cell.innerHTML = "<b>CODIGO</b>";
	    
	    var cell2 = row3.insertCell(1);
	    cell2.innerHTML = "<b>NOMBRE</b>";
	    
	     var cell3 = row3.insertCell(2);
	    cell3.innerHTML = "<b>TELEFONO</b>";
	  
	});
	
}



function InsertarGenerico() { 	
	var accion = "PUT";	
	var objeto = {
			codigo: document.p.codigo.value,
	        nombre: document.p.nombre.value,
	        telefono: document.p.telefono.value 
	};
	var url = "http://localhost:8080/ProyectoRestaurante/rest/restauranteService/insertar";
	//invocarRest(accion,url,objeto,function(){});
	invocarRest(accion,url,objeto);
	
}

