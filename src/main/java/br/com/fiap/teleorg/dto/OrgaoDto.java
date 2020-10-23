package br.com.fiap.teleorg.dto;

import javax.validation.constraints.NotNull;

public class OrgaoDto {

    @NotNull(message = "{campo.tipo-orgao.obrigatorio}")
    private String TipoOrgao;

    @NotNull(message = "{campo.cpf-paciente.obrigatorio}")
    private String cpfPaciente;

    public OrgaoDto(@NotNull(message = "{campo.tipo-orgao.obrigatorio}") String tipoOrgao, @NotNull(message = "{campo.cpf-doador.obrigatorio}") String cpfDoador) {
        TipoOrgao = tipoOrgao;
        this.cpfPaciente = cpfDoador;
    }

    public String getTipoOrgao() {
        return TipoOrgao;
    }

    public void setTipoOrgao(String tipoOrgao) {
        TipoOrgao = tipoOrgao;
    }

    public String getCpfPaciente() {
        return cpfPaciente;
    }

    public void setCpfPaciente(String cpfDoador) {
        this.cpfPaciente = cpfDoador;
    }
}
