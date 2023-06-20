package br.com.danifleikson.ClinicaMedica.requisitions;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
public class MedicoRequest {
	
	@NotBlank
	private String nome;
	@NotBlank
	@Email
	private	String email;
	@NotBlank
	@CPF
	private	String cpf;
	@NotBlank
	private	String crm;
	@Enumerated(EnumType.STRING)
	private	Especialidade especialidade;
	@Valid
	private EnderecoRequest endereco;
}
