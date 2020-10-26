package br.com.fiap.teleorg.domain;



import br.com.fiap.teleorg.enums.StatusOrgao;
import br.com.fiap.teleorg.enums.TipoOrgao;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Table
public class Orgao implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoOrgao tipoOrgao;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusOrgao statusOrgao;

    @ManyToOne
    @JoinColumn(name = "doador_id")
    private Paciente doador;

    public Orgao () {};

    public Orgao(TipoOrgao tipoOrgao, StatusOrgao statusOrgao, Paciente doador) {
        this.tipoOrgao = tipoOrgao;
        this.statusOrgao = statusOrgao;
        this.doador = doador;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoOrgao getTipoOrgao() {
        return tipoOrgao;
    }

    public void setTipoOrgao(TipoOrgao tipoOrgao) {
        this.tipoOrgao = tipoOrgao;
    }

    public StatusOrgao getStatusOrgao() {
        return statusOrgao;
    }

    public void setStatusOrgao(StatusOrgao statusOrgao) {
        this.statusOrgao = statusOrgao;
    }

    public Paciente getDoador() {
        return doador;
    }

    public void setDoador(Paciente doador) {
        this.doador = doador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Orgao)) return false;
        Orgao orgao = (Orgao) o;
        return getId().equals(orgao.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
