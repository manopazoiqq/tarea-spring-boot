package com.bodega.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bodega.model.Articulo;
import com.bodega.model.BodegaStockArticulo;
import com.bodega.repo.IBodegaStockArticuloRepo;
import com.bodega.service.IBodegaStockArticuloService;

@Service
public class BodegaStockArticuloServiceImpl implements IBodegaStockArticuloService<BodegaStockArticulo> {
	
	@Autowired
	private IBodegaStockArticuloRepo repo;
	
	@Override
	public List<Articulo> listarStockBodega(Integer codBodega){		
		return repo.listarStockBodega(codBodega);
	}
	@Override
	public List<Articulo> listarStockBodegaArticulo(Integer codBodega, Integer codArticulo){
		return repo.listarStockBodegaArticulo(codBodega, codArticulo);
	}
	@Override
	public BodegaStockArticulo registrar(BodegaStockArticulo objeto) {
		return repo.save(objeto);
	}
	
}
