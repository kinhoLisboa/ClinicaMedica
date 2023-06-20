package br.com.danifleikson.api.pessoa.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.com.danifleikson.api.pessoa.dto.PessoaAlteraRequest;
import br.com.danifleikson.api.pessoa.dto.PessoaRequest;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Setter
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID idPessoa;
	private String nome;
	private String dataNascimento;
	private String cpf;
	private String email;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Endereco> endereco  = new ArrayList<>() ;


	public Pessoa(PessoaRequest pessoaRequest) {
		this.nome = pessoaRequest.getNome();
		this.dataNascimento = pessoaRequest.getDataNascimento();
		this.cpf = pessoaRequest.getCpf();
	    this.email = pessoaRequest.getEmail();
		this.endereco = new ArrayList<Endereco>(pessoaRequest.getEndereco());
	}


	public void altera(PessoaAlteraRequest pessoaAlteraRequest) {
		
		this.nome = pessoaAlteraRequest.getNome();
		this.dataNascimento = pessoaAlteraRequest.getDataNascimento();
		this.endereco =  new ArrayList<Endereco>(pessoaAlteraRequest.getEndereco());
		
		
	}

		
}


	
