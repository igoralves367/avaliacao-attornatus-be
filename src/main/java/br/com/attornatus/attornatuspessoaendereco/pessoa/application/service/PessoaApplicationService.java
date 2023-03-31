package br.com.attornatus.attornatuspessoaendereco.pessoa.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.attornatus.attornatuspessoaendereco.pessoa.application.api.requests.EditaPessoaRequest;
import br.com.attornatus.attornatuspessoaendereco.pessoa.application.api.requests.PessoaRequest;
import br.com.attornatus.attornatuspessoaendereco.pessoa.application.api.responses.ConsultaPessoaResponse;
import br.com.attornatus.attornatuspessoaendereco.pessoa.application.api.responses.ListaPessoasResponse;
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

	@Override
	public List<ListaPessoasResponse> listaPessoas() {
		log.info("[inicia] PessoaApplicationService - listaPessoas");
		List<Pessoa> pessoas = pessoaRepository.listaPessoas();
		log.info("[finaliza] PessoaApplicationService - listaPessoas");
		return ListaPessoasResponse.converte(pessoas);
	}

	@Override
	public ConsultaPessoaResponse consultaPessoaAtravesId(UUID idPessoa) {
		log.info("[inicia] PessoaApplicationService - consultaPessoaAtravesId");
		Pessoa pessoa = pessoaRepository.consultaPessoaAtravesId(idPessoa);
		log.info("[finaliza] PessoaApplicationService - consultaPessoaAtravesId");
		return new ConsultaPessoaResponse(pessoa);
	}

	@Override
	public void editaPessoa(UUID idPessoa, EditaPessoaRequest editaPessoaRequest) {
		log.info("[inicia] PessoaApplicationService - editaPessoa");		
		Pessoa pessoa = pessoaRepository.consultaPessoaAtravesId(idPessoa);
		pessoa.edita(editaPessoaRequest);
		pessoaRepository.salva(pessoa);
		log.info("[finaliza] PessoaApplicationService - editaPessoa");	
	}
}
