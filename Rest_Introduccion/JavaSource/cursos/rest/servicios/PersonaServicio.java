package cursos.rest.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.xml.bind.annotation.XmlRootElement;

import cursos.rest.dto.Persona;


@Path(value = "/persona")
public class PersonaServicio {
	@GET
	@Path(value = "/recuperar")
	@Produces("application/xml")  //tipo de trama a producir  	
	public Persona recuperar(){
		return new Persona("110401176","hernan","ludena");
	}
	
	@GET
	@Path(value = "/recuperar2")
	@Produces("application/json")  //tipo de trama a producir  	
	public Persona recuperar2(){
		return new Persona("110401176","hernan","ludena");
	}
	
	@GET
	@Path(value = "/recuperar3")
	@Produces({"application/json","application/xml"})  //puede soportar 2 tipos de trama a producir  	
	public Persona recuperar3(){
		return new Persona("110401176","hernan","ludena");
	}
	
	@POST
	//@GET  //La accion Http GET: es para consultar, el contentType no viaja nada; no funciona con objetos. No puede enviar contenido.
	@Path(value = "/insertar")	
	@Consumes("application/xml")   //tipo de trama a consumir
	public void insertar(Persona persona){
		System.out.println(persona);
		
	}
	
	@POST
	@Path(value = "/insertar2")	 
	@Consumes({"application/json","application/xml"})   //puede soportar 2 tipos de trama a consumir
	public void insertar2(Persona persona){
		System.out.println(persona);
		// si tratamos dee enviarle una trama json del lado del cliente, se produce un error de ContentType no soportado
	}
	
	@POST
	@Path(value = "/modificar")	  //recibe json y devuelve xml
	@Produces("application/xml") 
	@Consumes("application/json")    //{"cedula":"110401176","nombre":"hernan","apellido":"ludena","genero":"S"}
	public Persona modificar(Persona persona){	
		persona.setGenero("M");
		System.out.println(persona); 
		return persona;
	}
	
	//La accion Http GET: es para consultar, el contentType no viaja nada; no funciona con objetos. No puede enviar contenido.
	//si quiero pasar objetos tengo que usar EL POST y el consumes y el produces
	
	

}
