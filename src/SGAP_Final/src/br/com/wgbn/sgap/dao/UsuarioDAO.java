package br.com.wgbn.sgap.dao;

import br.com.wgbn.sgap.entity.UsuarioEntity;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

/**
 *
 * @author Walter Gandarella
 */
public class UsuarioDAO extends GenericoDAO<UsuarioEntity> {

    public UsuarioDAO(EntityManager em) {
        super(em);
    }

    public UsuarioEntity getPorNome(String nome){
        String query = "FROM " + getTypeClass().getName() + " WHERE nome = '" + nome + "'";
        return (UsuarioEntity) this.entityManager.createQuery(query).getSingleResult();
    }

    public UsuarioEntity getPorEmail(String email){
        String query = "FROM " + getTypeClass().getName() + " WHERE email = '" + email + "'";
        return (UsuarioEntity) this.entityManager.createQuery(query).getSingleResult();
    }

    public UsuarioEntity getPorFacebookId(String id){
        String query = "FROM " + getTypeClass().getName() + " WHERE facebook_user_id = '" + id + "'";
        UsuarioEntity user = null;

        try {
            user = (UsuarioEntity) this.entityManager.createQuery(query).getSingleResult();
        } catch (NoResultException nre){
            // ignora o erro e retona NULL
        }

        if (user != null)
            return user;

        return null;
    }

    public List<UsuarioEntity> getTodosPorNome(String nome){
        String query = "FROM " + getTypeClass().getName() + " WHERE nome LIKE '%" + nome + "%' ORDER BY nome";
        return this.entityManager.createQuery(query).getResultList();
    }

    public List<UsuarioEntity> getTodosPorTipo(boolean gerente){
        String query = "FROM " + getTypeClass().getName() + " WHERE gerente = " + (gerente ? 1 : 0) + " ORDER BY nome";
        return this.entityManager.createQuery(query).getResultList();
    }
}