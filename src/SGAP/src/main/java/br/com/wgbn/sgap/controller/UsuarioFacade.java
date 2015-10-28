package br.com.wgbn.sgap.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by Walter Gandarella on 20/10/15.
 */
@ManagedBean
@SessionScoped
public class UsuarioFacade {

    public UsuarioFacade() {

    }

    public static boolean fazerLoginUsuario(){
        return true;
    }
}