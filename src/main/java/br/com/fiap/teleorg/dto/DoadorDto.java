package br.com.fiap.teleorg.dto;


import br.com.fiap.teleorg.enums.TipoSanguineo;

import javax.validation.constraints.NotNull;
import java.util.Calendar;

public class DoadorDto {

    @NotNull(message = "{campo.nome.obrigatorio}")
    private String nome;

    private TipoSanguineo tipoSanguineo;

    private Calendar dataNascimento;

    private String cpf;

    private Integer hospital;
}
