package br.com.wgbn.sgap.model;

import br.com.wgbn.sgap.controller.MainApp;

import java.lang.reflect.ParameterizedType;

/**
 * Created by Walter Gandarella
 */
public abstract class GenericoModel<T, D> {
    private D dao = null;
    protected T entity;

    public GenericoModel(D dao){
        this.dao = dao;
    }

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