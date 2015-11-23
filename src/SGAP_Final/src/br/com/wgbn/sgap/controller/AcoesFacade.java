package br.com.wgbn.sgap.controller;

import br.com.wgbn.sgap.dao.AcaoDAO;
import br.com.wgbn.sgap.entity.AcaoEntity;
import br.com.wgbn.sgap.model.AcaoModel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Walter Gandarella
 */

@ManagedBean
@SessionScoped
public class AcoesFacade {

    private List<AcaoEntity>    acoes = new LinkedList<AcaoEntity>();
    private AcaoModel           model;
    private AcaoDAO             dao;

    public AcoesFacade(){
        if (this.dao == null && MainApp.getFacadeEntityManager() != null)
            this.dao = new AcaoDAO(MainApp.getFacadeEntityManager().getEntityManager());
        model = new AcaoModel(dao);

        System.out.println("##-> AcoesFacade iniciado");
    }

    /**
     * Getters & Setters
     */

    public List<AcaoEntity> getAcoesNaoRealizadas() {
        this.acoes = this.model.getTodasNaoRealizadas();
        return this.acoes;
    }

    /**
    * Métodos do facade
    */
}
