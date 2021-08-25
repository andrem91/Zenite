package br.com.zenite.zenite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zenite.zenite.model.CursoModel;

@Repository
public interface CursoRepository extends JpaRepository<CursoModel, Long> {
	
	public List<CursoModel> findAllByTituloContainingIgnoreCase (String titulo);

}
