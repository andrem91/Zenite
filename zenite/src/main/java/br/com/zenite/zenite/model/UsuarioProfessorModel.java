package br.com.zenite.zenite.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table (name = "tb_usuarioProfessor")
public class UsuarioProfessorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(min=2, max=80)
    private String nome;

    @NotBlank
    @Size(min=2, max=80)
    @Email
    private String email;

    @NotBlank
    @Size (min=6)
    private String senha;

    @OneToMany(mappedBy = "usuarioProfessor", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("usuarioProfessor")
    private List<PostagemModel> postagem;

	@OneToMany (mappedBy = "usuarioProfessor", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties ("usuarioProfessor")
	private List<CursoModel> curso;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<PostagemModel> getPostagem() {
        return postagem;
    }

    public void setPostagem(List<PostagemModel> postagem) {
        this.postagem = postagem;
    }

   /* public List<CursoModel> getCurso() {
        return curso;
    }

    public void setPostagem(List<CursoModel> curso) {
        this.curso = curso;
    } */
}