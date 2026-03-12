package com.ShopSmart.inventario.models.request;

import lombok.Data;

@Data
public class AgregarInventario {
    private Integer id_producto;
    private Integer stock;
}
