package br.com.fabricadeprogramador.fdpapp1;

import java.io.Serializable;

/**
 * Created by viniciuspodi on 10/11/16.
 */

public class Pessoa implements Serializable{

    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private Integer imagem;

    public Pessoa() {
    }

    public Pessoa(String nome, String telefone, String email, Integer imagem) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.imagem = imagem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getImagem() {
        return imagem;
    }

    public void setImagem(Integer imagem) {
        this.imagem = imagem;
    }
}
