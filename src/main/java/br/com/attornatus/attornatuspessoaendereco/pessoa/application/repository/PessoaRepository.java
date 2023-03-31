package br.com.attornatus.attornatuspessoaendereco.pessoa.application.repository;

import java.util.List;

import br.com.attornatus.attornatuspessoaendereco.pessoa.domain.Pessoa;

public interface PessoaRepository {

	Pessoa salva(Pessoa pessoa);
	List<Pessoa> listaPessoas();
}
