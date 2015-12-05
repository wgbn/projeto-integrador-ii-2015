package br.com.wgbn.sgap.dao;

import org.hibernate.annotations.QueryHints;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.QueryHint;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Walter Gandarella
 */
public abstract class GenericoDAO<T> implements IF_DAO<T> {

    protected EntityManager entityManager;

    public EntityManager getEntityManager() { return entityManager; }

    protected Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return clazz;
    }

    public GenericoDAO(EntityManager em){
        this.entityManager = em;
    }

    public T salvar(T object) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(object);
            this.entityManager.getTransaction().commit();
            return object;
        } catch (Exception ex) {
            ex.printStackTrace();
            this.entityManager.getTransaction().rollback();
            return null;
        }
    }

    public void alterar(T object) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.merge(this.entityManager.contains(object) ? object : this.entityManager.merge(object));
            this.entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            this.entityManager.getTransaction().rollback();
        }
    }

    public void excluir(T object) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.remove(this.entityManager.contains(object) ? object : this.entityManager.merge(object));
            this.entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            this.entityManager.getTransaction().rollback();
        }
    }

    public List<T> getTodos() {
        Query queryStr = this.entityManager.createQuery("FROM " + getTypeClass().getName());
        return queryStr.getResultList();
    }

    public T getPorPk(int pk) {
        return (T) this.entityManager.find(getTypeClass(), pk);
    }

}
