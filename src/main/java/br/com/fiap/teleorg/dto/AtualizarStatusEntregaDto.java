package br.com.fiap.teleorg.dto;

public class AtualizarStatusEntregaDto {

    private Integer idEntrega;

    private String novoStatus;

    public AtualizarStatusEntregaDto(Integer idEntrega, String novaDataHoraEntrega) {
        this.idEntrega = idEntrega;
        this.novoStatus = novaDataHoraEntrega;
    }

    public Integer getIdEntrega() {
        return idEntrega;
    }

    public void setIdEntrega(Integer idEntrega) {
        this.idEntrega = idEntrega;
    }

    public String getNovoStatus() {
        return novoStatus;
    }

    public void setNovoStatus(String novoStatus) {
        this.novoStatus = novoStatus;
    }
}
