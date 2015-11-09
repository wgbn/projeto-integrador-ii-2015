package br.com.wgbn.sgap.controller;

import br.com.wgbn.sgap.entity.UsuarioEntity;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;

/**
 * Created by Walter Gandarella on 09/11/15.
 */
@ManagedBean(name = "navegacaoMB")
@ViewScoped
public class navegacaoManagedBean {

    private void navegarPara(String _pagina){
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath() + _pagina);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ### Navegação de Usuarios
     */
    public void actionUsuariosListar(){
        navegarPara("/paginas/usuarios/usuariosListar.xhtml");
    }

    public void actionUsuariosCadastrar(){
        UsuarioFacade uf = new UsuarioFacade();
        uf.setUsuario(new UsuarioEntity());
        navegarPara("/paginas/usuarios/usuariosCadastrar.xhtml");
    }

    public void actionUsuariosEditar(){
        navegarPara("/paginas/usuarios/usuariosEditar.xhtml");
    }

    /**
     * ### Navegação de Ações
     */
    public void actionAcoesUsuario(){
        navegarPara("/paginas/acoes/acoesUsuario.xhtml");
    }

}
