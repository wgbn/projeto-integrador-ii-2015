package br.com.wgbn.sgap.vo;

import br.com.wgbn.sgap.entity.AcaoEntity;
import br.com.wgbn.sgap.entity.UsuarioAcaoEntity;
import br.com.wgbn.sgap.entity.UsuarioEntity;

import java.sql.Timestamp;

/**
 * Created by Walter Gandarella
 */
public class UsuarioAcaoVO {
    private int         id;
    private int         confirmado;
    private int         lider;
    private Timestamp   datacadastro;
    private Timestamp   dataedicao;
    private AcaoVO      acao;
    private UsuarioVO   usuario;

    public UsuarioAcaoVO(){
        this.acao = new AcaoVO();
        this.usuario = new UsuarioVO();
    }

    public UsuarioAcaoVO(UsuarioAcaoEntity ua){
        this.id             = ua.getId();
        this.confirmado     = ua.getConfirmado();
        this.lider          = ua.getLider();
        this.datacadastro   = ua.getDatacadastro();
        this.dataedicao     = ua.getDataedicao();
        this.acao           = ua.getAcao();
        this.usuario        = ua.getUsuario();
    }

    public UsuarioAcaoVO(int id, int confirmado, int lider, Timestamp datacadastro, Timestamp dataedicao, AcaoVO acao, UsuarioVO usuario) {
        this.id             = id;
        this.confirmado     = confirmado;
        this.lider          = lider;
        this.datacadastro   = datacadastro;
        this.dataedicao     = dataedicao;
        this.acao           = acao;
        this.usuario        = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(int confirmado) {
        this.confirmado = confirmado;
    }

    public int getLider() {
        return lider;
    }

    public void setLider(int lider) {
        this.lider = lider;
    }

    public Timestamp getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(Timestamp datacadastro) {
        this.datacadastro = datacadastro;
    }

    public Timestamp getDataedicao() {
        return dataedicao;
    }

    public void setDataedicao(Timestamp dataedicao) {
        this.dataedicao = dataedicao;
    }

    public AcaoVO getAcao() {
        return acao;
    }

    public void setAcao(AcaoVO acao) {
        this.acao = acao;
    }

    public UsuarioVO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioVO usuario) {
        this.usuario = usuario;
    }
}
