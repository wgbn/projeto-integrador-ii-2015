package br.com.wgbn.sgap.dao;

import br.com.wgbn.sgap.entity.UsuarioAcaoEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Walter Gandarella
 */
public class UsuarioAcaoDAO extends GenericoDAO<UsuarioAcaoEntity> {
    public UsuarioAcaoDAO(EntityManager em) { super(em); }

    public List<UsuarioAcaoEntity> getPorAcao(int _id){
        String queryStr = "SELECT ua FROM UsuarioAcaoEntity ua WHERE ua.acao.id = :idAcao ORDER BY ua.usuario.nome";
        Query query = this.entityManager.createQuery(queryStr, UsuarioAcaoEntity.class);
        query.setParameter("idAcao", _id);
        return query.getResultList();
    }
}
