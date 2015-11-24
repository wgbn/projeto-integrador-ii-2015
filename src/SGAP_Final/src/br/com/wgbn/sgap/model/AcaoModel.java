package br.com.wgbn.sgap.model;

import br.com.wgbn.sgap.dao.AcaoDAO;
import br.com.wgbn.sgap.dao.UsuarioAcaoDAO;
import br.com.wgbn.sgap.entity.AcaoEntity;
import br.com.wgbn.sgap.entity.UsuarioAcaoEntity;

import java.util.List;

/**
 * Created by Walter Gandarella
 */
public class AcaoModel extends GenericoModel<AcaoEntity, AcaoDAO> {
    
    private UsuarioAcaoModel    usuarioAcaoModel;
    private UsuarioAcaoDAO      uaDAO;

    public AcaoModel(AcaoDAO dao) {
        super(dao);
        usuarioAcaoModel = new UsuarioAcaoModel(new UsuarioAcaoDAO(dao.getEntityManager()));
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
}
