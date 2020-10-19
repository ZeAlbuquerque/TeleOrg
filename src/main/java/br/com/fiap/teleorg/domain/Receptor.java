package br.com.fiap.teleorg.domain;

import io.github.zealbuquerque.enums.TipoSanguineo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import java.util.Calendar;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Receptor {

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
    @CPF
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;
}
