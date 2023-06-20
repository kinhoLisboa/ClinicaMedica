package br.com.danifleikson.ClinicaMedica.medico.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Pageable;

import br.com.danifleikson.ClinicaMedica.medico.domain.Medico;

public interface MedicoRepository {

	 Medico cadastra(Medico medico);

	 List<Medico> lista();
	
	Medico buscaId(UUID id);

	void excluir(UUID idMedico);

	

	

	

}
