package cursojpa.prestamo.dtos;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import cursojpa.prestamo.entidades.DetallePrestamo;

public class PrestamoDTO {
	
	private Integer idPrestamo;	
	private String fechaPrestamo;	
	private String idCliente;	
	private BigDecimal montoTotal;
	private List<DetallePrestamoDTO> detallesPrestamo;
	
	
	
	public List<DetallePrestamoDTO> getDetallesPrestamo() {
		return detallesPrestamo;
	}
	public void setDetallesPrestamo(List<DetallePrestamoDTO> detallesPrestamo) {
		this.detallesPrestamo = detallesPrestamo;
	}
	public Integer getIdPrestamo() {
		return idPrestamo;
	}
	public void setIdPrestamo(Integer idPrestamo) {
		this.idPrestamo = idPrestamo;
	}
	public String getFechaPrestamo() {
		return fechaPrestamo;
	}
	public void setFechaPrestamo(String fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public BigDecimal getMontoTotal() {
		return montoTotal;
	}
	public void setMontoTotal(BigDecimal montoTotal) {
		this.montoTotal = montoTotal;
	}
	
	

}
