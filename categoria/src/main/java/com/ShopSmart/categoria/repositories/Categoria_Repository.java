package com.ShopSmart.categoria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ShopSmart.categoria.models.entities.Categoria;

@Repository
public interface Categoria_Repository extends JpaRepository<Categoria, Integer> {
    
}
