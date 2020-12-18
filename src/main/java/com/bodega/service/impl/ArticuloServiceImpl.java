package com.bodega.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bodega.model.Articulo;
import com.bodega.repo.IArticuloRepo;
import com.bodega.service.IArticuloService;

@Service
public class ArticuloServiceImpl implements IArticuloService {
	@Autowired
	private IArticuloRepo repo;
	
	@Override
	public Articulo registrar(Articulo articulo) {				
		return repo.save(articulo);
	}
	@Override
	public Articulo modificar(Articulo articulo) {
		return repo.save(articulo);
	}
	@Override
	public List<Articulo> listar(){
		return repo.findAll();
	}
	@Override
	public Articulo leerPorId(Integer codArticulo) {
		Optional<Articulo> op = repo.findById(codArticulo);
		return op.isPresent() ? op.get() : new Articulo();
	}
	@Override
	public boolean eliminar(Integer codArticulo) {
		repo.deleteById(codArticulo);;
		return true;
	}	

}
