package br.com.wgbn.sgap.controller;

import br.com.wgbn.sgap.dao.UsuarioDAO;
import br.com.wgbn.sgap.entity.UsuarioEntity;
import br.com.wgbn.sgap.bo.UsuarioModel;
import br.com.wgbn.sgap.util.Navegacao;
import br.com.wgbn.sgap.util.Utilidades;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
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

    /**
     * Define um usuário selecionado
     * @param usuario Objeto contendo o usuário
     */
    public void setUsuario(UsuarioEntity usuario) {
        this.model.setEntity(usuario);
    }

    /**
     * Pega o usuário selecionado
     * @return Objeto com o usuário selecionado
     */
    public UsuarioEntity getUsuario(){
        return this.model.getEntity();
    }

    /**
     * Pega uma lista de usuários
     * @return
     */
    public List<UsuarioEntity> getUsuarios() {
        this.usuarios = this.model.getDao().getTodos();
        return this.usuarios;
    }

    /**
     * Pega o usuário logado no istema
     * @return Objeto com usuário nolago
     */
    public UsuarioEntity getUsuarioLogado(){
        return this.model.getUsuarioLogado();
    }

    /**
     * Define a senha a ser comparada
     * @param _resenha String com a senha
     */
    public void setResenha(String _resenha){
        this.model.setResenha(_resenha);
    }

    /**
     * Pega a senha a ser comparada
     * @return
     */
    public String getResenha(){
        return this.model.getResenha();
    }

    /**
     * Converte a Flag de gerencia em uma flag légivel
     * @param usr Objeto com o usuário a ser convertido
     * @return 'Sim' ou 'Não'
     */
    public String getGerenteToString(UsuarioEntity usr){ return this.model.gerenteToStr(usr); }

    /**
     * ### Métodos do facade
     */

    /**
     * Ação executada ao carregar determinada página
     * Ŕ responsável por inicializar um Objeto usuario
     * @param event
     */
    public void aoCarregarCriarUsuario(ComponentSystemEvent event){
        if (Utilidades.isNewRequest()){
            this.model.setEntity(new UsuarioEntity());
            this.model.setResenha(new String());
            this.model.getEntity().setDatacriacao(new Timestamp(new Date().getTime()));
        }
    }

    /**
     * Faz o cadastro de um usuário e persiste no banco
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public void cadastrarUsuario() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (this.model.validarSenha()) {
            this.model.inserirUsuario();
            Navegacao.navegarPara("usuarios/usuariosListar.xhtml");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "O usuário foi cadstrado com sucesso!"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atenção!", "As senhas não conferem"));
        }
    }

    /**
     * Atualiza um usuário do banco
     */
    public void atualizarUsuario(){
        this.model.getDao().alterar(this.model.getEntity());
        Navegacao.navegarPara("usuarios/usuariosListar.xhtml");
    }

    /**
     * Remove um usuário do banco
     */
    public void apagarUsuario(){
        this.model.getDao().excluir(this.model.getEntity());
        Navegacao.navegarPara("usuarios/usuariosListar.xhtml");
    }

    /**
     * Verifica se há um usuário logado
     * Caso não exista, envia para tela de login
     * @param event
     */
    public void verificaLogado(ComponentSystemEvent event){
        if (this.model.getUsuarioLogado() == null)
            Navegacao.navegarPara("usuarios/usuariosLogin.xhtml");
    }

    /**
     * Faz o login do usuário no sistema
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public void fazerLoginUsuario() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (!this.model.validarLogin())
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atenção!", "Usuário e/ou senha não conferem."));
        else
            Navegacao.navegarPara("../");
    }

    /**
     * Faz o logout do usuário no sistema
     */
    public void logOut(){
        this.model.setUsuarioLogado(null);
        this.verificaLogado(null);
    }
}