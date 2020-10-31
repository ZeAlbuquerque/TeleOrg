package br.com.fiap.teleorg.service;

import br.com.fiap.teleorg.domain.Doacao;
import br.com.fiap.teleorg.domain.Entrega;
import br.com.fiap.teleorg.dto.AtualizarDataHoraPrevisaoEntregaDto;
import br.com.fiap.teleorg.dto.AtualizarStatusEntregaDto;
import br.com.fiap.teleorg.dto.EntregaDto;
import br.com.fiap.teleorg.enums.StatusEntrega;
import br.com.fiap.teleorg.repository.EntregaRepository;
import br.com.fiap.teleorg.service.exeption.RegraNegocioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

@Service
public class EntregaService {

    @Autowired
    private EntregaRepository entregaRepository;
    @Autowired
    private DoacaoService doacaoService;


    public Entrega findById(Integer id) {
        return entregaRepository
                .findById(id)
                .orElseThrow(() -> new RegraNegocioException("Entrega não encontrada"));
    }

    public Entrega insert(EntregaDto dto) throws ParseException {
        Entrega entrega = new Entrega();

        entrega.setStatusEntrega(StatusEntrega.EM_PREPARACAO);
        entrega.setDataHoraEntrega(null);

        Doacao doacao = doacaoService.findById(dto.getDoacao());
        entrega.setDoacao(doacao);
        entrega.setHospitalEntrega(doacao.getReceptor().getHospital());

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy H:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(dto.getPrevisaoDeEntrega()));
        entrega.setPrevisaoEntrega(cal);

        entregaRepository.save(entrega);
        return entrega;
    }

    public void alterarDataHorarioPrevisaoEntrega(AtualizarDataHoraPrevisaoEntregaDto dto) {
        Entrega novaEntrega = findById(dto.getIdEntrega());

        String strPrevisao = dto.getNovaDataHoraPrevisao();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(strPrevisao));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        novaEntrega.setPrevisaoEntrega(cal);


        entregaRepository.save(novaEntrega);
    }

    public Entrega findByDoacao(Integer idDoacao) {
        return entregaRepository.findEntregaByDoacaoId(idDoacao);
    }

    public void atualizarStatus(AtualizarStatusEntregaDto dto) {
        Entrega entregaAtualizada = findById(dto.getIdEntrega());

        if (entregaAtualizada.getStatusEntrega().equals(StatusEntrega.CANCELADO)) {
            throw new RegraNegocioException("Entrega está cancelada!!!");
        } else if (entregaAtualizada.getStatusEntrega().equals(StatusEntrega.ENTREGUE)) {
            throw new RegraNegocioException("Entrega já efetivada");
        } else {
            try {
                entregaAtualizada.setStatusEntrega(StatusEntrega.valueOf(dto.getNovoStatus()));

                if(entregaAtualizada.getStatusEntrega().equals(StatusEntrega.ENTREGUE)){
                    entregaAtualizada.setDataHoraEntrega(LocalDate.now());
                }

                entregaRepository.save(entregaAtualizada);
            } catch (DataIntegrityViolationException e) {
                throw new DataIntegrityViolationException("Não é possível modificar a entrega: " + entregaAtualizada.getId());
            }
        }
    }

    public List<Entrega> findAll() {
        return entregaRepository.findAll();
    }

    public Page<Entrega> search(Integer page){
        page--;
        PageRequest pageRequest = PageRequest.of(page,5, Sort.Direction.ASC,"id");

        return entregaRepository.search(pageRequest);
    }
}
