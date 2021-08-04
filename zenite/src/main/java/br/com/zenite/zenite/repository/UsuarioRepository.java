package br.com.zenite.zenite.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.zenite.zenite.model.UsuarioModel;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
	
	public List<UsuarioModel> findAllByNomeContainingIgnoreCase(String nome);

}
