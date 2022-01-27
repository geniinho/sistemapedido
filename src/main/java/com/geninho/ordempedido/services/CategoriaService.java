package com.geninho.ordempedido.services;

import com.geninho.ordempedido.domain.Categoria;
import com.geninho.ordempedido.dto.CategoriaDTO;
import com.geninho.ordempedido.repositories.CategoriaRepository;
import com.geninho.ordempedido.services.Exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria find (Integer id){
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(
                () -> new ObjectNotFoundException(
                        "Objeto não encontrado."
                )
        );
    }

    public Categoria insert (Categoria obj){
        obj.setId(null);
        return repo.save(obj);
    }

    public Categoria update(Categoria obj){
        find(obj.getId());
        return repo.save(obj);
    }

    public void delete(Integer id){
        find(id);
        repo.deleteById(id);
    }

    public List<Categoria> findAll(){
        return repo.findAll();
    }

    public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page,linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    public Categoria fromDTO(CategoriaDTO objDto){
        return new Categoria(objDto.getId(), objDto.getNome());
    }

}