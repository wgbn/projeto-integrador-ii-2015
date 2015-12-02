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
public class tbClienteDTO {
    
    private int idcliente;
    private String nome;
    private String contato;
    private String email;
    private Date dtcriacao;
    private Date dtedicao;
    private String telefonefixo;
    private String telefonecelular;
    private String fax;

    public tbClienteDTO() {
    }

    public tbClienteDTO(int idcliente, String nome, String contato, String email, Date dtcriacao, Date dtedicao, String telefonefixo, String telefonecelular, String fax) {
        this.idcliente = idcliente;
        this.nome = nome;
        this.contato = contato;
        this.email = email;
        this.dtcriacao = dtcriacao;
        this.dtedicao = dtedicao;
        this.telefonefixo = telefonefixo;
        this.telefonecelular = telefonecelular;
        this.fax = fax;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
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

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
    
    
    
}
