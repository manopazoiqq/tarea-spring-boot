package com.bodega.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="donacion_detalle")
public class DonacionDetalle {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer linea_detalle;
	
	@JsonIgnore // sirve para obviar redundancia
	@ManyToOne
	@JoinColumn(name = "cod_donacion", nullable = false, foreignKey=@ForeignKey(name = "fk_donacion_detalle") )
	private Donacion donacion; // fk
	
	@Column(name="cantidad_articulo")
	private Integer cantidad_articulo;
	
	@Column(name="estado_detalle", length=1,nullable = false) // A = ACTIVO, I = INACTIVO...
	private String estado_detalle;
	
	@Column(name="codigo_articulo")
	private Integer codigo_articulo;

	public Integer getLinea_detalle() {
		return linea_detalle;
	}

	public void setLinea_detalle(Integer linea_detalle) {
		this.linea_detalle = linea_detalle;
	}

	public Donacion getDonacion() {
		return donacion;
	}

	public void setDonacion(Donacion donacion) {
		this.donacion = donacion;
	}

	public Integer getCantidad_articulo() {
		return cantidad_articulo;
	}

	public void setCantidad_articulo(Integer cantidad_articulo) {
		this.cantidad_articulo = cantidad_articulo;
	}

	public String getEstado_detalle() {
		return estado_detalle;
	}

	public void setEstado_detalle(String estado_detalle) {
		this.estado_detalle = estado_detalle;
	}

	public Integer getCodigo_articulo() {
		return codigo_articulo;
	}

	public void setCodigo_articulo(Integer codigo_articulo) {
		this.codigo_articulo = codigo_articulo;
	}

}
