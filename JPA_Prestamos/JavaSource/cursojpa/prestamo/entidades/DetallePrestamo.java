package cursojpa.prestamo.entidades;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_prestamo")
public class DetallePrestamo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_det_prestamo")
	private Integer idDetallePrestamo;

	@Column(name = "numero_pago")
	private Integer numeroPago;

	@Column(name = "total_cuota")
	private BigDecimal totalCuota;

	@Column(name = "capital_cuota")
	private BigDecimal capitalCuota;

	@Column(name = "interes_cuota")
	private BigDecimal interesCuota;

	@Column(name = "fecha_pago")
	private Date fechaPago;

	@Column(name = "fecha_cuota_pagada")
	private Date fechaCuotaPagada;

	@Column(name = "estado_cuota")
	private Integer estadoCuota;


	@ManyToOne  //un prestamo tiene muchos detalles
	@JoinColumn(name = "id_prestamo")
	private Prestamo prestamo; //id_prestamo integer, FK
	
	
	public DetallePrestamo(){
		
	}

	public DetallePrestamo(Integer numeroPago, BigDecimal totalCuota,
			BigDecimal capitalCuota, BigDecimal interesCuota, Date fechaPago) {
		super();
		this.numeroPago = numeroPago;
		this.totalCuota = totalCuota;
		this.capitalCuota = capitalCuota;
		this.interesCuota = interesCuota;
		this.fechaPago = fechaPago;
	}


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

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public Date getFechaCuotaPagada() {
		return fechaCuotaPagada;
	}

	public void setFechaCuotaPagada(Date fechaCuotaPagada) {
		this.fechaCuotaPagada = fechaCuotaPagada;
	}

	public Integer getEstadoCuota() {
		return estadoCuota;
	}

	public void setEstadoCuota(Integer estadoCuota) {
		this.estadoCuota = estadoCuota;
	}


	public Prestamo getPrestamo() {
		return prestamo;
	}



	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}


	@Override
	public String toString() {
		return "DetallePrestamo [idDetallePrestamo=" + idDetallePrestamo
				+ ", numeroPago=" + numeroPago + ", totalCuota=" + totalCuota
				+ ", capitalCuota=" + capitalCuota + ", interesCuota="
				+ interesCuota + ", fechaPago=" + fechaPago
				+ ", fechaCuotaPagada=" + fechaCuotaPagada + ", estadoCuota="
				+ estadoCuota + ", prestamo=" + prestamo + "]";
	}

	
	
	
	
}
