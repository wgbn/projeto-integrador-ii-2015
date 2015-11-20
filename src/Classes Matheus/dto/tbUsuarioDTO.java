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
public class tbUsuarioDTO {
    
    private int idusuario;
    private String nome;
    private String email;
    private String senha;
    private String banco;
    private String agencia;
    private String conta;
    private Boolean gerente;
    private Date dtcriacao;
    private Date dtedicao;
    private String telefonefixo;
    private String telefonecelular;

    public tbUsuarioDTO() {
    }

    public tbUsuarioDTO(int idusuario, String nome, String email, String senha, String banco, String agencia, String conta, Boolean gerente, Date dtcriacao, Date dtedicao, String telefonefixo, String telefonecelular) {
        this.idusuario = idusuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.banco = banco;
        this.agencia = agencia;
        this.conta = conta;
        this.gerente = gerente;
        this.dtcriacao = dtcriacao;
        this.dtedicao = dtedicao;
        this.telefonefixo = telefonefixo;
        this.telefonecelular = telefonecelular;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
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

    public Boolean getGerente() {
        return gerente;
    }

    public void setGerente(Boolean gerente) {
        this.gerente = gerente;
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

    public String getTelefonefixo() {
        return telefonefixo;
    }

    public void setTelefonefixo(String telefonefixo) {
        this.telefonefixo = telefonefixo;
    }

    public String getTelefonecelular() {
        return telefonecelular;
    }

    public void setTelefonecelular(String telefonecelular) {
        this.telefonecelular = telefonecelular;
    }

    
    
    
    
}