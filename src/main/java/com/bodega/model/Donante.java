package com.bodega.model;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
import javax.persistence.Id;

@Entity
@Table(name = "donante")
public class Donante {
	
	@Id
	@Column(name = "rut_donante", unique = true, nullable = false, updatable = false)
	private Integer rutDonante;
	
	@Column(name="dv_donante", length=1, nullable = false)
	private String dvDonante;
	
	@Size(max=50, message = "Nombres no pueden superar los 50 caracteres")
	@Column(name = "nombres_donante", length = 50, nullable = false)
	private String nombresDonante;
	
	@Size(max=50, message = "Apellido paterno no puede superar los 50 caracteres")
	@Column(name = "apaterno_donante", length=50)
	private String apaternoDonante;
	
	@Size(max = 50, message = "Apellido materno no puede superar los 50 caracteres")
	@Column(name = "amaterno_donante", length=50)
	private String amaternoDonante;
	
	@Column(name="estado_donante", length=1,nullable = false) // A = ACTIVO, I = INACTIVO...
	private String estadoDonante;
	
	@Email
	@Size(max=50, message = "Email no puede superar los 50 caracteres")
	@Column(name = "email_donante", length = 50)
	private String emailDonante;
	
	public Integer getRutDonante() {
		return rutDonante;
	}

	public void setRutDonante(Integer rutDonante) {
		this.rutDonante = rutDonante;
	}

	public String getDvDonante() {
		return dvDonante;
	}

	public void setDvDonante(String dvDonante) {
		this.dvDonante = dvDonante;
	}

	public String getNombresDonante() {
		return nombresDonante;
	}

	public void setNombresDonante(String nombresDonante) {
		this.nombresDonante = nombresDonante;
	}

	public String getApaternoDonante() {
		return apaternoDonante;
	}

	public void setApaternoDonante(String apaternoDonante) {
		this.apaternoDonante = apaternoDonante;
	}

	public String getAmaternoDonante() {
		return amaternoDonante;
	}

	public void setAmaternoDonante(String amaternoDonante) {
		this.amaternoDonante = amaternoDonante;
	}

	public String getEstadoDonante() {
		return estadoDonante;
	}

	public void setEstadoDonante(String estadoDonante) {
		this.estadoDonante = estadoDonante;
	}

	public String getEmailDonante() {
		return emailDonante;
	}

	public void setEmailDonante(String emailDonante) {
		this.emailDonante = emailDonante;
	}

	public String getPasswordDonante() {
		return passwordDonante;
	}

	public void setPasswordDonante(String passwordDonante) {
		this.passwordDonante = passwordDonante;
	}

	@Column(name = "password_donante", length=100, nullable = false)
	private String passwordDonante;
	
		

}
