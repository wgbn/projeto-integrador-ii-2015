package br.com.wgbn.sgap.dao;

import br.com.wgbn.sgap.entity.ClienteEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Walter Gandarella
 */
public class ClienteDAO extends GenericoDAO<ClienteEntity> {
    public ClienteDAO(EntityManager em) {
        super(em);
    }

    public Long getTotalClientes(){
        String queryStr = "SELECT count(c.id) FROM ClienteEntity c";
        Query query = this.entityManager.createQuery(queryStr);
        return (Long)query.getSingleResult();
    }

    public Long getTotalClientesMesAtual(){
        Date dt = new Date();
        String queryStr = "SELECT count(c.id) FROM ClienteEntity c WHERE MONTH(c.datacriacao) = :mes";
        Query query = this.entityManager.createQuery(queryStr);
        query.setParameter("mes", dt.getMonth());
        return (Long)query.getSingleResult();
    }

    public Long getTotalClientesMesAnterior(){
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.MONTH, -1);
        dt = c.getTime();
        String queryStr = "SELECT count(c.id) FROM ClienteEntity c WHERE MONTH(c.datacriacao) = :mes";
        Query query = this.entityManager.createQuery(queryStr);
        query.setParameter("mes", dt.getMonth());
        return (Long)query.getSingleResult();
    }
}
