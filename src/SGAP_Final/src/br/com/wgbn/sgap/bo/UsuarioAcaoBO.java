package br.com.wgbn.sgap.bo;

import br.com.wgbn.sgap.dao.UsuarioAcaoDAO;
import br.com.wgbn.sgap.entity.AcaoEntity;
import br.com.wgbn.sgap.entity.UsuarioAcaoEntity;
import br.com.wgbn.sgap.util.FabricaDAO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Walter Gandarella
 */
public class UsuarioAcaoBO extends GenericoBO<UsuarioAcaoEntity, UsuarioAcaoDAO> {
    public UsuarioAcaoBO() {
        this.dao = FabricaDAO.getInstance().getUsuarioAcaoDAO();
    }

    public List<UsuarioAcaoEntity> getTodos(){
        return this.getDao().getTodos();
    }

    public Set<UsuarioAcaoEntity> getPorAcao(AcaoEntity _acao){
        return new HashSet<UsuarioAcaoEntity>(this.getDao().getPorAcao(_acao.getId()));
    }

    public UsuarioAcaoEntity salvar(UsuarioAcaoEntity _usuarioAcao){
        return this.getDao().salvar(_usuarioAcao);
    }

    public void alterar(UsuarioAcaoEntity _usuarioAcao){
        this.getDao().alterar(_usuarioAcao);
    }

    public void excluir(UsuarioAcaoEntity _usuarioAcao){
        this.getDao().excluir(_usuarioAcao);
    }

    @Override
    public void resetEntity() {
        this.entity = new UsuarioAcaoEntity();
    }

}
