package br.com.wgbn.sgap.bo;

import br.com.wgbn.sgap.dao.UsuarioAcaoDAO;
import br.com.wgbn.sgap.entity.UsuarioAcaoEntity;

/**
 * Created by Walter Gandarella
 */
public class UsuarioAcaoBO extends GenericoBO<UsuarioAcaoEntity, UsuarioAcaoDAO> {
    public UsuarioAcaoBO(UsuarioAcaoDAO dao) { super(dao); }

    @Override
    public void resetEntity() {
        this.entity = new UsuarioAcaoEntity();
    }
}
