package br.com.wgbn.sgap.controller;

import br.com.wgbn.sgap.entity.AcaoEntity;
import br.com.wgbn.sgap.entity.MetricaEntity;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Walter Gandarella
 */
@ManagedBean
@SessionScoped
public class DashboardFacade extends GenericoBean {

    private boolean logado;
    private List<AcaoEntity> acoes = new LinkedList<AcaoEntity>();
    private MetricaEntity metricaCliente;
    private MetricaEntity metricaAcao;
    private MetricaEntity metricaReceber;
    private MetricaEntity metricaPagar;

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

    public DashboardFacade(){
        this.preencheTimeline();
        this.preencheMetricas();

    }

    public List<AcaoEntity> getAcoes() {
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

    private void preencheTimeline(){
        AcaoEntity acao;

        for (int i = 1; i < 11; i++){
            acao = new AcaoEntity();
            acao.setId(i);
            //acao.setDatainicio(new Timestamp(2015, 11, 7, 10, 50, 0));
            //acao.setDatafim(new Timestamp(2015, 11, 7, 11, 50, 0));
            acao.setDescricao("Uma ação para comemorar o nascimento de Theo");
            acao.setLocal("Centro, Lauro de Freitas - BA");
            acao.setTitulo("Bem vindo Theo!");
            this.acoes.add(acao);
        }
    }

    private void preencheMetricas(){
        this.metricaAcao = new MetricaEntity("ic-bullhorn", "ações", 300, "+ 80 no último mês");
        this.metricaCliente = new MetricaEntity("ic-user-tie", "clientes", 100, "+ 10 no último mês");
        this.metricaPagar = new MetricaEntity("ic-coin-dollar", "à pagar", 2500, "10% a mais");
        this.metricaReceber = new MetricaEntity("ic-coin-dollar", "à receber", 1150, "15% a mais");
    }
}
