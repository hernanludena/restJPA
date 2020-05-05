package cursojpa.facturacion.exceptiones;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MiMapper implements ExceptionMapper<CobisException>{

	@Override	
	public Response toResponse(CobisException arg0) {		
		return Response.serverError().entity(arg0.getMessage()).build();
	}	

}
