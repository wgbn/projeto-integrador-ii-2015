package br.com.wgbn.sgap.vo;

import br.com.wgbn.sgap.entity.UsuarioAcaoEntity;
import br.com.wgbn.sgap.entity.UsuarioEntity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Walter Gandarella
 */
public class UsuarioVO {
    private int         id;
    private String      nome;
    private String      email;
    private String      senha;
    private String      banco;
    private String      agencia;
    private String      conta;
    private int         gerente;
    private Timestamp   datacriacao;
    private Timestamp   dataedicao;
    private String      telefoneFixo;
    private String      telefoneCelular;
    private Set<UsuarioAcaoVO> acoes;

    public UsuarioVO() {
        this.acoes = new HashSet<UsuarioAcaoVO>();
    }

    public UsuarioVO(UsuarioEntity usuario){
        this.id             = usuario.getId();
        this.nome           = usuario.getNome();
        this.email          = usuario.getEmail();
        this.senha          = usuario.getSenha();
        this.banco          = usuario.getBanco();
        this.agencia        = usuario.getAgencia();
        this.conta          = usuario.getConta();
        this.gerente        = usuario.getGerente();
        this.datacriacao    = usuario.getDatacriacao();
        this.dataedicao     = usuario.getDataedicao();
        this.telefoneFixo   = usuario.getTelefoneFixo();
        this.telefoneCelular = usuario.getTelefoneCelular();
        this.acoes          = usuario.getAcoes();
    }

    public UsuarioVO(int id, String nome, String email, String senha, String banco, String agencia, String conta, int gerente, Timestamp datacriacao, Timestamp dataedicao, String telefoneFixo, String telefoneCelular, Set<UsuarioAcaoVO> acoes) {
        this.id             = id;
        this.nome           = nome;
        this.email          = email;
        this.senha          = senha;
        this.banco          = banco;
        this.agencia        = agencia;
        this.conta          = conta;
        this.gerente        = gerente;
        this.datacriacao    = datacriacao;
        this.dataedicao     = dataedicao;
        this.telefoneFixo   = telefoneFixo;
        this.telefoneCelular = telefoneCelular;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public int getGerente() {
        return gerente;
    }

    public void setGerente(int gerente) {
        this.gerente = gerente;
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

    public Set<UsuarioAcaoVO> getAcoes() {
        return acoes;
    }

    public void setAcoes(Set<UsuarioAcaoVO> acoes) {
        this.acoes = acoes;
    }
}
