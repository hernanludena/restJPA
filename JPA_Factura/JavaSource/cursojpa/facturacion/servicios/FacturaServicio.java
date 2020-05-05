package cursojpa.facturacion.servicios;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cursojpa.facturacion.entidades.Factura;
import cursojpa.facturacion.exceptiones.CobisException;
import cursojpa.facturacion.exceptiones.FacturaException;

@Stateless
public class FacturaServicio {

	@PersistenceContext
	private EntityManager em;

	public void insertar(Factura factura) throws CobisException {
		try {
			em.persist(factura);
			em.flush(); //realiza el commit directamente y no espera al salir del metodo
		} catch (Exception e) {
			throw new CobisException("ERROR AL INSERTAR FACTURA");
		}
		
	}

	/**
	 * Busca la factura que corresponde al código que recibe como parámetro. La
	 * factura debe retornar con el detalle incluido
	 * 
	 * @param codigo
	 *            Código para la búsqueda
	 * @return la factura buscada, si no encuentra retorna null.
	 */
	public Factura buscarFactura(String codigo)throws FacturaException {  //una consulta a traves de este metodo es mas OPTIMO que hacer FETCH JOIN
		//<<<Trae la Factura con su lista de detalles>>>
		//una solucion es colocar el FETCHTYPE a EAGER, pero no es aconsejable
		//Otra solucion es buscar la factura a traves del entityManager y luego llamar la metodo.size de la lista; para que asi traiga toda la lista.
		
		Factura f = new Factura();
		
		try{
			f = em.find(Factura.class, codigo);		
			System.out.println(f);
	    	System.out.println(f.getDetalles().size());	
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new FacturaException("No existe la factura");
		}
		
		
		return f;
	}

	// buscarFacturaConJoin sobre detalles  //hacemos un JOIN contra el atributo(lista)
	public Factura buscarFacturaJoin(String codigo) {
		Query query= em.createQuery("SELECT f FROM Factura f JOIN FETCH f.detalles WHERE f.codigo = :paramCodigo");
		query.setParameter("paramCodigo", codigo);
		return (Factura)query.getSingleResult();  //single and cast
	}
	
	//Examen 3
	//En FacturaServicio implementar el método para eliminar una factura, asegurarse de eliminar la factura y todos sus detalles
	public void eliminar(Factura factura){		
		Factura f = new Factura();
		try {
			f = buscarFactura(factura.getCodigo());
		} catch (FacturaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		em.remove(f);		
		
	}
	


}
