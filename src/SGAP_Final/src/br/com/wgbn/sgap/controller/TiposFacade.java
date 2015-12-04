package br.com.wgbn.sgap.controller;

import br.com.wgbn.sgap.bo.TipoacaoBO;
import br.com.wgbn.sgap.entity.TipoacaoEntity;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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

    public TiposFacade(){
        this.tipoBO = new TipoacaoBO();
    }


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
}
