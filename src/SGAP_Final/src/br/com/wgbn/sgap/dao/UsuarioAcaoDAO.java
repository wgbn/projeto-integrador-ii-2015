package br.com.wgbn.sgap.dao;

import br.com.wgbn.sgap.entity.UsuarioAcaoEntity;

import javax.persistence.EntityManager;

/**
 * Created by Walter Gandarella
 */
public class UsuarioAcaoDAO extends GenericoDAO<UsuarioAcaoEntity> {
    public UsuarioAcaoDAO(EntityManager em) { super(em); }
}
