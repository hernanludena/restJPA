package curso.restaurantes.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import curso.restaurantes.entidades.Restaurante;
import curso.restaurantes.servicios.RestaurantesServicios;



@Path(value = "/restauranteService")
@Stateless
public class RestauranteRest {
	
	@EJB
	RestaurantesServicios restauranteServicios;
		
	@GET	
	@Path(value = "/recuperarTodos")	
	@Produces("application/json")   //tipo de trama a recibir
	public Response recuperarTodos2() {	
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Restaurante> list = restauranteServicios.recuperarTodos();
		return Response.ok().entity(list).build(); 		 //en el entity podemos enviar cualquier data.
	}
	
	
	@PUT	
	@Path(value = "/insertar")	
	@Consumes("application/json")   
	public Response insertar(Restaurante restaurante){		
		try {
			restauranteServicios.insertar(restaurante);
			
		} catch (Exception e) {
			return Response.serverError().entity("Error al insertar").build();
		}
		
		return Response.ok("Correcto al insertar").build();		
	}

}
