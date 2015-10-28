package br.com.wgbn.sgap.dao;

import br.com.wgbn.sgap.entity.ClienteEntity;
import org.hibernate.Session;
import org.hibernate.metamodel.domain.Entity;
import java.util.List;

/**
 * Created by vivasalute on 27/10/15.
 */
public class ClienteDAO implements IF_DAO {

    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    /**
     * ### Métodos da Interface
     */

    public void salvar(Entity cliente) {
        this.sessao.save(cliente);
    }

    public void alterar(Entity cliente) {
        this.sessao.update(cliente);
    }

    public void excluir(Entity cliente) {
        this.sessao.delete(cliente);
    }

    public List<Entity> getAll() {
        return this.sessao.createCriteria(ClienteEntity.class).list();
    }

    public Entity getByPk(Entity cliente) {
        return null ;//(Entity) this.sessao.get(ClienteEntity.class, ((Entity)cliente).getId());
    }
}
