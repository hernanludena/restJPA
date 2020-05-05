package cursojpa.facturacion.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;


import cursojpa.facturacion.entidades.Categoria;
import cursojpa.facturacion.exceptiones.CobisException;
import cursojpa.facturacion.servicios.CategoriaServicio;

@Path(value = "/categoria")
@Stateless
public class CategoriaRest {
	
	@EJB
	CategoriaServicio categoriaServicio;
	
	@POST	
	@Path(value = "/insertar")	
	@Consumes("application/json")   //tipo de trama a consumir - trama que acepta --acepta un json de categoria
	public void insertar(Categoria categoria) {
		System.out.println(categoria);
		categoriaServicio.insertar(categoria);	
	}
	
	
	//Buscar categoria por ID
	@GET
	@Path(value = "/buscar")
	@Produces("application/json")  //trama que retorna
	public Categoria buscarCategoria(@QueryParam(value="id") int id){ //atributo que se envia
		Categoria c = categoriaServicio.buscarPorId(id);
		return c;
	}
	
	@GET
	@Path(value = "/buscar2")
	@Produces("application/json")  //trama que retorna
	public Response buscarCategoria2(@QueryParam(value="id") int id){
		return Response.ok().build();
	}
	
	@GET
	@Path(value = "/buscar3")
	@Produces("application/json")  //trama que retorna
	public Response buscarCategoria3(@QueryParam(value="id") int id){  //Devolvemos en un Renponse		
		Categoria c = categoriaServicio.buscarPorId(id);		
		return Response.ok().entity(c).build();  //devuelve codigo 200 (ok)
	}
	
	
	@GET
	@Path(value = "/buscar4")
	@Produces("application/json")  //trama que retorna
	public Response buscarCategoria4(@QueryParam(value="id") int id){		
		//Categoria c = categoriaServicio.buscarPorId(id);		
		return Response.serverError().build();  //devuelve Error interno del servidor 500
	}
	
	//Buscar va buscarCategoria, si encuentra retorna response de exito con la cat encontrada.
	//Si no encuentra retorna error 500 y en el contenido no existe la categoria.
	@GET
	@Path(value = "/buscar5")
	@Produces("application/json")  //trama que retorna
	public Response buscarCategoria5(@QueryParam(value="id") int id){		
		Categoria c = categoriaServicio.buscarPorId(id);
		if (c != null){  //c.getId() null.null --->null pointer exception
			return Response.ok().entity(c).build();
		}else{		
			return Response.serverError().entity("No existe Categoria").build();
		}
		
		//return Response.serverError().build();  //devuelve Error interno del servidor 500
	}
	
	
	@POST	
	@Path(value = "/insertar2")	
	@Consumes("application/json")   //tipo de trama a consumir - trama que acepta --acepta una json de categoria
	public Response insertar2(Categoria categoria) {	//retorna un response	
		try {
			System.out.println(categoria);
			categoriaServicio.insertar(categoria);
			return Response.ok().entity("Categoria Insertada").build();
			
		} catch (Exception e) {
			return Response.serverError().entity("No se puede insertar").build();
			
		}
			
	}
	
	
	//----------Control de excepciones--------------
	@PUT	
	@Path(value = "/insertar3")	
	@Consumes("application/json")   //tipo de trama a consumir - trama que acepta --acepta un json de categoria
	public void insertar3(Categoria categoria) {		
		try {
			System.out.println(categoria);
			categoriaServicio.insertar(categoria);			
		} catch (Exception e) {
			throw new WebApplicationException(Response.Status.NOT_FOUND); //ERROR 404
		}			
	}
	
	
	@PUT	
	@Path(value = "/insertar4")	
	@Consumes("application/json")   //tipo de trama a consumir - trama que acepta --acepta un json de categoria
	public void insertar4(Categoria categoria) {		
		try {
			System.out.println(categoria);
			categoriaServicio.insertar(categoria);			
		} catch (Exception e) {
			throw new WebApplicationException(Response.serverError().entity("No se puede insertar").build()); //ERROR 404
		}			
	}
	//----------Control de excepciones--------------
	
	
	//----------RECUPERAR----------
	@POST	
	@Path(value = "/recuperar")	
	@Produces("application/json")   //tipo de trama a recibir
	public List<Categoria> recuperarTodos() {		
		List<Categoria> list = categoriaServicio.recuperarTodos();
		return list;
	}
	
	
	@POST	
	@Path(value = "/recuperar2")	
	@Produces("application/json")   //tipo de trama a recibir
	public Response recuperarTodos2() {			
		List<Categoria> list = categoriaServicio.recuperarTodos();
		return Response.ok().entity(list).build(); 		 //en el entity podemos enviar cualquier data.
	}	
	
	@POST	
	@Path(value = "/recuperar3")	
	//@Produces("application/json")   //tipo de trama a recibir
	public Response recuperarTodos3() {			
		List<Categoria> list = categoriaServicio.recuperarTodos();
		return Response.ok(list,"application/json").build(); 		  //podemos enviar directamen la data sin entity
		//podemos omitir el Produces, enviando directamente la trama por el Response
	}
	//----------RECUPERAR----------
	
	@POST	
	@Path(value = "/insertar5")	
	@Consumes("application/json")   //acepta una json de categoria {"nombre":"servicios"}
	public Response insertar5(Categoria categoria)throws CobisException {	//retorna un response	
		try {			
			categoriaServicio.insertar(categoria);
			return Response.ok().entity("Categoria Insertada").build();
			
		} catch (Exception e) {
			//return Response.serverError().entity("No se puede insertar").build();
			throw new CobisException("Error Fatal Server");
			
		}
			
	}
	
	

}
