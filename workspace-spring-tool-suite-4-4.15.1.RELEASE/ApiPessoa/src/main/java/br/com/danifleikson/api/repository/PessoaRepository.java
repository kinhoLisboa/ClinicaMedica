package br.com.danifleikson.api.repository;

import java.util.List;
import java.util.UUID;

import br.com.danifleikson.api.pessoa.domain.Endereco;
import br.com.danifleikson.api.pessoa.domain.Pessoa;

public interface PessoaRepository {
	
	Pessoa cadastra(Pessoa pessoa);

	List<Pessoa> listaTodos();

	Pessoa buscaId(UUID pessoaId);

	void deletar(Pessoa pessoa);






	

	

}
