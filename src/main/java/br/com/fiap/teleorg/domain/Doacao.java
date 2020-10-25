package br.com.fiap.teleorg.domain;


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

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente receptor;

    public Doacao(){}

    public Doacao(Integer id, Orgao orgao, Paciente receptor) {
        this.id = id;
        this.orgao = orgao;
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
