package br.com.wgbn.sgap.dao;

import org.hibernate.metamodel.domain.Entity;
import java.util.List;

/**
 * Created by Walter Gandarella
 */
public interface IF_DAO {

    void salvar(Entity object);
    void alterar(Entity object);
    void excluir(Entity object);
    List<Entity> getAll();
    Entity getByPk(Entity object);

}
