package br.com.wgbn.sgap.controller;

import br.com.wgbn.sgap.entity.UsuarioEntity;
import br.com.wgbn.sgap.util.Navegacao;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;

/**
 * Created by Walter Gandarella
 */
@ManagedBean(name = "navegacaoMB")
@SessionScoped
public class NavegacaoManagedBean {

    /**
     * ### Navegação de Usuarios
     */
    public void actionUsuariosListar(){
        Navegacao.navegarPara("usuarios/usuariosListar.xhtml");
    }

    public void actionUsuariosEditar(){
        Navegacao.navegarPara("usuarios/usuariosCadastrar.xhtml");
        //Navegacao.navegarPara("usuarios/usuariosEditar.xhtml");
    }

    /**
     * ### Navegação de Ações
     */
    public void actionAcoesUsuario(){
        Navegacao.navegarPara("acoes/acoesUsuario.xhtml");
    }


    /**
     * ### Navegação de Clientes
     */
    public void actionClientesListar(){
        Navegacao.navegarPara("clientes/clientesListar.xhtml");
    }

    public void actionClientesEditar(){
        Navegacao.navegarPara("clientes/clientesEditar.xhtml");
    }
}
