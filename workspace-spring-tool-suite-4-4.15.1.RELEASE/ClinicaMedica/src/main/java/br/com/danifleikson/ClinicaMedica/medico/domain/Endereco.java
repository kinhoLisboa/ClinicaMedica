package br.com.danifleikson.ClinicaMedica.medico.domain;


import br.com.danifleikson.ClinicaMedica.requisitions.EnderecoRequest;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Endereco {
	
	private String rua;
	private String numero;
	private String bairro;
	private String cidade;
	private String uf;
	
	public Endereco(EnderecoRequest dados) {

		this.rua = dados.getRua();
		this.numero = dados.getNumero();
		this.bairro = dados.getBairro();
		this.cidade = dados.getCidade();
		this.uf = dados.getUf();
		
	}

	public void atualizarInformacoes(EnderecoRequest dados) {
		
		if(dados.getRua()!= null) {
			this.rua = dados.getRua();
		}
		if(dados.getNumero()!= null) {
			this.rua = dados.getNumero();
		}
		if(dados.getBairro()!= null) {
			this.rua = dados.getBairro();
		}
		if(dados.getCidade()!= null) {
			this.rua = dados.getCidade();
		}
		if(dados.getUf()!= null) {
			this.rua = dados.getUf();
		}
	
	}


}
