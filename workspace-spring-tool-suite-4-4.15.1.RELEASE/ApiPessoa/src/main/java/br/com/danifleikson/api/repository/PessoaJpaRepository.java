package br.com.danifleikson.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.danifleikson.api.pessoa.domain.Pessoa;

public interface PessoaJpaRepository extends JpaRepository<Pessoa, UUID>{

}
