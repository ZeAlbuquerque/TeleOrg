package br.com.fiap.teleorg.domain;


import io.github.zealbuquerque.enums.StatusOrgao;
import io.github.zealbuquerque.enums.TipoOrgao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Orgao {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoOrgao tipoOrgao;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusOrgao statusOrgao;

    @ManyToOne
    @JoinColumn(name = "doador_id")
    private Doador doador;


}
