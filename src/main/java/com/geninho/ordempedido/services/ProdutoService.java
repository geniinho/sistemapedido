package com.geninho.ordempedido.services;

import com.geninho.ordempedido.domain.Categoria;
import com.geninho.ordempedido.domain.Produto;
import com.geninho.ordempedido.repositories.CategoriaRepository;
import com.geninho.ordempedido.repositories.ProdutoRepository;
import com.geninho.ordempedido.services.Exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repo;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Produto find (Integer id){
        Optional<Produto> obj = repo.findById(id);
        return obj.orElseThrow(
                () -> new ObjectNotFoundException(
                        "Objeto não encontrado."
                )
        );
    }

    public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage,
                               String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);

        List<Categoria> categorias = categoriaRepository.findAllById(ids);
        return repo.findDistinctByNomeContainingAndCategoriasIn(nome, categorias,pageRequest);

    }
}