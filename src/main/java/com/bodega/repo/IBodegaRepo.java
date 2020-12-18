// REPO OK CON LAS FUNCIONES BASICAS
package com.bodega.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bodega.model.Bodega;

public interface IBodegaRepo extends JpaRepository<Bodega, Integer> {

}
