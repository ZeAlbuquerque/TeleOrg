package br.com.fiap.teleorg.service;

import br.com.fiap.teleorg.domain.Orgao;
import br.com.fiap.teleorg.domain.Paciente;
import br.com.fiap.teleorg.dto.OrgaoDto;
import br.com.fiap.teleorg.enums.StatusOrgao;
import br.com.fiap.teleorg.enums.TipoOrgao;
import br.com.fiap.teleorg.repository.OrgaoRepository;
import br.com.fiap.teleorg.service.exeption.RegraNegocioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrgaoService {

    @Autowired
    private OrgaoRepository orgaoRepository;

    @Autowired
    private PacienteService pacienteService;


    public OrgaoService(OrgaoRepository orgaoRepository, PacienteService pacienteService, PacienteService PacienteService) {
        this.orgaoRepository = orgaoRepository;
        this.pacienteService = pacienteService;
    }

    @Transactional
    public Orgao insert(OrgaoDto dto) {
        String doadorCpf = dto.getCpfPaciente();
        Paciente doador = pacienteService.findByCpf(doadorCpf);

        if(doador != null) {
            if(doador.getDoador()) {
                Orgao orgao = new Orgao();
                orgao.setPaciente(doador);
                TipoOrgao tipoOrgao = TipoOrgao.valueOf(dto.getTipoOrgao());
                orgao.setTipoOrgao(tipoOrgao);
                orgao.setStatusOrgao(StatusOrgao.AGUARDANDO_RECEPTOR);

                orgaoRepository.save(orgao);
                return orgao;
            }else{
                throw  new RegraNegocioException("Paciente não é um doador");
            }
        }
        else{
            throw new RegraNegocioException("Doador não encontrado");
        }
    }

    public void update(Integer id, Orgao orgao) {
        orgaoRepository
                .findById(id)
                .map(orgaoExistente -> {
                    orgao.setId(orgaoExistente.getId());
                    orgaoRepository.save(orgao);
                    return orgaoExistente;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Orgao não encontrado"));
    }

    public void delete(Integer id){
        orgaoRepository
                .findById(id)
                .map(orgao -> {
                    orgaoRepository.delete(orgao);
                    return orgao;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Orgao não encontrado"));
    }

    public Orgao getOrgaoById (Integer id) {
        return orgaoRepository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Orgao não encontrado"));
    }


    public List<Orgao> findByCpfDoador(String cpf){
        Paciente doador = pacienteService.findByCpf(cpf);

        List<Orgao> orgaos = new ArrayList<Orgao>();
        orgaos.addAll(orgaoRepository.findByPaciente(doador.getId()));

        return orgaos;
    }




}