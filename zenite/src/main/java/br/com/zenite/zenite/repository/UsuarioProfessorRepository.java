package br.com.zenite.zenite.repository;

import br.com.zenite.zenite.model.UsuarioProfessorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioProfessorRepository extends JpaRepository <UsuarioProfessorModel, Long> {

   /* public List<CursoModel> findAllByCursoContainingIgnoreCase(String curso ); */

    public Optional<UsuarioProfessorModel> findByEmail(String usuario);

}
