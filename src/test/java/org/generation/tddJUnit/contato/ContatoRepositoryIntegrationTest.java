package org.generation.tddJUnit.contato;

import java.util.List;

import org.generation.tddJUnit.model.Contato;
import org.generation.tddJUnit.repository.ContatoRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContatoRepositoryIntegrationTest {
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	@Before
	public void start() {
		
		Contato contato = new Contato("Chefe", "0y", "9xxxxxxx9");
		if (contatoRepository.findFirstByNome(contato.getNome()) == null)
			contatoRepository.save(contato);
		
		contato = new Contato("Novo Chefe", "0y", "8xxxxxxx8");
		if (contatoRepository.findFirstByNome(contato.getNome()) == null)
			contatoRepository.save(contato);
		
		contato = new Contato("chefe Mais Antigo", "0y", "7xxxxxxx7");
		if (contatoRepository.findFirstByNome(contato.getNome()) == null)
			contatoRepository.save(contato);
		
		contato = new Contato("Amigo", "0z", "5xxxxxxx5");
		if (contatoRepository.findFirstByNome(contato.getNome()) == null)
			contatoRepository.save(contato);
		
	}
	
	@Test
	public void findByNomeRetornaContato() throws Exception {
		Contato contato = contatoRepository.findFirstByNome("Chefe");
		Assert.assertTrue(contato.getNome().equals("Chefe"));
	}
	
	@Test
	public void findAllByNomeIgnoreCaseRetornaTresContato() {
		List<Contato> contatos = contatoRepository.findAllByNomeContainingIgnoreCase("chefe");
		Assert.assertEquals(3, contatos.size());
	}
	
	@After
		public void end() {
		contatoRepository.deleteAll();
	}

}
