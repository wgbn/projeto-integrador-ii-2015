package br.com.wgbn.sgap.controller;

import br.com.wgbn.sgap.entity.UsuarioEntity;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Walter Gandarella
 */
@ManagedBean
@SessionScoped
public class UsuarioFacade {

    private List<UsuarioEntity> usuarios = new LinkedList<UsuarioEntity>();
    private UsuarioEntity usuario;

    public UsuarioFacade() {
        this.preencheUsuarios();
    }

    /**
     * ### Getters & Setters
     */

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public List<UsuarioEntity> getUsuarios() {
        return this.usuarios;
    }

    public void setUsuarios(List<UsuarioEntity> usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * ### Funções do facade
     */

    private void preencheUsuarios(){
        UsuarioEntity usr;
        for (int i = 1; i < 11; i++){
            usr = new UsuarioEntity();
            usr.setId(i);
            usr.setNome("Walter Gandarella");
            usr.setTelefoneCelular("(71) 99205-3595");
            usr.setTelefoneFixo("(71) 3508-0443");
            usr.setEmail("walter.wgbn@gmail.com");
            usr.setGerente(true);

            this.usuarios.add(usr);
        }
    }

    public String editarUsuario(){
        return "editarUsuario";
    }

    public String acoesUsuario(){
        return "acoesUsuario";
    }
}