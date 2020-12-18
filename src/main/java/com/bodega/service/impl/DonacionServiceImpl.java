package com.bodega.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bodega.dto.FiltroDonacionDTO;
import com.bodega.model.Donacion;
import com.bodega.repo.IDonacionRepo;
import com.bodega.service.IDonacionService;

@Service
public class DonacionServiceImpl implements IDonacionService {
	@Autowired
	private IDonacionRepo repo;

	@Override
	public Donacion registrar(Donacion objeto) {
		return repo.save(objeto);		
	}
	@Override
	public Donacion modificar(Donacion objeto) {
		return repo.save(objeto);
	}
	@Override
	public List<Donacion> listar(){
		return repo.findAll();
	}
	@Override
	public Donacion leerPorId(Integer codDonacion) {
		Optional<Donacion> op = repo.findById(codDonacion);
		return op.isPresent() ? op.get() : new Donacion();
	}
	@Override
	public boolean eliminar(Integer codDonacion) {
		repo.deleteById(codDonacion);
		return true;
	}
	@Override
	public List<Donacion> buscarPorFecha(FiltroDonacionDTO filtro){
		return repo.buscarPorFecha(filtro.getFechaDonacion());		
	}
}
