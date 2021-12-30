package com.geninho.ordempedido.repositories;

import com.geninho.ordempedido.domain.Categoria;
import com.geninho.ordempedido.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository <Cidade, Integer> {

}
