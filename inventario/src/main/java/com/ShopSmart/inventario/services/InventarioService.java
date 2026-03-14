package com.ShopSmart.inventario.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import com.ShopSmart.inventario.models.dto.ProductoDto;
import com.ShopSmart.inventario.models.entities.Inventario;
import com.ShopSmart.inventario.models.request.AgregarInventario;
import com.ShopSmart.inventario.repositories.InventarioRepository;

@Service
public class InventarioService {
    
    @Autowired
    private InventarioRepository inventarioRepository;

    @Autowired
    private WebClient productoWebClient;

    public List<Inventario> obtenerInventarios() {
        return inventarioRepository.findAll();
    }

    public Inventario obtenerInventarioPorId(Integer id_inventario) {
        Inventario inventario = inventarioRepository.findById(id_inventario).orElse(null);

        if (inventario == null) {
            throw new RuntimeException("Error: No se encontró un inventario con ID " + id_inventario);
        }

        return inventario;
    }

    private ProductoDto validarProducto(Integer idProducto) {

        try {
            return productoWebClient.get()
                .uri("/productos/{id}", idProducto)
                .retrieve()
                .bodyToMono(ProductoDto.class)
                .block();

        } catch (Exception e) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "No se encontró el producto con ID " + idProducto
            );
        }
    }


    public Inventario agregarInventario(AgregarInventario inventario) {
    
        validarProducto(inventario.getId_producto());

        if (inventarioRepository.findByIdProducto(inventario.getId_producto()).isPresent()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "El producto con ID " + inventario.getId_producto() + " ya tiene inventario"
            );
        }

        Inventario nuevoInventario = new Inventario();
        nuevoInventario.setId_producto(inventario.getId_producto());
        nuevoInventario.setStock(inventario.getStock());
        nuevoInventario.setFecha_ultima_actualizacion(LocalDateTime.now());
        
        return inventarioRepository.save(nuevoInventario);
    }

}
