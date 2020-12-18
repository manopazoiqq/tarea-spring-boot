package com.bodega.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bodega.model.Donante;
import com.bodega.service.IDonanteService;

@RestController
@RequestMapping("/donante")
public class DonanteController {
	
	@Autowired
	private IDonanteService servicio;
	
	@GetMapping
	public ResponseEntity<List<Donante>> listar(){
		List<Donante> listado = servicio.listar();
		return new ResponseEntity<List<Donante>>(listado, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Donante> leerPorId(@PathVariable("id") Integer codDonante){
		Donante donante = servicio.leerPorId(codDonante);
		return new ResponseEntity<Donante>(donante, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Donante> registrar(@Valid @RequestBody Donante donante){
		Donante nuevoDonante = servicio.registrar(donante);
		return new ResponseEntity<Donante>(nuevoDonante,HttpStatus.OK);
	}
	@PutMapping
	public ResponseEntity<Donante> modificar(@Valid @RequestBody Donante donante){
		Donante nuevoDonante = servicio.registrar(donante);
		return new ResponseEntity<Donante>(nuevoDonante,HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer codDonante){
		servicio.eliminar(codDonante);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
