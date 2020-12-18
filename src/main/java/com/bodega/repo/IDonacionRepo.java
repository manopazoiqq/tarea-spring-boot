// REPO OK CON LAS FUNCIONES BASICAS
package com.bodega.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bodega.model.Donacion;


public interface IDonacionRepo extends JpaRepository<Donacion, Integer> {
	// retornar donaciones de una fecha X
	@Query(value="SELECT * FROM DONACION WHERE FECHA_DONACION = :fechaDonacion", nativeQuery = true)
	List<Donacion> buscarPorFecha(@Param("fechaDonacion") LocalDateTime fechaDonacion);	

}
