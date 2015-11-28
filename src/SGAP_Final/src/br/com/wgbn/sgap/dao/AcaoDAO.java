package br.com.wgbn.sgap.dao;

import br.com.wgbn.sgap.entity.AcaoEntity;
import br.com.wgbn.sgap.entity.UsuarioAcaoEntity;
import br.com.wgbn.sgap.entity.UsuarioEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Walter Gandarella
 */
public class AcaoDAO extends GenericoDAO<AcaoEntity> {

    public AcaoDAO(EntityManager em) { super(em); }

    public List<AcaoEntity> getTodosNaoRealizadosGerente(){
        Date hoje = new Date();
        String queryStr = "SELECT a FROM AcaoEntity a WHERE a.datainicio >= :dataIni ORDER BY a.datainicio";
        Query query = this.entityManager.createQuery(queryStr, AcaoEntity.class);
        query.setParameter("dataIni", hoje);
        return query.getResultList();
    }

    public List<AcaoEntity> getTodosNaoRealizadosPromotor(int _promotorId){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
}