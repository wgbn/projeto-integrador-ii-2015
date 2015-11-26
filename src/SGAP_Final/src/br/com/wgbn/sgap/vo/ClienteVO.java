package br.com.wgbn.sgap.vo;

import br.com.wgbn.sgap.entity.ClienteEntity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Walter Gandarella
 */
public class ClienteVO {
    private int         id;
    private String      nome;
    private String      contato;
    private String      email;
    private Timestamp   datacriacao;
    private Timestamp   dataedicao;
    private String      telefoneFixo;
    private String      telefoneCelular;
    private String      fax;
    private Set<AcaoVO> acoes;

    public ClienteVO(){
        this.acoes = new HashSet<AcaoVO>();
    }

    public ClienteVO(ClienteEntity cliente){
        this.id             = cliente.getId();
        this.nome           = cliente.getNome();
        this.contato        = cliente.getContato();
        this.email          = cliente.getEmail();
        this.datacriacao    = cliente.getDatacriacao();
        this.dataedicao     = cliente.getDataedicao();
        this.telefoneFixo   = cliente.getTelefoneFixo();
        this.telefoneCelular = cliente.getTelefoneCelular();
        this.fax            = cliente.getFax();
        this.acoes          = cliente.getAcoes();
    }

    public ClienteVO(int id, String nome, String contato, String email, Timestamp datacriacao, Timestamp dataedicao, String telefoneFixo, String telefoneCelular, String fax, Set<AcaoVO> acoes) {
        this.id             = id;
        this.nome           = nome;
        this.contato        = contato;
        this.email          = email;
        this.datacriacao    = datacriacao;
        this.dataedicao     = dataedicao;
        this.telefoneFixo   = telefoneFixo;
        this.telefoneCelular = telefoneCelular;
        this.fax            = fax;
        this.acoes          = acoes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Set<AcaoVO> getAcoes() {
        return acoes;
    }

    public void setAcoes(Set<AcaoVO> acoes) {
        this.acoes = acoes;
    }
}
