package br.com.wgbn.sgap.controller;

import br.com.wgbn.sgap.bo.AcaoBO;
import br.com.wgbn.sgap.entity.*;
import br.com.wgbn.sgap.util.Navegacao;
import br.com.wgbn.sgap.util.Sessao;
import br.com.wgbn.sgap.util.Utilidades;
import org.primefaces.model.map.DefaultMapModel;
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
import java.util.Set;

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

    public AcaoFacade(){
        this.acaoBO = new AcaoBO();
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
    public String strBoolean(int _flag){
        return _flag == 0 ? "Não":"Sim";
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
            this.dataInicio = this.dataFim = null;
            this.acaoBO.resetEntity();
        }
    }

    public void aoCarregarEditarAcao(ComponentSystemEvent event){
        this.dataInicio = new Date(this.acao.getDatainicio().getTime());
        this.dataFim = new Date(this.acao.getDatafim().getTime());
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

    public void atualizarAcao(){
        this.acao.setDatainicio(new Timestamp(this.dataInicio.getTime()));
        this.acao.setDatafim(new Timestamp(this.dataFim.getTime()));
        this.acaoBO.setEntity(this.acao);
        this.acaoBO.alterar();
        Navegacao.navegarPara("acoes/acoesPromotoresAcao.xhtml");
    }

    public void apagarAcao(){
        this.acaoBO.setEntity(this.acao);
        this.acaoBO.excluir();
        Navegacao.navegarPara("acoes/acoesListar.xhtml");
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
            ) {
            Set<UsuarioAcaoEntity> usuarios = this.acaoBO.setPromotor(this.promotor, this.acao);
            if (usuarios == null){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ooops!", "Este usuário já participa desta ação"));
            } else {
                this.acao.setUsuarios(usuarios);
            }
        }
    }

    public void tornarLider(UsuarioAcaoEntity _promotor){
        this.acao.setUsuarios(this.acaoBO.setLider(_promotor, this.acao));
    }

    public void removerPromotor(UsuarioAcaoEntity _promotor){
        this.acao.setUsuarios(this.acaoBO.removerPromotor(_promotor, this.acao));
    }

    public void confirmarAcao(boolean _flag){
        this.acao.setUsuarios(this.acaoBO.confirmarAcao(_flag, Sessao.getInstance().getUsuarioLogado(), this.acao));
    }

    public boolean confirmadoNaAcao(){
        for (UsuarioAcaoEntity ua : this.acao.getUsuarios()){
            if (ua.getUsuario().getId() == Sessao.getInstance().getUsuarioLogado().getId() && ua.getConfirmado() == 1){
                return true;
            }
        }
        return false;
    }

    @PostConstruct
    public void init() {
        this.carregaMapa = new DefaultMapModel();
    }

    public MapModel getCarregaMapa() {
        return this.carregaMapa;
    }
}
