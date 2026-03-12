package com.ShopSmart.inventario.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ShopSmart.inventario.models.entities.Inventario;
import com.ShopSmart.inventario.models.request.AgregarInventario;
import com.ShopSmart.inventario.repositories.InventarioRepository;

@Service
public class InventarioService {
    
    @Autowired
    private InventarioRepository inventarioRepository;

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


    public Inventario agregarInventario(AgregarInventario request) {
    
        if (inventarioRepository.findByIdProducto(request.getId_producto()).isPresent()) {
            throw new RuntimeException("Error: El producto con ID " + request.getId_producto() + " ya tiene un registro de inventario.");
        }

        Inventario nuevoInventario = new Inventario();
        nuevoInventario.setId_producto(request.getId_producto());
        nuevoInventario.setStock(request.getStock());
        nuevoInventario.setFecha_ultima_actualizacion(LocalDateTime.now());
        
        return inventarioRepository.save(nuevoInventario);
    }

}
