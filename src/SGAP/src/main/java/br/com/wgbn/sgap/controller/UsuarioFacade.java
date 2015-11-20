package br.com.wgbn.sgap.controller;

import br.com.wgbn.sgap.dao.UsuarioDAO;
import br.com.wgbn.sgap.entity.UsuarioEntity;
import br.com.wgbn.sgap.util.FacadeEntityManager;
import br.com.wgbn.sgap.util.Navegacao;

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
    private FacadeEntityManager fEntityManager = null;
    private UsuarioDAO usuarioDao = null;

    public UsuarioFacade() {
        if (this.fEntityManager == null)
            this.fEntityManager = new FacadeEntityManager("wgbn");

        if (this.usuarioDao == null && this.fEntityManager != null)
            this.usuarioDao = new UsuarioDAO(this.fEntityManager.getEntityManager());

        //this.preencheUsuarios();
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
        this.usuarios = this.usuarioDao.getTodos();
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
            usr.setNome("Walter Gandarella "+i);
            usr.setTelefoneCelular("(71) 99205-3595");
            usr.setTelefoneFixo("(71) 3508-0443");
            usr.setEmail("walter.wgbn@gmail.com");
            usr.setGerente(1);

            this.usuarios.add(usr);
        }
    }

    public void actionUsuariosCadastrar(){
        this.usuario = new UsuarioEntity();
        Navegacao.navegarPara("usuarios/usuariosCadastrar.xhtml");
    }
}