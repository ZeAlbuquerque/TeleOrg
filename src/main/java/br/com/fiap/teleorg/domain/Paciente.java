package br.com.fiap.teleorg.domain;

import br.com.fiap.teleorg.enums.TipoSanguineo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;


@Entity
@Table
public class Paciente implements Serializable {
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

    @Column(nullable = false)
    private Boolean doador;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    public  Paciente (){}

    public Paciente(Integer id, String nome, TipoSanguineo tipoSanguineo, Calendar dataNascimento, String cpf, Boolean doador, Hospital hospital) {
        this.id = id;
        this.nome = nome;
        this.tipoSanguineo = tipoSanguineo;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.doador = doador;
        this.hospital = hospital;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoSanguineo getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(TipoSanguineo tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

   public Boolean getDoador() {
        return doador;
    }

    public void setDoador(Boolean doador) {
        this.doador = doador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Paciente)) return false;
        Paciente paciente = (Paciente) o;
        return getId().equals(paciente.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
