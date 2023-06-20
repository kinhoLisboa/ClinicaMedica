package br.com.danifleikson.ClinicaMedica.medico.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.danifleikson.ClinicaMedica.medico.service.MedicoService;
import br.com.danifleikson.ClinicaMedica.requisitions.AtualizarMedicoRequest;
import br.com.danifleikson.ClinicaMedica.requisitions.ListagemMedicoResponse;
import br.com.danifleikson.ClinicaMedica.requisitions.MedicoDetalhadoResponse;
import br.com.danifleikson.ClinicaMedica.requisitions.MedicoRequest;
import br.com.danifleikson.ClinicaMedica.requisitions.MedicoResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequiredArgsConstructor
public class MedicoController implements MedicoApiApplication {

	private  final MedicoService medicoService;

	@Override
	public ResponseEntity criaMedico(MedicoRequest medicoRequest, UriComponentsBuilder ucb) {
		log.info("[Inicia] MedicoController - criaMedico");
		MedicoResponse medico = medicoService.salvaMedico(medicoRequest);
		var uri = ucb.path("/medicos{id}").buildAndExpand(medico.getIdMedico()).toUri();
		log.info("[Finaliza] MedicoController - criaMedico");
		return ResponseEntity.created(uri).body(medico);

	}

	@Override
	public List<ListagemMedicoResponse> listar() {
		log.info("[Inicia] MedicoController - listar");
		List<ListagemMedicoResponse> medico = medicoService.listamedicos();
		log.info("[Finaliza] MedicoController - listar");
		return medico;
	}

	@Override
	public void alteraMedico(AtualizarMedicoRequest dados, UUID idMedico) {
		log.info("[Inicia] MedicoController - alteraMedico");
		medicoService.atualizar(dados, idMedico);
		log.info("[Finaliza] MedicoController - alteraMedico");

	}

	@Override
	public void excluir(UUID idMedico) {
		log.info("[Inicia] MedicoController - excluir");
		medicoService.deletar(idMedico);
		log.info("[Finaliza] MedicoController - excluir");

	}

	@Override
	public MedicoDetalhadoResponse detalharInformacoes(UUID idMedico) {
		log.info("[Inicia] MedicoController - detalharInformacoes");
		var medico = medicoService.buscamedico(idMedico);
		log.info("[Finaliza] MedicoController - detalharInformacoes");
		return new MedicoDetalhadoResponse(medico);
	}

	

}
