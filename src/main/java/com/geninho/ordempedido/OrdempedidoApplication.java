package com.geninho.ordempedido;

import com.geninho.ordempedido.domain.Categoria;
import com.geninho.ordempedido.domain.Produto;
import com.geninho.ordempedido.repositories.CategoriaRepository;
import com.geninho.ordempedido.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class OrdempedidoApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrdempedidoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
