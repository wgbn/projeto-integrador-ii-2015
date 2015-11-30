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

        if (!Sessao.getInstance().isLogado())
            Navegacao.navegarPara("usuarios/usuariosLogin.xhtml");
    }

}
