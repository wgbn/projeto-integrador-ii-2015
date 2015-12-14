package br.com.wgbn.sgap.dao;

import br.com.wgbn.sgap.entity.AcaoEntity;
import br.com.wgbn.sgap.entity.UsuarioAcaoEntity;
import br.com.wgbn.sgap.entity.UsuarioEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Walter Gandarella
 */
public class AcaoDAO extends GenericoDAO<AcaoEntity> {

    public AcaoDAO(EntityManager em) { super(em); }

    public List<AcaoEntity> getTodosNaoRealizadosGerente(){
        Date hojeDt = new Date();
        Timestamp hojeTs = new Timestamp(hojeDt.getTime());
        String queryStr = "SELECT a FROM AcaoEntity a WHERE a.datainicio >= :dataIni ORDER BY a.datainicio";
        Query query = this.entityManager.createQuery(queryStr, AcaoEntity.class);
        query.setParameter("dataIni", hojeTs);
        return query.getResultList();
    }

    public List<AcaoEntity> getTodosNaoRealizadosPromotor(int _promotorId){
        Date hoje = new Date();
        Timestamp hojeTime = new Timestamp(hoje.getTime());
        String queryStr = "SELECT u FROM UsuarioEntity u WHERE u.id = :id";
        Query query = this.entityManager.createQuery(queryStr, UsuarioEntity.class);
        query.setParameter("id", _promotorId);
        UsuarioEntity promotor = (UsuarioEntity)query.getSingleResult();

        List<AcaoEntity> acoes = new LinkedList<AcaoEntity>();

        for (UsuarioAcaoEntity a : promotor.getAcoes()){
            if (a.getAcao().getDatainicio().getTime() >= hojeTime.getTime())
                acoes.add(a.getAcao());
        }

        return acoes;
    }

    public Long getTotalAcoes(){
        String queryStr = "SELECT count(a.id) FROM AcaoEntity a";
        Query query = this.entityManager.createQuery(queryStr);
        return (Long)query.getSingleResult();
    }

    public Long getTotalAcoesMesAtual(){
        Date dt = new Date();
        String queryStr = "SELECT count(a.id) FROM AcaoEntity a WHERE MONTH(a.datainicio) = :mes";
        Query query = this.entityManager.createQuery(queryStr);
        query.setParameter("mes", (dt.getMonth()+1));
        return (Long)query.getSingleResult();
    }

    public Long getTotalAcoesMesAnterior(){
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.MONTH, -1);
        dt = c.getTime();
        String queryStr = "SELECT count(a.id) FROM AcaoEntity a WHERE MONTH(a.datainicio) = :mes";
        Query query = this.entityManager.createQuery(queryStr);
        query.setParameter("mes", (dt.getMonth()+1));
        return (Long)query.getSingleResult();
    }

    public Double getTotalReceberMesAtual(){
        Date dt = new Date();
        String queryStr = "SELECT SUM(a.valor) FROM AcaoEntity a WHERE MONTH(a.datainicio) = :mes";
        Query query = this.entityManager.createQuery(queryStr);
        query.setParameter("mes", (dt.getMonth()+1));
        return (Double)query.getSingleResult();
    }

    public Double getTotalReceberMesAnterior(){
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.MONTH, -1);
        dt = c.getTime();
        String queryStr = "SELECT SUM(a.valor) FROM AcaoEntity a WHERE MONTH(a.datainicio) = :mes";
        Query query = this.entityManager.createQuery(queryStr);
        query.setParameter("mes", (dt.getMonth()+1));
        return (Double)query.getSingleResult();
    }
}