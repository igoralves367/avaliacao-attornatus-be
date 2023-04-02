package br.com.attornatus.attornatuspessoaendereco.endereco.application.api;

import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.attornatus.attornatuspessoaendereco.endereco.application.api.requests.EnderecoRequest;
import br.com.attornatus.attornatuspessoaendereco.endereco.application.api.responses.EnderecoResponse;
import br.com.attornatus.attornatuspessoaendereco.endereco.application.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Log4j2
@RestController
@RequiredArgsConstructor
public class EnderecoController implements EnderecoAPI {
	private final EnderecoService enderecoService;

	@Override
	public EnderecoResponse criaEndereco(UUID idPessoa, EnderecoRequest enderecoRequest) {
		log.info("[inicia] EnderecoController - criaEndereco");
		log.info("[idPessoa] {}", idPessoa);
		EnderecoResponse endereco = enderecoService
				.criaEndereco(idPessoa, enderecoRequest);
		log.info("[inicia] EnderecoController - criaEndereco");
		return endereco;
	}
}
