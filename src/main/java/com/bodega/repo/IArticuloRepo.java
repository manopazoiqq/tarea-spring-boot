// REPO OK CON LAS FUNCIONES BASICAS
package com.bodega.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bodega.model.Articulo;

public interface IArticuloRepo extends JpaRepository<Articulo, Integer> {

}
