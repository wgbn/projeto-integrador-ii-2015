package br.com.wgbn.sgap.model;

import br.com.wgbn.sgap.dao.AcaoDAO;
import br.com.wgbn.sgap.dao.ClienteDAO;
import br.com.wgbn.sgap.dao.TipoacaoDAO;
import br.com.wgbn.sgap.dao.UsuarioAcaoDAO;
import br.com.wgbn.sgap.entity.AcaoEntity;
import br.com.wgbn.sgap.entity.ClienteEntity;
import br.com.wgbn.sgap.entity.TipoacaoEntity;
import br.com.wgbn.sgap.entity.UsuarioAcaoEntity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by Walter Gandarella
 */
public class AcaoModel extends GenericoModel<AcaoEntity, AcaoDAO> {
    
    private UsuarioAcaoModel    usuarioAcaoModel;
    private TipoacaoModel       tipoAcaoModel;
    private ClienteModel        clienteModel;
    private UsuarioAcaoDAO      uaDAO;

    public AcaoModel(AcaoDAO dao) {
        super(dao);
        usuarioAcaoModel    = new UsuarioAcaoModel(new UsuarioAcaoDAO(dao.getEntityManager()));
        tipoAcaoModel       = new TipoacaoModel(new TipoacaoDAO(dao.getEntityManager()));
        clienteModel        = new ClienteModel(new ClienteDAO(dao.getEntityManager()));
    }

    @Override
    public void resetEntity() {
        this.entity = new AcaoEntity();
    }

    public List<AcaoEntity> getTodasNaoRealizadas(){
        if (UsuarioModel.getLogado().getGerente() == 1)
            return this.getDao().getTodosNaoRealizadosGerente();
        else
            return this.getDao().getTodosNaoRealizadosPromotor(UsuarioModel.getLogado().getId());
    }

    public UsuarioAcaoEntity setPromotor(UsuarioAcaoEntity usuarioAcao){
        usuarioAcao = this.usuarioAcaoModel.getDao().salvar(usuarioAcao);
        this.entity.getUsuarios().add(usuarioAcao);
        return usuarioAcao;
    }

    public List<TipoacaoEntity> getTiposAcao(){ return this.tipoAcaoModel.getDao().getTodos(); }

    public List<ClienteEntity> getClientes(){ return this.clienteModel.getDao().getTodos(); }

    public TipoacaoEntity setTipoAcao(TipoacaoEntity _tipo){
        return this.tipoAcaoModel.getDao().salvar(_tipo);
    }

    public void inserirAcao(){
        this.getEntity().setDatacriacao(new Timestamp(new Date().getTime()));
        this.setEntity(this.getDao().salvar(this.getEntity()));
    }
}
