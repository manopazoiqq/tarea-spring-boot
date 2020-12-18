package com.bodega.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bodega.exception.ModeloNotFoundException;
import com.bodega.model.Articulo;
import com.bodega.service.IArticuloService;

@RestController
@RequestMapping("/articulo")
public class ArticuloController {
	
	@Autowired
	private IArticuloService serv;
	
	@GetMapping
	public ResponseEntity<List<Articulo>> listar(){
		List<Articulo> listado = serv.listar();
		return new ResponseEntity<List<Articulo>>(listado,HttpStatus.OK);		
	}
	@GetMapping("/{id}")
	public ResponseEntity<Articulo> listarPorId(@PathVariable("id") Integer codArticulo ){
		Articulo articulo = serv.leerPorId(codArticulo);
		if (articulo.getCodigo_articulo() == null) {
			throw new ModeloNotFoundException("ID: "+codArticulo+" no encontrado");
		}
		return new ResponseEntity<Articulo>(articulo, HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Articulo> registrar(@Valid @RequestBody Articulo articulo){		
		Articulo nuevorticulo = serv.registrar(articulo);
		return new ResponseEntity<Articulo>(nuevorticulo,HttpStatus.OK);		
	}
	@PutMapping
	public ResponseEntity<Articulo> modificar(@Valid @RequestBody Articulo articulo){
		Articulo nuevoArticulo = serv.modificar(articulo);
		return new ResponseEntity<Articulo>(nuevoArticulo, HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminarPorId(@PathVariable("id") Integer codArticulo){
		Articulo articulo = serv.leerPorId(codArticulo);
		if (articulo.getCodigo_articulo() == null) {
			throw new ModeloNotFoundException("ID: "+ codArticulo +" no encontrado");
		}
		serv.eliminar(codArticulo);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
