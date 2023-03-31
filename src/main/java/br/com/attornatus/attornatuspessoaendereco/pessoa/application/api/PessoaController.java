package br.com.attornatus.attornatuspessoaendereco.pessoa.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.attornatus.attornatuspessoaendereco.pessoa.application.api.requests.PessoaRequest;
import br.com.attornatus.attornatuspessoaendereco.pessoa.application.api.responses.ConsultaPessoaResponse;
import br.com.attornatus.attornatuspessoaendereco.pessoa.application.api.responses.ListaPessoasResponse;
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

	@Override
	public List<ListaPessoasResponse> listaPessoas() {
		log.info("[inicia] PessoaController - listaPessoas");
		List<ListaPessoasResponse> pessoas = pessoaService.listaPessoas();
		log.info("[finaliza] PessoaController - listaPessoas");
		return pessoas;
	}

	@Override
	public ConsultaPessoaResponse consultaPessoaAtravesId(UUID idPessoa) {
		log.info("[inicia] PessoaController - consultaPessoaAtravesId");
		log.info("[idPessoa] {}", idPessoa);
		log.info("[inicia] PessoaController - consultaPessoaAtravesId");
		return null;
	}
}
