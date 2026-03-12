package com.ShopSmart.inventario.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ShopSmart.inventario.models.entities.Inventario;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Integer> {

    @Query("SELECT i FROM Inventario i WHERE i.id_producto = :idProd")
    Optional<Inventario> findByIdProducto(@Param("idProd") Integer idProducto);
}
