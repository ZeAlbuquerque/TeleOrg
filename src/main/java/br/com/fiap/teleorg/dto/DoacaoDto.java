package br.com.fiap.teleorg.dto;

import javax.validation.constraints.NotNull;

public class DoacaoDto {

    @NotNull(message = "{campo.id-receptor.obrigatorio}")
    private String receptor;

    @NotNull(message = "{campo.id-orgao.obrigatorio}")
    private Integer orgao;

    public DoacaoDto() {
    }

    public DoacaoDto(String receptor, Integer orgao) {
        this.receptor = receptor;
        this.orgao = orgao;
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    public Integer getOrgao() {
        return orgao;
    }

    public void setOrgao(Integer orgao) {
        this.orgao = orgao;
    }
}
