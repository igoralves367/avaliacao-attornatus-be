package br.com.attornatus.attornatuspessoaendereco.endereco.application.service;

import java.util.List;
import java.util.UUID;
import br.com.attornatus.attornatuspessoaendereco.endereco.application.api.requests.EnderecoRequest;
import br.com.attornatus.attornatuspessoaendereco.endereco.application.api.responses.EnderecoResponse;
import br.com.attornatus.attornatuspessoaendereco.endereco.application.api.responses.ListaEnderecosResponse;

public interface EnderecoService {
	EnderecoResponse criaEndereco(UUID idPessoa, EnderecoRequest enderecoRequest);
	List<ListaEnderecosResponse> listaEnderecosDaPessoa(UUID idPessoa);
}
