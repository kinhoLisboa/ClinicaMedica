package br.com.danifleikson.api.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.danifleikson.api.endereco.EnderecoRequest;
import br.com.danifleikson.api.endereco.domain.EnderecoResponse;
import br.com.danifleikson.api.pessoa.dto.ListPessoaResponse;
import br.com.danifleikson.api.pessoa.dto.PessoaAlteraRequest;
import br.com.danifleikson.api.pessoa.dto.PessoaDetalhadaResponse;
import br.com.danifleikson.api.pessoa.dto.PessoaRequest;
import br.com.danifleikson.api.pessoa.dto.PessoaResponse;
import jakarta.validation.Valid;

@RequestMapping("/pessoa")
@RestController
public interface ApiApplicationPessoa {
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	PessoaResponse criar(@Valid @RequestBody PessoaRequest pessoaRequest);
	
	@GetMapping
	List<ListPessoaResponse> getTodos();
	
	@GetMapping("/{pessoaId}")
	PessoaDetalhadaResponse detalhar(@PathVariable UUID pessoaId);
	
	@PatchMapping("/{pessoaId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void alterar(@Valid @RequestBody PessoaAlteraRequest pessoaAlteraRequest,@PathVariable UUID pessoaId);
	
	@DeleteMapping("/{pessoaId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void deletar(@PathVariable UUID idPessoa);
	
	@PostMapping("/{pessoaId}")
	List<EnderecoResponse> criaEndereco(@PathVariable UUID pessoaId, @Valid @RequestBody EnderecoRequest enderecoRequest );
	
	

}
