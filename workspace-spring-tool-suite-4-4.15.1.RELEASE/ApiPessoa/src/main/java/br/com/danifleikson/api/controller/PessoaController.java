package br.com.danifleikson.api.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.danifleikson.api.endereco.EnderecoRequest;
import br.com.danifleikson.api.endereco.domain.EnderecoResponse;
import br.com.danifleikson.api.pessoa.dto.ListPessoaResponse;
import br.com.danifleikson.api.pessoa.dto.PessoaAlteraRequest;
import br.com.danifleikson.api.pessoa.dto.PessoaDetalhadaResponse;
import br.com.danifleikson.api.pessoa.dto.PessoaRequest;
import br.com.danifleikson.api.pessoa.dto.PessoaResponse;
import br.com.danifleikson.api.service.EnderecoService;
import br.com.danifleikson.api.service.PessoaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@RestController
public class PessoaController implements ApiApplicationPessoa{
	
	private final PessoaService pessoaService;
	private final EnderecoService enderecoService;

	@Override
	public PessoaResponse criar(@Valid PessoaRequest pessoaRequest) {
		log.info("[Inicia]PessoaController -criaPessoa");
		PessoaResponse pessoa = pessoaService.cadastra(pessoaRequest);
		log.info("[Finaliza]PessoaController -criaPessoa");
		return pessoa;
	}

	@Override
	public List<ListPessoaResponse> getTodos() {
		log.info("[Inicia]PessoaController -getTodasPessoas");
		List<ListPessoaResponse> pessoas = pessoaService.listar();
		log.info("[Finaliza]PessoaController -getTodasPessoas");
		return pessoas;
	}

	@Override
	public PessoaDetalhadaResponse detalhar(UUID pessoaId) {
		log.info("[Inicia]PessoaController -pessoaDetalhada");
		log.info("PessoaId ()", pessoaId);
		var buscar = pessoaService.busca(pessoaId);
		log.info("[Finaliza]PessoaController -pessoaDetalhada");
		return buscar;
	}

	@Override
	public void alterar(PessoaAlteraRequest pessoaAlteraRequest, UUID pessoaId) {
		log.info("[Inicia]PessoaController -alterarPessoa");
		log.info("PessoaId ()", pessoaId);
		pessoaService.atualiza(pessoaAlteraRequest, pessoaId);
		log.info("[Finaliza]PessoaController -alterarPessoa");
	}

	@Override
	public void deletar(UUID pessoaId) {
		log.info("[Inicia]PessoaController - deletarPessoa");
		log.info("PessoaId ()", pessoaId);
		pessoaService.excluir(pessoaId);
		log.info("[Finaliza]PessoaController - deletarPessoa");
	}

	@Override
	public List<EnderecoResponse> criaEndereco(UUID pessoaId,@Valid EnderecoRequest enderecoRequest) {
		   log.info("[Inicia]PessoaController - criaEndereco");
		   log.info("PessoaId ()", pessoaId);
		   List<EnderecoResponse> endereco =	enderecoService.criaNovoEndereco(pessoaId, enderecoRequest);
		   log.info("[Finaliza]PessoaController -criaEndereco");
		   return endereco;
	}


}
