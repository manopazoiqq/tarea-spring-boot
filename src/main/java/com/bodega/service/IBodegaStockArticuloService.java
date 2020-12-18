package com.bodega.service;

import java.util.List;

import com.bodega.model.Articulo;

public interface IBodegaStockArticuloService<T> {
	T registrar(T obj); // queda pendiente hacer un metodo para insertar un registro en la tabla...
	List<Articulo> listarStockBodega(Integer codBodega);
	List<Articulo> listarStockBodegaArticulo(Integer codBodega, Integer codArticulo);
}
