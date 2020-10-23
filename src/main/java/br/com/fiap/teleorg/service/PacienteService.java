package br.com.fiap.teleorg.service;

import br.com.fiap.teleorg.domain.Hospital;
import br.com.fiap.teleorg.domain.Paciente;
import br.com.fiap.teleorg.dto.PacienteDto;
import br.com.fiap.teleorg.enums.TipoSanguineo;
import br.com.fiap.teleorg.repository.HospitalRepository;
import br.com.fiap.teleorg.repository.PacienteRepository;
import br.com.fiap.teleorg.service.exeption.DataIntegretyException;
import br.com.fiap.teleorg.service.exeption.RegraNegocioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private  HospitalRepository hospitalRepository;

    public PacienteService(PacienteRepository pacienteRepository, HospitalRepository hospitalRepository) {
        this.pacienteRepository = pacienteRepository;
        this.hospitalRepository = hospitalRepository;
    }


    @Transactional
    public Paciente insert(PacienteDto dto){
        Integer idHospital = dto.getHospital();
        Hospital hospital = hospitalRepository
                .findById(idHospital)
                .orElseThrow(() -> new RegraNegocioException("Código do hospital invalido"));

        Paciente paciente = new Paciente();
        paciente.setNome(dto.getNome());
        paciente.setDoador(dto.getDoador());
        TipoSanguineo tipoSanguineo = TipoSanguineo.valueOf(dto.getTipoSanguineo());
        paciente.setTipoSanguineo(tipoSanguineo);
        String strDataNascimento = dto.getDataNascimento();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(strDataNascimento));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        paciente.setDataNascimento(cal);
        paciente.setCpf(dto.getCpf());
        paciente.setHospital(hospital);

        pacienteRepository.save(paciente);
        return paciente;
    }

    public Paciente findByCpf(String cpf){
        Optional<Paciente> paciente = Optional.ofNullable(pacienteRepository.findByCpf(cpf));
        return paciente.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Paciente não encontrado! ID: " + cpf ));
    }


    public void updateHospital(Paciente Paciente, Paciente newPaciente){
        newPaciente.setHospital(Paciente.getHospital());
    }

    public Paciente update (Paciente Paciente){
        Paciente newPaciente = findByCpf(Paciente.getCpf());
        updateHospital(Paciente, newPaciente);
        return pacienteRepository.save(newPaciente);
    }

    public void delete(String cpf) {
        Paciente Paciente = findByCpf(cpf);
        try {
            pacienteRepository.deleteByCpf(cpf);
        } catch (DataIntegretyException e){
            throw new DataIntegretyException("Não é possível deletar o Paciente " + Paciente.getNome());
        }
    }




}
