package com.coop.model.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.coop.model.Producto;
import com.coop.model.dto.ProductoSintetico;

// DAO ¬
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

	public List<Producto> findByProductoLike(String partName);

	public List<Producto> findByPrecioBetween(double precioDesde, double precioHasta);

	@Query(name = "Sintetico", nativeQuery = true)
	public List<ProductoSintetico> listadoSintetico(double precioMinimo);

	@Query(value = "SELECT COUNT(*) FROM productos WHERE precio>?", nativeQuery = true)
	public long cantidadProductosMasCarosQue(double precioMinimo);

}