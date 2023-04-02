package br.com.attornatus.attornatuspessoaendereco.endereco.application.service;

import java.util.UUID;

import br.com.attornatus.attornatuspessoaendereco.endereco.application.api.requests.EnderecoRequest;
import br.com.attornatus.attornatuspessoaendereco.endereco.application.api.responses.EnderecoResponse;

public interface EnderecoService {

	EnderecoResponse criaEndereco(UUID idPessoa, EnderecoRequest enderecoRequest);
}
