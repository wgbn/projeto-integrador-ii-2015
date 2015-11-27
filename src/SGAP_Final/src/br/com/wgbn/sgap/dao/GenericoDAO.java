package br.com.wgbn.sgap.dao;

import br.com.wgbn.sgap.util.FacadeEntityManager;

import javax.persistence.EntityManager;
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
        return this.entityManager.createQuery("FROM " + getTypeClass().getName()).getResultList();
    }

    public T getPorPk(int pk) {
        return (T) this.entityManager.find(getTypeClass(), pk);
    }

}
