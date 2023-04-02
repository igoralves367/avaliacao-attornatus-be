package br.com.attornatus.attornatuspessoaendereco.pessoa.application.api.responses;

import java.util.UUID;
import lombok.Builder;
import lombok.Value;
@Value
@Builder
public class PessoaResponse {
	private UUID idPessoa;
}
