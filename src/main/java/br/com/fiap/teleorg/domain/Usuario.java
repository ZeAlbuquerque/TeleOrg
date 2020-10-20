package br.com.fiap.teleorg.domain;

import io.github.zealbuquerque.enums.StatusUsuario;
import io.github.zealbuquerque.enums.TipoUsuario;

import javax.persistence.*;

@Entity
@Table
public class Usuario {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 20, nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusUsuario status;

    @Column( nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipo;



}
