package br.com.fiap.teleorg.domain;

import br.com.fiap.teleorg.enums.TipoSanguineo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;


@Entity
@Table
public class Receptor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoSanguineo tipoSanguineo;

    @Column(nullable = false)
    private Calendar dataNascimento;

    @Column(nullable = false, unique = true)
   
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;
}
