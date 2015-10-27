package br.com.wgbn.sgap.dao;

import br.com.wgbn.sgap.entity.UsuarioEntity;

import java.util.List;

/**
 * Created by Walter Gandarella
 */
public interface IF_DAO {

    void salvar(Object object);

    void alterar(Object object);

    void excluir(Object object);

    List<Object> getAll();

    Object getByPk(Object object);

}
