package br.com.attornatus.attornatuspessoaendereco.pessoa.application.api.responses;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import br.com.attornatus.attornatuspessoaendereco.pessoa.domain.Pessoa;
import lombok.Value;
@Value
public class ListaPessoasResponse {
	private UUID idPessoa;
	private String nomeCompleto;
	private LocalDate dataNascimento;
	
	public static List<ListaPessoasResponse> converte(List<Pessoa> pessoas) {
		// TODO Auto-generated method stub
		return null;
	}
}
