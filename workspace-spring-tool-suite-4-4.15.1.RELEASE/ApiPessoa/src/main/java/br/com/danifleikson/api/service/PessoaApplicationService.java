package br.com.danifleikson.api.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.danifleikson.api.Exception.QuantidadeEnderecoPrincipalInválida;
import br.com.danifleikson.api.endereco.domain.TipoEndereco;
import br.com.danifleikson.api.pessoa.domain.Pessoa;
import br.com.danifleikson.api.pessoa.dto.ListPessoaResponse;
import br.com.danifleikson.api.pessoa.dto.PessoaAlteraRequest;
import br.com.danifleikson.api.pessoa.dto.PessoaDetalhadaResponse;
import br.com.danifleikson.api.pessoa.dto.PessoaRequest;
import br.com.danifleikson.api.pessoa.dto.PessoaResponse;
import br.com.danifleikson.api.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Log4j2
@Service
@AllArgsConstructor
public class PessoaApplicationService implements PessoaService{
	
	private  PessoaRepository pessoaRepository;

	@Override
	public PessoaResponse cadastra(PessoaRequest pessoaRequest) {
		log.info("[Inicia]PessoaApplicationService - salvaPessoa");
		validaEndereco(pessoaRequest);
		var pessoa = pessoaRepository.cadastra(new Pessoa(pessoaRequest));
		log.info("[Inicia]PessoaApplicationService - salvaPessoa");
		return new PessoaResponse(pessoa);
	}

	@Override
	public List<ListPessoaResponse> listar() {
		log.info("[Inicia]PessoaApplicationService - listarPessoas");
		List<Pessoa> pessoas = pessoaRepository.listaTodos();
		log.info("[Finaliza]PessoaApplicationService - listarPessoas");
		return ListPessoaResponse.convert(pessoas);
	}

	@Override
	public PessoaDetalhadaResponse busca(UUID pessoaId) {
		log.info("[Inicia]PessoaApplicationService - buscaPessoa");
		Pessoa pessoa = pessoaRepository.buscaId(pessoaId);
		log.info("[Finaliza]PessoaApplicationService - buscaPessoa");
		return new PessoaDetalhadaResponse(pessoa);
	}
	
	@Override
	public void atualiza(PessoaAlteraRequest pessoaAlteraRequest, UUID pessoaId) {
		log.info("[Inicia]PessoaApplicationService - atualizaPessoa");
		Pessoa pessoa =	pessoaRepository.buscaId(pessoaId);
		pessoa.altera(pessoaAlteraRequest);
		pessoaRepository.cadastra(pessoa);
		log.info("[Finaliza]PessoaApplicationService - atualizaPessoa");
	}

	@Override
	public void excluir(UUID idPessoa) {
		log.info("[Inicia]PessoaApplicationService - excluirPessoa");
		Pessoa pessoa = pessoaRepository.buscaId(idPessoa);
		pessoaRepository.deletar(pessoa);
		log.info("[Finaliza]PessoaApplicationService - excluirPessoa");
	}
	
	@Override
	public void validaEndereco(PessoaRequest pessoaRequest) {
		long qtdEnderecoPrincipal = pessoaRequest.getEndereco()
			.stream()
			.filter(endereco -> TipoEndereco.PRINCIPAL.equals(endereco.getTipoEndereco())).count();
		
		if(qtdEnderecoPrincipal>1) {
			throw new QuantidadeEnderecoPrincipalInválida("Não é permitido inserir mais de um endereço principal.");
		}
	}

}
