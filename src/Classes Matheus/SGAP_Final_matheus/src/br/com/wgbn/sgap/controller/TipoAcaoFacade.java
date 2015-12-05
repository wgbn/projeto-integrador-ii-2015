/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sgap_final;

/**
 *
 * @author Matthew
 */

    package br.com.wgbn.sgap.controller;

import br.com.wgbn.sgap.bo.TipoacaoBO;
import br.com.wgbn.sgap.entity.*;
import br.com.wgbn.sgap.util.Navegacao;
import br.com.wgbn.sgap.util.Utilidades;
import br.com.wgbn.sgap.vo.TipoAcaoVO;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Matheus Oliveira
 */

@ManagedBean
@SessionScoped
public class TipoAcaoFacade extends GenericoBean {

    private List<TipoacaoEntity> tiposacoes = new LinkedList<TipoacaoEntity>();
    private TipoacaoBO          tipoBO;
    private TipoacaoEntity      tipoAcao;
   

    public TipoAcaoFacade(){
        this.TipoacaoBO = new TipoacaoBO();
        System.out.println("##-> TipoAcãoFacade iniciado");
    }

    public TipoacaoEntity getTipoAcao() {
        return tipoAcao;
    }

    public void setTipoAcao(TipoacaoEntity tipoAcao) {
        this.tipoAcao = tipoAcao;
    }
    
     public List<TipoacaoEntity> getTiposccao() {

        this.tiposacoes = this.TipoacaoBO.getTodos();
        return this.tiposacoes;
    }
     
     /***
      * Metodos
      */
     public void aoCarregarCriarTipoAcao(ComponentSystemEvent event) throws InstantiationException, IllegalAccessException {
        if (Utilidades.isNewRequest()){
            this.tipoAcao = new TipoacaoEntity();
            this.tipoAcao.setDatacriacao(new Timestamp(new Date().getTime()));
            this.TipoacaoBO.setEntity(this.tipoAcao);
        }
    }

    public void alterarTipoAcao(){
        this.TipoacaoBO.setEntity(this.tipoAcao);
        this.TipoacaoBO.alterar();
        Navegacao.navegarPara("tipoAcao/tipoAcaoListar.xhtml");
    }

    public void apagarTipoAcao(){
        this.TipoacaoBO.setEntity(this.tipoAcao);
        this.TipoacaoBO.excluir();
        Navegacao.navegarPara("tipoAcao/tipoAcaoListar.xhtml");
    }
    
    
    
    
    
    }


