package br.com.danifleikson.api.pessoa.dto;

import java.util.UUID;

import br.com.danifleikson.api.pessoa.domain.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaResponse {

	private UUID idPessoa;
	private String nome;

	public PessoaResponse(Pessoa pessoa) {
		
		this.idPessoa = pessoa.getIdPessoa();
		this.nome = pessoa.getNome();
	}

	

}
