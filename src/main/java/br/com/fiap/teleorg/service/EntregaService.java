package br.com.fiap.teleorg.service;

import br.com.fiap.teleorg.domain.Entrega;
import br.com.fiap.teleorg.dto.AtualizarDataHoraEntregaDto;
import br.com.fiap.teleorg.dto.AtualizarStatusEntregaDto;
import br.com.fiap.teleorg.enums.StatusEntrega;
import br.com.fiap.teleorg.repository.EntregaRepository;
import br.com.fiap.teleorg.service.exeption.RegraNegocioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class EntregaService {

    @Autowired
    private EntregaRepository entregaRepository;
    @Autowired
    private DoacaoService doacaoService;

    public EntregaService(EntregaRepository entregaRepository, DoacaoService doacaoService) {
        this.entregaRepository = entregaRepository;
        this.doacaoService = doacaoService;
    }

    public Entrega findById(Integer id) {
        return entregaRepository
                .findById(id)
                .orElseThrow(() -> new RegraNegocioException("Entrega não encontrada"));
    }

    public void alterarDataHorarioEntrega(AtualizarDataHoraEntregaDto dto) {
        Entrega novaEntrega = findById(dto.getIdEntrega());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy H:mm:ss");
        LocalDate novaDataHora = LocalDate.parse(dto.getNovaDataHoraEntrega(), formatter);

        novaEntrega.setDataHoraEntrega(novaDataHora);

        entregaRepository.save(novaEntrega);
    }

    public Entrega findByDoacao(Integer idDoacao) {
        return entregaRepository.findEntregaByDoacaoId(idDoacao);
    }

    public void cancelarEntregaPelaDoacao(Integer idDoacao) {
        Entrega entregaAtualizada = findByDoacao(idDoacao);

        if (entregaAtualizada.getStatusEntrega().equals(StatusEntrega.CANCELADO)) {
            throw new RegraNegocioException("Entrega já está cancelada");
        } else if (entregaAtualizada.getStatusEntrega().equals(StatusEntrega.ENTREGUE)) {
            throw new RegraNegocioException("Entrega já efetivada");
        } else {
            entregaAtualizada.setStatusEntrega(StatusEntrega.CANCELADO);

            try {
                entregaRepository.save(entregaAtualizada);
            } catch (DataIntegrityViolationException e) {
                new DataIntegrityViolationException("Não é possivel cancelar a entrega: " + entregaAtualizada.getId());
            }
        }
    }

    public void cancelarEntregaPeloId(Integer id) {
        Entrega entregaAtualizada = findById(id);

        if (entregaAtualizada.getStatusEntrega().equals(StatusEntrega.CANCELADO)) {
            throw new RegraNegocioException("Entrega já está cancelada");
        } else if (entregaAtualizada.getStatusEntrega().equals(StatusEntrega.ENTREGUE)) {
            throw new RegraNegocioException("Entrega já efetivada");
        } else {
            entregaAtualizada.setStatusEntrega(StatusEntrega.CANCELADO);

            try {
                entregaRepository.save(entregaAtualizada);
            } catch (DataIntegrityViolationException e) {
                new DataIntegrityViolationException("Não é possivel cancelar a entrega: " + entregaAtualizada.getId());
            }
        }
    }

    public void atualizarStatus(AtualizarStatusEntregaDto dto) {
        Entrega entregaAtualizada = findById(dto.getIdEntrega());

        if (entregaAtualizada.getStatusEntrega().equals(StatusEntrega.CANCELADO)) {
            throw new RegraNegocioException("Entrega cancelada!!!");
        } else if (entregaAtualizada.getStatusEntrega().equals(StatusEntrega.ENTREGUE)) {
            throw new RegraNegocioException("Entrega já efetivada");
        } else {
            try {
                entregaAtualizada.setStatusEntrega(StatusEntrega.valueOf(dto.getNovoStatus()));
                entregaRepository.save(entregaAtualizada);
            } catch (DataIntegrityViolationException e) {
                new DataIntegrityViolationException("Não é possivel cancelar a entrega: " + entregaAtualizada.getId());
            }
        }
    }

    public List<Entrega> findAll() {
        return entregaRepository.findAll();
    }
}
