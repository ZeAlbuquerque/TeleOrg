package br.com.fiap.teleorg.dto;

import javax.validation.constraints.NotNull;

public class OrgaoDto {

    @NotNull(message = "{campo.tipo-orgao.obrigatorio}")
    private String tipoOrgao;

    @NotNull(message = "{campo.cpf-paciente.obrigatorio}")
    private String cpfPaciente;

    public OrgaoDto(@NotNull(message = "{campo.tipo-orgao.obrigatorio}") String tipoOrgao, @NotNull(message = "{campo.cpf-doador.obrigatorio}") String cpfDoador) {
        this.tipoOrgao = tipoOrgao;
        this.cpfPaciente = cpfDoador;
    }

    public String getTipoOrgao() {
        return tipoOrgao;
    }

    public void setTipoOrgao(String tipoOrgao) {
        this.tipoOrgao = tipoOrgao;
    }

    public String getCpfPaciente() {
        return cpfPaciente;
    }

    public void setCpfPaciente(String cpfDoador) {
        this.cpfPaciente = cpfDoador;
    }
}
