package br.com.fiap.teleorg.service;

import br.com.fiap.teleorg.domain.Doador;
import br.com.fiap.teleorg.repository.DoadorRepository;
import br.com.fiap.teleorg.service.exeption.DataIntegretyException;
import br.com.fiap.teleorg.service.exeption.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class DoadorService {

    @Autowired
    private DoadorRepository repository;

    public Doador findById(Integer id){
        Optional<Doador> doador = repository.findById(id);
        return doador.orElseThrow(() -> new ObjectNotFoundException("Doador não encontrado! ID: " + id ));
    }

    public Doador findByCpf(String cpf){
        Optional<Doador> doador = Optional.ofNullable(repository.findByCpf(cpf));
        return doador.orElseThrow(() -> new ObjectNotFoundException("Doador não encontrado! ID: " + cpf ));
    }

    public List<Doador> findAll(){
        return repository.findAll();
    }

    @Transactional
    public Doador insert(Doador doador){
        doador = repository.save(doador);
        return doador;
    }

    public void updateHospital(Doador doador, Doador newDoador){
        newDoador.setHospital(doador.getHospital());
    }

    public Doador update (Doador doador){
        Doador newDoador = findByCpf(doador.getCpf());
        updateHospital(doador, newDoador);
        return repository.save(newDoador);
    }

    public void delete(String cpf) {
        Doador doador = findByCpf(cpf);
        try {
            repository.deleteByCpf(cpf);
        } catch (DataIntegretyException e){
            throw new DataIntegretyException("Não é possível deletar o doador " + doador.getNome());
        }
    }




}
