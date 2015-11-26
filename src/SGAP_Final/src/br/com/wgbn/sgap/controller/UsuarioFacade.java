package br.com.wgbn.sgap.controller;

import br.com.wgbn.sgap.bo.UsuarioBO;
import br.com.wgbn.sgap.entity.UsuarioEntity;
import br.com.wgbn.sgap.util.Navegacao;
import br.com.wgbn.sgap.util.Utilidades;
import br.com.wgbn.sgap.vo.UsuarioVO;

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

    private List<UsuarioVO> usuarios = new LinkedList<UsuarioVO>();
    private UsuarioBO       usuarioBO;
    private UsuarioVO       usuarioVO;

    public UsuarioFacade(){
        FacesContext.getCurrentInstance().getExternalContext().getSession(true);

        this.usuarioBO = new UsuarioBO();
        this.verificaLogado(null);
        System.out.println("##-> UsuarioFacade iniciado");
    }

    /**
     * ### Getters & Setters
     */

    /**
     * Define um usuário selecionado
     * @param _usuario Objeto contendo o usuário
     */
    public void setUsuario(UsuarioVO _usuario) {
        this.usuarioVO = _usuario;
    }

    /**
     * Pega o usuário selecionado
     * @return Objeto com o usuário selecionado
     */
    public UsuarioVO getUsuario(){
        return this.usuarioVO;
    }

    /**
     * Pega uma lista de usuários
     * @return
     */
    public List<UsuarioVO> getUsuarios() {
        this.usuarios = new LinkedList<UsuarioVO>();
        for (UsuarioEntity u : this.usuarioBO.getTodos()){
            this.usuarios.add(new UsuarioVO(u));
        }
        return this.usuarios;
    }

    /**
     * Pega o usuário logado no istema
     * @return Objeto com usuário nolago
     */
    public UsuarioVO getUsuarioLogado(){
        /*UsuarioEntity u = this.usuarioBO.getUsuarioLogado();
        if (u == null){
            Navegacao.navegarPara("usuarios/usuariosLogin.xhtml");
            return null;
        } else {
            return this.usuarioBO.toVo();
        }*/
        return this.usuarioBO.toVo(this.usuarioBO.getUsuarioLogado());
    }

    /**
     * Define a senha a ser comparada
     * @param _resenha String com a senha
     */
    public void setResenha(String _resenha){
        this.usuarioBO.setResenha(_resenha);
    }

    /**
     * Pega a senha a ser comparada
     * @return
     */
    public String getResenha(){
        return this.usuarioBO.getResenha();
    }

    /**
     * Converte a Flag de gerencia em uma flag légivel
     * @param usr Objeto com o usuário a ser convertido
     * @return 'Sim' ou 'Não'
     */
    public String getGerenteToString(UsuarioVO usr){
        return this.usuarioBO.gerenteToStr(usr);
    }

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
            this.usuarioVO = new UsuarioVO();
            this.usuarioVO.setDatacriacao(new Timestamp(new Date().getTime()));
            this.usuarioBO.setEntityFromVo(this.usuarioVO);
            this.usuarioBO.setResenha(new String());
        } else {
            this.verificaLogado(null);
        }
    }

    /**
     * Faz o cadastro de um usuário e persiste no banco
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public void cadastrarUsuario() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        this.usuarioBO.setEntityFromVo(this.usuarioVO);
        if (this.usuarioBO.validarSenha()) {
            this.usuarioBO.inserirUsuario();
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
        this.usuarioBO.setEntityFromVo(this.usuarioVO);
        this.usuarioBO.alterar();
        Navegacao.navegarPara("usuarios/usuariosListar.xhtml");
    }

    /**
     * Remove um usuário do banco
     */
    public void apagarUsuario(){
        this.usuarioBO.setEntityFromVo(this.usuarioVO);
        this.usuarioBO.excluir();
        Navegacao.navegarPara("usuarios/usuariosListar.xhtml");
    }

    /**
     * Verifica se há um usuário logado
     * Caso não exista, envia para tela de login
     * @param event
     */
    public void verificaLogado(ComponentSystemEvent event){
        System.out.println("##-> verificaLogado");
        if (this.usuarioBO.getUsuarioLogado() == null)
            Navegacao.navegarPara("usuarios/usuariosLogin.xhtml");
    }

    /**
     * Faz o login do usuário no sistema
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public void fazerLoginUsuario() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        this.usuarioBO.setEntityFromVo(this.usuarioVO);
        if (!this.usuarioBO.validarLogin())
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atenção!", "Usuário e/ou senha não conferem."));
        else
            Navegacao.navegarPara("index.xhtml");
    }

    /**
     * Faz o logout do usuário no sistema
     */
    public void logOut(){
        this.usuarioBO.setUsuarioLogado(null);
        this.verificaLogado(null);
    }
}