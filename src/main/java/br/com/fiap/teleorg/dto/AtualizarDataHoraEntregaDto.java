package br.com.fiap.teleorg.dto;

public class AtualizarDataHoraEntregaDto {

    private Integer idEntrega;

    private String novaDataHoraEntrega;

    public AtualizarDataHoraEntregaDto(Integer idEntrega, String novaDataHoraEntrega) {
        this.idEntrega = idEntrega;
        this.novaDataHoraEntrega = novaDataHoraEntrega;
    }

    public Integer getIdEntrega() {
        return idEntrega;
    }

    public void setIdEntrega(Integer idEntrega) {
        this.idEntrega = idEntrega;
    }

    public String getNovaDataHoraEntrega() {
        return novaDataHoraEntrega;
    }

    public void setNovaDataHoraEntrega(String novaDataHoraEntrega) {
        this.novaDataHoraEntrega = novaDataHoraEntrega;
    }
}
