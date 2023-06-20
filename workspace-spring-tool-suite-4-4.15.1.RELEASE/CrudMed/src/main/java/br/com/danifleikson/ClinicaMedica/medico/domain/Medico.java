package br.com.danifleikson.ClinicaMedica.medico.domain;

import java.util.UUID;

import br.com.danifleikson.ClinicaMedica.requisitions.AtualizarMedicoRequest;
import br.com.danifleikson.ClinicaMedica.requisitions.Especialidade;
import br.com.danifleikson.ClinicaMedica.requisitions.MedicoRequest;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Medico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID idMedico;
	private String nome; 
	private String email;
	private String cpf; 
	private String crm; 
	@Enumerated(EnumType.STRING)
	private Especialidade especialidade;
	@Embedded
	private Endereco endereco;
	

	public Medico(MedicoRequest medicoRequest) {
		
		this.nome = medicoRequest.getNome();
		this.email = medicoRequest.getEmail();
		this.cpf = medicoRequest.getCpf();
		this.crm =medicoRequest.getCrm();
		this.especialidade = medicoRequest.getEspecialidade();
		this.endereco = new Endereco(medicoRequest.getEndereco());
	}


	public void atualizarInformacoes(AtualizarMedicoRequest medicoRequest) {
		
		if(medicoRequest.getEmail()!= null) {
			this.email= medicoRequest.getEmail();
		}
		if(medicoRequest.getEndereco()!= null) {
			this.endereco.atualizarInformacoes(medicoRequest.getEndereco());
		}
	
	}

}
