package br.com.wgbn.sgap.dao;

import br.com.wgbn.sgap.entity.AcaoEntity;
import org.hibernate.Session;
import org.hibernate.metamodel.domain.Entity;

import java.util.List;

/**
 * Created by Walter Gandarella
 */
public class AcaoDAO implements IF_DAO {

    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    public AcaoDAO(){}

    /**
     * ### Métodos da Interface
     */

    public void salvar(Entity acao) { this.sessao.save(acao); }

    public void alterar(Entity acao) { this.sessao.update(acao); }

    public void excluir(Entity acao) { this.sessao.delete(acao); }

    public List<Entity> getAll() { return this.sessao.createCriteria(AcaoEntity.class).list(); }

    public Object getByPk(Entity acao) {
        return null; //return (AcaoEntity) this.sessao.get(AcaoEntity.class, ((AcaoEntity)acao).getId());;
    }

    /**
     * ### Métodos Próprios
     */
}
