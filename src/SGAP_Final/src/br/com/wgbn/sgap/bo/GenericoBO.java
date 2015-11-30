package br.com.wgbn.sgap.bo;

/**
 * Created by Walter Gandarella
 */
public abstract class GenericoBO<T, D> {
    protected D dao = null;
    protected T entity;

    public D getDao() {
        return this.dao;
    }

    public void setDao(D dao) {
        this.dao = dao;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public abstract void resetEntity();
}
