package br.com.fiap.teleorg.controller;


import br.com.fiap.teleorg.domain.Doador;
import br.com.fiap.teleorg.dto.DoadorDto;
import br.com.fiap.teleorg.service.DoadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping (value = "/api/doador")
public class DoadorController {

    @Autowired
    private DoadorService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Doador save(@RequestBody DoadorDto dto){
        Doador doador = service.insert(dto);
        return doador;
    }

}
