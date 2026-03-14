package com.ShopSmart.inventario.models.dto;

import java.time.LocalDateTime;

public record ProductoDto(
    Integer id_producto,
    String nombre,
    double precio,
    LocalDateTime fecha_regristro,
    Integer id_inventario,
    Integer id_categoria
) {}
