package cursojpa.prestamo.servicios;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cursojpa.prestamo.entidades.DetallePrestamo;
import cursojpa.prestamo.entidades.Prestamo;
import cursojpa.prestamo.utils.Constantes;


@Stateless
public class PrestamoServicio {
	@PersistenceContext
	private EntityManager em;
	
	public List<DetallePrestamo> generarCuotas(Prestamo prestamo,int numeroCuotas){
		List<DetallePrestamo> detallesPrestamo = new ArrayList<DetallePrestamo>();
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		BigDecimal interesMensual = Constantes.interes.divide(
				new BigDecimal(numeroCuotas), 2, RoundingMode.HALF_UP);
		BigDecimal capital = (prestamo.getMontoTotal()).divide(new BigDecimal(
				numeroCuotas), 2, RoundingMode.HALF_UP);
		BigDecimal interes = prestamo.getMontoTotal().multiply(interesMensual);
		BigDecimal totalCuota = capital.add(interes);
		for (int i = 0; i < numeroCuotas; i++) {
			int numero = i+1;
			c.add(Calendar.DATE, 30);
			DetallePrestamo d = new DetallePrestamo(numero, totalCuota, capital,
					interes, c.getTime());
			d.setEstadoCuota(1); //estado de cuota = 1
			detallesPrestamo.add(d);
			
		}
		return detallesPrestamo;
	}
	
	public void registrarPrestamo(Prestamo prestamo,Integer numeroCuotas){
		//registra el prestamo y sus detalles
		List<DetallePrestamo> lista = generarCuotas(prestamo,numeroCuotas);
		for (DetallePrestamo detallePrestamo : lista) {
			detallePrestamo.setPrestamo(prestamo);  //guardar el papa
		}
		
		prestamo.setDetallesPrestamo(lista);
		em.persist(prestamo);
		
	}
	
	/**
	 * Busca el préstamo correspondiente al cliente. Retorna el préstamo con todos los detalles
	 * @param idCliente id del Cliente
	 * @return
	 */
	public Prestamo buscarPorCliente(String idCliente){		
		
		//consulta prestamo			
		Query query= em.createQuery("SELECT p FROM Prestamo p " +
    			"WHERE p.idCliente = :paramIdCliente");
    	query.setParameter("paramIdCliente", idCliente);    	
    	Prestamo P =(Prestamo)query.getSingleResult();
    	P.getDetallesPrestamo().size();
    	
    	return P;
    	
	
	}
	
	public void pagar(Prestamo prestamo){
		Query q = em.createQuery("SELECT p.detallesPrestamo FROM Prestamo p where p.idPrestamo =:paramIdPrestamo");
		q.setParameter("paramIdPrestamo", prestamo.getIdPrestamo());		
		DetallePrestamo det= (DetallePrestamo)q.setMaxResults(1).setFirstResult(0);
		
		det.setEstadoCuota(2);
		det.setFechaCuotaPagada(new Date());
		em.merge(det);
	}
	

//	List<DetallePrestamo> list = prestamo.getDetallesPrestamo();
//	DetallePrestamo de= list.get(0);
//	
	/***
	 * Busca el préstamo y retorna solamente 3 atributos del préstamo
	 * @param idCliente id del cliente
	 * @return
	 */
	public Prestamo buscarSimple(String idCliente){
		
		return null;
	}
	
	
//	Query query2= em.createQuery("SELECT dp FROM DetallePrestamo dp " +
//	"WHERE dp.prestamo = :paramIdPrestamo");
//query2.setParameter("paramIdPrestamo", P.getIdPrestamo());
//List<DetallePrestamo> listDet =  query2.getResultList();

	
    //return (Prestamo)query.getSingleResult();        
//	Prestamo p = em.find(Prestamo.class, idCliente);
//	System.out.println(p);
//	System.out.println(p.getDetallesPrestamo().size());
//	return p;	
	
}
