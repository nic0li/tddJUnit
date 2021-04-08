package org.generation.tddJUnit.repository;

import java.util.List;

import org.generation.tddJUnit.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
	
	public Contato findFirstByNome(String nome);
	
	public List<Contato> findAllByNomeContainingIgnoreCase(String nome);

}
