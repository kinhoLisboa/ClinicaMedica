package br.com.danifleikson.ClinicaMedica.medico.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.danifleikson.ClinicaMedica.medico.domain.Medico;

public interface MedicoJpaRepository extends JpaRepository<Medico, UUID>{

}
