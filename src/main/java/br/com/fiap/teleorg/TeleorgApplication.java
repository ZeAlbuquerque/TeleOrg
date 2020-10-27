package br.com.fiap.teleorg;

import br.com.fiap.teleorg.domain.Hospital;
import br.com.fiap.teleorg.domain.Orgao;
import br.com.fiap.teleorg.domain.Paciente;
import br.com.fiap.teleorg.enums.StatusOrgao;
import br.com.fiap.teleorg.enums.TipoOrgao;
import br.com.fiap.teleorg.enums.TipoSanguineo;
import br.com.fiap.teleorg.repository.*;
import br.com.fiap.teleorg.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@SpringBootApplication
@RestController
public class TeleorgApplication {

    @Bean
    public CommandLineRunner init(@Autowired HospitalRepository hospitalRepository,
                                  @Autowired PacienteRepository pacienteRepository,
                                  @Autowired PacienteService pacienteService,
                                  @Autowired HospitalService hospitalService,
                                  @Autowired OrgaoRepository orgaoRepository,
                                  @Autowired OrgaoService orgaoService,
                                  @Autowired DoacaoRepository doacaoRepository,
                                  @Autowired DoacaoService doacaoService,
                                  @Autowired EntregaRepository entregaRepository,
                                  @Autowired EntregaService entregaService) {
        return args -> {

            //Inserindo hospitais
            hospitalRepository.save(new Hospital("Sirio Libanes", "28.510.268/0001-92", "São Paulo", "Rua Dona Adma Jafet, 91", "Bela Vista", 1133940200));
            hospitalRepository.save(new Hospital("Albert Einstein", "10.585.152/0001-57", "São Paulo", "Av. Albert Einstein, 627", "Jardim Leonor", 1121511233));

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Calendar cal = Calendar.getInstance();

            //Inserindo Doadores

            cal.setTime(sdf.parse("12/09/1994"));

            pacienteRepository.save(new Paciente("Aleixo Meirelles", TipoSanguineo.ABNegativo, cal, "35112410060", true, hospitalService.findById(1)));

            cal.setTime(sdf.parse("25/12/1988"));

            pacienteRepository.save(new Paciente("Diodete Lage", TipoSanguineo.ABPositivo, cal, "00317272047", true, hospitalService.findById(1)));

            cal.setTime(sdf.parse("30/04/1973"));

            pacienteRepository.save(new Paciente("Evaristo Bensaúde", TipoSanguineo.ANegativo, cal, "94765431088", true, hospitalService.findById(2)));

            cal.setTime(sdf.parse("05/10/1978"));

            pacienteRepository.save(new Paciente("Patrícia Castanho", TipoSanguineo.APositivo, cal, "48073568012", true, hospitalService.findById(2)));

            cal.setTime(sdf.parse("22/03/1969"));

            pacienteRepository.save(new Paciente("Arnaldo Bessa", TipoSanguineo.BNegativo, cal, "68465484082", true, hospitalService.findById(1)));

            cal.setTime(sdf.parse("12/09/1994"));

            pacienteRepository.save(new Paciente("Telo Lóio", TipoSanguineo.BPositivo, cal, "15185749040", true, hospitalService.findById(1)));

            cal.setTime(sdf.parse("25/12/1988"));

            pacienteRepository.save(new Paciente("Viridiano Rocha", TipoSanguineo.ONegativo, cal, "59376147049", true, hospitalService.findById(2)));

            cal.setTime(sdf.parse("30/04/1973"));

            pacienteRepository.save(new Paciente("Cássio Lameira", TipoSanguineo.OPositivo, cal, "84834459055", true, hospitalService.findById(2)));


            //Inserindo Receptores


            cal.setTime(sdf.parse("12/09/1994"));

            pacienteRepository.save(new Paciente("Boaventura Rebelo", TipoSanguineo.ABNegativo, cal, "59662771093", false, hospitalService.findById(2)));

            cal.setTime(sdf.parse("25/12/1988"));

            pacienteRepository.save(new Paciente("Ferdinando Moreira", TipoSanguineo.ABPositivo, cal, "16587957099", false, hospitalService.findById(2)));

            cal.setTime(sdf.parse("30/04/1973"));

            pacienteRepository.save(new Paciente("Levi Fontoura", TipoSanguineo.ANegativo, cal, "12731085070", false, hospitalService.findById(1)));

            cal.setTime(sdf.parse("05/10/1978"));

            pacienteRepository.save(new Paciente("Mariano França", TipoSanguineo.APositivo, cal, "16315091016", false, hospitalService.findById(1)));

            cal.setTime(sdf.parse("22/03/1969"));

            pacienteRepository.save(new Paciente("Nazaré Damasceno", TipoSanguineo.BNegativo, cal, "61473178061", false, hospitalService.findById(2)));

            cal.setTime(sdf.parse("12/09/1994"));

            pacienteRepository.save(new Paciente("Sebastião Ferreyra", TipoSanguineo.BPositivo, cal, "66170246057", false, hospitalService.findById(2)));

            cal.setTime(sdf.parse("25/12/1988"));

            pacienteRepository.save(new Paciente("Ubajara Caeira", TipoSanguineo.ONegativo, cal, "00941221059", false, hospitalService.findById(1)));

            cal.setTime(sdf.parse("30/04/1973"));

            pacienteRepository.save(new Paciente("Úrsula Valente", TipoSanguineo.OPositivo, cal, "11558685014", false, hospitalService.findById(1)));


            //Inserindo orgãos
            orgaoRepository.save(new Orgao(TipoOrgao.CORACAO, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(1)));
            orgaoRepository.save(new Orgao(TipoOrgao.CORNEA, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(1)));
            orgaoRepository.save(new Orgao(TipoOrgao.FIGADO, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(1)));
            orgaoRepository.save(new Orgao(TipoOrgao.PULMAO, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(1)));
            orgaoRepository.save(new Orgao(TipoOrgao.RIM, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(1)));
            orgaoRepository.save(new Orgao(TipoOrgao.INTESTINO, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(1)));
            orgaoRepository.save(new Orgao(TipoOrgao.MEDULA, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(1)));
            orgaoRepository.save(new Orgao(TipoOrgao.OSSOS, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(1)));
            orgaoRepository.save(new Orgao(TipoOrgao.PANCREAS, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(1)));
            orgaoRepository.save(new Orgao(TipoOrgao.PELE, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(1)));

            orgaoRepository.save(new Orgao(TipoOrgao.CORACAO, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(2)));
            orgaoRepository.save(new Orgao(TipoOrgao.CORNEA, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(2)));
            orgaoRepository.save(new Orgao(TipoOrgao.FIGADO, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(2)));
            orgaoRepository.save(new Orgao(TipoOrgao.PULMAO, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(2)));
            orgaoRepository.save(new Orgao(TipoOrgao.RIM, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(2)));
            orgaoRepository.save(new Orgao(TipoOrgao.INTESTINO, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(2)));
            orgaoRepository.save(new Orgao(TipoOrgao.MEDULA, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(2)));
            orgaoRepository.save(new Orgao(TipoOrgao.OSSOS, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(2)));
            orgaoRepository.save(new Orgao(TipoOrgao.PANCREAS, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(2)));
            orgaoRepository.save(new Orgao(TipoOrgao.PELE, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(2)));

            orgaoRepository.save(new Orgao(TipoOrgao.CORACAO, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(3)));
            orgaoRepository.save(new Orgao(TipoOrgao.CORNEA, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(3)));
            orgaoRepository.save(new Orgao(TipoOrgao.FIGADO, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(3)));
            orgaoRepository.save(new Orgao(TipoOrgao.PULMAO, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(3)));
            orgaoRepository.save(new Orgao(TipoOrgao.RIM, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(3)));
            orgaoRepository.save(new Orgao(TipoOrgao.INTESTINO, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(3)));
            orgaoRepository.save(new Orgao(TipoOrgao.MEDULA, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(3)));
            orgaoRepository.save(new Orgao(TipoOrgao.OSSOS, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(3)));
            orgaoRepository.save(new Orgao(TipoOrgao.PANCREAS, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(3)));
            orgaoRepository.save(new Orgao(TipoOrgao.PELE, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(3)));

            orgaoRepository.save(new Orgao(TipoOrgao.CORACAO, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(4)));
            orgaoRepository.save(new Orgao(TipoOrgao.CORNEA, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(4)));
            orgaoRepository.save(new Orgao(TipoOrgao.FIGADO, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(4)));
            orgaoRepository.save(new Orgao(TipoOrgao.PULMAO, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(4)));
            orgaoRepository.save(new Orgao(TipoOrgao.RIM, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(4)));
            orgaoRepository.save(new Orgao(TipoOrgao.INTESTINO, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(4)));
            orgaoRepository.save(new Orgao(TipoOrgao.MEDULA, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(4)));
            orgaoRepository.save(new Orgao(TipoOrgao.OSSOS, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(4)));
            orgaoRepository.save(new Orgao(TipoOrgao.PANCREAS, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(4)));
            orgaoRepository.save(new Orgao(TipoOrgao.PELE, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(4)));

            orgaoRepository.save(new Orgao(TipoOrgao.CORACAO, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(5)));
            orgaoRepository.save(new Orgao(TipoOrgao.CORNEA, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(5)));
            orgaoRepository.save(new Orgao(TipoOrgao.FIGADO, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(5)));
            orgaoRepository.save(new Orgao(TipoOrgao.PULMAO, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(5)));
            orgaoRepository.save(new Orgao(TipoOrgao.RIM, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(5)));
            orgaoRepository.save(new Orgao(TipoOrgao.INTESTINO, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(5)));
            orgaoRepository.save(new Orgao(TipoOrgao.MEDULA, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(5)));
            orgaoRepository.save(new Orgao(TipoOrgao.OSSOS, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(5)));
            orgaoRepository.save(new Orgao(TipoOrgao.PANCREAS, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(5)));
            orgaoRepository.save(new Orgao(TipoOrgao.PELE, StatusOrgao.AGUARDANDO_RECEPTOR, pacienteService.findById(5)));


        };
    }

    public static void main(String[] args) {
        SpringApplication.run(TeleorgApplication.class, args);
    }


    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/orgao").allowedOrigins("http://localhost:3000");
            }
        };
    }


}
