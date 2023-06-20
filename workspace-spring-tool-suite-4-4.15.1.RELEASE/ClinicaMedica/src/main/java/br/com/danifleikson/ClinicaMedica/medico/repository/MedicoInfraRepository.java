package br.com.danifleikson.ClinicaMedica.medico.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import br.com.danifleikson.ClinicaMedica.medico.domain.Medico;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Log4j2
@RequiredArgsConstructor
@Repository
public class MedicoInfraRepository implements MedicoRepository{
	
	
	private final MedicoJpaRepository repository;

	@Override
	public Medico cadastra(Medico medico) {
		log.info("[Inicia]MedicoInfraRepository - cadastra");
		repository.save(medico);
		log.info("[Finaliza]MedicoInfraRepository - cadastra");
		return medico;
	}
	@Override
	public List<Medico> lista() {
		log.info("[Inicia]MedicoInfraRepository - lista");
		var medicos = repository.findAll();
		log.info("[Finaliza]MedicoInfraRepository - lista");
		return  medicos ;
	}

	

	@Override
	public Medico buscaId(UUID id) {
		log.info("[Inicia]MedicoInfraRepository - buscaId");
		var medico = repository.getReferenceById(id);
		log.info("[Finaliza]MedicoInfraRepository - buscaId");
		return medico;
	}

	@Override
	public void excluir(UUID idMedico) {
		log.info("[Inicia]MedicoInfraRepository - excluir");
		repository.deleteById(idMedico);
		log.info("[Finaliza]MedicoInfraRepository - excluir");

	}

}
