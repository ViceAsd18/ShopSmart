package com.ShopSmart.inventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ShopSmart.inventario.models.entities.Inventario;
import com.ShopSmart.inventario.models.request.AgregarInventario;
import com.ShopSmart.inventario.services.InventarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/inventarios")
public class InventarioController {
    
    @Autowired
    private InventarioService inventarioService;

    @GetMapping
    public List<Inventario> listarTodo() {
        return inventarioService.obtenerInventarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable Integer id) {
        
        try {

            return ResponseEntity.ok(inventarioService.obtenerInventarioPorId(id));

        } catch (RuntimeException e) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody AgregarInventario request) {
        
        try {

            Inventario nuevo = inventarioService.agregarInventario(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);

        } catch (RuntimeException e) {
            //Lanzar error en caso de que el producto ya exista
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
            
        }
    }

}
