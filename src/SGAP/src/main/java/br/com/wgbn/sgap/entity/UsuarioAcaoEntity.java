package br.com.wgbn.sgap.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Walter Gandarella
 */
@Entity
@Table(name = "usuario_acao", schema = "", catalog = "pi2015")
@IdClass(UsuarioAcaoEntityPK.class)
public class UsuarioAcaoEntity {
    private int usuarioId;
    private int acaoId;
    private boolean confirmado;
    private boolean lider;
    private Timestamp datacadastro;
    private Timestamp dataedicao;
    private AcaoEntity acaoByAcaoId;
    private UsuarioEntity usuarioByUsuarioId;

    @Id
    @Column(name = "usuario_id", nullable = false, insertable = true, updatable = true)
    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Id
    @Column(name = "acao_id", nullable = false, insertable = true, updatable = true)
    public int getAcaoId() {
        return acaoId;
    }

    public void setAcaoId(int acaoId) {
        this.acaoId = acaoId;
    }

    @Basic
    @Column(name = "confirmado", nullable = false, insertable = true, updatable = true)
    public boolean isConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    @Basic
    @Column(name = "lider", nullable = false, insertable = true, updatable = true)
    public boolean isLider() {
        return lider;
    }

    public void setLider(boolean lider) {
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

        if (usuarioId != that.usuarioId) return false;
        if (acaoId != that.acaoId) return false;
        if (confirmado != that.confirmado) return false;
        if (lider != that.lider) return false;
        if (datacadastro != null ? !datacadastro.equals(that.datacadastro) : that.datacadastro != null) return false;
        if (dataedicao != null ? !dataedicao.equals(that.dataedicao) : that.dataedicao != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = usuarioId;
        result = 31 * result + acaoId;
        result = 31 * result + (confirmado ? 1 : 0);
        result = 31 * result + (lider ? 1 : 0);
        result = 31 * result + (datacadastro != null ? datacadastro.hashCode() : 0);
        result = 31 * result + (dataedicao != null ? dataedicao.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "acao_id", referencedColumnName = "id", nullable = false)
    public AcaoEntity getAcaoByAcaoId() {
        return acaoByAcaoId;
    }

    public void setAcaoByAcaoId(AcaoEntity acaoByAcaoId) {
        this.acaoByAcaoId = acaoByAcaoId;
    }

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)
    public UsuarioEntity getUsuarioByUsuarioId() {
        return usuarioByUsuarioId;
    }

    public void setUsuarioByUsuarioId(UsuarioEntity usuarioByUsuarioId) {
        this.usuarioByUsuarioId = usuarioByUsuarioId;
    }
}
