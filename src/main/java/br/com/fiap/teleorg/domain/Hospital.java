package br.com.fiap.teleorg.domain;


import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table
public class Hospital implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String nome;

    //@CNPJ
    @Column(nullable = false)
    private String cnpj;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String logradouro;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private Integer telefone;
}
