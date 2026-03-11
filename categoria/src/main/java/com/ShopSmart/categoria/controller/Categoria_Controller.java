package com.ShopSmart.categoria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ShopSmart.categoria.models.entities.Categoria;
import com.ShopSmart.categoria.models.request.AgregarCategoria;
import com.ShopSmart.categoria.services.Categoria_Service;

@RestController
@RequestMapping("/api/v1/categorias")
public class Categoria_Controller {

    @Autowired
    private Categoria_Service categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> obtenerCategorias() {
        List<Categoria> categorias = categoriaService.obtenerCategorias();
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> obtenerCategoriaPorId(@PathVariable Integer id) {
        Categoria categoria = categoriaService.obtenerCategoriaPorId(id);
        return ResponseEntity.ok(categoria);
    }

    @PostMapping
    public ResponseEntity<Categoria> crearCategoria(@RequestBody AgregarCategoria categoria) {
        Categoria nuevaCategoria = categoriaService.crearCategoria(categoria);
        return ResponseEntity.status(201).body(nuevaCategoria);
    }

}
