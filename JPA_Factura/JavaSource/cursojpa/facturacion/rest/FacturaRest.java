package cursojpa.facturacion.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import cursojpa.facturacion.entidades.Categoria;
import cursojpa.facturacion.entidades.Cliente;
import cursojpa.facturacion.entidades.Factura;
import cursojpa.facturacion.entidades.FacturaDetalle;
import cursojpa.facturacion.entidades.Producto;
import cursojpa.facturacion.exceptiones.CobisException;
import cursojpa.facturacion.exceptiones.FacturaException;
import cursojpa.facturacion.servicios.ClienteServicio;
import cursojpa.facturacion.servicios.FacturaServicio;
import cursojpa.facturacion.servicios.ProductoServicio;
import cursojpa.facturacion.utils.DateUtils;
import cursojpa.facturaciones.dtos.FacturaDTO;
import cursojpa.facturaciones.dtos.FacturaDetalleDTO;

@Path(value = "/factura")
@Stateless  //Inyeccion de codigo
public class FacturaRest {
	
	@EJB  //Inyeccion de codigo
	FacturaServicio facturaServicio;
	
	@EJB  //Inyeccion de codigo
	ClienteServicio clienteServicio;
	
	@EJB
	ProductoServicio productoServicio;
	
	@POST	
	@Path(value = "/insertar")	  //Trama Factura: {"codigo":"47","fecha":"12/12/2012 12:48","total":125.23,"cedulaCliente":"1104011786"}
	//Trama Completa {"codigo":"68","fecha":"06/16/2014 12:48","total":125.23,"cedulaCliente":"1104011786","detalles":[{"codigoProducto":"1","cantidad":3},{"codigoProducto":"3","cantidad":9},{"codigoProducto":"5","cantidad":11}]}
	@Consumes("application/json")   //tipo de trama a consumir - trama que acepta --acepta una json de categoria
	public Response insertar(FacturaDTO facturaDTO) throws CobisException {	//retorna un response
		Factura factura = new Factura();
		factura.setCodigo(facturaDTO.getCodigo());
		factura.setTotal(facturaDTO.getTotal());
		
		Cliente cliente = clienteServicio.buscarPorCedula(facturaDTO.getCedulaCliente()); // Search de categoria por id
		if (cliente == null){
			throw new CobisException("NO EXISTE EL CLIENTE: "+facturaDTO.getCedulaCliente()); 
		}		
		factura.setCliente(cliente);
		
		List<FacturaDetalleDTO> list = facturaDTO.getDetalles();		
		List<FacturaDetalle>  list2 = new ArrayList<FacturaDetalle>(); 
				
		for (FacturaDetalleDTO facturaDetalleDTO : list) {
			FacturaDetalle f = new FacturaDetalle();
			f.setCantidad(facturaDetalleDTO.getCantidad());
			
			Producto producto = productoServicio.buscarPorId(facturaDetalleDTO.getCodigoProducto());	
			f.setProducto(producto);
			f.setFactura(factura);
			
			list2.add(f);
			
		}
		
		factura.setDetalles(list2);
		
		
		
		Date date = DateUtils.StringToFecha(facturaDTO.getFecha());
		factura.setFecha(date);	
		
		try {
			facturaServicio.insertar(factura); //no salta al catch, debido a que al salir del metodo, hace el fush, y el flush hace commit de las operaciones pendientes (persist,merge,etc)
			//todas las operaciones contra la base se ejecutan al salir del metodo, con flush obligamos a que se ejecuten en ese momento
			return Response.ok().entity("FACTURA INSERTADA: "+factura).build();
		} catch (CobisException e) {
		//throw e;
			return Response.serverError().entity("ERROR: "+e.getMessage()).build();			
		}catch (Exception e) {
			System.out.println("ENTRO AL CATCH");
			e.printStackTrace();
			//throw new CobisException("NO SE PUDO INSERTAR");
			return Response.serverError().entity(new CobisException("NO SE PUDO INSERTAR")).build();
		}		
			
	}
	
	@POST	
	@Path(value = "/buscar")
	@Consumes("application/json")   
	public Response consultar(@QueryParam(value="codigo") String codigo)throws FacturaException{
		//Retorna FacturaDTO  con lista de FacturaDetalleDTO
		
		Factura f = new Factura();	
		try {
			f = facturaServicio.buscarFactura(codigo);			
		} catch (FacturaException e) {
		throw e;
			//return Response.serverError().entity("No existe la factura: "+e.getMessage()).build();			
		}catch (Exception e) {			
			//e.printStackTrace();
			//throw new CobisException("NO SE PUDO INSERTAR");
			return Response.serverError().entity(new FacturaException("No existe la factura")).build();
		}			
		
		
		FacturaDTO fdto = new FacturaDTO();
		Cliente  c= f.getCliente();
				
		fdto.setCedulaCliente(c.getCedula());
		fdto.setCodigo(f.getCodigo());
		
		List<FacturaDetalleDTO> listDto = new ArrayList<FacturaDetalleDTO>();		
		List<FacturaDetalle>  list = f.getDetalles();
		
		
		for (FacturaDetalle facturaDetalle : list) {
			FacturaDetalleDTO fd = new FacturaDetalleDTO();
			fd.setCantidad(facturaDetalle.getCantidad());
			
			Producto producto = facturaDetalle.getProducto();	
			fd.setCodigoProducto(producto.getCodigo());
						
			listDto.add(fd);
			
		}
		
		fdto.setDetalles(listDto);
		
		String date = DateUtils.fechaToString(f.getFecha());		
		fdto.setFecha(date);
		fdto.setTotal(f.getTotal());
		
		
		return Response.ok().entity(fdto).build();
		
		
		
	}
	

}
