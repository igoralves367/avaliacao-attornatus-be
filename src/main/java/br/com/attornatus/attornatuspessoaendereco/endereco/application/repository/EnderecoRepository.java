package br.com.attornatus.attornatuspessoaendereco.endereco.application.repository;

import java.util.List;
import java.util.UUID;
import br.com.attornatus.attornatuspessoaendereco.endereco.domain.entities.Endereco;
import br.com.attornatus.attornatuspessoaendereco.endereco.domain.enums.TipoEndereco;

public interface EnderecoRepository {
	Endereco salvaEndereco(Endereco endereco);
	List<Endereco> listaEnderecosDaPessoa(UUID idPessoa);
	Endereco findEnderecoPrincipal(UUID idPessoa, TipoEndereco principal);
}
