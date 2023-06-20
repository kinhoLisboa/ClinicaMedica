package br.com.danifleikson.ClinicaMedica.medico.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.danifleikson.ClinicaMedica.medico.domain.Medico;
import br.com.danifleikson.ClinicaMedica.requisitions.AtualizarMedicoRequest;
import br.com.danifleikson.ClinicaMedica.requisitions.ListagemMedicoResponse;
import br.com.danifleikson.ClinicaMedica.requisitions.MedicoRequest;
import br.com.danifleikson.ClinicaMedica.requisitions.MedicoResponse;
@Service
public interface MedicoService {
	
	MedicoResponse salvaMedico(MedicoRequest medicoRequest);

	List<ListagemMedicoResponse> listamedicos();

	void deletar(UUID idMedico);

	void atualizar(AtualizarMedicoRequest medicoRequest, UUID idMedico);

	Medico buscamedico(UUID idMedico);

	

	


}
