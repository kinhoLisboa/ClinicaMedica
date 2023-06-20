package br.com.danifleikson.api.repository;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.danifleikson.api.pessoa.domain.Endereco;
import br.com.danifleikson.api.pessoa.domain.Pessoa;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@AllArgsConstructor
@Log4j2
public class EnderecoInfraRepository implements EnderecoRepository{
		
	private EnderecoJpaRepository repositoryJpa;
	private PessoaJpaRepository repository;


	@Override
	public Endereco salvaEndereco(UUID pessoaId, Endereco endereco) {
		log.info("[Inicia]EnderecoApplicationervice - criaNovoEndereco");
		Pessoa pessoa = repository.findById(pessoaId).orElseThrow();
		pessoa.getEndereco().add(endereco);
		log.info("[Inicia]EnderecoApplicationervice - criaNovoEndereco");
		return repositoryJpa.save(endereco);
	}

	
	

}
