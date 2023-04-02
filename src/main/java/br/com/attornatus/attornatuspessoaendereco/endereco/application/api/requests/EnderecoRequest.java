package br.com.attornatus.attornatuspessoaendereco.endereco.application.api.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import br.com.attornatus.attornatuspessoaendereco.endereco.domain.enums.TipoEndereco;
import lombok.Value;
@Value
public class EnderecoRequest {
	
	@NotBlank
	private String lagradouro;
	@NotBlank
	private String cep;
	@NotBlank
	private String numero;
	@NotBlank
	private String cidade;
	@NotNull
	private TipoEndereco tipoEndereco;
}
