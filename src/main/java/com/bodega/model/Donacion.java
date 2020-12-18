package com.bodega.model;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;
//import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Table(name="donacion")
//@IdClass(DonacionPK.class)
public class Donacion {
	
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cod_donacion;
	
	@JsonIgnore // sirve para obviar redundancia
	@ManyToOne
	@JoinColumn(name = "rut_donante", nullable = false, foreignKey=@ForeignKey(name = "fk_donacion_donante") )
	private Donante rut_donante;
	
	@JsonIgnore // sirve para obviar redundancia
	@ManyToOne
	@JoinColumn(name = "rut_fundacion", nullable = false, foreignKey=@ForeignKey(name = "fk_donacion_fundacion") )
	private Fundacion rut_fundacion;
	
	private LocalDateTime fecha_donacion;
	
	@Column(name="estado_donacion", length=1,nullable = false) // A = ACTIVO, I = INACTIVO...
	private String estado_donacion;
	
	@Column(name="comentario_donacion", length=300) 
	private String comentario_donacion;
	
	@OneToMany(mappedBy = "donacion", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<DonacionDetalle> donacion_detalle;

	public Integer getCod_donacion() {
		return cod_donacion;
	}

	public void setCod_donacion(Integer cod_donacion) {
		this.cod_donacion = cod_donacion;
	}

	public Donante getRut_donante() {
		return rut_donante;
	}

	public void setRut_donante(Donante rut_donante) {
		this.rut_donante = rut_donante;
	}

	public Fundacion getRut_fundacion() {
		return rut_fundacion;
	}

	public void setRut_fundacion(Fundacion rut_fundacion) {
		this.rut_fundacion = rut_fundacion;
	}

	public LocalDateTime getFecha_donacion() {
		return fecha_donacion;
	}

	public void setFecha_donacion(LocalDateTime fecha_donacion) {
		this.fecha_donacion = fecha_donacion;
	}

	public List<DonacionDetalle> getDonacion_detalle() {
		return donacion_detalle;
	}

	public void setDonacion_detalle(List<DonacionDetalle> donacion_detalle) {
		this.donacion_detalle = donacion_detalle;
	}

	public String getEstado_donacion() {
		return estado_donacion;
	}

	public void setEstado_donacion(String estado_donacion) {
		this.estado_donacion = estado_donacion;
	}

	public String getComentario_donacion() {
		return comentario_donacion;
	}

	public void setComentario_donacion(String comentario_donacion) {
		this.comentario_donacion = comentario_donacion;
	}
	
	
	
}
