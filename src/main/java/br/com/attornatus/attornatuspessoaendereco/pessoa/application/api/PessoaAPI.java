package br.com.attornatus.attornatuspessoaendereco.pessoa.application.api;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.attornatus.attornatuspessoaendereco.pessoa.application.api.requests.PessoaRequest;
import br.com.attornatus.attornatuspessoaendereco.pessoa.application.api.responses.PessoaResponse;

@RestController
@RequestMapping("/v1/pessoa")
public interface PessoaAPI {
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	PessoaResponse postPessoa(@Valid @RequestBody PessoaRequest pessoaRequest);
}
