package br.com.wgbn.sgap.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Walter Gandarella
 */
@Entity
@Cacheable(false)
@Table(name = "acao")
public class AcaoEntity implements Serializable {
    private int id;
    private Timestamp datainicio;
    private Timestamp datafim;
    private String descricao;
    private String local;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private float valor;
    private String titulo;
    private Timestamp datacriacao;
    private Timestamp dataedicao;
    private ClienteEntity cliente;
    private TipoacaoEntity tipoacao;
    private UsuarioEntity usuario;
    private Set<UsuarioAcaoEntity> usuarios;

    public AcaoEntity() {
        this.tipoacao   = new TipoacaoEntity();
        this.cliente    = new ClienteEntity();
        this.usuario    = new UsuarioEntity();
        this.usuarios   = new HashSet<UsuarioAcaoEntity>();
    }

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
    @Column(name = "datainicio", nullable = false, insertable = true, updatable = true)
    public Timestamp getDatainicio() {
        return datainicio;
    }
    public void setDatainicio(Timestamp datainicio) { this.datainicio = datainicio; }

    @Basic
    @Column(name = "datafim", nullable = false, insertable = true, updatable = true)
    public Timestamp getDatafim() {
        return datafim;
    }
    public void setDatafim(Timestamp datafim) {this.datafim = datafim; }

    @Basic
    @Column(name = "descricao", nullable = true, insertable = true, updatable = true, length = 500)
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Basic
    @Column(name = "local", nullable = false, insertable = true, updatable = true, length = 300)
    public String getLocal() {
        return local;
    }
    public void setLocal(String local) {
        this.local = local;
    }

    @Basic
    @Column(name = "latitude", nullable = true, insertable = true, updatable = true, precision = 14)
    public BigDecimal getLatitude() {
        return latitude;
    }
    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "longitude", nullable = true, insertable = true, updatable = true, precision = 14)
    public BigDecimal getLongitude() {
        return longitude;
    }
    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "valor", nullable = false, insertable = true, updatable = true, precision = 0)
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }

    @Basic
    @Column(name = "titulo", nullable = false, insertable = true, updatable = true, length = 200)
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Basic
    @Column(name = "datacriacao", nullable = false, insertable = true, updatable = false)
    public Timestamp getDatacriacao() {
        return datacriacao;
    }
    public void setDatacriacao(Timestamp datacriacao) {
        this.datacriacao = datacriacao;
    }

    @Basic
    @Column(name = "dataedicao", nullable = true, insertable = false, updatable = true)
    public Timestamp getDataedicao() {
        return dataedicao;
    }
    public void setDataedicao(Timestamp dataedicao) {
        this.dataedicao = dataedicao;
    }

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "cliente_id", referencedColumnName = "id", nullable = false)
    public ClienteEntity getCliente() {
        return cliente;
    }
    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "tipoacao_id", referencedColumnName = "id", nullable = false)
    public TipoacaoEntity getTipoacao() {
        return tipoacao;
    }
    public void setTipoacao(TipoacaoEntity tipoacao) {
        this.tipoacao = tipoacao;
    }

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)
    public UsuarioEntity getUsuario() {
        return usuario;
    }
    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    @OneToMany(mappedBy = "acao", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    public Set<UsuarioAcaoEntity> getUsuarios() {
        return usuarios;
    }
    public void setUsuarios(Set<UsuarioAcaoEntity> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AcaoEntity that = (AcaoEntity) o;

        if (id != that.id) return false;
        if (Float.compare(that.valor, valor) != 0) return false;
        if (datainicio != null ? !datainicio.equals(that.datainicio) : that.datainicio != null) return false;
        if (datafim != null ? !datafim.equals(that.datafim) : that.datafim != null) return false;
        if (descricao != null ? !descricao.equals(that.descricao) : that.descricao != null) return false;
        if (local != null ? !local.equals(that.local) : that.local != null) return false;
        if (latitude != null ? !latitude.equals(that.latitude) : that.latitude != null) return false;
        if (longitude != null ? !longitude.equals(that.longitude) : that.longitude != null) return false;
        if (titulo != null ? !titulo.equals(that.titulo) : that.titulo != null) return false;
        if (datacriacao != null ? !datacriacao.equals(that.datacriacao) : that.datacriacao != null) return false;
        if (dataedicao != null ? !dataedicao.equals(that.dataedicao) : that.dataedicao != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (datainicio != null ? datainicio.hashCode() : 0);
        result = 31 * result + (datafim != null ? datafim.hashCode() : 0);
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (local != null ? local.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (valor != +0.0f ? Float.floatToIntBits(valor) : 0);
        result = 31 * result + (titulo != null ? titulo.hashCode() : 0);
        result = 31 * result + (datacriacao != null ? datacriacao.hashCode() : 0);
        result = 31 * result + (dataedicao != null ? dataedicao.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AcaoEntity{" +
                "id=" + id +
                ", datainicio=" + datainicio +
                ", datafim=" + datafim +
                ", descricao='" + descricao + '\'' +
                ", local='" + local + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", valor=" + valor +
                ", titulo='" + titulo + '\'' +
                ", datacriacao=" + datacriacao +
                ", dataedicao=" + dataedicao +
                ", cliente=" + cliente +
                ", tipoacao=" + tipoacao +
                ", usuario=" + usuario +
                ", usuarios=" + usuarios +
                '}';
    }
}
