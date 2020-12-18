package com.bodega.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bodega.model.Articulo;
import com.bodega.repo.IBodegaStockArticuloRepo;

@RestController
@RequestMapping("/detallestock")
public class BodegaStockArticuloController {
	@Autowired	
	private IBodegaStockArticuloRepo service;
	// INSERTAR REGISTRO, LEER STOCK X BODEGA, LEER STOCK ARTICULO X BODEGA...
	@GetMapping("/{codBodega}")
	public ResponseEntity<List<Articulo>> listarStockBodega(@PathVariable("codBodega") Integer codBodega){
		List<Articulo> listado = service.listarStockBodega(codBodega);		
		return new ResponseEntity<List<Articulo>>(listado,HttpStatus.OK);		
	}
	@GetMapping("/{codBodega}/{codArticulo}")
	public ResponseEntity<List<Articulo>> listarStockBodegaArticulo(@PathVariable("codBodega") Integer codBodega, @PathVariable("codArticulo") Integer codArticulo){
		List<Articulo> listado = service.listarStockBodegaArticulo(codBodega, codArticulo);
		return new ResponseEntity<List<Articulo>>(listado,HttpStatus.OK);
	}	
	
}
