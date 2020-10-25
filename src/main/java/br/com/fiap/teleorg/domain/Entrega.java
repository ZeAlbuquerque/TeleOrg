package br.com.fiap.teleorg.domain;

import br.com.fiap.teleorg.enums.StatusEntrega;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Objects;


@Entity
@Table
public class Entrega implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Calendar dataHoraEntregaPrevista;

    @Column()
    private LocalDate dataHoraEntrega;

    @ManyToOne
    @JoinColumn(name = "id_doacao")
    private Doacao doacao;

    @Column(nullable = false)
    private StatusEntrega statusEntrega;

    @ManyToOne
    @JoinColumn(name = "id_hospital")
    private Hospital hospital;

    public Entrega (){}

    public Entrega(Calendar dataHoraEntregaPrevista, LocalDate dataHoraEntrega, Doacao doacao, StatusEntrega statusEntrega, Hospital hospital) {
        this.dataHoraEntregaPrevista = dataHoraEntregaPrevista;
        this.dataHoraEntrega = dataHoraEntrega;
        this.doacao = doacao;
        this.statusEntrega = statusEntrega;
        this.hospital = hospital;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getDataHoraEntregaPrevista() {
        return dataHoraEntregaPrevista;
    }

    public void setDataHoraEntregaPrevista(Calendar dataHoraEntregaPrevista) {
        this.dataHoraEntregaPrevista = dataHoraEntregaPrevista;
    }

    public LocalDate getDataHoraEntrega() {
        return dataHoraEntrega;
    }

    public void setDataHoraEntrega(LocalDate dataHoraEntrega) {
        this.dataHoraEntrega = dataHoraEntrega;
    }

    public Doacao getDoacao() {
        return doacao;
    }

    public void setDoacao(Doacao doacao) {
        this.doacao = doacao;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public StatusEntrega getStatusEntrega() {
        return statusEntrega;
    }

    public void setStatusEntrega(StatusEntrega statusEntrega) {
        this.statusEntrega = statusEntrega;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entrega)) return false;
        Entrega entrega = (Entrega) o;
        return getId().equals(entrega.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
