package br.com.prontuni.controller;

import br.com.prontuni.exceptions.PacienteException;
import br.com.prontuni.model.Paciente;
import br.com.prontuni.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping("/insert")
    public Paciente Insert(@RequestBody Paciente paciente) throws PacienteException {
        int id = count(pacienteRepository.findAll());
        id++;

        paciente.setId(id);
        pacienteRepository.save(paciente);
        return selectById(paciente.getId());
    }

    @PutMapping("/update/{id}")
    public Paciente updateById(@PathVariable int id, @RequestBody Paciente edit) throws PacienteException {
        Paciente pacientedb = pacienteRepository.findById(id).orElseThrow(PacienteException::new);

        pacientedb.setId(id);
        pacientedb.setNome(edit.getNome());
        pacientedb.setDataNascimento(edit.getDataNascimento());
        pacientedb.setGenero(edit.getGenero());
        pacientedb.setEndereco(edit.getEndereco());
        pacientedb.setCidade(edit.getCidade());
        pacientedb.setTelefone(edit.getTelefone());
        pacientedb.setUbs(edit.getUbs());

        return pacienteRepository.save(pacientedb);
    }

    @GetMapping("/selectFull")
    public List<Paciente> all(){
        return pacienteRepository.findAll();
    }

    @GetMapping("/selectID/{id}")
    public Paciente selectById(@PathVariable int id) throws PacienteException {
        return pacienteRepository.findById(id).orElseThrow(PacienteException::new);
    }

    public int count(List<Paciente> pacientes){
        int contagem = 0;

        for (Paciente p: pacientes) {
            contagem++;
        }
        return contagem;
    }

}
