package com.geninho.ordempedido;

import com.geninho.ordempedido.domain.Categoria;
import com.geninho.ordempedido.domain.Cidade;
import com.geninho.ordempedido.domain.Estado;
import com.geninho.ordempedido.domain.Produto;
import com.geninho.ordempedido.repositories.CategoriaRepository;
import com.geninho.ordempedido.repositories.CidadeRepository;
import com.geninho.ordempedido.repositories.EstadoRepository;
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
    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private CidadeRepository cidadeRepositoryRepository;


    public static void main(String[] args) {
        SpringApplication.run(OrdempedidoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria(null, "Informática");
        Categoria cat2 = new Categoria(null, "Escritório");

        Produto p1 = new Produto(null, "Computador", 2000.00);
        Produto p2 = new Produto(null, "Impressora", 800.00);
        Produto p3 = new Produto(null, "Mouse", 80.00);

        Estado est1 = new Estado(null,"Bahia");
        Estado est2 = new Estado(null,"São Paulo");

        Cidade cd1 = new Cidade(null,"Salvador",est1);
        Cidade cd2 = new Cidade(null,"Feira de Santana",est1);
        Cidade cd3 = new Cidade(null,"Itu",est2);

        est1.getCidades().addAll(Arrays.asList(cd1,cd3));
        est2.getCidades().addAll(Arrays.asList(cd2));

        cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
        cat2.getProdutos().add(p2);

        p1.getCategorias().add(cat1);
        p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
        p3.getCategorias().add(cat1);




        categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
        produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
        estadoRepository.saveAll(Arrays.asList(est1,est2));
        cidadeRepositoryRepository.saveAll(Arrays.asList(cd1,cd2,cd3));
    }
}
