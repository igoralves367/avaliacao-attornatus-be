package br.com.attornatus.attornatuspessoaendereco.pessoa.application.service;

import org.springframework.stereotype.Service;

import br.com.attornatus.attornatuspessoaendereco.pessoa.application.api.requests.PessoaRequest;
import br.com.attornatus.attornatuspessoaendereco.pessoa.application.api.responses.PessoaResponse;
import br.com.attornatus.attornatuspessoaendereco.pessoa.application.repository.PessoaRepository;
import br.com.attornatus.attornatuspessoaendereco.pessoa.domain.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Service
@Log4j2
@RequiredArgsConstructor
public class PessoaApplicationService implements PessoaService {
	private final PessoaRepository pessoaRepository;

	@Override
	public PessoaResponse criaPessoa(PessoaRequest pessoaRequest) {
		log.info("[inicia] PessoaApplicationService - criaPessoa");
		Pessoa pessoa = pessoaRepository.salva(new Pessoa(pessoaRequest));
		log.info("[finaliza] PessoaApplicationService - criaPessoa");
		return PessoaResponse.builder()
				.idPessoa(pessoa.getIdPessoa())
				.build();
	}
}
