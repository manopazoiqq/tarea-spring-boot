// REPO OK CON LAS FUNCIONES BASICAS
package com.bodega.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bodega.model.Donante;

public interface IDonanteRepo extends JpaRepository<Donante, Integer> {

}
