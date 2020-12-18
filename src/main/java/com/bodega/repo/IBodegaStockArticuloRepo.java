package com.bodega.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bodega.model.Articulo;
import com.bodega.model.BodegaStockArticulo;

public interface IBodegaStockArticuloRepo extends JpaRepository<BodegaStockArticulo, Integer> {
	@Query(value="SELECT * FROM BODEGA_STOCK_ARTICULO WHERE COD_BODEGA = :codBodega", nativeQuery = true)
	List<Articulo> listarStockBodega(@Param("codBodega") Integer codBodega);
	
	@Query(value="SELECT M.*,A.NOMBRE_ARTICULO "
				+ "FROM BODEGA_STOCK_ARTICULO M, ARTICULO A "
				+ "WHERE M.COD_BODEGA = :codBodega "
				+ "AND M.codigo_articulo = :codArticulo "
				+ "AND A.codigo_articulo = :codArticulo", nativeQuery = true)
	List<Articulo> listarStockBodegaArticulo(@Param("codBodega") Integer codBodega, @Param("codArticulo") Integer codArticulo);
}
