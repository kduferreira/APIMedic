package io.github.kduferreira.APIMedic.Repository;

import io.github.kduferreira.APIMedic.Domain.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends  JpaRepository<Medico, Long> {
}
