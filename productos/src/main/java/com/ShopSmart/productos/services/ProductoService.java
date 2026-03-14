package com.ShopSmart.productos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import com.ShopSmart.productos.models.entities.Producto;
import com.ShopSmart.productos.models.request.ActualizarProducto;
import com.ShopSmart.productos.models.request.AgregarProducto;
import com.ShopSmart.productos.repositories.ProductoRepository;

import lombok.val;

@Service
public class ProductoService {
    
    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private WebClient categoriaClient;

    public List<Producto> obtenerProductos(){
        return productoRepository.findAll();
    }


    public Producto obtenerProductoPorId(Integer id){

        Producto productoEncontrado = productoRepository.findById(id).orElse(null);

        if (productoEncontrado == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encontro el producto con ID: " + id);

        }

        return productoEncontrado;

    }

    private void validarCategoria(Integer idCategoria) {

        try {
            categoriaClient.get()
                .uri("/categorias/{id}", idCategoria)
                .retrieve()
                .bodyToMono(Object.class)
                .block();

        } catch (Exception e) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "No se encontró la categoría con ID: " + idCategoria
            );
        }
    }


    public Producto agregarProducto(AgregarProducto producto){

        validarCategoria(producto.getId_categoria());

        Producto productoNuevo = new Producto();

        productoNuevo.setNombre(producto.getNombre());
        productoNuevo.setPrecio(producto.getPrecio());
        productoNuevo.setId_categoria(producto.getId_categoria());
        productoNuevo.setFecha_registro(java.time.LocalDateTime.now());


        return productoRepository.save(productoNuevo);

    }

    public Producto actualizarProducto(Integer id_producto, ActualizarProducto producto){

        Producto productoEncontrado = obtenerProductoPorId(id_producto);

        productoEncontrado.setNombre(producto.getNombre());
        productoEncontrado.setPrecio(producto.getPrecio());
        productoEncontrado.setId_categoria(producto.getId_categoria());

        return productoRepository.save(productoEncontrado);
    }

    public String eliminarProducto(Integer id){

        Producto productoEncontrado = obtenerProductoPorId(id);

        productoRepository.deleteById(productoEncontrado.getId_producto());
        return "Producto Eliminado Correctamente";

    }


}
