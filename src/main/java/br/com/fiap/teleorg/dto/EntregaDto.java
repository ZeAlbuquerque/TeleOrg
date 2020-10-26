package br.com.fiap.teleorg.dto;


public class EntregaDto {

    private String previsaoDeEntrega;

    private String dataHoraEntrega;

    private Integer doacao;


    public EntregaDto(String previsaoDeEntrega, String dataHoraEntrega, Integer doacao) {
        this.previsaoDeEntrega = previsaoDeEntrega;
        this.dataHoraEntrega = dataHoraEntrega;
        this.doacao = doacao;
    }

    public String getPrevisaoDeEntrega() {
        return previsaoDeEntrega;
    }

    public void setPrevisaoDeEntrega(String previsaoDeEntrega) {
        this.previsaoDeEntrega = previsaoDeEntrega;
    }

    public String getDataHoraEntrega() {
        return dataHoraEntrega;
    }

    public void setDataHoraEntrega(String dataHoraEntrega) {
        this.dataHoraEntrega = dataHoraEntrega;
    }

    public Integer getDoacao() {
        return doacao;
    }

    public void setDoacao(Integer doacao) {
        this.doacao = doacao;
    }

}
