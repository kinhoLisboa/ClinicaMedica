package br.com.danifleikson.api.pessoa.dto;

import java.util.List;
import java.util.UUID;

import org.hibernate.validator.constraints.br.CPF;

import br.com.danifleikson.api.pessoa.domain.Endereco;
import br.com.danifleikson.api.pessoa.domain.Pessoa;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PessoaRequest {

	private UUID pessoaId;
	@NotBlank
	private String nome;

	@NotBlank
	private String dataNascimento;
	@NotBlank
	@CPF
	private String cpf;
	@Email
	@NotBlank
	private String email;
	@Valid
	@NotEmpty
	private List<Endereco> endereco;

	public PessoaRequest(Pessoa pessoa) {

		this.nome = pessoa.getNome();
		this.dataNascimento = pessoa.getDataNascimento();
		this.cpf = pessoa.getCpf();
		this.email = pessoa.getEmail();
		this.endereco = pessoa.getEndereco();
	}

}
