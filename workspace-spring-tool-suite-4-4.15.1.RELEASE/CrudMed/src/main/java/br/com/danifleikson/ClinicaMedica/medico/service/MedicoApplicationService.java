package br.com.danifleikson.ClinicaMedica.medico.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.danifleikson.ClinicaMedica.medico.domain.Medico;
import br.com.danifleikson.ClinicaMedica.medico.repository.MedicoRepository;
import br.com.danifleikson.ClinicaMedica.requisitions.AtualizarMedicoRequest;
import br.com.danifleikson.ClinicaMedica.requisitions.ListagemMedicoResponse;
import br.com.danifleikson.ClinicaMedica.requisitions.MedicoRequest;
import br.com.danifleikson.ClinicaMedica.requisitions.MedicoResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@Service
public class MedicoApplicationService implements MedicoService {
	

	private final MedicoRepository medicoRepository;

	@Override
	public MedicoResponse salvaMedico(MedicoRequest medicoRequest) {
		log.info("[Inicia] MedicoApplicationService- salvaMedico");
		var medico = medicoRepository.cadastra(new Medico(medicoRequest));
		log.info("[Finaliza] MedicoApplicationService- salvaMedico");
		return new MedicoResponse(medico);
	}
	@Override
	public List<ListagemMedicoResponse> listamedicos() {
		log.info("[Inicia] MedicoApplicationService- listamedicos");
		List<Medico> medicos = medicoRepository.lista();
		log.info("[Finaliza] MedicoApplicationService- listamedicos");
		return  ListagemMedicoResponse.converte(medicos);
	}

	

	@Override
	public void atualizar(AtualizarMedicoRequest medicoRequest, UUID idMedico) {
		log.info("[Inicial] MedicoService- atualizar");
		var medico = medicoRepository.buscaId(idMedico);
		medico.atualizarInformacoes(medicoRequest);
		log.info("[Finaliza] MedicoService- atualizar");

	}

	@Override
	public void deletar(UUID idMedico) {
		log.info("[Inicial] MedicoService- deletar");
		medicoRepository.excluir(idMedico);
		log.info("[Finaliza] MedicoService- deletar");

	}

	@Override
	public Medico buscamedico(UUID idMedico) {
		log.info("[Inicial] MedicoService- buscamedico");
		var medico = medicoRepository.buscaId(idMedico);
		log.info("[Finaliza] MedicoService- buscamedico");
		return medico;
	}


}
