package br.com.wgbn.sgap.model;

import br.com.wgbn.sgap.dao.UsuarioAcaoDAO;
import br.com.wgbn.sgap.entity.UsuarioAcaoEntity;

/**
 * Created by Walter Gandarella
 */
public class UsuarioAcaoModel extends GenericoModel<UsuarioAcaoEntity, UsuarioAcaoDAO> {
    public UsuarioAcaoModel(UsuarioAcaoDAO dao) { super(dao); }

    @Override
    public void resetEntity() {
        this.entity = new UsuarioAcaoEntity();
    }
}
