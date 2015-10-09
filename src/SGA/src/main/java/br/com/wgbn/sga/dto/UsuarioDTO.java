package br.com.wgbn.sga.dto;

/**
 * Classe DTO para mapear a tabela Usuario
 * @author Walter Gandarella
 */
public class UsuarioDTO {
    

    private int id;
    
    private String nome;
    
    private TipoUsuarioDTO tipo;
    
    private String email;

    public UsuarioDTO() {
    }

    public UsuarioDTO(int id, String nome, TipoUsuarioDTO tipo, String email) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoUsuarioDTO getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuarioDTO tipo) {
        this.tipo = tipo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
