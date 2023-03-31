package br.com.attornatus.attornatuspessoaendereco.pessoa.application.api.responses;

import java.time.LocalDate;
import java.util.UUID;
import lombok.Value;
@Value
public class ListaPessoasResponse {
	private UUID idPessoa;
	private String nomeCompleto;
	private LocalDate dataNascimento;
}
