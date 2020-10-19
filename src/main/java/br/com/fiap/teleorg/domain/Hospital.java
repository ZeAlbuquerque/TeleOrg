package br.com.fiap.teleorg.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Hospital {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String nome;

    @CNPJ
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
