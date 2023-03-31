package br.com.attornatus.attornatuspessoaendereco.pessoa.application.api;

import org.springframework.web.bind.annotation.RestController;

import br.com.attornatus.attornatuspessoaendereco.pessoa.application.api.requests.PessoaRequest;
import br.com.attornatus.attornatuspessoaendereco.pessoa.application.api.responses.PessoaResponse;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class PessoaController implements PessoaAPI {

	@Override
	public PessoaResponse postPessoa(PessoaRequest pessoaRequest) {
		log.info("[inicia] PessoaController - postPessoa");
		log.info("[finaliza] PessoaController - postPessoa");
		return null;
	}
}
