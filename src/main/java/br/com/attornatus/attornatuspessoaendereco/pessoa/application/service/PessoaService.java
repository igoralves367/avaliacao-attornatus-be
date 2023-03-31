package br.com.attornatus.attornatuspessoaendereco.pessoa.application.service;

import java.util.List;
import java.util.UUID;

import br.com.attornatus.attornatuspessoaendereco.pessoa.application.api.requests.PessoaRequest;
import br.com.attornatus.attornatuspessoaendereco.pessoa.application.api.responses.ConsultaPessoaResponse;
import br.com.attornatus.attornatuspessoaendereco.pessoa.application.api.responses.ListaPessoasResponse;
import br.com.attornatus.attornatuspessoaendereco.pessoa.application.api.responses.PessoaResponse;
public interface PessoaService {

	PessoaResponse criaPessoa(PessoaRequest pessoaRequest);
	List<ListaPessoasResponse> listaPessoas();
	ConsultaPessoaResponse consultaPessoaAtravesId(UUID idPessoa);
}
