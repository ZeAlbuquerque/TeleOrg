package br.com.fiap.teleorg.domain;


import br.com.fiap.teleorg.enums.StatusUsuario;
import br.com.fiap.teleorg.enums.TipoUsuario;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 20, nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusUsuario status;

    @Column( nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipo;

    public Usuario () {};

    public Usuario(Integer id, String login, String senha, String email, StatusUsuario status, TipoUsuario tipo) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.status = status;
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;
        return id.equals(usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
