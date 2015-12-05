package br.com.wgbn.sgap.dao;

import br.com.wgbn.sgap.entity.TipoacaoEntity;

import javax.persistence.EntityManager;

/**
 * Created by Walter Gandarella
 */
public class TipoacaoDAO extends GenericoDAO<TipoacaoEntity> {
    public TipoacaoDAO(EntityManager em) { super(em); }
}
