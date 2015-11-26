package br.com.wgbn.sgap.bo;

import br.com.wgbn.sgap.dao.ClienteDAO;
import br.com.wgbn.sgap.entity.ClienteEntity;

/**
 * Created by Walter Gandarella
 */
public class ClienteBO extends GenericoBO<ClienteEntity, ClienteDAO> {

    public ClienteBO(ClienteDAO dao) { super(dao); }

    @Override
    public void resetEntity() {
        this.entity = new ClienteEntity();
    }
}
