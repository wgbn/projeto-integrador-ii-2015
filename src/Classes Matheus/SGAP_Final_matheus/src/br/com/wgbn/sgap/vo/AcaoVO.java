package br.com.wgbn.sgap.vo;

import br.com.wgbn.sgap.entity.AcaoEntity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Walter Gandarella
 */
public class AcaoVO {
    private int         id;
    private Date        datainicio;
    private Date        datafim;
    private String      descricao;
    private String      local;
    private BigDecimal  latitude;
    private BigDecimal  longitude;
    private float       valor;
    private String      titulo;
    private Timestamp   datacriacao;
    private Timestamp   dataedicao;
    private ClienteVO   cliente;
    private TipoacaoVO  tipoacao;
    private UsuarioVO   usuario;
    private Set<UsuarioAcaoVO> usuarios;

    public AcaoVO(){
        this.cliente    = new ClienteVO();
        this.tipoacao   = new TipoacaoVO();
        this.usuario    = new UsuarioVO();
        this.usuarios   = new HashSet<UsuarioAcaoVO>();
    }

    public AcaoVO(AcaoEntity acao){
        this.id         = acao.getId();
        this.datainicio = new Date(acao.getDatainicio().getTime());
        this.datafim    = new Date(acao.getDatafim().getTime());
        this.descricao  = acao.getDescricao();
        this.local      = acao.getLocal();
        this.latitude   = acao.getLatitude();
        this.longitude  = acao.getLongitude();
        this.valor      = acao.getValor();
        this.titulo     = acao.getTitulo();
        this.datacriacao = acao.getDatacriacao();
        this.dataedicao = acao.getDataedicao();
        this.cliente    = new ClienteVO(acao.getCliente());
        this.tipoacao   = new TipoacaoVO(acao.getTipoacao());
        this.usuario    = new UsuarioVO(acao.getUsuario());
        this.usuarios   = new HashSet<UsuarioAcaoVO>();
    }

    public AcaoVO(int id, Timestamp datainicio, Timestamp datafim, String descricao, String local, BigDecimal latitude, BigDecimal longitude, float valor, String titulo, Timestamp datacriacao, Timestamp dataedicao, ClienteVO cliente, TipoacaoVO tipoacao, UsuarioVO usuario, Set<UsuarioAcaoVO> usuarios) {
        this.id         = id;
        this.datainicio = datainicio;
        this.datafim    = datafim;
        this.descricao  = descricao;
        this.local      = local;
        this.latitude   = latitude;
        this.longitude  = longitude;
        this.valor      = valor;
        this.titulo     = titulo;
        this.datacriacao = datacriacao;
        this.dataedicao = dataedicao;
        this.cliente    = cliente;
        this.tipoacao   = tipoacao;
        this.usuario    = usuario;
        this.usuarios   = usuarios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(Date datainicio) {
        this.datainicio = datainicio;
    }

    public Date getDatafim() {
        return datafim;
    }

    public void setDatafim(Date datafim) {
        this.datafim = datafim;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public ClienteVO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteVO cliente) {
        this.cliente = cliente;
    }

    public TipoacaoVO getTipoacao() {
        return tipoacao;
    }

    public void setTipoacao(TipoacaoVO tipoacao) {
        this.tipoacao = tipoacao;
    }

    public UsuarioVO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioVO usuario) {
        this.usuario = usuario;
    }

    public Set<UsuarioAcaoVO> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<UsuarioAcaoVO> usuarios) {
        this.usuarios = usuarios;
    }
}
