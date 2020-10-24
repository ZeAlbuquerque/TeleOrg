package br.com.fiap.teleorg.service;

import br.com.fiap.teleorg.domain.Doacao;
import br.com.fiap.teleorg.domain.Orgao;
import br.com.fiap.teleorg.domain.Paciente;
import br.com.fiap.teleorg.dto.DoacaoDto;
import br.com.fiap.teleorg.enums.StatusOrgao;
import br.com.fiap.teleorg.repository.DoacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

@Service
public class DoacaoService {

    private final DoacaoRepository repository;
    @Autowired
    private final PacienteService pacienteService;
    @Autowired
    private final OrgaoService orgaoService;

    public DoacaoService(DoacaoRepository repository, PacienteService pacienteService, OrgaoService orgaoService) {
        this.repository = repository;
        this.pacienteService = pacienteService;
        this.orgaoService = orgaoService;
    }

    @Transactional
    public Doacao insert(DoacaoDto dto) {
        String cpfReceptor = dto.getReceptor();
        Integer idOrgao = dto.getOrgao();

        Paciente receptor = pacienteService.findByCpf(cpfReceptor);
        Orgao orgao = orgaoService.getOrgaoById(idOrgao);

        if (orgao.getPaciente().getId() == receptor.getId()) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Doador deve ser diferente do Receptor");

        }

        if (!orgao.getStatusOrgao().equals(StatusOrgao.AGUARDANDO_RECEPTOR)) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Este orgão não pode ser doado");

        }


        if (orgao.getPaciente().getTipoSanguineo().equals(receptor.getTipoSanguineo())) {

            Doacao doacao = new Doacao();
            doacao.setOrgao(orgao);
            doacao.setReceptor(receptor);

            orgao.setStatusOrgao(StatusOrgao.AGUARDANDO_TRANSPLANTE);
            orgaoService.update(orgao.getId(), orgao);

            repository.save(doacao);

            return doacao;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"O orgão passado não é compativel com o receptor");
        }


    }

    public void cancelarDoacao(Integer id) {
        repository
                .findById(id)
                .map(doacao -> {
                    repository.delete(doacao);
                    return doacao;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Doacao não encontrado"));
    }

    public Doacao findById(Integer id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Doacao não encontrado"));
    }


}
