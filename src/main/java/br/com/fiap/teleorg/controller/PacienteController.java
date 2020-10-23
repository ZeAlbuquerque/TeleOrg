package br.com.fiap.teleorg.controller;


import br.com.fiap.teleorg.domain.Paciente;
import br.com.fiap.teleorg.dto.PacienteDto;
import br.com.fiap.teleorg.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping (value = "/api/Paciente")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Paciente insert(@RequestBody PacienteDto dto){
        Paciente Paciente = service.insert(dto);
        return Paciente;
    }

}
