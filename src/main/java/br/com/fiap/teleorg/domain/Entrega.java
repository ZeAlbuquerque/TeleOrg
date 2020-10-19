package br.com.fiap.teleorg.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Calendar;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Entrega {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private Calendar dataHoraEntregaPrevista;

    @Column(nullable = false)
    private LocalDate dataHoraEntrega;

    @OneToOne(cascade = CascadeType.ALL)
    private Doacao doacao;

    @ManyToOne
    @JoinColumn(name = "id_hospital")
    private Hospital hospital;


}
