package br.com.wgbn.sgap.controller;

import br.com.wgbn.sgap.bo.AcaoBO;
import br.com.wgbn.sgap.bo.ClienteBO;
import br.com.wgbn.sgap.entity.AcaoEntity;
import br.com.wgbn.sgap.entity.MetricaEntity;
import br.com.wgbn.sgap.util.Sessao;
import br.com.wgbn.sgap.util.Utilidades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created by Walter Gandarella
 */
@ManagedBean
@ViewScoped
public class DashboardFacade extends GenericoBean {

    private boolean             logado;
    private List<AcaoEntity>    acoes = new LinkedList<AcaoEntity>();
    private AcaoBO              acaoBO;
    private ClienteBO           clienteBO;
    private MetricaEntity       metricaCliente;
    private MetricaEntity       metricaAcao;
    private MetricaEntity       metricaReceber;
    private MetricaEntity       metricaPagar;

    public DashboardFacade(){
        this.acaoBO = new AcaoBO();
        this.clienteBO = new ClienteBO();
        this.preencheMetricas();
    }

    public MetricaEntity getMetricaCliente() {
        return metricaCliente;
    }

    public void setMetricaCliente(MetricaEntity metricaCliente) {
        this.metricaCliente = metricaCliente;
    }

    public MetricaEntity getMetricaAcao() {
        return metricaAcao;
    }

    public void setMetricaAcao(MetricaEntity metricaAcao) {
        this.metricaAcao = metricaAcao;
    }

    public MetricaEntity getMetricaReceber() {
        return metricaReceber;
    }

    public void setMetricaReceber(MetricaEntity metricaReceber) {
        this.metricaReceber = metricaReceber;
    }

    public MetricaEntity getMetricaPagar() {
        return metricaPagar;
    }

    public void setMetricaPagar(MetricaEntity metricaPagar) {
        this.metricaPagar = metricaPagar;
    }

    public List<AcaoEntity> getAcoes() {
        if (Sessao.getInstance().isLogado())
            this.acoes = this.acaoBO.getTodasNaoRealizadas();

        return acoes;
    }

    public void setAcoes(List<AcaoEntity> acoes) {
        this.acoes = acoes;
    }

    public boolean isLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }

    public String getDiaDaSemana(Timestamp ts){
        return Utilidades.getDiaDaSemana(ts);
    }

    public String getMes(Timestamp ts){
        return Utilidades.getMes(ts);
    }

    public String formataHora(Timestamp ts){
        return Utilidades.formataHora(ts);
    }

    private void preencheMetricas(){
        //this.metricaAcao = new MetricaEntity("ic-bullhorn", "ações", 300, "+ 80 no último mês");
        this.metricaAcao = acaoBO.getAcaoMetrica();
        //this.metricaCliente = new MetricaEntity("ic-user-tie", "clientes", 100, "+ 10 no último mês");
        this.metricaCliente = clienteBO.getClienteMetrica();
        //this.metricaPagar = new MetricaEntity("ic-coin-dollar", "à pagar", 2500, "10% a mais");
        //this.metricaReceber = new MetricaEntity("ic-coin-dollar", "à receber", 1150, "15% a mais");
        this.metricaReceber = acaoBO.getReceberMetrica();
    }
}
