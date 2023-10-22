package io.github.kduferreira.APIMedic.Controller;

import io.github.kduferreira.APIMedic.Domain.Medico;
import io.github.kduferreira.APIMedic.Exception.ResourceNotFoundException;
import io.github.kduferreira.APIMedic.Repository.MedicoRepository;
import io.github.kduferreira.APIMedic.Service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoService medicoService;

    private MedicoRepository medicoRepository;
    @PostMapping
    public Medico criarMedico(@RequestBody Medico medico) {
        return medicoService.criarMedico(medico);
    }

    @GetMapping
    public List<Medico> listarMedicos() {
        return medicoService.listarMedicos();
    }

    @PutMapping("/{id}")
    public Medico atualizarMedico(@PathVariable Long id, @RequestBody Medico medico) {
        Optional<Medico> medicoExistente = medicoRepository.findById(id);

        if (medicoExistente.isPresent()) {
            Medico medicoAtualizado = medicoExistente.get();
            medicoAtualizado.setNome(medico.getNome());
            medicoAtualizado.setEspecialidade(medico.getEspecialidade());

            return medicoRepository.save(medicoAtualizado);
        } else {
            throw new ResourceNotFoundException("Médico não encontrado com o ID: " + id);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirMedico(@PathVariable Long id) {
        Optional<Medico> medico = medicoRepository.findById(id);

        if (medico.isPresent()) {
            medicoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            throw new ResourceNotFoundException("Médico não encontrado com o ID: " + id);
        }
    }

}