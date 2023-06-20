package br.com.danifleikson.api.service;

import java.util.List;
import java.util.UUID;

import br.com.danifleikson.api.pessoa.dto.ListPessoaResponse;
import br.com.danifleikson.api.pessoa.dto.PessoaAlteraRequest;
import br.com.danifleikson.api.pessoa.dto.PessoaDetalhadaResponse;
import br.com.danifleikson.api.pessoa.dto.PessoaRequest;
import br.com.danifleikson.api.pessoa.dto.PessoaResponse;

public interface PessoaService {

	PessoaResponse cadastra(PessoaRequest pessoaRequest);

	List<ListPessoaResponse> listar();

	PessoaDetalhadaResponse busca(UUID pessoaId);

	void atualiza(PessoaAlteraRequest pessoaAlteraRequest, UUID pessoaId);

	void excluir (UUID pessoaId);

	void validaEndereco(PessoaRequest pessoaRequest);

	

}
