package cursos.rest.servicios;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path(value = "/convertidor")
public class Convertidor {
	@GET
	@Path(value = "/convertidorEaD")
	public double convertidorEurosDolares(@QueryParam(value="valor") double euros){
		return euros * 1.3378;
	}
	
	@GET
	@POST
	@Path(value = "/suma")
	public double sumar(@QueryParam(value="valor1") double valor1,@QueryParam(value="valor2") double valor2){
		return valor1+valor2;
	}

}
