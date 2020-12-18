package com.bodega.controller;

import java.util.ArrayList;
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

import com.bodega.dto.FiltroDonacionDTO;
import com.bodega.exception.ModeloNotFoundException;
import com.bodega.model.Donacion;
import com.bodega.service.IDonacionService;

@RestController
@RequestMapping("/donacion")
public class DonacionController {
	
	@Autowired
	private IDonacionService service;
	
	@GetMapping
	public ResponseEntity<List<Donacion>> listar(){
		List<Donacion> listado = service.listar();
		return new ResponseEntity<List<Donacion>>(listado,HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Donacion> leerPorId(@PathVariable("id") Integer codDonacion){
		Donacion donacion = service.leerPorId(codDonacion);
		if (donacion.getCod_donacion() == null) {
			throw new ModeloNotFoundException("ID: "+codDonacion+" no encontrado");
		}
		return new ResponseEntity<Donacion>(donacion, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Donacion> registrar(@Valid @RequestBody Donacion donacion){
		Donacion nuevaDonacion = service.registrar(donacion);
		return new ResponseEntity<Donacion>(nuevaDonacion,HttpStatus.OK);
	}
	@PutMapping
	public ResponseEntity<Donacion> modificar(@Valid @RequestBody Donacion donacion){
		Donacion nuevaDonacion = service.modificar(donacion);
		return new ResponseEntity<Donacion>(nuevaDonacion,HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminarPorId(@PathVariable("id") Integer codDonacion){
		service.eliminar(codDonacion);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	//DONACIONES DE UN DÍA X	
	@PostMapping("/buscarporfecha")
	public ResponseEntity<List<Donacion>> buscarPorFecha(@RequestBody FiltroDonacionDTO filtro){
		List<Donacion> lista = new ArrayList<>();
		lista = service.buscarPorFecha(filtro);
		return new ResponseEntity<List<Donacion>>(lista,HttpStatus.OK);
		
	}
}
