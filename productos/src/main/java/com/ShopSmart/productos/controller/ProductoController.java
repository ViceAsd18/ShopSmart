package com.ShopSmart.productos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ShopSmart.productos.models.entities.Producto;
import com.ShopSmart.productos.models.request.ActualizarProducto;
import com.ShopSmart.productos.models.request.AgregarProducto;
import com.ShopSmart.productos.services.ProductoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("")
    public List<Producto> obtenerProductos() {
        return productoService.obtenerProductos();
    }

    @GetMapping("/{id_producto}")
    public Producto obtenerPrductoPorId(@PathVariable Integer id_producto){
        return productoService.obtenerProductoPorId(id_producto);
    }

    @PostMapping()
    public Producto agregarProducto(@RequestBody AgregarProducto producto){
        return productoService.agregarProducto(producto);
    }

    @PutMapping("/{id_producto}")
    public Producto actualizarProducto(@PathVariable Integer id_producto, @RequestBody ActualizarProducto producto){
        return productoService.actualizarProducto(id_producto,producto);
    }

    @DeleteMapping("/{id_producto}")
    public String eliminarProducto(@PathVariable Integer id_producto){
        return productoService.eliminarProducto(id_producto);
    }


}
