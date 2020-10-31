package br.com.fiap.teleorg.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtualizarDataHoraPrevisaoEntregaDto {

    private Integer idEntrega;

    private String novaDataHoraPrevisao;


}
