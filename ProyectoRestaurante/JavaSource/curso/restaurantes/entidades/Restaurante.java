package curso.restaurantes.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "restaurantes")
public class Restaurante {	
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "codigo") 
	private Integer codigo;
	
	@Column(name = "nombre") 
	private String nombre;
	
	@Column(name = "telefono") 
	private String telefono;	
	
	public Restaurante(){
		
	}

	public Restaurante(Integer codigo, String nombre, String telefono) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.telefono = telefono;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	

}
