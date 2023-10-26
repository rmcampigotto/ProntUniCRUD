package br.com.prontuni;

import br.com.prontuni.controller.PacienteController;
import br.com.prontuni.model.Paciente;
import br.com.prontuni.repository.PacienteRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ProntuniApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProntuniApplication.class, args);

	}

}
