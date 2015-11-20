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
public class tbUsuarioAcaoDTO {
    
    private tbUsuarioDTO usuario;
    private tbAcaoDTO acao;
    private Boolean confirmado;
    private Boolean lider;
    private Date dtcadastro;
    private Date dtedicao;

    public tbUsuarioAcaoDTO() {
    }

    public tbUsuarioAcaoDTO(tbUsuarioDTO usuario, tbAcaoDTO acao, Boolean confirmado, Boolean lider, Date dtcadastro, Date dtedicao) {
        this.usuario = usuario;
        this.acao = acao;
        this.confirmado = confirmado;
        this.lider = lider;
        this.dtcadastro = dtcadastro;
        this.dtedicao = dtedicao;
    }

    public tbUsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(tbUsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public tbAcaoDTO getAcao() {
        return acao;
    }

    public void setAcao(tbAcaoDTO acao) {
        this.acao = acao;
    }

    public Boolean getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(Boolean confirmado) {
        this.confirmado = confirmado;
    }

    public Boolean getLider() {
        return lider;
    }

    public void setLider(Boolean lider) {
        this.lider = lider;
    }

    public Date getDtcadastro() {
        return dtcadastro;
    }

    public void setDtcadastro(Date dtcadastro) {
        this.dtcadastro = dtcadastro;
    }

    public Date getDtedicao() {
        return dtedicao;
    }

    public void setDtedicao(Date dtedicao) {
        this.dtedicao = dtedicao;
    }
    
    
    
}
