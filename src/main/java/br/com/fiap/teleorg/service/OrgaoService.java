package br.com.fiap.teleorg.service;

import br.com.fiap.teleorg.domain.Doador;
import br.com.fiap.teleorg.domain.Orgao;
import br.com.fiap.teleorg.dto.OrgaoDto;
import br.com.fiap.teleorg.enums.StatusOrgao;
import br.com.fiap.teleorg.enums.TipoOrgao;
import br.com.fiap.teleorg.repository.DoadorRepository;
import br.com.fiap.teleorg.repository.OrgaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class OrgaoService {


    private final OrgaoRepository orgaoRepository;
    private final DoadorService doadorService;

    public OrgaoService(OrgaoRepository orgaoRepository, DoadorRepository doadorRepository, DoadorService doadorService) {
        this.orgaoRepository = orgaoRepository;
        this.doadorService = doadorService;
    }

    @Transactional
    public Orgao insert(OrgaoDto dto) {
        String doadorCpf = dto.getCpfDoador();
        Doador doador = doadorService.findByCpf(doadorCpf);

        Orgao orgao = new Orgao();
        orgao.setDoador(doador);
        TipoOrgao tipoOrgao = TipoOrgao.valueOf(dto.getTipoOrgao());
        orgao.setTipoOrgao(tipoOrgao);
        orgao.setStatusOrgao(StatusOrgao.AGUARDANDO_RECEPTOR);

        orgaoRepository.save(orgao);
        return orgao;
    }

    public List<Orgao> findByDoador(String cpfDoador){
        Doador doador = doadorService.findByCpf(cpfDoador);

        List<Orgao> listaDeOrgaos = new ArrayList<Orgao>();
        

    }


}
