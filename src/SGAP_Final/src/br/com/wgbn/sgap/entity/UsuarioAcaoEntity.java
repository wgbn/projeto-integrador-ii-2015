package br.com.wgbn.sgap.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by walter on 21/11/15.
 */
@Entity
@Table(name = "usuario_acao", schema = "", catalog = "acoesdb")
public class UsuarioAcaoEntity {
    private int id;
    private int confirmado;
    private int lider;
    private Timestamp datacadastro;
    private Timestamp dataedicao;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "confirmado", nullable = false, insertable = true, updatable = true)
    public int getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(int confirmado) {
        this.confirmado = confirmado;
    }

    @Basic
    @Column(name = "lider", nullable = false, insertable = true, updatable = true)
    public int getLider() {
        return lider;
    }

    public void setLider(int lider) {
        this.lider = lider;
    }

    @Basic
    @Column(name = "datacadastro", nullable = false, insertable = true, updatable = true)
    public Timestamp getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(Timestamp datacadastro) {
        this.datacadastro = datacadastro;
    }

    @Basic
    @Column(name = "dataedicao", nullable = false, insertable = true, updatable = true)
    public Timestamp getDataedicao() {
        return dataedicao;
    }

    public void setDataedicao(Timestamp dataedicao) {
        this.dataedicao = dataedicao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsuarioAcaoEntity that = (UsuarioAcaoEntity) o;

        if (id != that.id) return false;
        if (confirmado != that.confirmado) return false;
        if (lider != that.lider) return false;
        if (datacadastro != null ? !datacadastro.equals(that.datacadastro) : that.datacadastro != null) return false;
        if (dataedicao != null ? !dataedicao.equals(that.dataedicao) : that.dataedicao != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + confirmado;
        result = 31 * result + lider;
        result = 31 * result + (datacadastro != null ? datacadastro.hashCode() : 0);
        result = 31 * result + (dataedicao != null ? dataedicao.hashCode() : 0);
        return result;
    }
}
