package br.com.danifleikson.ClinicaMedica.medico.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.danifleikson.ClinicaMedica.requisitions.AtualizarMedicoRequest;
import br.com.danifleikson.ClinicaMedica.requisitions.ListagemMedicoResponse;
import br.com.danifleikson.ClinicaMedica.requisitions.MedicoDetalhadoResponse;
import br.com.danifleikson.ClinicaMedica.requisitions.MedicoRequest;
import jakarta.validation.Valid;

@RequestMapping("/medicos")
@RestController
public interface MedicoApiApplication {
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	ResponseEntity criaMedico(@Valid @RequestBody MedicoRequest medicoRequest ,UriComponentsBuilder ucb);
	
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	List<ListagemMedicoResponse> listar();
	
	@PutMapping("/{idMedico}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	void alteraMedico(@RequestBody @Valid AtualizarMedicoRequest medicoRequest,@PathVariable UUID idMedico);
	
	@DeleteMapping("/{idMedico}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	void excluir (@PathVariable UUID idMedico);
	
	@GetMapping("/{idMedico}")
	@ResponseStatus(value = HttpStatus.OK)
	MedicoDetalhadoResponse detalharInformacoes (@PathVariable UUID idMedico);
	

}
