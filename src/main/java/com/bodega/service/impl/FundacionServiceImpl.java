package com.bodega.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bodega.model.Fundacion;
import com.bodega.repo.IFundacionRepo;
import com.bodega.service.IFundacionService;

@Service
public class FundacionServiceImpl implements IFundacionService {
	@Autowired
	private IFundacionRepo repo;
	@Override
	public Fundacion registrar(Fundacion fundacion) {
		return repo.save(fundacion);
	}
	@Override
	public Fundacion modificar(Fundacion fundacion) {
		return repo.save(fundacion);
	}
	@Override
	public List<Fundacion> listar(){
		return repo.findAll();
	}
	@Override
	public Fundacion leerPorId(Integer codFundacion) {
		Optional<Fundacion> op = repo.findById(codFundacion);
		return op.isPresent() ? op.get() : new Fundacion();
	}
	@Override
	public boolean eliminar(Integer codFundacion) {
		repo.deleteById(codFundacion);
		return true;
	}

}
