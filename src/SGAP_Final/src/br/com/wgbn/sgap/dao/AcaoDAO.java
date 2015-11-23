package br.com.wgbn.sgap.dao;

import br.com.wgbn.sgap.entity.AcaoEntity;

import javax.persistence.EntityManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Walter Gandarella
 */
public class AcaoDAO extends GenericoDAO<AcaoEntity> {

    public AcaoDAO(EntityManager em) { super(em); }

    public List<AcaoEntity> getTodosNaoRealizadosGerente(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date hoje = new Date();
        String query = "FROM " + getTypeClass().getName() + " WHERE datainicio >= '" + sdf.format(hoje) + "' ORDER BY datainicio";
        return this.entityManager.createQuery(query).getResultList();
    }

    public List<AcaoEntity> getTodosNaoRealizadosPromotor(int _promotorId){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date hoje = new Date();
        String query = "FROM " + getTypeClass().getName() + " WHERE datainicio >= '" + sdf.format(hoje) + "' ORDER BY datainicio";
        System.out.println(query);
        return this.entityManager.createQuery(query).getResultList();
    }
}