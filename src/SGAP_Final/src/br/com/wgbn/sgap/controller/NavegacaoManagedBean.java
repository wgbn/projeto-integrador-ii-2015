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
    public void actionUsuariosEditar(){ Navegacao.navegarPara("usuarios/usuariosEditar.xhtml"); }
    public void actionUsuariosCadastrar(){ Navegacao.navegarPara("usuarios/usuariosCadastrar.xhtml"); }

    /**
     * ### Navegação de Ações
     */
    public void actionAcoesUsuario(){ Navegacao.navegarPara("acoes/acoesUsuario.xhtml"); }
    public void actionAcoesCadastrar(){ Navegacao.navegarPara("acoes/acoesCadastrar.xhtml"); }
    public void actionAcoesEditar(){ Navegacao.navegarPara("acoes/acoesEditar.xhtml"); }
    public void actionAcoesListar() { Navegacao.navegarPara("acoes/acoesListar.xhtml"); }
    public void actionAcoesVisualizar(){ Navegacao.navegarPara("acoes/acoesPromotoresAcao.xhtml"); }


    /**
     * ### Navegação de Clientes
     */
    public void actionClientesListar(){
        Navegacao.navegarPara("clientes/clientesListar.xhtml");
    }
    public void actionClientesEditar(){
        Navegacao.navegarPara("clientes/clientesEditar.xhtml");
    }
    public void actionClientesCadastrar(){ Navegacao.navegarPara("clientes/clientesCadastrar.xhtml"); }

    /**
     * ### Navegação de Tipos
     */
    public void actionTiposListar(){ Navegacao.navegarPara("tipos/tiposListar.xhtml"); }
    public void actionTiposCadastrar(){ Navegacao.navegarPara("tipos/tiposCadastrar.xhtml"); }
}
