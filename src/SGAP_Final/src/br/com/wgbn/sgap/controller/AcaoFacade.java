package br.com.wgbn.sgap.controller;

import br.com.wgbn.sgap.bo.AcaoBO;
import br.com.wgbn.sgap.entity.*;
import br.com.wgbn.sgap.util.Navegacao;
import br.com.wgbn.sgap.util.Utilidades;
import br.com.wgbn.sgap.vo.AcaoVO;
import br.com.wgbn.sgap.vo.ClienteVO;
import br.com.wgbn.sgap.vo.TipoacaoVO;
import org.primefaces.event.map.MarkerDragEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Walter Gandarella
 */

@ManagedBean
@SessionScoped
public class AcaoFacade extends GenericoBean {

    private List<AcaoEntity>    acoes = new LinkedList<AcaoEntity>();
    private AcaoBO          acaoBO;
    private AcaoEntity      acao;
    private UsuarioEntity   promotor;
    private MapModel        carregaMapa;
    private Marker          marker;
    private Date            dataInicio;
    private Date            dataFim;

    public AcaoFacade(){
        this.acaoBO = new AcaoBO();
        System.out.println("##-> AcoesFacade iniciado");
    }

    /**
     * Getters & Setters
     */

    public AcaoEntity getAcao(){
        return this.acao;
    }
    public void setAcao(AcaoEntity _acao){
        this.acao = _acao;
    }

    public List<AcaoEntity> getAcoesNaoRealizadas() {
        /*this.acoes = new LinkedList<AcaoEntity>();
        for (AcaoEntity a : this.acaoBO.getTodasNaoRealizadas()){
            this.acoes.add(new AcaoVO(a));
        }*/
        this.acoes = this.acaoBO.getTodasNaoRealizadas();
        return this.acoes;
    }

    public List<TipoacaoEntity> getTipos(){
        /*List<TipoacaoVO> _tipos = new LinkedList<TipoacaoVO>();
        for (TipoacaoEntity t : this.acaoBO.getTiposAcao()){
            _tipos.add(new TipoacaoVO(t));
        }
        return _tipos;*/
        return this.acaoBO.getTiposAcao();
    }

    public List<ClienteEntity> getClientes(){
        /*List<ClienteVO> _clis = new LinkedList<ClienteVO>();
        for (ClienteEntity c : this.acaoBO.getClientes()){
            _clis.add(new ClienteVO(c));
        }
        return _clis;*/
        return this.acaoBO.getClientes();
    }

    public Date getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }
    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public UsuarioEntity getPromotor() {
        return promotor;
    }
    public void setPromotor(UsuarioEntity promotor) {
        this.promotor = promotor;
    }

    public List<UsuarioEntity> getUsuarios(){
        return this.acaoBO.getUsuarios();
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
            /*this.acaoVO = new AcaoVO();
            this.acaoVO.setDatacriacao(new Timestamp(new Date().getTime()));
            this.acaoBO.setEntity(new AcaoEntity());*/
            this.acao = new AcaoEntity();
            this.acao.setDatacriacao(new Timestamp(new Date().getTime()));
            this.acaoBO.resetEntity();
        }
    }
    public void aoCarregarPromotoresAcao(ComponentSystemEvent event){
        this.promotor = new UsuarioEntity();
    }

    public void cadastrarAcao(){
        /*this.acaoBO.setEntityFromVo(this.acaoVO);
        this.acaoBO.inserirAcao();
        this.acaoVO = this.acaoBO.toVo();*/
        this.acao.setDatainicio(new Timestamp(this.dataInicio.getTime()));
        this.acao.setDatafim(new Timestamp(this.dataFim.getTime()));
        this.acaoBO.setEntity(this.acao);
        this.acaoBO.inserirAcao();
        this.acao = this.acaoBO.getEntity();
        Navegacao.navegarPara("acoes/acoesPromotoresAcao.xhtml");
    }

    public String getDataLegivel(Timestamp _data){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return sdf.format(new Date(_data.getTime()));
    }
    public String getDataLegivel(Date _data){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return sdf.format(_data);
    }

    public void adicionarPromotor(){
        this.acao.setUsuarios(this.acaoBO.setPromotor(this.acao, this.promotor));
    }

    @PostConstruct
    public void init() {
        this.carregaMapa = new DefaultMapModel();
    }

    public MapModel getCarregaMapa() {
        return this.carregaMapa;
    }
}
