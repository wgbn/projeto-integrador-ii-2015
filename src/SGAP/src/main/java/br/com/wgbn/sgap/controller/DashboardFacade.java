package br.com.wgbn.sgap.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by Walter Gandarella
 */
@ManagedBean
@SessionScoped
public class DashboardFacade {

    private boolean logado;

    public DashboardFacade(){
        if (!this.logado)
            this.logado = UsuarioFacade.fazerLoginUsuario();
    }

    public boolean isLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }
}
