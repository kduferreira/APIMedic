package io.github.kduferreira.APIMedic.Service;

import io.github.kduferreira.APIMedic.Domain.Medico;
import io.github.kduferreira.APIMedic.Repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class MedicoService {
    @Autowired
    private MedicoRepository medicoRepository;

    public Medico criarMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    public List<Medico> listarMedicos() {
        return medicoRepository.findAll();
    }
}
