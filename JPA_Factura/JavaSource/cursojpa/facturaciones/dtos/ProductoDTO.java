package cursojpa.facturaciones.dtos;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.Table;


public class ProductoDTO {

	private String codigo;	
	private String nombre;
	private BigDecimal precioVenta;
	private Boolean impuesto;
	private Integer idCategoria; 

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(BigDecimal precioVenta) {
		this.precioVenta = precioVenta;
	}

	public Boolean getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(Boolean impuesto) {
		this.impuesto = impuesto;
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	

	

}

