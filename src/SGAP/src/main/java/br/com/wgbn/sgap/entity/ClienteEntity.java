package br.com.wgbn.sgap.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Walter Gandarella
 */
@Entity
@Table(name = "cliente", schema = "", catalog = "pi2015")
public class ClienteEntity {
    private int id;
    private String nome;
    private String contato;
    private String email;
    private Timestamp datacriacao;
    private Timestamp dataedicao;
    private String telefoneFixo;
    private String telefoneCelular;
    private String fax;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nome", nullable = false, insertable = true, updatable = true, length = 200)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Basic
    @Column(name = "contato", nullable = false, insertable = true, updatable = true, length = 100)
    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    @Basic
    @Column(name = "email", nullable = false, insertable = true, updatable = true, length = 200)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "datacriacao", nullable = false, insertable = true, updatable = true)
    public Timestamp getDatacriacao() {
        return datacriacao;
    }

    public void setDatacriacao(Timestamp datacriacao) {
        this.datacriacao = datacriacao;
    }

    @Basic
    @Column(name = "dataedicao", nullable = false, insertable = true, updatable = true)
    public Timestamp getDataedicao() {
        return dataedicao;
    }

    public void setDataedicao(Timestamp dataedicao) {
        this.dataedicao = dataedicao;
    }

    @Basic
    @Column(name = "telefone_fixo", nullable = true, insertable = true, updatable = true, length = 15)
    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    @Basic
    @Column(name = "telefone_celular", nullable = true, insertable = true, updatable = true, length = 15)
    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    @Basic
    @Column(name = "fax", nullable = true, insertable = true, updatable = true, length = 15)
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClienteEntity that = (ClienteEntity) o;

        if (id != that.id) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (contato != null ? !contato.equals(that.contato) : that.contato != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (datacriacao != null ? !datacriacao.equals(that.datacriacao) : that.datacriacao != null) return false;
        if (dataedicao != null ? !dataedicao.equals(that.dataedicao) : that.dataedicao != null) return false;
        if (telefoneFixo != null ? !telefoneFixo.equals(that.telefoneFixo) : that.telefoneFixo != null) return false;
        if (telefoneCelular != null ? !telefoneCelular.equals(that.telefoneCelular) : that.telefoneCelular != null)
            return false;
        if (fax != null ? !fax.equals(that.fax) : that.fax != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (contato != null ? contato.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (datacriacao != null ? datacriacao.hashCode() : 0);
        result = 31 * result + (dataedicao != null ? dataedicao.hashCode() : 0);
        result = 31 * result + (telefoneFixo != null ? telefoneFixo.hashCode() : 0);
        result = 31 * result + (telefoneCelular != null ? telefoneCelular.hashCode() : 0);
        result = 31 * result + (fax != null ? fax.hashCode() : 0);
        return result;
    }
}
