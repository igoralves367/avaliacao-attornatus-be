package br.com.attornatus.attornatuspessoaendereco.pessoa.application.service;

import java.util.List;

import br.com.attornatus.attornatuspessoaendereco.pessoa.application.api.requests.PessoaRequest;
import br.com.attornatus.attornatuspessoaendereco.pessoa.application.api.responses.ListaPessoasResponse;
import br.com.attornatus.attornatuspessoaendereco.pessoa.application.api.responses.PessoaResponse;
public interface PessoaService {

	PessoaResponse criaPessoa(PessoaRequest pessoaRequest);
	List<ListaPessoasResponse> listaPessoas();
}
