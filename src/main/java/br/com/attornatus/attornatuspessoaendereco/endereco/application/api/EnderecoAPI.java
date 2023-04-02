package br.com.attornatus.attornatuspessoaendereco.endereco.application.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.attornatus.attornatuspessoaendereco.endereco.application.api.requests.EnderecoRequest;
import br.com.attornatus.attornatuspessoaendereco.endereco.application.api.responses.EnderecoResponse;
import br.com.attornatus.attornatuspessoaendereco.endereco.application.api.responses.ListaEnderecosResponse;

@RestController
@RequestMapping("/v1/endereco")
public interface EnderecoAPI {
	
	@PostMapping(value = "/{idPessoa}")
	@ResponseStatus(code = HttpStatus.CREATED)
	EnderecoResponse criaEndereco(@PathVariable UUID idPessoa, 
			@Valid @RequestBody EnderecoRequest enderecoRequest);
	
	@GetMapping(value = "/{idPessoa}")
	@ResponseStatus(code = HttpStatus.OK)
	List<ListaEnderecosResponse> listaEnderecosDaPessoa(@PathVariable UUID idPessoa);
}
