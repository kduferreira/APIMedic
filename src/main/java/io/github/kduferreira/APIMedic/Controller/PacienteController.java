package io.github.kduferreira.APIMedic.Controller;


import io.github.kduferreira.APIMedic.Domain.Paciente;
import io.github.kduferreira.APIMedic.Exception.ResourceNotFoundException;
import io.github.kduferreira.APIMedic.Repository.PacienteRepository;
import io.github.kduferreira.APIMedic.Service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;
    private PacienteRepository pacienteRepository;

    @PostMapping
    public Paciente criarPaciente(@RequestBody Paciente paciente) {
        return pacienteService.criarPaciente(paciente);
    }

    @GetMapping
    public List<Paciente> listarPacientes() {
        return pacienteService.listarPacientes();
    }

    @PutMapping("/{id}")
    public Paciente atualizarPaciente(@PathVariable Long id, @RequestBody Paciente paciente) {
        Optional<Paciente> pacienteExistente = pacienteRepository.findById(id);

        if (pacienteExistente.isPresent()) {
            Paciente pacienteAtualizado = pacienteExistente.get();
            pacienteAtualizado.setNome(paciente.getNome());
            pacienteAtualizado.setIdade(paciente.getIdade());

            return pacienteRepository.save(pacienteAtualizado);
        } else {
            throw  new ResourceNotFoundException("Paciente não encontrado com o ID: " + id);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirPaciente(@PathVariable Long id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);

        if (paciente.isPresent()) {
            pacienteRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            throw new ResourceNotFoundException("Paciente não encontrado com o ID: " + id);
        }
    }


}