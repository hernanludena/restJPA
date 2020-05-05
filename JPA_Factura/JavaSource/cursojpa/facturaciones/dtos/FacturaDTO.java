package cursojpa.facturaciones.dtos;

import java.math.BigDecimal;
import java.util.List;


public class FacturaDTO {

	private String codigo;
	private String fecha;	
	private BigDecimal total;
	private String cedulaCliente;
	private List<FacturaDetalleDTO> detalles;	
	
	public List<FacturaDetalleDTO> getDetalles() {
		return detalles;
	}
	public void setDetalles(List<FacturaDetalleDTO> detalles) {
		this.detalles = detalles;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public String getCedulaCliente() {
		return cedulaCliente;
	}
	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}


	
	
}
