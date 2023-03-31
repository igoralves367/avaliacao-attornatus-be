package br.com.attornatus.attornatuspessoaendereco.pessoa.application.api;

import org.springframework.web.bind.annotation.RestController;

import br.com.attornatus.attornatuspessoaendereco.pessoa.application.api.requests.PessoaRequest;
import br.com.attornatus.attornatuspessoaendereco.pessoa.application.api.responses.PessoaResponse;
import br.com.attornatus.attornatuspessoaendereco.pessoa.application.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequiredArgsConstructor
public class PessoaController implements PessoaAPI {
	private final PessoaService pessoaService;

	@Override
	public PessoaResponse postPessoa(PessoaRequest pessoaRequest) {
		log.info("[inicia] PessoaController - postPessoa");
		PessoaResponse pessoaResponse = pessoaService.criaPessoa(pessoaRequest);
		log.info("[finaliza] PessoaController - postPessoa");
		return pessoaResponse;
	}
}
