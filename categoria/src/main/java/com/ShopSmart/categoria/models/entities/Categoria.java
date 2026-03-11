package com.ShopSmart.categoria.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "categorias")
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_categoria_producto;

    @Column(name = "nombre_categoria", nullable = false, length = 100, unique = true)
    private String nombre_categoria;

    @Column(name = "descripcion_categoria", nullable = false, length = 500, unique = true)
    private String descripcion_categoria;

}
