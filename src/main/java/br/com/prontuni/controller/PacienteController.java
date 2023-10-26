package br.com.prontuni.controller;

import br.com.prontuni.exceptions.PacienteException;
import br.com.prontuni.model.Paciente;
import br.com.prontuni.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping("/insert")
    public Paciente Insert(@RequestBody Paciente paciente) throws PacienteException {
        pacienteRepository.save(paciente);
        return selectById(paciente.getId());
    }

    @PutMapping("/update")
    public Paciente updateNameById(@RequestParam("id") int id, @RequestParam("nome") String nome) throws PacienteException {
        if(pacienteRepository.findById(id).isPresent()){
            Paciente paciente = pacienteRepository.findById(id).get();

            paciente.setNome(nome);

            pacienteRepository.save(paciente);

            return selectById(id);
        }else{
            return null;
        }
    }

    @GetMapping("/selectFull")
    public List<Paciente> all(){
        return pacienteRepository.findAll();
    }

    @GetMapping("/selectID/{id}")
    public Paciente selectById(@PathVariable int id) throws PacienteException {
        return pacienteRepository.findById(id).orElseThrow(PacienteException::new);
    }

}
