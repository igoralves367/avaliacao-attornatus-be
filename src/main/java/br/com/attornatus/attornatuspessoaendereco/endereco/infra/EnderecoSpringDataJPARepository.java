package br.com.attornatus.attornatuspessoaendereco.endereco.infra;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.attornatus.attornatuspessoaendereco.endereco.domain.entities.Endereco;
import br.com.attornatus.attornatuspessoaendereco.endereco.domain.enums.TipoEndereco;

public interface EnderecoSpringDataJPARepository extends JpaRepository <Endereco, UUID> {
	Endereco findByIdPessoaCadastroAndTipoEndereco(UUID idPessoa, TipoEndereco principal);
}
