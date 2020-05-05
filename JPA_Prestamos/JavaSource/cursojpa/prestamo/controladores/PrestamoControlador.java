package cursojpa.prestamo.controladores;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import cursojpa.prestamo.entidades.DetallePrestamo;
import cursojpa.prestamo.entidades.Prestamo;
import cursojpa.prestamo.servicios.PrestamoServicio;
import cursojpa.prestamo.utils.Constantes;

@ManagedBean
@ViewScoped
public class PrestamoControlador {

	private Prestamo prestamo;
	private Integer numeroCuotas;
	private BigDecimal interes = Constantes.interes;
	@EJB
	private PrestamoServicio prestamoServicio;
	
	private List<DetallePrestamo> detallesPrestamo;

	public PrestamoControlador() {
		prestamo = new Prestamo();
		detallesPrestamo = new ArrayList<DetallePrestamo>();

	}
	
	public void insertar() {		
		prestamoServicio.registrarPrestamo(prestamo,numeroCuotas);		
	}
	
	

	public void generarCuotas() {
		detallesPrestamo=prestamoServicio.generarCuotas(prestamo, numeroCuotas);
	}

	public Prestamo getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}

	public Integer getNumeroCuotas() {
		return numeroCuotas;
	}

	public void setNumeroCuotas(Integer numeroCuotas) {
		this.numeroCuotas = numeroCuotas;
	}

	public BigDecimal getInteres() {
		return interes;
	}

	public void setInteres(BigDecimal interes) {
		this.interes = interes;
	}

	public List<DetallePrestamo> getDetallesPrestamo() {
		return detallesPrestamo;
	}

	public void setDetallesPrestamo(List<DetallePrestamo> detallesPrestamo) {
		this.detallesPrestamo = detallesPrestamo;
	}

}
