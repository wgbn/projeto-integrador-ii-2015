package br.com.wgbn.sgap.bo;

import br.com.wgbn.sgap.dao.AcaoDAO;
import br.com.wgbn.sgap.dao.ClienteDAO;
import br.com.wgbn.sgap.dao.TipoacaoDAO;
import br.com.wgbn.sgap.dao.UsuarioAcaoDAO;
import br.com.wgbn.sgap.entity.AcaoEntity;
import br.com.wgbn.sgap.entity.ClienteEntity;
import br.com.wgbn.sgap.entity.TipoacaoEntity;
import br.com.wgbn.sgap.entity.UsuarioAcaoEntity;
import br.com.wgbn.sgap.util.FabricaDAO;
import br.com.wgbn.sgap.vo.AcaoVO;
import br.com.wgbn.sgap.vo.UsuarioAcaoVO;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by Walter Gandarella
 */
public class AcaoBO extends GenericoBO<AcaoEntity, AcaoDAO, AcaoVO> {

    private UsuarioAcaoBO   usuarioAcaoBO;
    private TipoacaoBO      tipoAcaoBO;
    private ClienteBO       clienteBO;

    public AcaoBO() {
        this.dao            = FabricaDAO.getInstance().getAcaoDAO();
        this.usuarioAcaoBO  = new UsuarioAcaoBO();
        this.tipoAcaoBO     = new TipoacaoBO();
        this.clienteBO      = new ClienteBO();
    }

    @Override
    public void resetEntity() {
        this.entity = new AcaoEntity();
    }

    public List<AcaoEntity> getTodasNaoRealizadas(){
        if (UsuarioBO.getLogado().getGerente() == 1)
            return this.getDao().getTodosNaoRealizadosGerente();
        else
            return this.getDao().getTodosNaoRealizadosPromotor(UsuarioBO.getLogado().getId());
    }

    public UsuarioAcaoEntity setPromotor(UsuarioAcaoEntity usuarioAcao){
        usuarioAcao = this.usuarioAcaoBO.salvar(usuarioAcao);
        this.entity.getUsuarios().add(usuarioAcao);
        return usuarioAcao;
    }

    public List<TipoacaoEntity> getTiposAcao(){
        return this.tipoAcaoBO.getTodos();
    }

    public List<ClienteEntity> getClientes(){
        return this.clienteBO.getTodos();
    }

    public TipoacaoEntity setTipoAcao(TipoacaoEntity _tipo){
        return this.tipoAcaoBO.salvar(_tipo);
    }

    public void alterar(){
        this.getDao().alterar(this.getEntity());
    }
    public void alterar(AcaoEntity _acao){
        this.getDao().alterar(_acao);
    }

    public void excluir(){
        this.getDao().excluir(this.getEntity());
    }
    public void excluir(AcaoEntity _acao){
        this.getDao().excluir(_acao);
    }

    public void inserirAcao(){
        this.salvar();
    }
    public void inserirAcao(AcaoEntity _acao){
        this.setEntity(_acao);
        this.salvar();
    }

    private void salvar(){
        this.getEntity().setDatacriacao(new Timestamp(new Date().getTime()));
        this.getEntity().setDataedicao(new Timestamp(new Date().getTime()));
        this.getEntity().setUsuario(UsuarioBO.getLogado());
        AcaoEntity ac = this.getEntity();
        this.setEntity(this.getDao().salvar(this.getEntity()));
    }

    @Override
    public AcaoVO toVo() {
        AcaoVO vo = new AcaoVO(this.getEntity());
        for (UsuarioAcaoEntity ua : this.getEntity().getUsuarios()){
            vo.getUsuarios().add(new UsuarioAcaoVO(ua));
        }
        return vo;
    }

    @Override
    public AcaoEntity toEntity(AcaoVO acaoVO) {
        AcaoEntity a = new AcaoEntity(acaoVO);
        for (UsuarioAcaoVO ua : acaoVO.getUsuarios()){
            a.getUsuarios().add(new UsuarioAcaoEntity(ua));
        }
        return a;
    }
}
