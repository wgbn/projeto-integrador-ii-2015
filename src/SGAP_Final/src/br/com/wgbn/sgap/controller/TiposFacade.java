package br.com.wgbn.sgap.controller;

import br.com.wgbn.sgap.bo.TipoacaoBO;
import br.com.wgbn.sgap.entity.TipoacaoEntity;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Walter Gandarella
 */
@ManagedBean
@SessionScoped
public class TiposFacade extends GenericoBean {

    private List<TipoacaoEntity>    tipos = new LinkedList<TipoacaoEntity>();
    private TipoacaoBO              tipoBO;
    private TipoacaoEntity          tipo;
    private TipoacaoEntity          tipoNovo;

    public TiposFacade(){
        this.tipoBO = new TipoacaoBO();
    }

    /**
     * ### Getters & Setters
     */

    public List<TipoacaoEntity> getTipos() {
        this.tipos = this.tipoBO.getTodos();
        return tipos;
    }

    public void setTipos(List<TipoacaoEntity> tipos) {
        this.tipos = tipos;
    }

    public TipoacaoEntity getTipo() {
        return tipo;
    }

    public void setTipo(TipoacaoEntity tipo) {
        this.tipo = tipo;
    }

    public TipoacaoEntity getTipoNovo() {
        return tipoNovo;
    }

    public void setTipoNovo(TipoacaoEntity tipoNovo) {
        this.tipoNovo = tipoNovo;
    }

    /**
     * ### Métodos do facade
     */

    public void aoCarregarCriarTipo(ComponentSystemEvent event){
        this.tipoNovo = new TipoacaoEntity();
    }
}
