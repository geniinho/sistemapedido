package com.geninho.ordempedido.services;

import com.geninho.ordempedido.domain.Cliente;

import com.geninho.ordempedido.repositories.ClienteRepository;
import com.geninho.ordempedido.services.Exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public Cliente find (Integer id){
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(
                () -> new ObjectNotFoundException(
                        "Objeto não encontrado."
                )
        );
    }
}