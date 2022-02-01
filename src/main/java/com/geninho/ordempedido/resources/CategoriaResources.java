package com.geninho.ordempedido.resources;

import com.geninho.ordempedido.domain.Categoria;
import com.geninho.ordempedido.dto.CategoriaDTO;
import com.geninho.ordempedido.services.CategoriaService;
import com.geninho.ordempedido.services.Exception.DataIntegrityViolation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResources {

    @Autowired
    private CategoriaService service;

    @PostMapping
    public ResponseEntity<Void> insert (@Valid @RequestBody CategoriaDTO objDto){
        Categoria obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        //retornando uri do obj criando para o cliente
        URI uri = ServletUriComponentsBuilder.
                fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> findAll(){
        List<Categoria> list = service.findAll();
        List<CategoriaDTO> listDto = list.stream().map(obj -> new CategoriaDTO()).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id){
        Categoria obj = service.find(id);
        return ResponseEntity.ok().body(obj);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody CategoriaDTO objDto,@PathVariable Integer id){
        Categoria obj = service.fromDTO(objDto);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        try{
            service.delete(id);
        }
        catch (DataIntegrityViolationException ex){
            throw new DataIntegrityViolation("Não é possivel excluir categoria que já possui produtos cadastrados");
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/page")
    public ResponseEntity<Page> findPage(
            @RequestParam(value = "page",defaultValue = "0") Integer page,
            @RequestParam(value = "linePerPage",defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy",defaultValue = "nome") String orderBy,
            @RequestParam(value = "direction",defaultValue = "ASC") String direction){

        Page<Categoria> list = service.findPage(page,linesPerPage,orderBy,direction);
        Page<CategoriaDTO> listDto = list.map(obj -> new CategoriaDTO());
        return ResponseEntity.ok().body(listDto);
    }

}
