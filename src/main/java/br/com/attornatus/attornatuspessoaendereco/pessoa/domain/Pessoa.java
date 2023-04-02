package br.com.attornatus.attornatuspessoaendereco.pessoa.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.attornatus.attornatuspessoaendereco.pessoa.application.api.requests.EditaPessoaRequest;
import br.com.attornatus.attornatuspessoaendereco.pessoa.application.api.requests.PessoaRequest;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Entity
@Data
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", name = "id", updatable = false, unique = true, nullable = false)
	private UUID idPessoa;
	@NotBlank
	private String nomeCompleto;
	@NotNull
	private LocalDate dataNascimento;
	
	private LocalDateTime dataHoraDoCadastro;
	private LocalDateTime dataHoraDaUltimaAlteracao;
	
	public Pessoa(PessoaRequest pessoaRequest) {
		this.nomeCompleto = pessoaRequest.getNomeCompleto();
		this.dataNascimento = pessoaRequest.getDataNascimento();
		this.dataHoraDoCadastro = LocalDateTime.now();
	}

	public void edita(EditaPessoaRequest editaPessoaRequest) {
		this.nomeCompleto = editaPessoaRequest.getNomeCompleto();
		this.dataNascimento = editaPessoaRequest.getDataNascimento();
		this.dataHoraDaUltimaAlteracao = LocalDateTime.now();
	}

	public Pessoa(String string) {
		this.nomeCompleto = string;
	}
}
