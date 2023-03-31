package br.com.attornatus.attornatuspessoaendereco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@SpringBootApplication
public class AttornatusPessoaEnderecoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AttornatusPessoaEnderecoApplication.class, args);
	}
}
