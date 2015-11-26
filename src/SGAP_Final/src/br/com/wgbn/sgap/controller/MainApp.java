package br.com.wgbn.sgap.controller;

import br.com.wgbn.sgap.util.FacadeEntityManager;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 * Created by Walter Gandarella
 */
@ManagedBean
@ApplicationScoped
public class MainApp {

    private static FacadeEntityManager fEntityManager = null;

    public MainApp(){
        MainApp.initEntityManager();
    }

    private static void initEntityManager(){
        if (MainApp.fEntityManager == null) {
            MainApp.fEntityManager = new FacadeEntityManager("wgbn");
            System.out.println("##-> MainApp iniciado");
        }
    }

    public static FacadeEntityManager getFacadeEntityManager(){
        MainApp.initEntityManager();
        return MainApp.fEntityManager;
    }

    @PostConstruct
    void initialiseSession() {
        System.out.println("##-> PostConstruct");
        FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    }

}
