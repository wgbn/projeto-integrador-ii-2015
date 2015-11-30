package br.com.wgbn.sgap.controller;

import br.com.wgbn.sgap.bo.AcaoBO;
import br.com.wgbn.sgap.entity.*;
import br.com.wgbn.sgap.util.Navegacao;
import br.com.wgbn.sgap.util.Utilidades;
import br.com.wgbn.sgap.vo.PromotorVO;
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
 * Created by Walter Gandarella
 */

@ManagedBean
@SessionScoped
public class AcaoFacade extends GenericoBean {

    private List<AcaoEntity>    acoes = new LinkedList<AcaoEntity>();
    private AcaoBO          acaoBO;
    private AcaoEntity      acao;
    private MapModel        carregaMapa;
    private Marker          marker;
    private Date            dataInicio;
    private Date            dataFim;
    private UsuarioAcaoEntity promotor;
    private PromotorVO      promotorVO;

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
        this.acoes = this.acaoBO.getTodasNaoRealizadas();
        return this.acoes;
    }

    public List<TipoacaoEntity> getTipos(){
        return this.acaoBO.getTiposAcao();
    }

    public List<ClienteEntity> getClientes(){
        return this.acaoBO.getClientes();
    }

    public List<UsuarioEntity> getUsuarios(){
        return this.acaoBO.getUsuariosDisponiveis(this.acao);
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

    public UsuarioAcaoEntity getPromotor() {
        return promotor;
    }
    public void setPromotor(UsuarioAcaoEntity promotor) {
        this.promotor = promotor;
    }

    public boolean isLider(int _flag){
        return _flag == 0 ? false : true;
    }
    public String strLider(int _flag){
        return _flag == 0 ? "Não":"Sim";
    }

    public PromotorVO getPromotorVO() {
        return promotorVO;
    }
    public void setPromotorVO(PromotorVO promotorVO) {
        this.promotorVO = promotorVO;
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
            this.acao = new AcaoEntity();
            this.acao.setDatacriacao(new Timestamp(new Date().getTime()));
            this.acaoBO.resetEntity();
        }
    }
    public void aoCarregarPromotoresAcao(ComponentSystemEvent event){
        this.promotor = new UsuarioAcaoEntity();
        this.promotor.setAcao(new AcaoEntity());
        this.promotor.getAcao().setId(this.acao.getId());
        this.promotor.setUsuario(new UsuarioEntity());
    }

    public void cadastrarAcao(){
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
        if (
                this.promotor.getAcao() != null &&
                this.promotor.getUsuario() != null &
                this.promotor.getUsuario().getId() > 0
            )
            this.acao.setUsuarios(this.acaoBO.setPromotor(this.promotor, this.acao));
    }

    public void tornarLider(UsuarioAcaoEntity _promotor){
        this.acao.setUsuarios(this.acaoBO.setLider(_promotor, this.acao));
    }

    public void removerPromotor(UsuarioAcaoEntity _promotor){
        this.acao.setUsuarios(this.acaoBO.removerPromotor(_promotor, this.acao));
    }

    @PostConstruct
    public void init() {
        this.carregaMapa = new DefaultMapModel();
    }

    public MapModel getCarregaMapa() {
        return this.carregaMapa;
    }
}
