package br.com.wgbn.sgap.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Walter Gandarella
 */
@Entity
@Cacheable(false)
@Table(name = "usuario")
public class UsuarioEntity implements Serializable {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String banco;
    private String agencia;
    private String conta;
    private int gerente;
    private Timestamp datacriacao;
    private Timestamp dataedicao;
    private String telefoneFixo;
    private String telefoneCelular;
    private String facebookUserId;
    private Set<UsuarioAcaoEntity> acoes;

    public UsuarioEntity() { this.acoes = new HashSet<UsuarioAcaoEntity>(); }

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
    @Column(name = "nome", nullable = false, insertable = true, updatable = true, length = 200)
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
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
    @Column(name = "senha", nullable = false, insertable = true, updatable = true, length = 128)
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Basic
    @Column(name = "banco", nullable = true, insertable = true, updatable = true, length = 45)
    public String getBanco() {
        return banco;
    }
    public void setBanco(String banco) {
        this.banco = banco;
    }

    @Basic
    @Column(name = "agencia", nullable = true, insertable = true, updatable = true, length = 10)
    public String getAgencia() {
        return agencia;
    }
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    @Basic
    @Column(name = "conta", nullable = true, insertable = true, updatable = true, length = 15)
    public String getConta() {
        return conta;
    }
    public void setConta(String conta) {
        this.conta = conta;
    }

    @Basic
    @Column(name = "gerente", nullable = false, insertable = true, updatable = true)
    public int getGerente() {
        return gerente;
    }
    public void setGerente(int gerente) {
        this.gerente = gerente;
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
    @Column(name = "facebook_user_id", nullable = true, insertable = true, updatable = true, length = 150)
    public String getFacebookUserId() {
        return facebookUserId;
    }
    public void setFacebookUserId(String facebookUserId) {
        this.facebookUserId = facebookUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsuarioEntity that = (UsuarioEntity) o;

        if (id != that.id) return false;
        if (gerente != that.gerente) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (senha != null ? !senha.equals(that.senha) : that.senha != null) return false;
        if (banco != null ? !banco.equals(that.banco) : that.banco != null) return false;
        if (agencia != null ? !agencia.equals(that.agencia) : that.agencia != null) return false;
        if (conta != null ? !conta.equals(that.conta) : that.conta != null) return false;
        if (datacriacao != null ? !datacriacao.equals(that.datacriacao) : that.datacriacao != null) return false;
        if (dataedicao != null ? !dataedicao.equals(that.dataedicao) : that.dataedicao != null) return false;
        if (telefoneFixo != null ? !telefoneFixo.equals(that.telefoneFixo) : that.telefoneFixo != null) return false;
        if (telefoneCelular != null ? !telefoneCelular.equals(that.telefoneCelular) : that.telefoneCelular != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (senha != null ? senha.hashCode() : 0);
        result = 31 * result + (banco != null ? banco.hashCode() : 0);
        result = 31 * result + (agencia != null ? agencia.hashCode() : 0);
        result = 31 * result + (conta != null ? conta.hashCode() : 0);
        result = 31 * result + gerente;
        result = 31 * result + (datacriacao != null ? datacriacao.hashCode() : 0);
        result = 31 * result + (dataedicao != null ? dataedicao.hashCode() : 0);
        result = 31 * result + (telefoneFixo != null ? telefoneFixo.hashCode() : 0);
        result = 31 * result + (telefoneCelular != null ? telefoneCelular.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "usuario")
    public Set<UsuarioAcaoEntity> getAcoes() {
        return acoes;
    }
    public void setAcoes(Set<UsuarioAcaoEntity> acoes) {
        this.acoes = acoes;
    }
}
