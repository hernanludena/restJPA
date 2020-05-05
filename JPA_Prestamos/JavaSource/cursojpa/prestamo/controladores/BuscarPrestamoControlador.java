package cursojpa.prestamo.controladores;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import cursojpa.prestamo.entidades.Prestamo;
import cursojpa.prestamo.servicios.PrestamoServicio;

@ManagedBean
@ViewScoped
public class BuscarPrestamoControlador {

	@EJB
	private PrestamoServicio prestamoServicio;
	
	private String idCliente;
	
	private Prestamo prestamo;

	public BuscarPrestamoControlador() {
		prestamo = new Prestamo();
	}	
	
	
	public void buscarPrestamo(){
		prestamo = prestamoServicio.buscarPorCliente(idCliente);
		
	}
	
	public void pagar(){
		prestamoServicio.pagar(prestamo);
	}
	
	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public Prestamo getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}
	
	
}
