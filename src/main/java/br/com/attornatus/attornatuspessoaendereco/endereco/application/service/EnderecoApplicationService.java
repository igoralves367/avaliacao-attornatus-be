package br.com.attornatus.attornatuspessoaendereco.endereco.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.attornatus.attornatuspessoaendereco.endereco.application.api.requests.EnderecoRequest;
import br.com.attornatus.attornatuspessoaendereco.endereco.application.api.responses.EnderecoResponse;
import br.com.attornatus.attornatuspessoaendereco.endereco.application.api.responses.ListaEnderecosResponse;
import br.com.attornatus.attornatuspessoaendereco.endereco.application.repository.EnderecoRepository;
import br.com.attornatus.attornatuspessoaendereco.endereco.domain.entities.Endereco;
import br.com.attornatus.attornatuspessoaendereco.pessoa.application.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Service
@Log4j2
@RequiredArgsConstructor
public class EnderecoApplicationService implements EnderecoService {
	private final PessoaService pessoaService;
	private final EnderecoRepository enderecoRepository; 

	@Override
	public EnderecoResponse criaEndereco(UUID idPessoa, EnderecoRequest enderecoRequest) {
		log.info("[inicia] EnderecoApplicationService - criaEndereco");
		pessoaService.consultaPessoaAtravesId(idPessoa);
		Endereco endereco = enderecoRepository
				.salvaEndereco(new Endereco(idPessoa, enderecoRequest));
		log.info("[finaliza] EnderecoApplicationService - criaEndereco");
		return new EnderecoResponse(endereco.getIdEndereco());
	}

	@Override
	public List<ListaEnderecosResponse> listaEnderecosDaPessoa(UUID idPessoa) {
		log.info("[inicia] EnderecoApplicationService - listaEnderecosDaPessoa");
		pessoaService.consultaPessoaAtravesId(idPessoa);
		List<Endereco> enderecos = enderecoRepository.listaEnderecosDaPessoa(idPessoa);
		log.info("[finaliza] EnderecoApplicationService - listaEnderecosDaPessoa");
		return ListaEnderecosResponse.converte(enderecos);
	}
}
