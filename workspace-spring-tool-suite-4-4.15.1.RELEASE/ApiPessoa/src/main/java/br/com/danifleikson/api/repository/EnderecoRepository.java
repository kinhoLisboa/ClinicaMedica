package br.com.danifleikson.api.repository;

import java.util.UUID;

import br.com.danifleikson.api.pessoa.domain.Endereco;

public interface EnderecoRepository {

	Endereco salvaEndereco(UUID pessoaId, Endereco endereco);


	

	



}
