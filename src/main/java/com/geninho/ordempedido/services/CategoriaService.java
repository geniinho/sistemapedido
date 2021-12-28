package com.geninho.ordempedido.services;

import com.geninho.ordempedido.domain.Categoria;
import com.geninho.ordempedido.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria buscar (Integer id){
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElse(null);
    }
}