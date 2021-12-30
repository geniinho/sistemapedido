package com.geninho.ordempedido.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Produto  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private double preco;

    @ManyToMany
    @JoinTable(
    name = "PRODUTO_CATEGORIA", // NOME DA TABELA
    joinColumns = @JoinColumn(name = "produto_id"),
    inverseJoinColumns = @JoinColumn (name = "categoria_id")
    )
    @JsonBackReference
    private List<Categoria> categorias = new ArrayList<>();

}
