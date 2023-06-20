package br.com.danifleikson.api.pessoa.domain;

import java.util.UUID;

import br.com.danifleikson.api.endereco.EnderecoRequest;
import br.com.danifleikson.api.endereco.domain.TipoEndereco;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Setter
@Getter
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID idEndereco;
	
	private String logradouro;
	
	private String cep;

	private String numero;
	
	private String cidade;
	
	
	private TipoEndereco tipoEndereco;

	public Endereco(UUID pessoaId ,@Valid EnderecoRequest enderecoRequest) {
		this.logradouro = enderecoRequest.getLogradouro();
		this.cep = enderecoRequest.getCep();
		this.numero = enderecoRequest.getNumero();
		this.cidade= enderecoRequest.getCidade();
		this.tipoEndereco = enderecoRequest.getTipoEndereco();
		
	}

	public Endereco(EnderecoRequest enderecoRequest) {
		this.logradouro = enderecoRequest.getLogradouro();
		this.cep = enderecoRequest.getCep();
		this.numero = enderecoRequest.getNumero();
		this.cidade= enderecoRequest.getCidade();
		this.tipoEndereco = enderecoRequest.getTipoEndereco();
	}

	

}
