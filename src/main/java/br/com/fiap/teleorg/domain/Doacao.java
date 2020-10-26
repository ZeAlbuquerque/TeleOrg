package br.com.fiap.teleorg.domain;


import br.com.fiap.teleorg.enums.StatusDoacao;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table
public class Doacao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    private Orgao orgao;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusDoacao statusDoacao;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente receptor;

    public Doacao(){}

    public Doacao(Orgao orgao, StatusDoacao statusDoacao, Paciente receptor) {
        this.orgao = orgao;
        this.statusDoacao = statusDoacao;
        this.receptor = receptor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Orgao getOrgao() {
        return orgao;
    }

    public void setOrgao(Orgao orgao) {
        this.orgao = orgao;
    }

    public Paciente getReceptor() {
        return receptor;
    }

    public void setReceptor(Paciente receptor) {
        this.receptor = receptor;
    }

    public StatusDoacao getStatusDoacao() {
        return statusDoacao;
    }

    public void setStatusDoacao(StatusDoacao statusDoacao) {
        this.statusDoacao = statusDoacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doacao)) return false;
        Doacao doacao = (Doacao) o;
        return getId().equals(doacao.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
