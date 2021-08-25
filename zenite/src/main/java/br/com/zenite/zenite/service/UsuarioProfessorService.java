package br.com.zenite.zenite.service;

import br.com.zenite.zenite.model.UsuarioProfessorLogin;
import br.com.zenite.zenite.model.UsuarioProfessorModel;
import br.com.zenite.zenite.repository.UsuarioProfessorRepository;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.nio.charset.Charset;
import java.util.Optional;

@Service
public class UsuarioProfessorService {

    @Autowired
    private UsuarioProfessorRepository repository;


    /* CADASTRAR */
    public Optional<UsuarioProfessorModel> cadastrarUsuarioProfessor (UsuarioProfessorModel usuarioProfessorCadastrar) {

        if (repository.findByEmail(usuarioProfessorCadastrar.getEmail()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario já existe.", null);
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String senhaEncoder = encoder.encode(usuarioProfessorCadastrar.getSenha());

        usuarioProfessorCadastrar.setSenha(senhaEncoder);

        return Optional.of(repository.save(usuarioProfessorCadastrar));
    }

    /* LOGAR*/

    public Optional<UsuarioProfessorLogin> LogarUsuarioProfessor (Optional<UsuarioProfessorLogin> usuarioProfessorLogin) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        Optional<UsuarioProfessorModel> usuarioProfessor = repository.findByEmail(usuarioProfessorLogin.get().getEmail());

        if (usuarioProfessor.isPresent()) {
            if (encoder.matches(usuarioProfessorLogin.get().getSenha(), usuarioProfessor.get().getSenha())) {
                String auth = usuarioProfessorLogin.get().getEmail() + ":" + usuarioProfessorLogin.get().getSenha();
                byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
                String authHeader = "Basic " + new String(encodeAuth);

                usuarioProfessorLogin.get().setNome(usuarioProfessor.get().getNome());
                usuarioProfessorLogin.get().setSenha(usuarioProfessor.get().getSenha());
                usuarioProfessorLogin.get().setToken(authHeader);

                return usuarioProfessorLogin;
            }
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuário ou senha inválida.", null);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário não existe.", null);
    }

    /* CURSO ZENITE FAZENDO O DEPLOY*/


}
