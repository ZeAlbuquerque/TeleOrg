package br.com.fiap.teleorg.controller;

import br.com.fiap.teleorg.domain.Orgao;
import br.com.fiap.teleorg.dto.OrgaoDto;
import br.com.fiap.teleorg.service.OrgaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orgao")
public class OrgaoController {

    @Autowired
    private OrgaoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Orgao insert(@RequestBody OrgaoDto dto){
        return service.insert(dto);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Orgao orgao){
        service.update(id,orgao);
    }

    @GetMapping("{id}")
    public Orgao get(@PathVariable Integer id){
        return service.getOrgaoById(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void Delete(@PathVariable Integer id){
        service.delete(id);
    }

    @GetMapping("{cpf}")
    @RequestMapping("/findByCpf")
    public List<Orgao> findByCpf(@PathVariable String cpf) {
        return service.findByCpf(cpf);
    }








}
