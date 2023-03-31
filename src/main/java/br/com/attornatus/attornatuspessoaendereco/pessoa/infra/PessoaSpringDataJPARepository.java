package br.com.attornatus.attornatuspessoaendereco.pessoa.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.attornatus.attornatuspessoaendereco.pessoa.domain.Pessoa;

public interface PessoaSpringDataJPARepository extends JpaRepository <Pessoa, UUID> {

}
