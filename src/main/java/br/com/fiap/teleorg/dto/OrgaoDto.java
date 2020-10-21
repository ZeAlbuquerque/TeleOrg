package br.com.fiap.teleorg.dto;

import javax.validation.constraints.NotNull;

public class OrgaoDto {

    @NotNull(message = "{campo.tipo-orgao.obrigatorio}")
    private String TipoOrgao;

    @NotNull(message = "{campo.cpf-doador.obrigatorio}")
    private String cpfDoador;

    public OrgaoDto(@NotNull(message = "{campo.tipo-orgao.obrigatorio}") String tipoOrgao, @NotNull(message = "{campo.cpf-doador.obrigatorio}") String cpfDoador) {
        TipoOrgao = tipoOrgao;
        this.cpfDoador = cpfDoador;
    }

    public String getTipoOrgao() {
        return TipoOrgao;
    }

    public void setTipoOrgao(String tipoOrgao) {
        TipoOrgao = tipoOrgao;
    }

    public String getCpfDoador() {
        return cpfDoador;
    }

    public void setCpfDoador(String cpfDoador) {
        this.cpfDoador = cpfDoador;
    }
}
