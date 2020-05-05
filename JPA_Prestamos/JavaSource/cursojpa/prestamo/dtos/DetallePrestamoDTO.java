package cursojpa.prestamo.dtos;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;

public class DetallePrestamoDTO {
	private Integer idDetallePrestamo;	
	private Integer numeroPago;
	private BigDecimal totalCuota;
	private BigDecimal capitalCuota;	
	private BigDecimal interesCuota;
	private String fechaPago;	
	private String fechaCuotaPagada;	
	private Integer estadoCuota;
	
	
	
	public Integer getIdDetallePrestamo() {
		return idDetallePrestamo;
	}
	public void setIdDetallePrestamo(Integer idDetallePrestamo) {
		this.idDetallePrestamo = idDetallePrestamo;
	}
	public Integer getNumeroPago() {
		return numeroPago;
	}
	public void setNumeroPago(Integer numeroPago) {
		this.numeroPago = numeroPago;
	}
	public BigDecimal getTotalCuota() {
		return totalCuota;
	}
	public void setTotalCuota(BigDecimal totalCuota) {
		this.totalCuota = totalCuota;
	}
	public BigDecimal getCapitalCuota() {
		return capitalCuota;
	}
	public void setCapitalCuota(BigDecimal capitalCuota) {
		this.capitalCuota = capitalCuota;
	}
	public BigDecimal getInteresCuota() {
		return interesCuota;
	}
	public void setInteresCuota(BigDecimal interesCuota) {
		this.interesCuota = interesCuota;
	}
	public String getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}
	public String getFechaCuotaPagada() {
		return fechaCuotaPagada;
	}
	public void setFechaCuotaPagada(String fechaCuotaPagada) {
		this.fechaCuotaPagada = fechaCuotaPagada;
	}
	public Integer getEstadoCuota() {
		return estadoCuota;
	}
	public void setEstadoCuota(Integer estadoCuota) {
		this.estadoCuota = estadoCuota;
	}
	
	
	
	

}
