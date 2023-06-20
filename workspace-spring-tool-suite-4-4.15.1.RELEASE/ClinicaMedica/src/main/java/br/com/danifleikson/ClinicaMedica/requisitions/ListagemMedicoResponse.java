package br.com.danifleikson.ClinicaMedica.requisitions;

import java.util.List;

import br.com.danifleikson.ClinicaMedica.medico.domain.Medico;
import lombok.Value;

@Value
public class ListagemMedicoResponse {

	String nome;
	String crm;
	String email;
	Especialidade especialidade;
	
	public static List<ListagemMedicoResponse> converte(List<Medico> medicos) {
		
		return medicos.stream().map(ListagemMedicoResponse::new).toList();
	}

	public ListagemMedicoResponse(Medico medico) {
		super();
		this.nome = medico.getNome();
		this.crm = medico.getCrm();
		this.email = medico.getEmail();
		this.especialidade = medico.getEspecialidade();
	}
	

}
