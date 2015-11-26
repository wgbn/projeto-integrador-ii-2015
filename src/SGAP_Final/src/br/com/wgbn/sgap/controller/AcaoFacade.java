package br.com.wgbn.sgap.controller;

import br.com.wgbn.sgap.bo.AcaoBO;
import br.com.wgbn.sgap.entity.AcaoEntity;
import br.com.wgbn.sgap.entity.ClienteEntity;
import br.com.wgbn.sgap.entity.TipoacaoEntity;
import br.com.wgbn.sgap.util.Navegacao;
import br.com.wgbn.sgap.util.Utilidades;
import br.com.wgbn.sgap.vo.AcaoVO;
import br.com.wgbn.sgap.vo.ClienteVO;
import br.com.wgbn.sgap.vo.TipoacaoVO;

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
public class AcaoFacade {

    private List<AcaoVO>    acoes = new LinkedList<AcaoVO>();
    private AcaoBO          acaoBO;
    private AcaoVO          acaoVO;

    public AcaoFacade(){
        this.acaoBO = new AcaoBO();
        System.out.println("##-> AcoesFacade iniciado");
    }

    /**
     * Getters & Setters
     */

    public AcaoVO getAcao(){
        return this.acaoVO;
    }
    public void setAcao(AcaoVO _acao){
        this.acaoVO = _acao;
    }

    public List<AcaoVO> getAcoesNaoRealizadas() {
        this.acoes = new LinkedList<AcaoVO>();
        for (AcaoEntity a : this.acaoBO.getTodasNaoRealizadas()){
            this.acoes.add(new AcaoVO(a));
        }
        return this.acoes;
    }

    public List<TipoacaoVO> getTipos(){
        List<TipoacaoVO> _tipos = new LinkedList<TipoacaoVO>();
        for (TipoacaoEntity t : this.acaoBO.getTiposAcao()){
            _tipos.add(new TipoacaoVO(t));
        }
        return _tipos;
    }

    public List<ClienteVO> getClientes(){
        List<ClienteVO> _clis = new LinkedList<ClienteVO>();
        for (ClienteEntity c : this.acaoBO.getClientes()){
            _clis.add(new ClienteVO(c));
        }
        return _clis;
    }

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
            this.acaoVO = new AcaoVO();
            this.acaoVO.setDatacriacao(new Timestamp(new Date().getTime()));
            this.acaoBO.setEntityFromVo(this.acaoVO);
        }
    }

    public void cadastrarAcao(){
        this.acaoBO.inserirAcao();
        Navegacao.navegarPara("acoes/acoesPromotoresAcao.xhtml");
    }
}
