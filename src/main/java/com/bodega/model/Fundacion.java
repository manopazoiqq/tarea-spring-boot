package com.bodega.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.persistence.Id; 

@Entity
@Table(name = "fundacion")
public class Fundacion {
	
	@Id
	@Column(name = "rut_fundacion", unique = true, nullable = false, updatable = false)
	private Integer rut_fundacion;
	
	@Size(max = 50, message = "Nombre fundación no puede superar los 50 caracteres")
	@Column(name = "nombre_fundacion", length = 50)
	private String nombre_fundacion;
	
	public Integer getRut_fundacion() {
		return rut_fundacion;
	}
	@Column(name="estado_fundacion", length=1,nullable = false) // A = ACTIVO, I = INACTIVO...
	private String estado_fundacion;
	
	@Size(max=50, message = "Email fundación no puede superar los 50 caracteres")
	@Column(name="email_fundacion", length=50)
	private String email_fundacion;
	
	@Size(max=50, message = "dirección fundación no puede superar los 50 caracteres")
	@Column(name = "direccion_fundacion", length = 50)
	private String direccion_fundacion;
	
	@Size(max=12, message = "número contacto de fundación no puede superar los 50 caracteres")
	@Column(name = "nro_contacto_fundacion", length=12)
	private String nro_contacto_fundacion;

	public void setRut_fundacion(Integer rut_fundacion) {
		this.rut_fundacion = rut_fundacion;
	}

	public String getNombre_fundacion() {
		return nombre_fundacion;
	}

	public void setNombre_fundacion(String nombre_fundacion) {
		this.nombre_fundacion = nombre_fundacion;
	}

	public String getEstado_fundacion() {
		return estado_fundacion;
	}

	public void setEstado_fundacion(String estado_fundacion) {
		this.estado_fundacion = estado_fundacion;
	}

	public String getEmail_fundacion() {
		return email_fundacion;
	}

	public void setEmail_fundacion(String email_fundacion) {
		this.email_fundacion = email_fundacion;
	}

	public String getDireccion_fundacion() {
		return direccion_fundacion;
	}

	public void setDireccion_fundacion(String direccion_fundacion) {
		this.direccion_fundacion = direccion_fundacion;
	}

	public String getNro_contacto_fundacion() {
		return nro_contacto_fundacion;
	}

	public void setNro_contacto_fundacion(String nro_contacto_fundacion) {
		this.nro_contacto_fundacion = nro_contacto_fundacion;
	}	

}
