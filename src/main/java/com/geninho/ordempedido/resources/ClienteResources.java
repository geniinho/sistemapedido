package com.geninho.ordempedido.resources;

import com.geninho.ordempedido.domain.Cliente;
import com.geninho.ordempedido.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResources {

    @Autowired
    private ClienteService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id){

        Cliente obj = service.find(id);
        return ResponseEntity.ok().body(obj);

    }
}
