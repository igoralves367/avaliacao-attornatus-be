package br.com.attornatus.attornatuspessoaendereco.endereco.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.attornatus.attornatuspessoaendereco.endereco.application.api.requests.EnderecoRequest;
import br.com.attornatus.attornatuspessoaendereco.endereco.application.api.responses.EnderecoResponse;
import br.com.attornatus.attornatuspessoaendereco.endereco.application.repository.EnderecoRepository;
import br.com.attornatus.attornatuspessoaendereco.endereco.domain.entities.Endereco;
import br.com.attornatus.attornatuspessoaendereco.pessoa.application.api.responses.ConsultaPessoaResponse;
import br.com.attornatus.attornatuspessoaendereco.pessoa.application.service.PessoaService;
import br.com.attornatus.attornatuspessoaendereco.pessoa.domain.Pessoa;
@ExtendWith(MockitoExtension.class)
class EnderecoApplicationServiceTest {
	
	@InjectMocks
    private EnderecoApplicationService enderecoApplicationService;

    @Mock
    private PessoaService pessoaService;

    @Mock
    private EnderecoRepository enderecoRepository;

	@Test
	public void testCriaEndereco() {
	    UUID idPessoa = UUID.randomUUID();
	    EnderecoRequest enderecoRequest = new EnderecoRequest("Av Gorvedador Valadares", "45820075", "308", "Eunapolis");
	    Endereco endereco = new Endereco(idPessoa, enderecoRequest);
	    @SuppressWarnings("unused")
		UUID idEnderco = UUID.randomUUID();
	    
	    ConsultaPessoaResponse consultaPessoaResponse = new ConsultaPessoaResponse(new Pessoa(), endereco);
	    when(pessoaService.consultaPessoaAtravesId(idPessoa)).thenReturn(consultaPessoaResponse);
	    when(enderecoRepository.salvaEndereco(any(Endereco.class))).thenReturn(endereco);

	    EnderecoResponse enderecoResponse = enderecoApplicationService.criaEndereco(idPessoa, enderecoRequest);

	    verify(pessoaService).consultaPessoaAtravesId(idPessoa);
	    verify(enderecoRepository).salvaEndereco(any(Endereco.class));
	    assertEquals(endereco.getIdEndereco(), enderecoResponse.getIdEndereco());
	}
}
