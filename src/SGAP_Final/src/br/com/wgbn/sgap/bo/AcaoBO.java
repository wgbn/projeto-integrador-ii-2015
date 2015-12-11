package br.com.wgbn.sgap.bo;

import br.com.wgbn.sgap.dao.AcaoDAO;
import br.com.wgbn.sgap.dao.ClienteDAO;
import br.com.wgbn.sgap.dao.TipoacaoDAO;
import br.com.wgbn.sgap.dao.UsuarioAcaoDAO;
import br.com.wgbn.sgap.entity.*;
import br.com.wgbn.sgap.util.FabricaDAO;
import br.com.wgbn.sgap.util.Sessao;
import br.com.wgbn.sgap.vo.AcaoVO;
import br.com.wgbn.sgap.vo.UsuarioAcaoVO;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Walter Gandarella
 */
public class AcaoBO extends GenericoBO<AcaoEntity, AcaoDAO> {

    private UsuarioAcaoBO   usuarioAcaoBO;
    private TipoacaoBO      tipoAcaoBO;
    private ClienteBO       clienteBO;
    private UsuarioBO       usuarioBO;

    public AcaoBO() {
        this.dao            = FabricaDAO.getInstance().getAcaoDAO();
        this.usuarioAcaoBO  = new UsuarioAcaoBO();
        this.tipoAcaoBO     = new TipoacaoBO();
        this.clienteBO      = new ClienteBO();
        this.usuarioBO      = new UsuarioBO();
    }

    @Override
    public void resetEntity() {
        this.entity = new AcaoEntity();
    }

    public List<AcaoEntity> getTodasNaoRealizadas(){
        if (Sessao.getInstance().isLogado()) {
            if (Sessao.getInstance().getUsuarioLogado().getGerente() == 1)
                return this.getDao().getTodosNaoRealizadosGerente();
            else
                return this.getDao().getTodosNaoRealizadosPromotor(Sessao.getInstance().getUsuarioLogado().getId());
        } else {
            return null;
        }
    }

    public Set<UsuarioAcaoEntity> setLider(UsuarioAcaoEntity _usuarioAcao, AcaoEntity _acao){
        for (UsuarioAcaoEntity ua : _acao.getUsuarios()){
            if (ua.getLider() == 1){
                ua.setLider(0);
                this.usuarioAcaoBO.alterar(ua);
            }
        }
        _usuarioAcao.setLider(1);
        this.usuarioAcaoBO.alterar(_usuarioAcao);
        return this.usuarioAcaoBO.getPorAcao(_acao);
    }

    public Set<UsuarioAcaoEntity> setPromotor(UsuarioAcaoEntity _promotor, AcaoEntity _acao){
        if (!this.verificaPromotorNaAcao(_promotor.getUsuario(), _acao)) {
            _promotor.setDatacadastro(new Timestamp(new Date().getTime()));
            _promotor.setUsuario(usuarioBO.getPorPk(_promotor.getUsuario()));
            this.usuarioAcaoBO.salvar(_promotor);
            return this.usuarioAcaoBO.getPorAcao(_acao);
        } else {
            return null;
        }
    }

    public Set<UsuarioAcaoEntity> removerPromotor(UsuarioAcaoEntity _promotor, AcaoEntity _acao){
        _acao.getUsuarios().remove(_promotor);
        this.usuarioAcaoBO.excluir(_promotor);
        return this.usuarioAcaoBO.getPorAcao(_acao);
    }

    public List<TipoacaoEntity> getTiposAcao(){
        return this.tipoAcaoBO.getTodos();
    }

    public List<ClienteEntity> getClientes(){
        return this.clienteBO.getTodos();
    }

    public List<UsuarioEntity> getUsuarios(){
        return this.usuarioBO.getTodos();
    }

    public List<UsuarioEntity> getUsuariosDisponiveis(AcaoEntity _acao){
        //return this.usuarioBO.getTodosDisponiveis(_acao);
        return this.usuarioBO.getTodos();
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
        this.getEntity().setUsuario(Sessao.getInstance().getUsuarioLogado());
        this.setEntity(this.getDao().salvar(this.getEntity()));
    }

    public Set<UsuarioAcaoEntity> confirmarAcao(boolean _flag, UsuarioEntity _promotor, AcaoEntity _acao){
        for (UsuarioAcaoEntity ua : _acao.getUsuarios()){
            if (ua.getUsuario().getId() == _promotor.getId()){
                ua.setConfirmado(_flag ? 1 : 0);
                this.usuarioAcaoBO.alterar(ua);
            }
        }
        return _acao.getUsuarios();
    }

    private boolean verificaPromotorNaAcao(UsuarioEntity _promotor, AcaoEntity _acao){
        for (UsuarioAcaoEntity ua : _acao.getUsuarios()){
            if (ua.getUsuario().getId() == _promotor.getId()){
                return true;
            }
        }
        return false;
    }
}
