package org.generation.tddJUnit.contato;

import org.generation.tddJUnit.model.Contato;
import org.generation.tddJUnit.repository.ContatoRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ContatoIntegrationTest {
	
	private Contato contato;
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	String message = "Employee ID is null";
	
	@Before 
	public void start() { 
		contato = new Contato("Gabriel", "011y", "9xxxxxxx9");
	}
	
	@Rule 
	public ExpectedException excecaoEsperada = ExpectedException.none();
	
	@Test //(expected = RuntimeException.class)
	public void salvarComTelefoneNulo() throws Exception {
		
		//excecaoEsperada.expect(ConstraintViolationException.class);
		//excecaoEsperada.expectMessage("O campo telefone deve ser preenchido.");
		
		contato.setTelefone(null);
		contatoRepository.save(contato);
		
	}
	
	@Test //(expected = RuntimeException.class)
	public void salvarComDddNulo() throws Exception {
		
		//excecaoEsperada.expect(ConstraintViolationException.class);
		//excecaoEsperada.expectMessage("O campo DDD deve ser preenchido.");
		
		contato.setDdd(null);
		contatoRepository.save(contato);
		
	}
	
	@Test //(expected = RuntimeException.class)
	public void salvarComNomeNulo() throws Exception {
		
		//excecaoEsperada.expect(ConstraintViolationException.class);
		//excecaoEsperada.expectMessage("O campo nome deve ser preenchido.");
		
		contato.setNome(null); 
		contatoRepository.save(contato);
		
	}

	

}
