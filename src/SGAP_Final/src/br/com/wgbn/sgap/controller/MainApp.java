package br.com.wgbn.sgap.controller;

import br.com.wgbn.sgap.util.FacadeEntityManager;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by Walter Gandarella
 */
@ManagedBean
@SessionScoped
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

}
