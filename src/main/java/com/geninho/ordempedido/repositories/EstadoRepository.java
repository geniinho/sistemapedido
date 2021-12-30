package com.geninho.ordempedido.repositories;

import com.geninho.ordempedido.domain.Cidade;
import com.geninho.ordempedido.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository <Estado, Integer> {

}
