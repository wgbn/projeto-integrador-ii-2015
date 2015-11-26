package br.com.wgbn.sgap.bo;

import br.com.wgbn.sgap.dao.UsuarioAcaoDAO;
import br.com.wgbn.sgap.entity.UsuarioAcaoEntity;
import br.com.wgbn.sgap.util.FabricaDAO;
import br.com.wgbn.sgap.vo.UsuarioAcaoVO;

import java.util.List;

/**
 * Created by Walter Gandarella
 */
public class UsuarioAcaoBO extends GenericoBO<UsuarioAcaoEntity, UsuarioAcaoDAO, UsuarioAcaoVO> {
    public UsuarioAcaoBO() {
        this.dao = FabricaDAO.getInstance().getUsuarioAcaoDAO();
    }

    public List<UsuarioAcaoEntity> getTodos(){
        return this.getDao().getTodos();
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

    @Override
    public UsuarioAcaoVO toVo() {
        UsuarioAcaoVO vo = new UsuarioAcaoVO(this.getEntity());
        return vo;
    }

    @Override
    public UsuarioAcaoEntity toEntity(UsuarioAcaoVO usuarioAcaoVO) {
        UsuarioAcaoEntity u = new UsuarioAcaoEntity(usuarioAcaoVO);
        return u;
    }
}
