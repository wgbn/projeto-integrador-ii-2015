package br.com.wgbn.sgap.dao;

import br.com.wgbn.sgap.entity.AcaoEntity;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

/**
 * Created by Walter Gandarella
 */
public class AcaoDAO extends GenericoDAO<AcaoEntity> {

    public AcaoDAO(EntityManager em) { super(em); }

    public List<AcaoEntity> getTodosNaoRealizados(){
        Date hoje = new Date();
        String query = "FROM " + getTypeClass().getName() + " WHERE nome LIKE '%" + nome + "%' ORDER BY nome";
        return this.entityManager.createQuery(query).getResultList();
    }
}