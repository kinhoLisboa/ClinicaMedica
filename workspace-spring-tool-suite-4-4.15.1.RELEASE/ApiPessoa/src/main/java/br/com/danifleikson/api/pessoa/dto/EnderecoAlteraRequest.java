package br.com.danifleikson.api.pessoa.dto;

import java.util.UUID;

import lombok.Value;

@Value
public class EnderecoAlteraRequest {
	
	private UUID enderecoId;
	private String logradouro;
	private String cep;
	private String numero;
	private String cidade;
	

}
