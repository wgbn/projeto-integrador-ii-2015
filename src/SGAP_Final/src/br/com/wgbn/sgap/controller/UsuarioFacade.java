package br.com.wgbn.sgap.controller;

import br.com.wgbn.sgap.dao.UsuarioDAO;
import br.com.wgbn.sgap.entity.UsuarioEntity;
import br.com.wgbn.sgap.model.UsuarioModel;
import br.com.wgbn.sgap.util.FacadeEntityManager;
import br.com.wgbn.sgap.util.Navegacao;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Walter Gandarella
 */
@ManagedBean
@SessionScoped
public class UsuarioFacade {

    private List<UsuarioEntity> usuarios = new LinkedList<UsuarioEntity>();
    private UsuarioModel model;
    private UsuarioDAO dao;

    public UsuarioFacade(){
        if (this.dao == null && MainApp.getFacadeEntityManager() != null)
            this.dao = new UsuarioDAO(MainApp.getFacadeEntityManager().getEntityManager());
        model = new UsuarioModel(dao);
    }

    /**
     * ### Getters & Setters
     */

    public UsuarioModel getModel() {
        return this.model;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.model.setEntity(usuario);
    }

    public UsuarioEntity getUsuario(){
        return this.model.getEntity();
    }

    public List<UsuarioEntity> getUsuarios() {
        this.usuarios = this.model.getDao().getTodos();
        return this.usuarios;
    }

    public void setUsuarios(List<UsuarioEntity> usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * ### Funções do facade
     */

    public void actionUsuariosCadastrar(){
        this.model.setEntity(new UsuarioEntity());
        this.model.setResenha(new String());
        this.model.getEntity().setDatacriacao(new Timestamp(new Date().getTime()));
        Navegacao.navegarPara("usuarios/usuariosCadastrar.xhtml");
    }

    public void cadastrarUsuario(){
        if (this.model.validarSenha()) {
            this.model.getDao().salvar(this.model.getEntity());
            Navegacao.navegarPara("usuarios/usuariosListar.xhtml");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "O usuário foi cadstrado com sucesso!"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atenção!", "As senhas não conferem"));
        }
    }

    public void atualizarUsuario(){
        this.model.getDao().alterar(this.model.getEntity());
        Navegacao.navegarPara("usuarios/usuariosListar.xhtml");
    }
}