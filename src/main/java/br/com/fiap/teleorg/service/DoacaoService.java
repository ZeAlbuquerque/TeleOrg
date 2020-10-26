package br.com.fiap.teleorg.service;

import br.com.fiap.teleorg.domain.Doacao;
import br.com.fiap.teleorg.domain.Entrega;
import br.com.fiap.teleorg.domain.Orgao;
import br.com.fiap.teleorg.domain.Paciente;
import br.com.fiap.teleorg.dto.DoacaoDto;
import br.com.fiap.teleorg.enums.StatusDoacao;
import br.com.fiap.teleorg.enums.StatusEntrega;
import br.com.fiap.teleorg.enums.StatusOrgao;
import br.com.fiap.teleorg.repository.DoacaoRepository;
import br.com.fiap.teleorg.repository.EntregaRepository;
import br.com.fiap.teleorg.service.exeption.RegraNegocioException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.List;

@Service
public class DoacaoService {

    private final DoacaoRepository repository;
    private final PacienteService pacienteService;
    private final OrgaoService orgaoService;
    private final EntregaRepository entregaRepository;

    public DoacaoService(DoacaoRepository repository, PacienteService pacienteService, OrgaoService orgaoService, EntregaRepository entregaRepository) {
        this.repository = repository;
        this.pacienteService = pacienteService;
        this.orgaoService = orgaoService;
        this.entregaRepository = entregaRepository;
    }

    @Transactional
    public Doacao insert(DoacaoDto dto) {
        String cpfReceptor = dto.getReceptor();
        Integer idOrgao = dto.getOrgao();

        Paciente receptor = pacienteService.findByCpf(cpfReceptor);
        Orgao orgao = orgaoService.getOrgaoById(idOrgao);

        if (orgao.getDoador().getId().equals(receptor.getId())) {
            throw new RegraNegocioException( "Doador deve ser diferente do Receptor");

        }

        if (!orgao.getStatusOrgao().equals(StatusOrgao.AGUARDANDO_RECEPTOR)) {
            throw new RegraNegocioException("Este orgão não pode ser doado");

        }


        if (orgao.getDoador().getTipoSanguineo().equals(receptor.getTipoSanguineo())) {

            if(orgao.getDoador().getHospital().getId() != receptor.getHospital().getId()) {
                Doacao doacao = new Doacao();
                doacao.setOrgao(orgao);
                doacao.setReceptor(receptor);
                doacao.setStatusDoacao(StatusDoacao.AGUARDANDO_TRANSPLANTE);

                orgao.setStatusOrgao(StatusOrgao.AGUARDANDO_ENTREGA);
                orgaoService.update(orgao.getId(), orgao);

                repository.save(doacao);

                Entrega entrega = new Entrega();
                entrega.setHospitalEntrega(receptor.getHospital());
                entrega.setDoacao(doacao);
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.HOUR, 2);
                entrega.setPrevisaoEntrega(cal);
                entrega.setStatusEntrega(StatusEntrega.EM_PREPARACAO);

                entregaRepository.save(entrega);

                return doacao;
            }else{
                Doacao doacao = new Doacao();
                doacao.setOrgao(orgao);
                doacao.setReceptor(receptor);
                doacao.setStatusDoacao(StatusDoacao.AGUARDANDO_TRANSPLANTE);

                orgao.setStatusOrgao(StatusOrgao.AGUARDANDO_TRANSPLANTE);
                orgaoService.update(orgao.getId(), orgao);

                repository.save(doacao);

                return doacao;
            }
        } else {
            throw new RegraNegocioException("O orgão passado não é compativel com o receptor");
        }


    }


    private void update(Doacao doacao){
        repository.findById(doacao.getId())
                .map( d -> {
                    doacao.setId(d.getId());
                    repository.save(doacao);
                    return doacao;
                }).orElseThrow( () ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Produto não encontrado."));
    }

    public void cancelarDoacao(Integer id) {
        repository
                .findById(id)
                .map(doacao -> {
                    Orgao orgao = orgaoService.getOrgaoById(doacao.getOrgao().getId());
                    orgaoService.update(doacao.getOrgao().getId(),orgao);
                    Doacao doacaoAtualizada = findById(doacao.getId());
                    doacaoAtualizada.setStatusDoacao(StatusDoacao.CANCELADA);
                    update(doacaoAtualizada);

                    return doacaoAtualizada;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Doacao não encontrada"));
    }

    public Doacao findById(Integer id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Doacao não encontrado"));
    }

    public List<Doacao> findByReceptorCpf(String cpf){
        Paciente receptor = pacienteService.findByCpf(cpf);

        return repository.findDoacaoByReceptorId(receptor.getId());
    }

    public List<Doacao> findAll(){
        return repository.findAll();
    }



}
