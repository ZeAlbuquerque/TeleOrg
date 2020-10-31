package br.com.fiap.teleorg.controller;

import br.com.fiap.teleorg.domain.Entrega;
import br.com.fiap.teleorg.dto.AtualizarDataHoraEntregaDto;
import br.com.fiap.teleorg.dto.AtualizarStatusEntregaDto;
import br.com.fiap.teleorg.dto.EntregaDto;
import br.com.fiap.teleorg.repository.EntregaRepository;
import br.com.fiap.teleorg.service.EntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/entrega")
public class EntregaController {

    @Autowired
    private EntregaService service;

    @Autowired
    private EntregaRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entrega insert(@RequestBody EntregaDto dto) throws ParseException {
        return service.insert(dto);
    }

    @GetMapping("/findById/{id}")
    public Entrega findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PutMapping("/alterarDataHorarioEntrega")
    @ResponseStatus(HttpStatus.CREATED)
    public void alterarDataHorarioEntrega(@RequestBody AtualizarDataHoraEntregaDto dto) {
        service.alterarDataHorarioEntrega(dto);
    }

    @GetMapping("/findByDoacao/{id}")
    public Entrega findByDoacao(@PathVariable Integer idDoacao) {
        return service.findByDoacao(idDoacao);
    }


    @PutMapping("/atualizarStatus")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarStatus(@RequestBody AtualizarStatusEntregaDto dto) {
        service.atualizarStatus(dto);
    }

    @GetMapping("/findAll")
    public List<Entrega> findAll() {
        return service.findAll();
    }

    @GetMapping("/filtro")
    public List<Entrega> find(Entrega filtro) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filtro, matcher);
        return repository.findAll(example);
    }

    @GetMapping("/{page}")
    public Page<Entrega> search(@PathVariable Integer page){
        return service.search(page);
    }


}
