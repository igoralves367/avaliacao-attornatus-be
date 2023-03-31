package br.com.attornatus.attornatuspessoaendereco.pessoa.application.service;

import br.com.attornatus.attornatuspessoaendereco.pessoa.application.api.requests.PessoaRequest;
import br.com.attornatus.attornatuspessoaendereco.pessoa.application.api.responses.PessoaResponse;
public interface PessoaService {

	PessoaResponse criaPessoa(PessoaRequest pessoaRequest);
}
