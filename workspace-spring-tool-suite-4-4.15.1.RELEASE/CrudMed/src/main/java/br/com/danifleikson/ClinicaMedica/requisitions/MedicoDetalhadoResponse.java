package br.com.danifleikson.ClinicaMedica.requisitions;

import java.util.UUID;

import br.com.danifleikson.ClinicaMedica.medico.domain.Endereco;
import br.com.danifleikson.ClinicaMedica.medico.domain.Medico;
import lombok.Value;

@Value
public class MedicoDetalhadoResponse {
	
	
	private UUID idMedico;
	private String email;
	private String cpf; 
	private String crm;
	private Especialidade especialidade;
	private Endereco endereco ;

	public MedicoDetalhadoResponse(Medico medico) {
		this.idMedico = medico.getIdMedico();
		this.email = medico.getEmail();
		this.cpf = medico.getCpf();
		this.crm = medico.getCrm();
		this.especialidade = medico.getEspecialidade();
		this.endereco = medico.getEndereco();
	}

}
