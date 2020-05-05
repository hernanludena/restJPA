package cursos.rest.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement  //--->Anotaciones Jaxv para mapear de objeto a xml y viceversa.
public class Persona {
	private String cedula;
	private String nombre;
	private String apellido;
	private String genero;
	
	
	public Persona(){
		super();
	}
	
	
	public Persona(String cedula, String nombre, String apellido) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	

	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	@Override
	public String toString() {
		return "Persona [cedula=" + cedula + ", nombre=" + nombre
				+ ", apellido=" + apellido + "]";
	}
	
	
	

}
