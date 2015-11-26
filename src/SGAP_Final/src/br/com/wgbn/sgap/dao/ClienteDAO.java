package br.com.wgbn.sgap.dao;

import br.com.wgbn.sgap.entity.ClienteEntity;

import javax.persistence.EntityManager;

/**
 * Created by Walter Gandarella
 */
public class ClienteDAO extends GenericoDAO<ClienteEntity> {
    public ClienteDAO(EntityManager em) {
        super(em);
    }
}
