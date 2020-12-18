// REPO OK CON LAS FUNCIONES BASICAS
package com.bodega.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bodega.model.Fundacion;

public interface IFundacionRepo extends JpaRepository<Fundacion, Integer> {

}
