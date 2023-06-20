package br.com.danifleikson.api.pessoa.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.com.danifleikson.api.pessoa.domain.Endereco;
import br.com.danifleikson.api.pessoa.domain.Pessoa;
import lombok.Value;

@Value
public class PessoaDetalhadaResponse {
	
	private UUID idPessoa;
	private String nome;
	private String email;
	private List<Endereco> endereco;
	
	public PessoaDetalhadaResponse(Pessoa pessoa) {
		
		this.idPessoa = pessoa.getIdPessoa();
		this.nome = pessoa.getNome();
		this.email = pessoa.getEmail();
		this.endereco = new ArrayList<Endereco>(pessoa.getEndereco());
		
	}

	

}
