package com.ShopSmart.categoria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ShopSmart.categoria.models.entities.Categoria;
import com.ShopSmart.categoria.models.request.AgregarCategoria;
import com.ShopSmart.categoria.repositories.Categoria_Repository;

@Service
public class Categoria_Service {
    
    @Autowired
    private Categoria_Repository categoriaRepository;

    public List<Categoria> obtenerCategorias () {
        return categoriaRepository.findAll();
    }

    public Categoria obtenerCategoriaPorId (Integer id) {
        Categoria categoriaEncontrada = categoriaRepository.findById(id).orElse(null);

        if (categoriaEncontrada == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encontro la categoria");
        }

        return categoriaEncontrada;
    }

    public Categoria crearCategoria (AgregarCategoria categoria) {

        Categoria categoriaCreada = new Categoria();
        categoriaCreada.setNombre_categoria(categoria.getNombre_categoria());
        categoriaCreada.setDescripcion_categoria(categoria.getDescripcion_categoria());
        return categoriaRepository.save(categoriaCreada);
    }


}
