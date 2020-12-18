package com.bodega.service;

import java.util.List;

import com.bodega.dto.FiltroDonacionDTO;
import com.bodega.model.Donacion;


public interface IDonacionService extends ICrud<Donacion> {
	List<Donacion> buscarPorFecha(FiltroDonacionDTO filtro);
}
