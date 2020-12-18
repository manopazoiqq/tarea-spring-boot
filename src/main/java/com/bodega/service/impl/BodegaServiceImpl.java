package com.bodega.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bodega.model.Bodega;
import com.bodega.repo.IBodegaRepo;
import com.bodega.service.IBodegaService;

@Service
public class BodegaServiceImpl implements IBodegaService {
	
	@Autowired
	private IBodegaRepo repo;
	
	@Override	
	public Bodega registrar(Bodega objeto) {
		return repo.save(objeto);
	}
	@Override
	public Bodega modificar(Bodega objeto) {
		return repo.save(objeto);
	}
	@Override
	public List<Bodega> listar(){
		return repo.findAll();
	}
	@Override
	public Bodega leerPorId(Integer id) {
		Optional<Bodega> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Bodega();
	}
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}
}
