package br.com.wgbn.sgap.model;

import br.com.wgbn.sgap.dao.ClienteDAO;
import br.com.wgbn.sgap.entity.ClienteEntity;

/**
 * Created by Walter Gandarella
 */
public class ClienteModel extends GenericoModel<ClienteEntity, ClienteDAO> {

    public ClienteModel(ClienteDAO dao) { super(dao); }

    @Override
    public void resetEntity() {
        this.entity = new ClienteEntity();
    }
}
