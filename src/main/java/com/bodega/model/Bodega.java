package com.bodega.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@ApiModel(description = "Información de la bodega")
@Entity
@Table(name="bodega")
public class Bodega {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cod_bodega;
	
	@ApiModelProperty(notes = "Nombre de bodega no puede superar los 50 caracteres")
	@Size(max=50, message = "Nombre de bodega no puede superar los 50 caracteres")
	@Column(name = "nombre_bodega", length = 50, nullable = false)
	private String nombre_bodega;
	
	@ApiModelProperty(notes = "Descripcion de bodega no puede superar los 50 caracteres")
	@Size(max=50, message = "Descripcion de bodega no puede superar los 50 caracteres")
	@Column(name = "descripcion_bodega", length = 50, nullable = false)
	private String descripcion_bodega;
	
	@Column(name="estado_bodega", length=1,nullable = false) // A = ACTIVO, I = INACTIVO...
	private String estado_bodega;
	
	@JsonIgnore // sirve para obviar redundancia
	@ManyToOne
	@JoinColumn(name = "rut_fundacion", nullable = false, foreignKey=@ForeignKey(name = "fk_fundacion_bodega") )
	private Fundacion fundacion; // fk

	public Integer getCod_bodega() {
		return cod_bodega;
	}

	public void setCod_bodega(Integer cod_bodega) {
		this.cod_bodega = cod_bodega;
	}

	public String getNombre_bodega() {
		return nombre_bodega;
	}

	public void setNombre_bodega(String nombre_bodega) {
		this.nombre_bodega = nombre_bodega;
	}

	public String getDescripcion_bodega() {
		return descripcion_bodega;
	}

	public void setDescripcion_bodega(String descripcion_bodega) {
		this.descripcion_bodega = descripcion_bodega;
	}

	public String getEstado_bodega() {
		return estado_bodega;
	}

	public void setEstado_bodega(String estado_bodega) {
		this.estado_bodega = estado_bodega;
	}

	public Fundacion getFundacion() {
		return fundacion;
	}

	public void setFundacion(Fundacion fundacion) {
		this.fundacion = fundacion;
	}
	

}
