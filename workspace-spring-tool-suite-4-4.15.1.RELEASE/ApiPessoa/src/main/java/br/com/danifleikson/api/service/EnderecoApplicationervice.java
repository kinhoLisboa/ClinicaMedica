package br.com.danifleikson.api.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.danifleikson.api.endereco.EnderecoRequest;
import br.com.danifleikson.api.endereco.domain.EnderecoResponse;
import br.com.danifleikson.api.pessoa.domain.Endereco;
import br.com.danifleikson.api.pessoa.domain.Pessoa;
import br.com.danifleikson.api.pessoa.dto.PessoaRequest;
import br.com.danifleikson.api.repository.EnderecoRepository;
import br.com.danifleikson.api.repository.PessoaRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@AllArgsConstructor
@Log4j2
public class EnderecoApplicationervice implements EnderecoService{
	
	private PessoaRepository pessoaRepository;
	private PessoaService pessoaService;
	
	@Override
	public List<EnderecoResponse> criaNovoEndereco( UUID pessoaId, @Valid EnderecoRequest enderecoRequest) {
		log.info("[Inicia]EnderecoApplicationervice - criaNovoEndereco");
		Pessoa pessoa = pessoaRepository.buscaId(pessoaId);
		pessoa.getEndereco().add(new Endereco( pessoaId ,enderecoRequest));
		pessoaService.validaEndereco(new PessoaRequest(pessoa));
		pessoaRepository.cadastra(pessoa);
		log.info("[Finaliza]EnderecoApplicationervice - criaNovoEndereco");
		return pessoa.getEndereco().stream().map(endereco -> new EnderecoResponse(endereco))
					.collect(Collectors.toList());
	}





	


}
