package br.com.fiap.teleorg.controller;

import br.com.fiap.teleorg.domain.Doacao;
import br.com.fiap.teleorg.dto.DoacaoDto;
import br.com.fiap.teleorg.service.DoacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doacao")
public class DoacaoController {

    @Autowired
    private DoacaoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Doacao insert(@RequestBody DoacaoDto dto) {
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




}
