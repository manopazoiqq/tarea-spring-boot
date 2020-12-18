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
import com.bodega.model.Bodega;
import com.bodega.service.IBodegaService;

@RestController
@RequestMapping("/bodega")
public class BodegaController {
	
	@Autowired	
	private IBodegaService servicio;
	
	@GetMapping
	public ResponseEntity<List<Bodega>> listar(){
		List<Bodega> listado = servicio.listar();
		return new ResponseEntity<List<Bodega>>(listado,HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Bodega> leerPorId(@PathVariable("id") Integer codBodega){
		Bodega bodega = servicio.leerPorId(codBodega);
		if (bodega.getCod_bodega() == null) {
			throw new ModeloNotFoundException("ID: "+codBodega+" no encontrado");
		}
		return new ResponseEntity<Bodega>(bodega,HttpStatus.OK);		
	}
	@PostMapping
	public ResponseEntity<Bodega> registrar(@Valid @RequestBody Bodega bodega){
		Bodega nuevaBodega = servicio.registrar(bodega);
		return new ResponseEntity<Bodega>(nuevaBodega,HttpStatus.OK);
	}
	@PutMapping
	public ResponseEntity<Bodega> modificar(@Valid @RequestBody Bodega bodega){
		Bodega nuevaBodega = servicio.modificar(bodega);
		return new ResponseEntity<Bodega>(nuevaBodega,HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer codBodega){
		Bodega bodega = servicio.leerPorId(codBodega);
		if (bodega.getCod_bodega() == null) {
			throw new ModeloNotFoundException("ID: "+codBodega+" no encontrado");
		}
		servicio.eliminar(codBodega);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
