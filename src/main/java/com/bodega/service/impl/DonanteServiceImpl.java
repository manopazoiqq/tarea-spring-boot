package com.bodega.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bodega.model.Donante;
import com.bodega.repo.IDonanteRepo;
import com.bodega.service.IDonanteService;

@Service
public class DonanteServiceImpl implements IDonanteService {
	
	@Autowired
	private IDonanteRepo repo;
	
	@Override
	public Donante registrar(Donante donante) {
		return repo.save(donante);
	}
	
	@Override
	public Donante modificar(Donante donante) {
		return repo.save(donante);
	}	
	@Override
	public List<Donante> listar(){
		return repo.findAll();		
	}
	@Override
	public Donante leerPorId(Integer codDonante) {
		Optional<Donante> op = repo.findById(codDonante);
		return op.isPresent() ? op.get() : new Donante();
	}
	@Override
	public boolean eliminar(Integer codDonante) {
		repo.deleteById(codDonante);
		return true;
	}

}
