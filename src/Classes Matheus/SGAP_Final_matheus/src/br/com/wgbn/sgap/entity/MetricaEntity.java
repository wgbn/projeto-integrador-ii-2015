package br.com.wgbn.sgap.entity;

/**
 * Created by Walter Gandarella on 09/11/15.
 */
public class MetricaEntity {
    private String  icone;
    private String  descricao;
    private int     valor;
    private String  statusAtual;

    public MetricaEntity(String icone, String descricao, int valor, String statusAtual) {
        this.icone = icone;
        this.descricao = descricao;
        this.valor = valor;
        this.statusAtual = statusAtual;
    }

    public MetricaEntity(){ }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getStatusAtual() {
        return statusAtual;
    }

    public void setStatusAtual(String statusAtual) {
        this.statusAtual = statusAtual;
    }
}
