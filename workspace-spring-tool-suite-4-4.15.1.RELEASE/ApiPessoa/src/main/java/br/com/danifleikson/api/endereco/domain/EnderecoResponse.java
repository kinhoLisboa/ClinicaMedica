package br.com.danifleikson.api.endereco.domain;

import java.util.UUID;

import br.com.danifleikson.api.pessoa.domain.Endereco;
import lombok.Value;

@Value
public class EnderecoResponse {

	UUID enderecoId;
	private String cep;
	private String numero;
	
	public EnderecoResponse(Endereco endereco) {
		this.enderecoId = endereco.getIdEndereco();
		this.cep = endereco.getCep();
		this.numero = endereco.getNumero();
	}

}
