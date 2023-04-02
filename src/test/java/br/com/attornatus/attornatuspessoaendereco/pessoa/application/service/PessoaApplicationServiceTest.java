package br.com.attornatus.attornatuspessoaendereco.pessoa.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.attornatus.attornatuspessoaendereco.endereco.application.repository.EnderecoRepository;
import br.com.attornatus.attornatuspessoaendereco.pessoa.application.api.requests.EditaPessoaRequest;
import br.com.attornatus.attornatuspessoaendereco.pessoa.application.api.requests.PessoaRequest;
import br.com.attornatus.attornatuspessoaendereco.pessoa.application.api.responses.ListaPessoasResponse;
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
    
    @Test
    public void testListaPessoas() {
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("Igor Alves"));
        pessoas.add(new Pessoa("Ester Alves"));

        when(pessoaRepository.listaPessoas()).thenReturn(pessoas);

        List<ListaPessoasResponse> listaPessoasResponse = pessoaApplicationService.listaPessoas();

        assertEquals(pessoas.size(), listaPessoasResponse.size());
        assertEquals(pessoas.get(0).getNomeCompleto(), listaPessoasResponse.get(0).getNomeCompleto());
        assertEquals(pessoas.get(1).getNomeCompleto(), listaPessoasResponse.get(1).getNomeCompleto());
    }
    
    @Test
    public void testEditaPessoa() {
        UUID idPessoa = UUID.randomUUID();
        EditaPessoaRequest editaPessoaRequest = new EditaPessoaRequest("Igor Alves", LocalDate.of(1997, 6, 3));
        
        Pessoa pessoa = new Pessoa();
        pessoa.setIdPessoa(idPessoa);
        pessoa.setNomeCompleto("Igor Alves Martins");
        pessoa.setDataNascimento(LocalDate.of(1990, 1, 1));
        
        when(pessoaRepository.consultaPessoaAtravesId(idPessoa)).thenReturn(pessoa);

        pessoaApplicationService.editaPessoa(idPessoa, editaPessoaRequest);

        verify(pessoaRepository).salva(pessoa);

        assertEquals(editaPessoaRequest.getNomeCompleto(), pessoa.getNomeCompleto());
        assertEquals(editaPessoaRequest.getDataNascimento(), pessoa.getDataNascimento());
    }
}