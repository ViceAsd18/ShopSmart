package com.ShopSmart.productos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ShopSmart.productos.models.entities.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
    
}
