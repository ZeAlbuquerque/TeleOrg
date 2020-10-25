package br.com.fiap.teleorg.controller;

import br.com.fiap.teleorg.domain.Doacao;
import br.com.fiap.teleorg.dto.DoacaoDto;
import br.com.fiap.teleorg.repository.DoacaoRepository;
import br.com.fiap.teleorg.service.DoacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/doacao")
public class DoacaoController {

    @Autowired
    private DoacaoService service;

    @Autowired
    private DoacaoRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Doacao insert(@RequestBody @Valid DoacaoDto dto) {
        Doacao doacao = service.insert(dto);
        return doacao;
    }

    @GetMapping("{id}")
    public Doacao findById(@PathVariable Integer id) {
        Doacao doacao = service.findById(id);
        return doacao;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cancelarDoacao(@PathVariable Integer id) {
        service.cancelarDoacao(id);
    }

    @GetMapping("/findByReceptorCpf/{cpf}")
    public List<Doacao> findByReceptor(@PathVariable String cpf){
        return service.findByReceptorCpf(cpf);
    }

    @GetMapping("/findAll")
    public List<Doacao> findAll(){
        return service.findAll();
    }

    @GetMapping
    public List<Doacao> find(Doacao filtro) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filtro, matcher);
        return repository.findAll(example);
    }





}
