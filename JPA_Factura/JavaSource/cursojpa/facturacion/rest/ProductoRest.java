package cursojpa.facturacion.rest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import cursojpa.facturacion.entidades.Categoria;
import cursojpa.facturacion.entidades.Producto;
import cursojpa.facturacion.exceptiones.CobisException;
import cursojpa.facturacion.servicios.CategoriaServicio;
import cursojpa.facturacion.servicios.ProductoServicio;
import cursojpa.facturaciones.dtos.ProductoDTO;

@Path(value = "/producto")
@Stateless  //Inyeccion de codigo
public class ProductoRest {
	
	@EJB  //Inyeccion de codigo
	ProductoServicio productoServicio;
	
	@EJB
	CategoriaServicio categoriaServicio;
	
	@POST	
	@Path(value = "/insertar")	
	@Consumes("application/json")   //consume un json de productoDTO {"codigo":"20","nombre":"hernan","precioVenta":125.23,"impuesto":true,"idCategoria":5}
	public void insertar(ProductoDTO productoDTO) throws CobisException {
		Producto producto = new Producto();
		producto.setCodigo(productoDTO.getCodigo());
		producto.setNombre(productoDTO.getNombre());
		producto.setPrecioVenta(productoDTO.getPrecioVenta());
		producto.setImpuesto(productoDTO.getImpuesto());		
		Categoria categoria = categoriaServicio.buscarPorId(productoDTO.getIdCategoria());	 // Search de categoria por id
		if (categoria == null){
			throw new CobisException("NO EXISTE LA CATEGORIA"+productoDTO.getIdCategoria()); 
		}		
		producto.setCategoria(categoria); 
		
		try {
			productoServicio.insertar(producto);  //no salta al catch, debido a que al salir del metodo hace el fush, y ee flush hace commit de las operaciones pendientes (persist,merge,ect)
			//todas las operaciones contra la base se ejecutan al salir del metodo, con flush obligamos a que se ejecuten en ese momento
		} catch (CobisException e) {
			throw e;
		}catch (Exception e) {
			System.out.println("ENTRO AL CATCH");
			e.printStackTrace();
			throw new CobisException("NO SE PUDO INSERTAR");
		}
		
		
	}

}
