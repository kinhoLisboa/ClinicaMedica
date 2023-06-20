package br.com.danifleikson.api.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.danifleikson.api.endereco.EnderecoRequest;
import br.com.danifleikson.api.endereco.domain.EnderecoResponse;
import jakarta.validation.Valid;
@Service
public interface EnderecoService {

	List<EnderecoResponse> criaNovoEndereco(UUID pessoaId, @Valid EnderecoRequest enderecoRequest);
	

}
