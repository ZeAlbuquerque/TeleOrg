package br.com.fiap.teleorg.controller;

import br.com.fiap.teleorg.domain.Entrega;
import br.com.fiap.teleorg.dto.AtualizarDataHoraEntregaDto;
import br.com.fiap.teleorg.dto.AtualizarStatusEntregaDto;
import br.com.fiap.teleorg.repository.EntregaRepository;
import br.com.fiap.teleorg.service.EntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entrega")
public class EntregaController {

    @Autowired
    private EntregaService service;

    @Autowired
    private EntregaRepository repository;

    @GetMapping("{id}")
    public Entrega findById(@PathVariable Integer id){
        return service.findById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void alterarDataHorarioEntrega(@RequestBody AtualizarDataHoraEntregaDto dto){
        service.alterarDataHorarioEntrega(dto);
    }

    @GetMapping("/findByDoacao/{id}")
    public Entrega findByDoacao(@PathVariable Integer idDoacao){
        return service.findByDoacao(idDoacao);
    }

    @PutMapping("/cancelarEntregaPelaDoacao/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cancelarEntregaPelaDoacao(@PathVariable Integer idDoacao){
        service.cancelarEntregaPelaDoacao(idDoacao);
    }

    @PutMapping("/cancelarEntregaPeloId/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cancelarEntregaPeloId(@PathVariable Integer id){
        service.cancelarEntregaPeloId(id);
    }

    @PutMapping("/atualizarStatus")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarStatus(@RequestBody AtualizarStatusEntregaDto dto){
        service.atualizarStatus(dto);
    }

    @GetMapping("/findAll")
    public List<Entrega> findAll(){
        return service.findAll();
    }

    @GetMapping
    public List<Entrega> find(Entrega filtro) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filtro, matcher);
        return repository.findAll(example);
    }


}
