package br.com.danifleikson.api.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.danifleikson.api.pessoa.domain.Endereco;
import br.com.danifleikson.api.pessoa.domain.Pessoa;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Repository
@Log4j2
@AllArgsConstructor
public class PessoaInfraRepository implements PessoaRepository{
	
	private PessoaJpaRepository pessoaJpaRepository;

	@Override
	public Pessoa cadastra(Pessoa pessoa) {
		log.info("[Inicia]PessoaInfraRepository - cadastra");
		pessoaJpaRepository.save(pessoa);
		log.info("[Inicia]PessoaInfraRepository - cadastra");
		return pessoa;
	}

	@Override
	public List<Pessoa> listaTodos() {
		log.info("[Inicia]PessoaInfraRepository - listaTodos");
		var pessoas = pessoaJpaRepository.findAll();
		log.info("[Finaliza]PessoaInfraRepository - listaTodos");
		return pessoas;
	}

	@Override
	public Pessoa buscaId(UUID pessoaId) {
		log.info("[Inicia]PessoaInfraRepository - buscaId");
		var pessoa = pessoaJpaRepository.getReferenceById(pessoaId);
		log.info("[Finaliza]PessoaInfraRepository - buscaId");
		return pessoa;
	}

	@Override
	public void deletar(Pessoa pessoa) {
		log.info("[Inicia]PessoaApplicationService - deletarPessoa");
		pessoaJpaRepository.delete(pessoa);
		log.info("[Finaliaza]PessoaApplicationService - deletarPessoa");
		
	}

	

}
