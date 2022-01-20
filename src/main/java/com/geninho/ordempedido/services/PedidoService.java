package com.geninho.ordempedido.services;

import com.geninho.ordempedido.domain.Pedido;
import com.geninho.ordempedido.repositories.PedidoRepository;
import com.geninho.ordempedido.services.Exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;

    public Pedido buscar (Integer id){
        Optional<Pedido> obj = repo.findById(id);
        return obj.orElseThrow(
                () -> new ObjectNotFoundException(
                        "Objeto não encontrado."
                )
        );
    }
}