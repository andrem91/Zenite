package br.com.zenite.zenite.controller;

import br.com.zenite.zenite.model.UsuarioModel;
import br.com.zenite.zenite.model.UsuarioProfessorLogin;
import br.com.zenite.zenite.model.UsuarioProfessorModel;
import br.com.zenite.zenite.repository.UsuarioProfessorRepository;
import br.com.zenite.zenite.service.UsuarioProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuarioProfessor")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioProfessorController {

    @Autowired
    private UsuarioProfessorRepository repository;

    @Autowired
    private UsuarioProfessorService service;

    @GetMapping ("/logar")
    public ResponseEntity<UsuarioProfessorLogin> authentication(@RequestBody Optional<UsuarioProfessorLogin> professorLogin){
        return service.LogarUsuarioProfessor (professorLogin).map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Optional<UsuarioProfessorModel>> post(@RequestBody UsuarioProfessorModel usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrarUsuarioProfessor(usuario));
        
    }
}



