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

@Entity
@Table(name="bodega_stock_articulo")
public class BodegaStockArticulo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cod_bodega_stock_articulo;
	
	@Column(name="estado_bodega_stock_articulo", length=1,nullable = false) // A = ACTIVO, I = INACTIVO...
	private String estado_bodega_stock_articulo;
	
	@Column(name="stock_actual", nullable = false)
	private Integer stock_actual;
	
	@Column(name="stock_minimo", nullable = false)
	private Integer stock_minimo;
	
	@ManyToOne
	@JoinColumn(name="cod_bodega", nullable = false, foreignKey = @ForeignKey(name = "FK_bodega_articulo"))
	private Bodega bodega;
	
	@ManyToOne
	@JoinColumn(name = "codigo_articulo", nullable = false, foreignKey = @ForeignKey(name = "FK_articulo_bodega"))
	private Articulo articulo;
	
	

	public Bodega getBodega() {
		return bodega;
	}

	public void setBodega(Bodega bodega) {
		this.bodega = bodega;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public Integer getCod_bodega_stock_articulo() {
		return cod_bodega_stock_articulo;
	}

	public void setCod_bodega_stock_articulo(Integer cod_bodega_stock_articulo) {
		this.cod_bodega_stock_articulo = cod_bodega_stock_articulo;
	}

	public String getEstado_bodega_stock_articulo() {
		return estado_bodega_stock_articulo;
	}

	public void setEstado_bodega_stock_articulo(String estado_bodega_stock_articulo) {
		this.estado_bodega_stock_articulo = estado_bodega_stock_articulo;
	}

	public Integer getStock_actual() {
		return stock_actual;
	}

	public void setStock_actual(Integer stock_actual) {
		this.stock_actual = stock_actual;
	}

	public Integer getStock_minimo() {
		return stock_minimo;
	}

	public void setStock_minimo(Integer stock_minimo) {
		this.stock_minimo = stock_minimo;
	}

}
