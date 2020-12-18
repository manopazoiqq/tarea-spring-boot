package com.bodega.controller;

import org.springframework.web.bind.annotation.RestController;
import com.bodega.exception.ModeloNotFoundException;

import com.bodega.model.Fundacion;
import com.bodega.service.IFundacionService;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/fundacion")
public class FundacionController {

	@Autowired
	private IFundacionService servicio;
	
	@GetMapping
	public ResponseEntity<List<Fundacion>> listar(){
		List<Fundacion> listado = servicio.listar();
		return new ResponseEntity<List<Fundacion>>(listado,HttpStatus.OK);		
	}
	@GetMapping("/{id}")
	public ResponseEntity<Fundacion> leerPorId(@PathVariable("id") Integer codFundacion){
		Fundacion fundacion = servicio.leerPorId(codFundacion);
		if (fundacion.getRut_fundacion() == null) {
			throw new ModeloNotFoundException("ID: "+codFundacion + " NO encontrado");
		}		
		return new ResponseEntity<Fundacion>(fundacion,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Fundacion> registrar(@Valid @RequestBody Fundacion fundacion){
		Fundacion nuevaFundacion = servicio.registrar(fundacion);
		return new ResponseEntity<Fundacion>(nuevaFundacion,HttpStatus.OK);
	}
	@PutMapping
	public ResponseEntity<Fundacion> modificar(@Valid @RequestBody Fundacion fundacion){
		Fundacion nuevaFundacion = servicio.modificar(fundacion);
		return new ResponseEntity<Fundacion>(nuevaFundacion,HttpStatus.OK);
	}	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer codFundacion){
		Fundacion fundacion = servicio.leerPorId(codFundacion);
		if (fundacion.getRut_fundacion() == null) {
			throw new ModeloNotFoundException("ID: "+codFundacion + " NO encontrado");
		}
		servicio.eliminar(codFundacion);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
