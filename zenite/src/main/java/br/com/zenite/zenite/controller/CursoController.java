package br.com.zenite.zenite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zenite.zenite.model.CursoModel;
import br.com.zenite.zenite.model.PostagemModel;
import br.com.zenite.zenite.repository.CursoRepository;

@RestController
@RequestMapping("/cursos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CursoController {
	
	@Autowired
	private CursoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<CursoModel>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<CursoModel>> getByTitulo(@PathVariable String titulo) {
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	@PostMapping
	public ResponseEntity<CursoModel> post(@RequestBody CursoModel curso) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(curso));
	}

	@PutMapping
	public ResponseEntity<CursoModel> put(@RequestBody CursoModel curso) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(curso));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}

}
