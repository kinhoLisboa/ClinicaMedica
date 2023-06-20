package br.com.danifleikson.api.pessoa.dto;

import java.util.List;
import java.util.UUID;

import br.com.danifleikson.api.pessoa.domain.Endereco;
import lombok.Value;

@Value
public class PessoaAlteraRequest {
	
	private String nome;
	private String dataNascimento;
	private List<Endereco> endereco;
	

}
