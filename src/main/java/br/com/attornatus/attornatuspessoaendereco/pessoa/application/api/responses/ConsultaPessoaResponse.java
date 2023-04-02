package br.com.attornatus.attornatuspessoaendereco.pessoa.application.api.responses;

import java.time.LocalDate;
import java.util.UUID;

import br.com.attornatus.attornatuspessoaendereco.endereco.domain.entities.Endereco;
import br.com.attornatus.attornatuspessoaendereco.pessoa.domain.Pessoa;
import lombok.Value;
@Value
public class ConsultaPessoaResponse {
	private UUID idPessoa;
	private String nomeCompleto;
	private LocalDate dataNascimento;
	private Endereco enderecoPrincipal;
	
	public ConsultaPessoaResponse(Pessoa pessoa, Endereco enderecoPrincipal) {
		this.idPessoa = pessoa.getIdPessoa();
		this.nomeCompleto = pessoa.getNomeCompleto();
		this.dataNascimento = pessoa.getDataNascimento();
		this.enderecoPrincipal = enderecoPrincipal;
	}
}
