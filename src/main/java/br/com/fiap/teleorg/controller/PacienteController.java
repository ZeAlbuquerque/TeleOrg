package br.com.fiap.teleorg.controller;


import br.com.fiap.teleorg.domain.Paciente;
import br.com.fiap.teleorg.dto.PacienteDto;
import br.com.fiap.teleorg.repository.PacienteRepository;
import br.com.fiap.teleorg.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value = "/api/paciente")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Paciente insert(@RequestBody PacienteDto dto){
        Paciente paciente = service.insert(dto);
        return paciente;
    }

    @GetMapping
    public List<Paciente> find(Paciente filtro) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filtro, matcher);
        return repository.findAll(example);
    }

    @GetMapping("/findByCpf/{cpf}")
    public Paciente findByCpf( @PathVariable String cpf){
        return service.findByCpf(cpf);
    }

    @GetMapping("{id}")
    public Paciente findById(@PathVariable Integer id){
        return service.findById(id);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update (@RequestBody Paciente paciente ){
        service.update(paciente);
    }

    @DeleteMapping("{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String cpf){
        service.delete(cpf);
    }

}
