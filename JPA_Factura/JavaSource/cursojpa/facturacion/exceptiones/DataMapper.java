package cursojpa.facturacion.exceptiones;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DataMapper implements ExceptionMapper<FacturaException>{

	@Override	
	public Response toResponse(FacturaException arg0) {		
		return Response.serverError().entity(arg0.getMessage()).build();
	}	

}