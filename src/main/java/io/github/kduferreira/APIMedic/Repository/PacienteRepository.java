package io.github.kduferreira.APIMedic.Repository;

import io.github.kduferreira.APIMedic.Domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}