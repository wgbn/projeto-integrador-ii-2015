/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Date;

/**
 *
 * @author Matthew
 */
public class tbAcaoDTO {
    
    private int idacao;
    private Date dtinicio;
    private Date dtfim;
    private String descricao;
    private String local;
    private Double latitude;
    private Double longitude;
    private Float valor;
    private String titulo;
    private Date dtcriacao;
    private Date dtedicao;
    private tbUsuarioDTO usuarioacao;
    private tbTipoAcaoDTO tipoacao;
    private tbClienteDTO cliente;

    public tbAcaoDTO() {
    }

    public tbAcaoDTO(int idacao, Date dtinicio, Date dtfim, String descricao, String local, Double latitude, Double longitude, Float valor, String titulo, Date dtcriacao, Date dtedicao, tbUsuarioDTO usuarioacao, tbTipoAcaoDTO tipoacao, tbClienteDTO cliente) {
        this.idacao = idacao;
        this.dtinicio = dtinicio;
        this.dtfim = dtfim;
        this.descricao = descricao;
        this.local = local;
        this.latitude = latitude;
        this.longitude = longitude;
        this.valor = valor;
        this.titulo = titulo;
        this.dtcriacao = dtcriacao;
        this.dtedicao = dtedicao;
        this.usuarioacao = usuarioacao;
        this.tipoacao = tipoacao;
        this.cliente = cliente;
    }

    public int getIdacao() {
        return idacao;
    }

    public void setIdacao(int idacao) {
        this.idacao = idacao;
    }

    public Date getDtinicio() {
        return dtinicio;
    }

    public void setDtinicio(Date dtinicio) {
        this.dtinicio = dtinicio;
    }

    public Date getDtfim() {
        return dtfim;
    }

    public void setDtfim(Date dtfim) {
        this.dtfim = dtfim;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getDtcriacao() {
        return dtcriacao;
    }

    public void setDtcriacao(Date dtcriacao) {
        this.dtcriacao = dtcriacao;
    }

    public Date getDtedicao() {
        return dtedicao;
    }

    public void setDtedicao(Date dtedicao) {
        this.dtedicao = dtedicao;
    }

    public tbUsuarioDTO getUsuarioacao() {
        return usuarioacao;
    }

    public void setUsuarioacao(tbUsuarioDTO usuarioacao) {
        this.usuarioacao = usuarioacao;
    }

    public tbTipoAcaoDTO getTipoacao() {
        return tipoacao;
    }

    public void setTipoacao(tbTipoAcaoDTO tipoacao) {
        this.tipoacao = tipoacao;
    }

    public tbClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(tbClienteDTO cliente) {
        this.cliente = cliente;
    }
    
    
}
