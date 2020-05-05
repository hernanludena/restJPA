package cursojpa.prestamo.entidades;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "prestamo")
public class Prestamo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_prestamo")
	private Integer idPrestamo;

	@Column(name = "fecha_prestamo")
	private Date fechaPrestamo;

	@Column(name = "id_cliente")
	private String idCliente;

	@Column(name = "monto_total")
	private BigDecimal montoTotal;
	
	@OneToMany(mappedBy = "prestamo",cascade={CascadeType.PERSIST,CascadeType.REMOVE})
	//@OneToMany(mappedBy = "prestamo",fetch =FetchType.EAGER)
	private List<DetallePrestamo>detallesPrestamo;
	
	public Prestamo(){
		detallesPrestamo = new ArrayList<DetallePrestamo>();
	}
	

	public Prestamo(Integer idPrestamo, Date fechaPrestamo, String idCliente,
			BigDecimal montoTotal, List<DetallePrestamo> detallesPrestamo) {
		super();
		this.idPrestamo = idPrestamo;
		this.fechaPrestamo = fechaPrestamo;
		this.idCliente = idCliente;
		this.montoTotal = montoTotal;
		this.detallesPrestamo = detallesPrestamo;
	}

	public Integer getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(Integer idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(Date fechaPrestamo) {
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

	public List<DetallePrestamo> getDetallesPrestamo() {
		return detallesPrestamo;
	}

	public void setDetallesPrestamo(List<DetallePrestamo> detallesPrestamo) {
		this.detallesPrestamo = detallesPrestamo;
	}

	@Override
	public String toString() {
		return "Prestamo [idPrestamo=" + idPrestamo + ", fechaPrestamo="
				+ fechaPrestamo + ", idCliente=" + idCliente + ", montoTotal="
				+ montoTotal + "]";
	}
	
	
	
}
