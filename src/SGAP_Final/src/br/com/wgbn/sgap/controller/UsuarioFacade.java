package br.com.wgbn.sgap.controller;

import br.com.wgbn.sgap.dao.UsuarioDAO;
import br.com.wgbn.sgap.entity.UsuarioEntity;
import br.com.wgbn.sgap.model.UsuarioModel;
import br.com.wgbn.sgap.util.Navegacao;
import br.com.wgbn.sgap.util.Utilidades;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
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
    private UsuarioModel        model;
    private UsuarioDAO          dao;

    public UsuarioFacade(){
        if (this.dao == null && MainApp.getFacadeEntityManager() != null)
            this.dao = new UsuarioDAO(MainApp.getFacadeEntityManager().getEntityManager());
        model = new UsuarioModel(dao);

        System.out.println("##-> UsuarioFacade iniciado");
    }

    /**
     * ### Getters & Setters
     */

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

    public UsuarioEntity getUsuarioLogado(){
        return this.model.getUsuarioLogado();
    }

    public void setResenha(String _resenha){
        this.model.setResenha(_resenha);
    }

    public String getResenha(){
        return this.model.getResenha();
    }

    public String getGerenteToString(UsuarioEntity usr){ return this.model.gerenteToStr(usr); }

    /**
     * ### Métodos do facade
     */

    public void aoCarregarCriarUsuario(ComponentSystemEvent event){
        if (Utilidades.isNewRequest()){
            this.model.setEntity(new UsuarioEntity());
            this.model.setResenha(new String());
            this.model.getEntity().setDatacriacao(new Timestamp(new Date().getTime()));
        }
    }

    public void cadastrarUsuario() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (this.model.validarSenha()) {
            this.model.inserirUsuario();
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

    public void apagarUsuario(){
        this.model.getDao().excluir(this.model.getEntity());
        Navegacao.navegarPara("usuarios/usuariosListar.xhtml");
    }

    public void verificaLogado(ComponentSystemEvent event){
        if (this.model.getUsuarioLogado() == null)
            Navegacao.navegarPara("usuarios/usuariosLogin.xhtml");
    }

    public void fazerLoginUsuario() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (!this.model.validarLogin())
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atenção!", "Usuário e/ou senha não conferem."));
        else
            Navegacao.navegarPara("../");
    }

    public void logOut(){
        this.model.setUsuarioLogado(null);
        this.verificaLogado(null);
    }
}