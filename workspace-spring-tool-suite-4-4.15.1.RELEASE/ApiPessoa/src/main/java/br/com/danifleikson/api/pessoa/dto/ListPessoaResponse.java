package br.com.danifleikson.api.pessoa.dto;

import java.util.List;

import br.com.danifleikson.api.pessoa.domain.Pessoa;
import lombok.Value;

@Value
public class ListPessoaResponse {
	
	private String nome;
	private String dataNascimento;
	
	public static List<ListPessoaResponse> convert(List<Pessoa> pessoas) {
		
		return pessoas.stream().map(ListPessoaResponse::new).toList();
	}
	 public ListPessoaResponse(Pessoa pessoa) {
		 super();
		 this.nome = pessoa.getNome();
		 this.dataNascimento = pessoa.getDataNascimento();
	 }
	

}
