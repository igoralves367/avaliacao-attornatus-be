package br.com.attornatus.attornatuspessoaendereco.pessoa.application.api;

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

import br.com.attornatus.attornatuspessoaendereco.pessoa.application.api.requests.PessoaRequest;
import br.com.attornatus.attornatuspessoaendereco.pessoa.application.api.responses.ConsultaPessoaResponse;
import br.com.attornatus.attornatuspessoaendereco.pessoa.application.api.responses.ListaPessoasResponse;
import br.com.attornatus.attornatuspessoaendereco.pessoa.application.api.responses.PessoaResponse;

@RestController
@RequestMapping("/v1/pessoa")
public interface PessoaAPI {
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	PessoaResponse postPessoa(@Valid @RequestBody PessoaRequest pessoaRequest);
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<ListaPessoasResponse> listaPessoas();
	
	@GetMapping(value = "/{idPessoa}")
	@ResponseStatus(code = HttpStatus.OK)
	ConsultaPessoaResponse consultaPessoaAtravesId(@PathVariable UUID idPessoa);
}
