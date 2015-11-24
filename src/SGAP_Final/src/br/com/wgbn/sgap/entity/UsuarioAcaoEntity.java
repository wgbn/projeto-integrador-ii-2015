package br.com.wgbn.sgap.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Walter Gandarella
 */
@Entity
@Table(name = "usuario_acao")
public class UsuarioAcaoEntity implements Serializable {
    private int id;
    private int confirmado;
    private int lider;
    private Timestamp datacadastro;
    private Timestamp dataedicao;
    private AcaoEntity acao;
    private UsuarioEntity usuario;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @Column(name = "dataedicao", nullable = true, insertable = true, updatable = true)
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

    @ManyToOne
    @JoinColumn(name = "acao_id", referencedColumnName = "id", nullable = false)
    public AcaoEntity getAcao() {
        return acao;
    }

    public void setAcao(AcaoEntity acao) {
        this.acao = acao;
    }

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)
    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }
}
