package br.com.attornatus.attornatuspessoaendereco.endereco.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.attornatus.attornatuspessoaendereco.endereco.application.repository.EnderecoRepository;
import br.com.attornatus.attornatuspessoaendereco.endereco.domain.entities.Endereco;
import br.com.attornatus.attornatuspessoaendereco.endereco.domain.enums.TipoEndereco;
import br.com.attornatus.attornatuspessoaendereco.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Repository
@Log4j2
@RequiredArgsConstructor
public class EnderecoInfraRepository implements EnderecoRepository {
	private final EnderecoSpringDataJPARepository enderecoSpringDataJPARepository; 

	@Override
	public Endereco salvaEndereco(Endereco endereco) {
		log.info("[inicia] EnderecoInfraRepository - salvaEndereco");
		try {
	        enderecoSpringDataJPARepository.save(endereco);
	    } catch (DataIntegrityViolationException e) {
	    	throw APIException.build(HttpStatus.BAD_REQUEST, "Endereço com esse lagradouro, já foi cadastrado", e);
		}
		log.info("[finaliza] EnderecoInfraRepository - salvaEndereco");
		return endereco;
	}

	@Override
	public List<Endereco> listaEnderecosDaPessoa(UUID idPessoa) {
		log.info("[inicia] EnderecoInfraRepository - listaEnderecosDaPessoa");
		List<Endereco> todosEnderecos = enderecoSpringDataJPARepository.findAll();
		log.info("[finaliza] EnderecoInfraRepository - listaEnderecosDaPessoa");
		return todosEnderecos;
	}

	@Override
	public Endereco findEnderecoPrincipal(UUID idPessoa, TipoEndereco principal) {
		log.info("[inicia] EnderecoInfraRepository - findEnderecoPrincipal");
	    Endereco endereco = enderecoSpringDataJPARepository.findByIdPessoaCadastroAndTipoEndereco(idPessoa, principal);
	    log.info("[finaliza] EnderecoInfraRepository - findEnderecoPrincipal");
	    return endereco;
	}
}
