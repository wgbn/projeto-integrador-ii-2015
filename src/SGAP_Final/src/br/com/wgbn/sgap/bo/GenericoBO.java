package br.com.wgbn.sgap.bo;

/**
 * Created by Walter Gandarella
 */
public abstract class GenericoBO<T, D, VO> {
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

    public void setEntityFromVo(VO vo){
        this.setEntity(this.toEntity(vo));
    }

    public abstract void resetEntity();

    public abstract VO toVo();

    public abstract T toEntity(VO vo);
}
