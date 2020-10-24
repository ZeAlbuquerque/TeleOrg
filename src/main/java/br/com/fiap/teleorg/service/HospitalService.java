package br.com.fiap.teleorg.service;

import br.com.fiap.teleorg.domain.Hospital;
import br.com.fiap.teleorg.repository.HospitalRepository;
import br.com.fiap.teleorg.service.exeption.DataIntegretyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

@Service
public class HospitalService {

    @Autowired
    private HospitalRepository repository;

    public Hospital findById (Integer id) {
        return repository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado"));
    }


    public Hospital findByNome (String nome){
        return repository.findByNome(nome);
    }

    @Transactional
    public Hospital insert(Hospital hospital){
        hospital.setId(null);
        hospital = repository.saveAndFlush(hospital);
        return hospital;
    }

    private void updateHospital(Hospital newHospital, Hospital hospital){
        newHospital.setNome(hospital.getNome());
        newHospital.setCnpj(hospital.getCnpj());
        newHospital.setBairro(hospital.getBairro());
        newHospital.setCidade(hospital.getCidade());
        newHospital.setLogradouro(hospital.getLogradouro());
        newHospital.setTelefone(hospital.getTelefone());
    }

    public Hospital update (Hospital hospital){
        Hospital newHospital = (Hospital) findById(hospital.getId());
        updateHospital(newHospital, hospital);
        return repository.save(newHospital);
    }

    public void delete(Integer id){
        findById(id);
        try{
            repository.deleteById(id);
        } catch (DataIntegretyException e){
            throw new DataIntegretyException("Não foi possível deletar o Hospital");
        }
    }
}
