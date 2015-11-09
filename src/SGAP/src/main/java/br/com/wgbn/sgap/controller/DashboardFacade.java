package br.com.wgbn.sgap.controller;

import br.com.wgbn.sgap.entity.AcaoEntity;

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
public class DashboardFacade {

    private boolean logado;
    private List<AcaoEntity> acoes = new LinkedList<AcaoEntity>();

    public DashboardFacade(){
        this.preencheTimeline();
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
}
