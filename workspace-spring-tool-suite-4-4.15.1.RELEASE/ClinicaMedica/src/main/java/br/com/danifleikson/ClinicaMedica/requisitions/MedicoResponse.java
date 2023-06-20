package br.com.danifleikson.ClinicaMedica.requisitions;

import java.util.UUID;

import br.com.danifleikson.ClinicaMedica.medico.domain.Medico;
import lombok.Value;

@Value
public class MedicoResponse {

	private UUID idMedico;
	private String nome;
	
	public MedicoResponse(Medico medico) {
			
		this.idMedico = medico.getIdMedico();
		this.nome = medico.getNome();
	}


}
