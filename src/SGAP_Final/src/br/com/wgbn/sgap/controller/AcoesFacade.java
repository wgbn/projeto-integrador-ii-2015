package br.com.wgbn.sgap.controller;

import br.com.wgbn.sgap.dao.AcaoDAO;
import br.com.wgbn.sgap.dao.TipoacaoDAO;
import br.com.wgbn.sgap.entity.AcaoEntity;
import br.com.wgbn.sgap.entity.ClienteEntity;
import br.com.wgbn.sgap.entity.TipoacaoEntity;
import br.com.wgbn.sgap.model.AcaoModel;
import br.com.wgbn.sgap.model.TipoacaoModel;
import br.com.wgbn.sgap.util.Navegacao;
import br.com.wgbn.sgap.util.Utilidades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import java.sql.Timestamp;
import java.util.Date;
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

    public AcaoEntity getAcao(){ return this.model.getEntity(); }
    public void setAcao(AcaoEntity _acao){ this.model.setEntity(_acao); }

    public List<AcaoEntity> getAcoesNaoRealizadas() {
        this.acoes = this.model.getTodasNaoRealizadas();
        return this.acoes;
    }

    public List<TipoacaoEntity> getTipos(){ return this.model.getTiposAcao(); }

    public List<ClienteEntity> getClientes(){ return this.model.getClientes(); }

    /**
    * Métodos do facade
    */

    /**
     * Ação executada ao carregar determinada página
     * Ŕ responsável por inicializar um Objeto usuario
     * @param event
     */
    public void aoCarregarCriarAcao(ComponentSystemEvent event){
        if (Utilidades.isNewRequest()){
            this.model.setEntity(new AcaoEntity());
            this.model.getEntity().setDatacriacao(new Timestamp(new Date().getTime()));
        }
    }

    public void cadastrarAcao(){
        this.model.inserirAcao();
        Navegacao.navegarPara("acoes/acoesPromotoresAcao.xhtml");
    }
}
