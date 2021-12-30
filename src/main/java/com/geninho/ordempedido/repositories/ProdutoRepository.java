package com.geninho.ordempedido.repositories;

import com.geninho.ordempedido.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository <Produto, Integer> {

}
