package br.com.wgbn.sgap.controller;

import br.com.wgbn.sgap.util.Navegacao;
import br.com.wgbn.sgap.util.Sessao;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

/**
 * Created by Walter Gandarella
 */
public abstract class GenericoBean {

    private void init() {
        FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    }

    @PostConstruct
    public void vefificaAcesso(){
        System.out.println("## vefificaAcesso()");
        this.init();

        String viewId = FacesContext.getCurrentInstance().getViewRoot().getViewId();
        System.out.println(viewId);

        if (Sessao.getInstance().isLogado())
            if (viewId != "/paginas/index.xhtml")
                Navegacao.navegarPara("index.xhtml");
        else
            Navegacao.navegarPara("usuarios/usuariosLogin.xhtml");
    }

}
