package br.com.fiap.teleorg.controller;

import br.com.fiap.teleorg.domain.Orgao;
import br.com.fiap.teleorg.dto.OrgaoDto;
import br.com.fiap.teleorg.repository.OrgaoRepository;
import br.com.fiap.teleorg.service.OrgaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orgao")
public class OrgaoController {

    @Autowired
    private OrgaoService service;

    @Autowired
    private OrgaoRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Orgao insert(@RequestBody OrgaoDto dto) {
        return service.insert(dto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Orgao orgao) {
        service.update(id, orgao);
    }

    @GetMapping("/{id}")
    public Orgao get(@PathVariable Integer id) {
        return service.getOrgaoById(id);
    }

    @GetMapping
    public List<Orgao> find(Orgao filtro) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filtro, matcher);
        return repository.findAll(example);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void Delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @GetMapping(value = "/findByCpf/{cpf}")
    public List<Orgao> findByCpf(@PathVariable String cpf) {
        return service.findByCpfDoador(cpf);
    }


}
