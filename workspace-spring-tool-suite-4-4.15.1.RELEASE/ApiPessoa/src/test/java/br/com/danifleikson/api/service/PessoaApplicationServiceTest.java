package br.com.danifleikson.api.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import br.com.danifleikson.api.Exception.QuantidadeEnderecoPrincipalInválida;
import br.com.danifleikson.api.endereco.EnderecoRequest;
import br.com.danifleikson.api.endereco.domain.TipoEndereco;
import br.com.danifleikson.api.pessoa.domain.Endereco;
import br.com.danifleikson.api.pessoa.domain.Pessoa;
import br.com.danifleikson.api.pessoa.dto.ListPessoaResponse;
import br.com.danifleikson.api.pessoa.dto.PessoaAlteraRequest;
import br.com.danifleikson.api.pessoa.dto.PessoaDetalhadaResponse;
import br.com.danifleikson.api.pessoa.dto.PessoaRequest;
import br.com.danifleikson.api.pessoa.dto.PessoaResponse;
import br.com.danifleikson.api.repository.PessoaRepository;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class PessoaApplicationServiceTest {

	@Autowired
	private PessoaApplicationService service;
	@MockBean
	private PessoaRepository repository;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void verificaSeEstaCadastrando() {

		ArrayList<Endereco> endereco = new ArrayList<Endereco>();
		PessoaRequest request = new PessoaRequest();
		Pessoa pessoa = new Pessoa();
		PessoaResponse response = new PessoaResponse();

		request.setPessoaId(UUID.randomUUID());
		request.setEndereco(endereco);

		when(repository.cadastra(any(Pessoa.class))).thenReturn(pessoa);
		PessoaResponse responseResultado = service.cadastra(request);

		verify(repository, times(1)).cadastra(any(Pessoa.class));
		assertNotNull(responseResultado);
	}

	@Test
	public void testCadastra_Falha() {
		
		ArrayList<Endereco> endereco = new ArrayList<Endereco>();
		PessoaRequest request = new PessoaRequest();
		Pessoa pessoa = new Pessoa();
		pessoa.setIdPessoa(UUID.randomUUID());
		request.setPessoaId(pessoa.getIdPessoa());
		request.setEndereco(endereco);

		when(repository.cadastra(any(Pessoa.class))).thenThrow(new UnsupportedOperationException("Não suportado"));

		Throwable exception = assertThrows(UnsupportedOperationException.class, () -> {
			service.cadastra(request);
		});
		assertEquals("Não suportado", exception.getMessage());
		verify(repository, times(1)).cadastra(any(Pessoa.class));
	}

	@Test
	public void verificarSeEstaListando() {

		List<Pessoa> pessoaList = new ArrayList<>();
		pessoaList.add(new Pessoa());

		when(repository.listaTodos()).thenReturn(pessoaList);
		List<ListPessoaResponse> responseList = service.listar();

		assertEquals(1, responseList.size());
		verify(repository, times(1)).listaTodos();

	}

	@Test
	public void verificarSeEstaListando_Falha() {

		List<Pessoa> pessoaList = new ArrayList<>();
		when(repository.listaTodos()).thenReturn(pessoaList);
		List<ListPessoaResponse> responseList = service.listar();

		assertTrue(responseList.isEmpty());
		verify(repository, times(1)).listaTodos();
	}

	@Test
	public void vericifaSeEstaDetalhando() {

		UUID uuid = UUID.randomUUID();
		Pessoa pessoa = new Pessoa();
		pessoa.setIdPessoa(uuid);

		when(repository.buscaId(uuid)).thenReturn(pessoa);
		PessoaDetalhadaResponse response = service.busca(uuid);

		assertEquals(uuid, response.getIdPessoa());
		verify(repository, times(1)).buscaId(uuid);
	}

	@Test
	public void vericifaSeNaoEstaDetalhando() {
		
		UUID uuid = UUID.randomUUID();

		when(repository.buscaId(uuid)).thenReturn(null);
		assertThrows(NullPointerException.class, () -> {
			service.busca(uuid);
		});

		verify(repository, times(1)).buscaId(uuid);
	}

	@Test
	public void verificarSeEstaAtualizando() {

		UUID uuid = UUID.randomUUID();
		Pessoa pessoa = new Pessoa();
		pessoa.setIdPessoa(uuid);
		PessoaAlteraRequest request = new PessoaAlteraRequest("kinho", "24/02/1994", pessoa.getEndereco());

		when(repository.buscaId(uuid)).thenReturn(pessoa);
		service.atualiza(request, uuid);

		assertEquals(uuid, pessoa.getIdPessoa());
		assertEquals("kinho", pessoa.getNome());
		assertEquals("24/02/1994", pessoa.getDataNascimento());
		assertEquals(request.getEndereco(), pessoa.getEndereco());
		verify(repository, times(1)).buscaId(uuid);
	}

	@Test
	public void verificarSeNaoEstaAtualizando() {

		UUID uuid = UUID.randomUUID();
		Pessoa pessoa = new Pessoa();
		PessoaAlteraRequest request = new PessoaAlteraRequest("kinho", "24/02/1994", pessoa.getEndereco());

		when(repository.buscaId(uuid)).thenReturn(null);
		assertThrows(NullPointerException.class, () -> {
			service.atualiza(request, uuid);
		});
		verify(repository, times(1)).buscaId(uuid);
	}

	@Test
	public void verificaSeEstaExcluindo() {

		UUID uuid = UUID.randomUUID();
		Pessoa pessoa = new Pessoa();
		pessoa.setIdPessoa(uuid);

		when(repository.buscaId(uuid)).thenReturn(pessoa);
		service.excluir(uuid);

		verify(repository, times(1)).buscaId(uuid);
		verify(repository, times(1)).deletar(pessoa);
	}

	@Test
	public void verificaSeNaoEstaExcluindo() {

		UUID uuid = UUID.randomUUID();

		when(repository.buscaId(uuid)).thenReturn(null);
		service.excluir(uuid);

		verify(repository, times(1)).buscaId(uuid);
		verify(repository, never()).deletar(any(Pessoa.class));
	}

	@Test
	public void verificaSeEstaValidandoComUmEnderecoPrincipal() {

		PessoaRequest request = new PessoaRequest();
		List<Endereco> listEndereco = new ArrayList<>();
		EnderecoRequest enderecoRequest = new EnderecoRequest("rua", "cep", "numero", "cidade", TipoEndereco.PRINCIPAL);

		listEndereco.add(new Endereco(enderecoRequest));
		request.setEndereco(listEndereco);

		assertDoesNotThrow(() -> {
			service.validaEndereco(request);
		});
	}

	@Test
	public void verificaSeEstaRetornandoExceptionPassandoMaisDeUmEnderecoPrincipal() {

		PessoaRequest request = new PessoaRequest();
		List<Endereco> listEndereco = new ArrayList<>();
		EnderecoRequest enderecoRequest = new EnderecoRequest("rua1", "cep1", "numero1", "cidade1",
				TipoEndereco.PRINCIPAL);
		EnderecoRequest enderecoRequest1 = new EnderecoRequest("rua2", "cep2", "numero2", "cidade2",
				TipoEndereco.PRINCIPAL);

		listEndereco.add(new Endereco(enderecoRequest));
		listEndereco.add(new Endereco(enderecoRequest1));
		request.setEndereco(listEndereco);

		assertThrows(QuantidadeEnderecoPrincipalInválida.class, () -> {
			service.validaEndereco(request);
		});
	}

}
