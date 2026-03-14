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
    public ResponseEntity<Inventario> obtenerPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(inventarioService.obtenerInventarioPorId(id));
    }

    @PostMapping
    public ResponseEntity<Inventario> agregarInventario(@Valid @RequestBody AgregarInventario inventario) {

        Inventario nuevoInventario = inventarioService.agregarInventario(inventario);

        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoInventario);
    }

}
