package br.com.fiap.teleorg.service;

import br.com.fiap.teleorg.domain.Doador;
import br.com.fiap.teleorg.domain.Hospital;
import br.com.fiap.teleorg.dto.DoadorDto;
import br.com.fiap.teleorg.enums.TipoSanguineo;
import br.com.fiap.teleorg.repository.DoadorRepository;
import br.com.fiap.teleorg.repository.HospitalRepository;
import br.com.fiap.teleorg.service.exeption.DataIntegretyException;
import br.com.fiap.teleorg.service.exeption.ObjectNotFoundException;
import br.com.fiap.teleorg.service.exeption.RegraNegocioException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class DoadorService {

    private final DoadorRepository doadorRepository;
    private final HospitalRepository hospitalRepository;

    public DoadorService(DoadorRepository doadorRepositoryrepository, HospitalRepository hospitalRepository) {
        this.doadorRepository = doadorRepositoryrepository;
        this.hospitalRepository = hospitalRepository;
    }


    @Transactional
    public Doador insert(DoadorDto dto){
        Integer idHospital = dto.getHospital();
        Hospital hospital = hospitalRepository
                .findById(idHospital)
                .orElseThrow(() -> new RegraNegocioException("Código do hospital invalido"));

        Doador doador = new Doador();
        doador.setNome(dto.getNome());
        TipoSanguineo tipoSanguineo = TipoSanguineo.valueOf(dto.getTipoSanguineo());
        doador.setTipoSanguineo(tipoSanguineo);
        String strDataNascimento = dto.getDataNascimento();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(strDataNascimento));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        doador.setDataNascimento(cal);
        doador.setCpf(dto.getCpf());
        doador.setHospital(hospital);

        doadorRepository.save(doador);
        return doador;
    }

    public Doador findByCpf(String cpf){
        Optional<Doador> doador = Optional.ofNullable(doadorRepository.findByCpf(cpf));
        return doador.orElseThrow(() -> new ObjectNotFoundException("Doador não encontrado! ID: " + cpf ));
    }

    public List<Doador> findAll(){
        return doadorRepository.findAll();
    }


    public void updateHospital(Doador doador, Doador newDoador){
        newDoador.setHospital(doador.getHospital());
    }

    public Doador update (Doador doador){
        Doador newDoador = findByCpf(doador.getCpf());
        updateHospital(doador, newDoador);
        return doadorRepository.save(newDoador);
    }

    public void delete(String cpf) {
        Doador doador = findByCpf(cpf);
        try {
            doadorRepository.deleteByCpf(cpf);
        } catch (DataIntegretyException e){
            throw new DataIntegretyException("Não é possível deletar o doador " + doador.getNome());
        }
    }




}
