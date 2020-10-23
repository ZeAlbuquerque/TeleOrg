package br.com.fiap.teleorg.dto;


import javax.validation.constraints.NotNull;

public class PacienteDto {

    @NotNull(message = "{campo.nome.obrigatorio}")
    private String nome;

    @NotNull(message = "{campo.tipo-sanguineo.obrigatorio}")
    private String tipoSanguineo;

    @NotNull(message = "{campo.data-nascimento.obrigatorio}")
    private String dataNascimento;

    @NotNull(message = "{campo.cpf.obrigatorio}")
    private String cpf;

    @NotNull(message = "{campo.codigo-hospital.obrigatorio}")
    private Integer hospital;

    @NotNull(message = "{campo.is-doador.obrigatorio}")
    private Boolean doador;

    public PacienteDto() {
    }

    public PacienteDto(@NotNull(message = "{campo.nome.obrigatorio}") String nome, @NotNull(message = "{campo.tipo-sanguineo.obrigatorio}") String tipoSanguineo, @NotNull(message = "{campo.data-nascimento.obrigatorio}") String dataNascimento, @NotNull(message = "{campo.cpf.obrigatorio}") String cpf, @NotNull(message = "{campo.codigo-hospital.obrigatorio}") Integer hospital, @NotNull(message = "{campo.is-doador.obrigatorio}") Boolean doador) {
        this.nome = nome;
        this.tipoSanguineo = tipoSanguineo;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.hospital = hospital;
        this.doador = doador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getHospital() {
        return hospital;
    }

    public void setHospital(Integer hospital) {
        this.hospital = hospital;
    }

    public Boolean getDoador() {
        return doador;
    }

    public void setDoador(Boolean doador) {
        doador = doador;
    }
}
