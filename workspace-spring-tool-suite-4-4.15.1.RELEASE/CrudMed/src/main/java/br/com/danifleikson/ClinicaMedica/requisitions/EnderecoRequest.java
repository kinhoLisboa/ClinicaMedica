package br.com.danifleikson.ClinicaMedica.requisitions;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class EnderecoRequest {
		
		@NotBlank
		private	String rua;
		@NotBlank
		private	String numero;
		@NotBlank
		private	String bairro;
		@NotBlank
		private	String cidade;
		@NotBlank
		private		String uf;



}
