package com.bodega.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Id; 

@ApiModel(description = "Información del articulo")
@Entity
@Table(name = "articulo")
public class Articulo {

	@Id
	@Column(name = "codigo_articulo", unique=true, nullable = false, updatable = false)
	private Integer codigo_articulo;
	
	@ApiModelProperty(notes = "Nombre de artículo no puede superar los 50 caracteres")
	@Size(max=50, message = "Nombre de artículo no puede superar los 50 caracteres")
	@Column(name = "nombre_articulo", length = 50, nullable = false)
	private String nombre_articulo;
	
	@Column(name="estado_articulo", length=1,nullable = false) // A = ACTIVO, I = INACTIVO...
	private String estado_articulo;
	
	@Column(name = "stock_articulo")
	private Integer stock_articulo;
	
	@Column(name = "stock_minimo_articulo")
	private Integer stock_minimo_articulo;

	public Integer getCodigo_articulo() {
		return codigo_articulo;
	}

	public void setCodigo_articulo(Integer codigo_articulo) {
		this.codigo_articulo = codigo_articulo;
	}

	public String getNombre_articulo() {
		return nombre_articulo;
	}

	public void setNombre_articulo(String nombre_articulo) {
		this.nombre_articulo = nombre_articulo;
	}

	public String getEstado_articulo() {
		return estado_articulo;
	}

	public void setEstado_articulo(String estado_articulo) {
		this.estado_articulo = estado_articulo;
	}

	public Integer getStock_articulo() {
		return stock_articulo;
	}

	public void setStock_articulo(Integer stock_articulo) {
		this.stock_articulo = stock_articulo;
	}

	public Integer getStock_minimo_articulo() {
		return stock_minimo_articulo;
	}

	public void setStock_minimo_articulo(Integer stock_minimo_articulo) {
		this.stock_minimo_articulo = stock_minimo_articulo;
	}
}
