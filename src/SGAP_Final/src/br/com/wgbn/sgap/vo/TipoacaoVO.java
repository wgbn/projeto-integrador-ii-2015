package br.com.wgbn.sgap.vo;

import br.com.wgbn.sgap.entity.AcaoEntity;
import br.com.wgbn.sgap.entity.TipoacaoEntity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Walter Gandarella
 */
public class TipoacaoVO {
    private int         id;
    private String      tipo;
    private Timestamp   datacriacao;
    private Timestamp   dataedicao;
    private Set<AcaoVO> acoes;

    public TipoacaoVO() {
        this.acoes = new HashSet<AcaoVO>();
    }

    public TipoacaoVO(TipoacaoEntity tipo) {
        this.id         = tipo.getId();
        this.tipo       = tipo.getTipo();
        this.datacriacao = tipo.getDatacriacao();
        this.dataedicao = tipo.getDataedicao();
        this.acoes      = tipo.getAcoes();
    }

    public TipoacaoVO(int id, String tipo, Timestamp datacriacao, Timestamp dataedicao, Set<AcaoVO> acoes) {
        this.id         = id;
        this.tipo       = tipo;
        this.datacriacao = datacriacao;
        this.dataedicao = dataedicao;
        this.acoes      = acoes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Timestamp getDatacriacao() {
        return datacriacao;
    }

    public void setDatacriacao(Timestamp datacriacao) {
        this.datacriacao = datacriacao;
    }

    public Timestamp getDataedicao() {
        return dataedicao;
    }

    public void setDataedicao(Timestamp dataedicao) {
        this.dataedicao = dataedicao;
    }

    public Set<AcaoVO> getAcoes() {
        return acoes;
    }

    public void setAcoes(Set<AcaoVO> acoes) {
        this.acoes = acoes;
    }
}
