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
public class tbTipoAcaoDTO {
    
    private int idtipoacao;
    private String tipo;
    private Date dtcriacao;
    private Date dtedicao;

    public tbTipoAcaoDTO() {
    }

    public tbTipoAcaoDTO(int idtipoacao, String tipo, Date dtcriacao, Date dtedicao) {
        this.idtipoacao = idtipoacao;
        this.tipo = tipo;
        this.dtcriacao = dtcriacao;
        this.dtedicao = dtedicao;
    }

    public int getIdtipoacao() {
        return idtipoacao;
    }

    public void setIdtipoacao(int idtipoacao) {
        this.idtipoacao = idtipoacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
    
    
    
}
