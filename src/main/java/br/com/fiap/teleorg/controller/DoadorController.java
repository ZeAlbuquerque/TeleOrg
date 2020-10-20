package br.com.fiap.teleorg.controller;


import br.com.fiap.teleorg.domain.Doador;
import br.com.fiap.teleorg.service.DoadorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping (value = "/doador")
public class DoadorController {

    private DoadorService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Doador save(@RequestBody Doador doador){
        return service.insert(doador);
    }

}
