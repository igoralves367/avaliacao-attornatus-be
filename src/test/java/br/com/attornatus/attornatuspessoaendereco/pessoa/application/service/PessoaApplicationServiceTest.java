package br.com.attornatus.attornatuspessoaendereco.pessoa.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import br.com.attornatus.attornatuspessoaendereco.endereco.application.repository.EnderecoRepository;
import br.com.attornatus.attornatuspessoaendereco.pessoa.application.api.requests.PessoaRequest;
import br.com.attornatus.attornatuspessoaendereco.pessoa.application.api.responses.PessoaResponse;
import br.com.attornatus.attornatuspessoaendereco.pessoa.application.repository.PessoaRepository;
import br.com.attornatus.attornatuspessoaendereco.pessoa.domain.Pessoa;
@ExtendWith(MockitoExtension.class)
class PessoaApplicationServiceTest {
	
	@InjectMocks
    private PessoaApplicationService pessoaApplicationService;

    @Mock
    private PessoaRepository pessoaRepository;

    @Mock
    private EnderecoRepository enderecoRepository;

    @Test
    public void testCriaPessoa() {
        PessoaRequest pessoaRequest = new PessoaRequest("Igor Alves", LocalDate.of(1997, 6, 3));
        UUID pessoaId = UUID.randomUUID();
        Pessoa pessoa = mock(Pessoa.class);
        when(pessoa.getIdPessoa()).thenReturn(pessoaId);
        when(pessoaRepository.salva(any(Pessoa.class))).thenReturn(pessoa);

        PessoaResponse pessoaResponse = pessoaApplicationService.criaPessoa(pessoaRequest);

        verify(pessoaRepository).salva(any(Pessoa.class));
        assertEquals(pessoaId, pessoaResponse.getIdPessoa());
    }
}