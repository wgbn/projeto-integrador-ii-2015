package br.com.wgbn.sgap.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Walter Gandarella
 */
@Entity
@Table(name = "tipoacao")
public class TipoacaoEntity implements Serializable {
    private int id;
    private String tipo;
    private Timestamp datacriacao;
    private Timestamp dataedicao;
    private Collection<AcaoEntity> acoes;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "tipo", nullable = false, insertable = true, updatable = true, length = 45)
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoacaoEntity that = (TipoacaoEntity) o;

        if (id != that.id) return false;
        if (tipo != null ? !tipo.equals(that.tipo) : that.tipo != null) return false;
        if (datacriacao != null ? !datacriacao.equals(that.datacriacao) : that.datacriacao != null) return false;
        if (dataedicao != null ? !dataedicao.equals(that.dataedicao) : that.dataedicao != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        result = 31 * result + (datacriacao != null ? datacriacao.hashCode() : 0);
        result = 31 * result + (dataedicao != null ? dataedicao.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tipoacao")
    public Collection<AcaoEntity> getAcoes() {
        return acoes;
    }

    public void setAcoes(Collection<AcaoEntity> acoes) {
        this.acoes = acoes;
    }
}
