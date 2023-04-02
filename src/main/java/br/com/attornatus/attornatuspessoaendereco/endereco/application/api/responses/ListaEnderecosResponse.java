package br.com.attornatus.attornatuspessoaendereco.endereco.application.api.responses;

import java.util.UUID;
import br.com.attornatus.attornatuspessoaendereco.endereco.domain.entities.Endereco;
import br.com.attornatus.attornatuspessoaendereco.endereco.domain.enums.TipoEndereco;
import lombok.Value;
@Value
public class ListaEnderecosResponse {
	private UUID idEndereco;
	private String lagradouro;
	private String cep;
	private String numero;
	private String cidade;
	private TipoEndereco tipoEndereco;
	
	public ListaEnderecosResponse(Endereco endereco) {
		this.idEndereco = endereco.getIdEndereco();
		this.lagradouro = endereco.getLagradouro();
		this.cep = endereco.getCep();
		this.numero = endereco.getNumero();
		this.cidade = endereco.getCidade();
		this.tipoEndereco = endereco.getTipoEndereco();
	}	
}
