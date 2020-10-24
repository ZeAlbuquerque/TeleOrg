package br.com.fiap.teleorg;

import br.com.fiap.teleorg.domain.Hospital;
import br.com.fiap.teleorg.domain.Paciente;
import br.com.fiap.teleorg.enums.TipoSanguineo;
import br.com.fiap.teleorg.repository.HospitalRepository;
import br.com.fiap.teleorg.repository.PacienteRepository;
import br.com.fiap.teleorg.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@SpringBootApplication
@RestController
public class TeleorgApplication {

	@Bean
	public CommandLineRunner init (@Autowired HospitalRepository hospitalRepository,
								   @Autowired PacienteRepository pacienteRepository,
								   @Autowired HospitalService hospitalService){
		return args -> {
			hospitalRepository.save(new Hospital("Sirio Libanes", "28.510.268/0001-92", "São Paulo", "Rua Dona Adma Jafet, 91", "Bela Vista", 1133940200));
			hospitalRepository.save(new Hospital("Albert Einstein", "10.585.152/0001-57", "São Paulo", "Av. Albert Einstein, 627", "Jardim Leonor", 1121511233 ));

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Calendar cal = Calendar.getInstance();

			//Inserindo Doadores

			cal.setTime(sdf.parse("12/09/1994"));

		    pacienteRepository.save(new Paciente("Aleixo Meirelles", TipoSanguineo.ABNegativo,cal,"351.124.100-60",true,hospitalService.findById(1)));

			cal.setTime(sdf.parse("25/12/1988"));

			pacienteRepository.save(new Paciente("Diodete Lage", TipoSanguineo.ABPositivo,cal,"003.172.720-47",true,hospitalService.findById(1)));

			cal.setTime(sdf.parse("30/04/1973"));

			pacienteRepository.save(new Paciente("Evaristo Bensaúde", TipoSanguineo.ANegativo,cal,"947.654.310-88",true,hospitalService.findById(2)));

			cal.setTime(sdf.parse("05/10/1978"));

			pacienteRepository.save(new Paciente("Patrícia Castanho", TipoSanguineo.APositivo,cal,"480.735.680-12",true,hospitalService.findById(2)));

			cal.setTime(sdf.parse("22/03/1969"));

			pacienteRepository.save(new Paciente("Arnaldo Bessa", TipoSanguineo.BNegativo,cal,"684.654.840-82",true,hospitalService.findById(1)));

			cal.setTime(sdf.parse("12/09/1994"));

			pacienteRepository.save(new Paciente("Telo Lóio", TipoSanguineo.BPositivo,cal,"151.857.490-40",true,hospitalService.findById(1)));

			cal.setTime(sdf.parse("25/12/1988"));

			pacienteRepository.save(new Paciente("Viridiano Rocha", TipoSanguineo.ONegativo,cal,"593.761.470-49",true,hospitalService.findById(2)));

			cal.setTime(sdf.parse("30/04/1973"));

			pacienteRepository.save(new Paciente("Cássio Lameira", TipoSanguineo.OPositivo,cal,"848.344.590-55",true,hospitalService.findById(2)));


			//Inserindo Receptores


			cal.setTime(sdf.parse("12/09/1994"));

			pacienteRepository.save(new Paciente("Boaventura Rebelo", TipoSanguineo.ABNegativo,cal,"596.627.710-93",false,hospitalService.findById(1)));

			cal.setTime(sdf.parse("25/12/1988"));

			pacienteRepository.save(new Paciente("Ferdinando Moreira", TipoSanguineo.ABPositivo,cal,"165.879.570-99",false,hospitalService.findById(1)));

			cal.setTime(sdf.parse("30/04/1973"));

			pacienteRepository.save(new Paciente("Levi Fontoura", TipoSanguineo.ANegativo,cal,"127.310.850-70",false,hospitalService.findById(2)));

			cal.setTime(sdf.parse("05/10/1978"));

			pacienteRepository.save(new Paciente("Mariano França", TipoSanguineo.APositivo,cal,"163.150.910-16",false,hospitalService.findById(2)));

			cal.setTime(sdf.parse("22/03/1969"));

			pacienteRepository.save(new Paciente("Nazaré Damasceno", TipoSanguineo.BNegativo,cal,"614.731.780-61",false,hospitalService.findById(1)));

			cal.setTime(sdf.parse("12/09/1994"));

			pacienteRepository.save(new Paciente("Sebastião Ferreyra", TipoSanguineo.BPositivo,cal,"661.702.460-57",false,hospitalService.findById(1)));

			cal.setTime(sdf.parse("25/12/1988"));

			pacienteRepository.save(new Paciente("Ubajara Caeira", TipoSanguineo.ONegativo,cal,"009.412.210-59",false,hospitalService.findById(2)));

			cal.setTime(sdf.parse("30/04/1973"));

			pacienteRepository.save(new Paciente("Úrsula Valente", TipoSanguineo.OPositivo,cal,"115.586.850-14",false,hospitalService.findById(2)));


		};
	}

	public static void main(String[] args) {
		SpringApplication.run(TeleorgApplication.class, args);
	}

}
