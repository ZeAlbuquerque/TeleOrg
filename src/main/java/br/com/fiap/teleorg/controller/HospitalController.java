package br.com.fiap.teleorg.controller;

import br.com.fiap.teleorg.domain.Hospital;
import br.com.fiap.teleorg.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
public class HospitalController {

    @Autowired
    private HospitalService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Hospital insert(@RequestBody Hospital hospital){
        return service.insert(hospital);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody Hospital hospital){
        service.update(hospital);
    }

    @GetMapping("{id}")
    public Hospital findById(@PathVariable Integer id){
        return service.findById(id);
    }

    @GetMapping("/findByName/{id}")
    public Hospital findByNome(@PathVariable String nome){
        return service.findByNome(nome);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }
}
