package br.com.danifleikson.ClinicaMedica.requisitions;

import java.util.UUID;

import lombok.Value;

@Value
public class AtualizarMedicoRequest{
		
	private	UUID id;
	private	String email;
	private	EnderecoRequest endereco;  

}
