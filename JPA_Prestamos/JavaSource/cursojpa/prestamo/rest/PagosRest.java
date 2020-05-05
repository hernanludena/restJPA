package cursojpa.prestamo.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import cursojpa.prestamo.dtos.DetallePrestamoDTO;
import cursojpa.prestamo.dtos.PrestamoDTO;
import cursojpa.prestamo.entidades.DetallePrestamo;
import cursojpa.prestamo.entidades.Prestamo;
import cursojpa.prestamo.servicios.PrestamoServicio;
import cursojpa.prestamo.utils.DateUtils;



@Path(value = "/prestamo")
@Stateless  //Inyeccion de codigo
public class PagosRest {
	
	@EJB  //Inyeccion de codigo
	PrestamoServicio prestamoServicio;
	
	
	@POST	
	@Path(value = "/insertar")	
	@Consumes("application/json")
	public Response insertar(PrestamoDTO prestamoDTO) {	//retorna un response		
		
		Prestamo prestamo = new Prestamo();
		Date date = DateUtils.StringToFecha(prestamoDTO.getFechaPrestamo());
		prestamo.setFechaPrestamo(date);
		prestamo.setIdCliente(prestamoDTO.getIdCliente()); 
		
		List<DetallePrestamoDTO> list = prestamoDTO.getDetallesPrestamo();		
		List<DetallePrestamo>  list2 = new ArrayList<DetallePrestamo>(); 
				
		for (DetallePrestamoDTO detallePrestamoDTO : list) {
			DetallePrestamo f = new DetallePrestamo();
			f.setCapitalCuota(detallePrestamoDTO.getCapitalCuota());
			f.setEstadoCuota(detallePrestamoDTO.getEstadoCuota());
			Date dateCP = DateUtils.StringToFecha(detallePrestamoDTO.getFechaCuotaPagada());			
			f.setFechaCuotaPagada(dateCP);
			Date dateFP = DateUtils.StringToFecha(detallePrestamoDTO.getFechaPago());			
			f.setFechaPago(dateFP);
			//f.setIdDetallePrestamo(detallePrestamoDTO.getIdDetallePrestamo());
			f.setInteresCuota(detallePrestamoDTO.getInteresCuota());
			f.setNumeroPago(detallePrestamoDTO.getNumeroPago());
			//Prestamo prestamoB = prestamoServicio.buscarPorCliente(prestamoDTO.getIdCliente());			
			f.setPrestamo(prestamo);
			f.setTotalCuota(detallePrestamoDTO.getTotalCuota());
						
			list2.add(f);
			
		}		
		prestamo.setDetallesPrestamo(list2);
		
		
		prestamo.setMontoTotal(prestamoDTO.getMontoTotal());			
		prestamoServicio.registrarPrestamo(prestamo, 12);
		return Response.ok().entity("PRESTAMO INSERTADO: "+prestamo).build();
		
			
	}

}



//prestamo.setIdPrestamo(prestamoDTO.getIdPrestamo());


