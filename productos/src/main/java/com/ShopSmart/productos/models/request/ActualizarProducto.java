package com.ShopSmart.productos.models.request;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class ActualizarProducto {

    @Column(nullable = false)
    private Integer id_producto;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false)
    private Double precio;

    @Column(nullable = false)
    private Integer id_inventario;

    @Column(nullable = false)
    private Integer id_categoria;
}
