package br.com.zenite.zenite.repository;

import br.com.zenite.zenite.model.CursoModel;
import br.com.zenite.zenite.model.UsuarioProfessorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioProfessorRepository extends JpaRepository <UsuarioProfessorModel, Long> {

   public List<CursoModel> findAllByCursoContainingIgnoreCase(String curso );
   
   public List<UsuarioProfessorModel> findAllByNomeContainingIgnoreCase(String nome);

   public Optional<UsuarioProfessorModel> findByEmail(String usuario);

}
